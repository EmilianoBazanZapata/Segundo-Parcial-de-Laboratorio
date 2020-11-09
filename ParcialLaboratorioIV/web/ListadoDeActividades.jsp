<%-- 
    Document   : ListadoDeActividades
    Created on : 24 oct. 2020, 2:08:37
    Author     : Emiliano
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Actividades</title>
    </head>
    <body>

        <c:choose>
            <c:when test="${usr}">
                <%@include file="Menues/MenuActividades.jsp" %>
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
                        <c:forEach items="${listadeactividades}" var="s">
                            <tr>
                                <th class="text-center">${s.actividad}</th>
                                <th class="text-center">${s.precio}</th>
                                <td class="text-center">

                                    <a href="ABMActividades?modo=editar&id=${s.id_actividad}" class="btn btn-outline-success btn-sm "name="btnEditar">Editar Actividad</a>
                                    <a href="ABMActividades?modo=versocios&id=${s.id_actividad}" class="btn btn-outline-primary btn-sm "name="btnEditar">Ver Socios</a>
                                    <a href="ABMActividades?modo=eliminar&id=${s.id_actividad}" class="btn btn-outline-danger btn-sm ">Eliminar</a>
                                </td>
                            </tr> 
                        </c:forEach>       
                    </table>
                </div>
            </c:when>
            <c:otherwise>
                <%@include file="infoError.jsp" %>
            </c:otherwise>
        </c:choose>
    </body>
</html>
