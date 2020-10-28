<%-- 
    Document   : SocioBuscado
    Created on : 23 oct. 2020, 21:48:24
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
                        <a class="nav-link" href="ActividadesConMasGanancias">Reportes<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" method="POST" action="BuscarSocio">
                    <input class="form-control mr-sm-2" type="number" placeholder="Ingrese un DNI" aria-label="number"name="txtDocumentoBuscado"required min="0" pattern="^[0-9]+">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" required>Buscar</button>
                </form>
            </div>
        </nav>


        <h1 class="text-center">Lista de Socios</h1>
        <div>
            <table class="table table-bordered table-responsive">

                <tr>
                    <td class="text-center">
                        <a href="AgregarSocio.jsp" class="btn btn-outline-info btn-sm ">Agregar Socio</a>
                    </td>
                </tr>
            </table>
        </div>
        <div class="container" >
            <table class="table table-bordered" >
                <tr class="text-primary thead-dark">
                    <th class="text-center">NOMBRE</th>
                    <th class="text-center">APELLIDO</th>
                    <th class="text-center">DNI</th>
                    <th class="text-center">ACCIONES</th>
                </tr>
                <c:forEach items="${SocioBuscadoPorDni}" var="s">
                    <tr>
                        <th class="text-center">${s.nombre}</th>
                        <th class="text-center">${s.apellido}</th>
                        <th class="text-center">${s.dni}</th>
                        <td class="text-center">
                            <a href="EditarSocio?id=${s.id_socio}" class="btn btn-outline-success btn-sm "name="btnEditar">Editar</a>
                            <a href="EliminarSocio?id=${s.id_socio}" class="btn btn-outline-danger btn-sm ">Dar de baja</a>
                            <a href="Actividad_x_Socio" class="btn btn-outline-info btn-sm ">Agregar Actividad al Socio</a>
                        </td>
                    </tr> 
                </c:forEach>       
            </table>
        </div>
    </body>
</html>
