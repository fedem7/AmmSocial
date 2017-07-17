/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.classi.Utente;
import amm.nerdbook.classi.UtenteFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edef
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Sessione
        HttpSession session = request.getSession();
        
        int loggedUserID;
        Utente loggato = null;
        
        //Distrugge la sessione
        if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        
        //Utente già loggato
        if (session.getAttribute("loggedIn") != null &&
            session.getAttribute("loggedIn").equals(true)) {
            
            
            
            loggedUserID = (Integer)session.getAttribute("loggedUserID");
            loggato = UtenteFactory.getInstance().getUtenteById(loggedUserID);
            
            if(loggato.getNome() == null || loggato.getCognome() == null ||
                            loggato.getUrlFotoProfilo() == null ||
                            loggato.getFrasePresentazione() == null)
            {
                request.getRequestDispatcher("Profilo").forward(request, response);
            }
            else
            {
                request.getRequestDispatcher("Bacheca").forward(request, response);
            }

            
            return;
        
        //Utente non loggato
        } else {
            String username = request.getParameter("userLogin");
            String password = request.getParameter("pswdLogin");
        
            if (username != null &&
                password != null) 
            {
                loggedUserID = UtenteFactory.getInstance().getIdByUserAndPassword(username, password);
                
                if(loggedUserID >= 0)
                {                  
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("loggedUserID", loggedUserID);
                    
                    loggato = UtenteFactory.getInstance().getUtenteById(loggedUserID);
            
                    if(loggato.getNome() == null || loggato.getCognome() == null ||
                            loggato.getUrlFotoProfilo() == null ||
                            loggato.getFrasePresentazione() == null)
                    {
                        request.getRequestDispatcher("Profilo").forward(request, response);
                    }
                    else
                    {
                        request.getRequestDispatcher("Bacheca").forward(request, response);
                    }              
                    return;
                } else { 
                    
                    //ritorno alla login ,dati sbagliati
                    request.setAttribute("invalidData", loggedUserID);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                }
                
                
            }
        }
        
        /*
          Se non si verifica nessuno degli altri casi, 
          tentativo di accesso diretto alla servlet Login -> reindirizzo verso 
          il form di login.
        */
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
