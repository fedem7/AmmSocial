
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Nerdbook-Profilo</title>
        <meta http-equiv = "content-type" content = "text/html; charset=utf-8" />
        <meta name="author" content="Federico Murru">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>

    <body>
        <div id="page">
            <!--header -->
            <c:set var="title" value="Bacheca Personale" scope="request"/>
            <jsp:include page="header.jsp"/>

            <!--Barra di navigazione tra le pagine del sito-->
            <c:set var="page" value="Bacheca Personale" scope="request"/>
            <jsp:include page="sidebar.jsp"/>


            <div id="content">
                <div class="form">
                    <c:if test="${click == 1}">
                        <div id="validate">


                            <h3>I dati sono stati inseriti correttamente :</h3>

                            <c:if test="${!empty newNome}">
                                <p><strong>nome:</strong> ${newNome}</p>
                            </c:if>
                            <c:if test="${!empty newCognome}">
                                <p><strong>cognome:</strong> ${newCognome}</p>
                            </c:if>
                            <c:if test="${!empty newDataNascita}">
                                <p><strong>data di nascita:</strong> ${newDataNascita}</p>
                            </c:if>
                            <c:if test="${!empty newImg}">
                                <p><strong>immagine del profilo:</strong> ${newImg}</p>
                            </c:if>
                            <c:if test="${!empty newFrase}">
                                <p><strong>stato:</strong> ${newFrase}</p>
                            </c:if>
                            <c:if test="${!empty newPassword}">
                                <p><strong>password:</strong> ${newPassword}</p>
                            </c:if>

                        </div>
                    </c:if>


                    <c:if test="${click == 2}">
                        <div id="invalidDataWarning">password non valida</div>
                    </c:if>

                    <div class="immaginiprofilo">
                        <img title="profilo" alt="immagine avatar" src="${utenteLoggato.getUrlFotoProfilo()}">
                    </div>

                    <div class="areaform">

                        <form action="Profilo" method="post"> 

                            <div class="textform">
                                <label for="username"><b>Nome</b></label> 
                                <input type="text" id="name" name="name" placeholder="Nome" 
                                       value="${utenteLoggato.getNome()}">
                            </div>
                            <div class="textform">
                                <label for="lastname"><b>Cognome</b></label> 
                                <input type="text" id="surname" name="surname" placeholder="Cognome"
                                       value="${utenteLoggato.getCognome()}">
                            </div>

                            <div class="textform">
                                <label for="img"><b>Immagine</b></label> 
                                <input type="text" name="img" id="img" placeholder="inserisci immagine"                                 
                                       value="${utenteLoggato.getUrlFotoProfilo()}">
                            </div>

                            <div class="textform">

                                <label for="bday"><b>Data di nascista</b></label> 
                                <input type="date" name="data" id="data" placeholder="inserisci la tua data di nascita"                          
                                       value="${utenteLoggato.getDataNascita()}">
                            </div>

                            <div class="textform">
                                <label for="frase"><b>Frase di presentazione</b></label> 
                                <input type="text" name="frase" id="frase" placeholder="scrivi una frase di presentazione..."
                                       value="${utenteLoggato.getFrasePresentazione()}">
                            </div>

                            <div class="textform">
                                <label for="primapsw"><b>Password</b></label> 
                                <input type="password" id="pswd" name="pswd" placeholder="inserisci password"
                                       value="${utenteLoggato.getPassword()}">
                            </div>

                            <div class="textform">
                                <label for="verifica"><b>Conferma password</b></label> 
                                <input type="password" id="confpswd"  name="confpswd" placeholder="inserisci nuovamente password"
                                       value="${utenteLoggato.getPassword()}">     
                            </div>
                            <div>
                                <button type="submit" >Aggiorna</button>
                            </div>
                        </form>
                    </div>                            
                </div>
            </div>
        </div>
    </body>
</html>


