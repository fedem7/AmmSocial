
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="it">
    <head>
        <title>Nerdbook-descrizione</title>
        <meta http-equiv = "content-type" content = "text/html; charset=utf-8" />
        <meta name="author" content="Federico Murru">
        <meta name="keywords" content="Descizione Nerdbook">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>

    <body>  

        <div id="page">

            <c:set var="title" value="" scope="request"/>
            <jsp:include page="header.jsp"/>

            <!--sidebar 1-->
            <div id="sidebar1">
                <h2>Sommario</h2>
                <ul>
                    <li><a href="#Iscrizione">Iscrizione</a></li>
                    <li><a href="#Funzionalità">Funzionalità</a></li>
                    <li><a href="#Storia">Storia</a></li>
                </ul>
            </div>

            <div id="content">
                <div id="descrizione">
                    <p>Nerdbook ti permette di tenerti in contatto con i tuoi amici Nerd e di condividere con loro i tuoi interessi e tanto altro.<p>
                    <h2 id="Iscrizione">Iscrizione</h2>
                    <p>L'iscrizione e l'uso di Nerdbook è totalmente gratuito

                    <h3 id="Funzionalità">Funzionalità Principali </h3>   
                    <p> Scopri cosa stanno facendo i tuoi amici   <br/>
                        Condividi aggiornamenti, foto e video     <br/>
                        Invia messaggi privati ai tuoi amici

                    <h3 id="Storia">Storia di Nerdbook</h3>   
                    <p>Nerdbook è un servizio di social network nato nel 2015 dall'idea di tre studenti 
                        del corso di laurea di Informatica dell'Università di Cagliari. <br/> 
                        Originariamente era stato progettato per mettere in contatto gli studenti del corso di Informatica , 
                        mentre ora è aperto a tutti i Nerd e a tutte le persone interessate. 
                </div>
            </div>

            <!--footer-->
            <div id="footer"></div>

        </div>
    </body>

</html>





