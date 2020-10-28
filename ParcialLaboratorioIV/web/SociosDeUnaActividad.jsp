<%-- 
    Document   : SociosDeUnaActividad
    Created on : 26 oct. 2020, 14:18:46
    Author     : Emiliano
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
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
            </ul>
        </div>
    </nav>
    <body>
        <table class="table table-bordered" >
            <tr class="text-primary thead-dark">
                <th class="text-center">NOMBRE</th>
                <th class="text-center">APELLIDO</th>
                <th class="text-center">DNI</th>
                <th class="text-center">ACTIVIDAD</th>
            </tr>
            <c:forEach items="${ListadeSociosPorActividad}" var="s">
                <tr>
                    <th class="text-center">${s.socio.getNombre()}</th>
                    <th class="text-center">${s.socio.getApellido()}</th>
                    <th class="text-center">${s.socio.getDni()}</th>
                    <th class="text-center">${s.actividad.actividad}</th>
                </tr> 
            </c:forEach>  

        </table>

    </body>
</html>
