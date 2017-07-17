
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="amm.nerdbook.classi.UtenteFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<div class="confPost">
    <div class="profilo">
        <img class="imgprofilo" title="profilo" alt="immagine avatar" src="${utenteLoggato.getUrlFotoProfilo()}">
        <div class="nameprofilo"><a href="#indirizzo_casuale">${utenteLoggato.getNome()} ${utenteLoggato.getCognome()}</a></div>
    </div>
    <c:if test="${proprietario != null}">
        <c:set var="urlAction2" value="Bacheca?user=${proprietario.getId()}&click=2"/> 
    </c:if>
    <c:if test="${gruppo != null}">
        <c:set var="urlAction2" value="Bacheca?group=${gruppo.getId()}&click=2"/>
    </c:if>
    <form class="nuovopost" name="nuovopost" action="${urlAction2}" method="post"> 
        <c:if test="${!empty proprietario}"><h3>Stai scrivendo nella bacheca di :</h3><h2> ${proprietario.getUsername()}</h2></c:if> 

        <c:if test="${!empty gruppo}"><h3>Stai scrivendo nel gruppo ${gruppo.getNomeGruppo()}</h3></c:if> 

            <h3>Stai pubblicando il seguente Post:</h3> 
            <p>${testo}</p>
        <c:if test="${!empty allegato}">
            <p>${allegato}</p>
        </c:if>
        <div>
            <button type="submit" >Conferma</button>
        </div>
</div>









