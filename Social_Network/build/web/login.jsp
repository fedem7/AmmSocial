<%-- 
    Document   : login
    Created on : 1-mag-2017, 18.03.08
    Author     : edef
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <title>Nerdbook-login</title>
        <meta http-equiv = "content-type" content = "text/html; charset=utf-8" />
        <meta name="author" content="Federico Murru">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>

    <body>
        <div id="page">
            <!--header-->
            <header class="perLogin">
                <div id="titleLogin">
                    <h1>NerdBook</h1>
                </div>
            </header>

            <div id="content">
                <div id="divlogin">
                    <form action="Login" method="post">
                        <div id="divform">
                            <div id="texar">
                                <label for="user"><b>Username</b></label>
                                <input class="inserimento" type="text" id="user" name="userLogin">
                                <label for="password"><b>Password</b></label>
                                <input class="inserimento" type="password" id="pswd"  name="pswdLogin">
                            </div>
                            <button type="submit">Accedi</button> 
                        </div>

                    </form>
                    <!-- messaggio di errore -->     
                    <c:if test="${invalidData == -1 }">
                        <div id="invalidDataWarning">I dati inseriti non sono corretti</div>
                    </c:if>
                    <c:if test="${invalidData == -2 }">
                        <div id="invalidDataWarning">I dati inseriti non sono corretti</div>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>


