
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <title>Nerdbook-Bacheca</title>
        <meta http-equiv = "content-type" content = "text/html; charset=utf-8" />
        <meta name="author" content="Federico Murru">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>

    <body>
        <div id="page">

            <!--header-->
            <c:set var="title" value="Bacheca Personale" scope="request"/>
            <jsp:include page="header.jsp"/>

            <!--Barra di navigazione tra le pagine del sito-->
            <c:set var="page" value="Bacheca Personale" scope="request"/>
            <jsp:include page="sidebar.jsp"/>

            <div id="content">

                <c:if test="${proprietario != null}">
                    <div id="stato">
                        <img class="imgelemen" title="profilo" alt="immagine avatar"src="${proprietario.getUrlFotoProfilo()}">
                        <p><strong><c:out value="${proprietario.getNome()}"/> :</strong></p>
                        <p><c:out value="${proprietario.getFrasePresentazione()}"/></p>
                    </div>
                </c:if>
                <c:if test="${gruppo != null}">
                    <div id="stato">

                        <p><strong>${gruppo.getNomeGruppo()}</strong></p>

                    </div>
                </c:if>

                <div id="divnuovopost">
                    <c:if test="${proprietario != null}">
                        <c:set var="urlAction" value="Bacheca?user=${proprietario.getId()}"/> 
                    </c:if>
                    <c:if test="${gruppo != null}">
                        <c:set var="urlAction" value="Bacheca?group=${gruppo.getId()}"/>
                    </c:if>
                    <form class="nuovopost" name="nuovopost" action="${urlAction}" method="post"> 
                        <div class="nuovopost">
                            <div class="profilo"><img class="imgprofilo" title="profilo" alt="immagine profilo" src="${utenteLoggato.getUrlFotoProfilo()}"></div>
                            <textarea  name="testo" id="testo"></textarea>
                        </div>
                        <div class="nuovopost">
                            <input type="url" name="allegato" id="allegato" placeholder="inserisci allegato">
                        </div>

                        <div>
                            <button type="submit" >Pubblica</button>
                        </div>
                    </form>

                </div>

                <c:if test="${click == 1}">
                    <div id="contentpost">
                        <c:set var="page" value="Bacheca Personale" scope="request"/>
                        <jsp:include page="newpost.jsp"/>
                    </div>
                </c:if>

                <c:if test="${click == 2}">

                    <c:if test="${!empty proprietario}">
                        <div id ="confermaPost">
                            <h3>Hai scritto sulla bacheca di <a href="bacheca.html?user=0${proprietario.getId()}">${proprietario.getUsername()}</a></h3>
                        </div>
                    </c:if>


                    <c:if test="${!empty gruppo}">
                        <div id ="confermaPost">
                            <h3>Hai scritto sulla bacheca di <a href="bacheca.html?group=0${gruppo.getId()}">${gruppo.getNomeGruppo()}</a></h3>
                        </div>
                    </c:if>
                </c:if>


                <div id="contentpost">
                    <c:set var="page" value="Bacheca Personale" scope="request"/>
                    <jsp:include page="post.jsp"/>
                </div>

            </div>
        </div>
    </div>
</body>    
</html>


