/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.util.*;

/**
 *
 * @author edef
 */
public class UtenteFactory {

//Pattern Design Singleton
    private static UtenteFactory singleton;

    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }

    private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();

    private UtenteFactory() {

        //Creazione utenti
        Utente utente1 = new Utente();
        utente1.setId(0);
        utente1.setNome("Genoveffo");
        utente1.setCognome("Rossi");
        utente1.setUrlFotoProfilo("img/nerd-urkel.jpg");
        utente1.setDataNascita("21/02/1990");
        utente1.setPassword("111");
        utente1.setFrasePresentazione("lalala lalalaaaaaa");

        Utente utente2 = new Utente();
        utente2.setId(1);
        utente2.setNome("Matteo");
        utente2.setCognome("Anedda");
        utente2.setUrlFotoProfilo("img/imges.jpg");
        utente2.setDataNascita("15/10/1980");
        utente2.setPassword("111");
        utente2.setFrasePresentazione(null);

        Utente utente3 = new Utente();
        utente3.setId(2);
        utente3.setNome("Marta");
        utente3.setCognome("Usai");
        utente3.setUrlFotoProfilo("img/gatto.jpg");
        utente3.setDataNascita("7/07/2000");
        utente3.setPassword("111");
        utente3.setFrasePresentazione("hjkdhskjdsh kjhsdjhds jshkjds");

        Utente utente4 = new Utente();
        utente4.setId(3);
        utente4.setNome("Marco");
        utente4.setCognome("Mura");
        utente4.setUrlFotoProfilo("img/messi.jpg");
        utente4.setDataNascita("16/03/1992");
        utente4.setPassword("111");
        utente4.setFrasePresentazione(null);

        //Amicizie utenti
        utente1.getListaAmici().add(utente2);
        utente1.getListaAmici().add(utente3);
        utente1.getListaAmici().add(utente4);

        utente2.getListaAmici().add(utente1);
        utente2.getListaAmici().add(utente4);

        utente3.getListaAmici().add(utente1);
        utente3.getListaAmici().add(utente4);

        utente4.getListaAmici().add(utente1);
        utente4.getListaAmici().add(utente2);
        utente4.getListaAmici().add(utente3);

        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        listaUtenti.add(utente4);

    }

    public Utente getUtenteById(int id) {
        for (Utente user : this.listaUtenti) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public int getIdByUserAndPassword(String username, String password) {
        for (Utente user : this.listaUtenti) {
            if (user.getNome().equals(username)) {
                if (user.getPassword().equals(password)) {
                    return user.getId();
                } else {
                    return -2;
                }
            }
        }
        return -1;
    }

    public List getListaUtenti() {

        return listaUtenti;
    }

}
