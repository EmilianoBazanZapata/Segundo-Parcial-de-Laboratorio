<%-- 
    Document   : ActividadBuscada
    Created on : 24 oct. 2020, 14:58:43
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
                        <a class="nav-link" href="#">Inicio <span class="sr-only">(current)</span></a>
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
                <form class="form-inline my-2 my-lg-0" method="POST" action="BuscarActividad">
                    <input class="form-control mr-sm-2" type="search" placeholder="Ingrese una Actividad" aria-label="Search"name="txtActividadBuscada"required>
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
                </form>
            </div>
        </nav>


        <h1 class="text-center">Lista de Actividades</h1>
        <div>
            <table class="table table-bordered table-responsive">

                <tr>
                    <td class="text-center">
                        <a href="AgregarActividad.jsp" class="btn btn-outline-info btn-sm ">Agregar Actividad</a>
                    </td>
                </tr>
            </table>
        </div>
        <div class="container" >
            <table class="table table-bordered" >
                <tr class="text-primary thead-dark">
                    <th class="text-center">ACTIVIDAD</th>
                    <th class="text-center">PRECIO</th>
                    <th class="text-center">ACCIONES</th>
                </tr>
                <c:forEach items="${ActiviadaBuscadaPorNombre}" var="s">
                    <tr>
                        <th class="text-center">${s.actividad}</th>
                        <th class="text-center">${s.precio}</th>
                        <td class="text-center">
                            <a href="EditarActividad?id=${s.id_actividad}" class="btn btn-outline-success btn-sm "name="btnEditar">Editar Actividad</a>
                            <a href="EliminarActividad?id=${s.id_actividad}" class="btn btn-outline-danger btn-sm ">Eliminar</a>
                        </td>
                    </tr> 
                </c:forEach>       
            </table>
        </div>
    </body>
</html>
