<%-- 
    Document   : NoticiasBuscadasParaInvitados
    Created on : 27 oct. 2020, 9:37:35
    Author     : Emiliano
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Menues/MenuInvitado.jsp" %>
        <div class="container" >
            <table class="table table-bordered" >
                <c:forEach items="${listadeNoticiasBuscadas}" var="s">
                    <div class="jumbotron">
                        <h1 class="display-4">${s.titulo}</h1>
                        <p class="lead">${s.noticia}</p>
                        <hr class="my-4">
                        <p></p>
                    </div>
                </c:forEach>       
            </table>
        </div>
    </body>
</html>
