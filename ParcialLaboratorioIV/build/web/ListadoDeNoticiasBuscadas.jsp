<%-- 
    Document   : ListadoDeNoticiasBuscadas
    Created on : 24 oct. 2020, 12:42:46
    Author     : Emiliano
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Pagina Inicial</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="InicioParaAdministradores.jsp">Inicio <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="ListadoDeSocios">Lista de Socios<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="ListadoDeActividades">Lista de Actividades<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="ListadoNoticia">Noticias<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="ActividadesConMasGanancias">Reportes<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="ActividadesConMasGanancias">Reportes<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container" >
            <table class="table table-bordered" >
                <c:forEach items="${listadeNoticiasBuscadas}" var="s">
                    <div class="jumbotron">
                        <h1 class="display-4">${s.titulo}</h1>
                        <p class="lead">${s.noticia}</p>
                        <hr class="my-4">
                        <p></p>
                        <a class="btn btn-danger btn-lg" href="EliminarNoticia?id=${s.id_noticia}" role="button">Eliminar</a>
                    </div>
                </c:forEach>       
            </table>
        </div>
    </body>
</html>
