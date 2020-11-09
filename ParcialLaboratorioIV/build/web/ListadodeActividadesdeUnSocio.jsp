<%-- 
    Document   : ListadodeActividadesdeUnSocio
    Created on : 24 oct. 2020, 22:21:01
    Author     : Emiliano
--%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <c:choose>
            <c:when test="${usr}">
                <%@include file="Menues/MenuGeneral.jsp" %>
                <div class="container" >
                    <table class="table table-bordered" >
                        <tr class="text-primary thead-dark">
                            <th class="text-center">NOMBRE</th>
                            <th class="text-center">APELLIDO</th>
                            <th class="text-center">DNI</th>
                            <th class="text-center">ACTIVIDAD</th>
                            <th class="text-center">ACCIONES</th>
                        </tr>
                        <c:forEach items="${ActividadesdelSocio}" var="s">

                            <form method="POST" action="ActividadPorSocio?modo=dardebaja&id=${s.getId_Socio()}">
                                <c:if test="${s.activo}">
                                    <tr>
                                        <th class="text-center">${s.socio.getNombre()}</th>
                                        <th class="text-center">${s.socio.getApellido()}</th>
                                        <th class="text-center">${s.socio.getDni()}</th>
                                        <th class="text-center">${s.actividad.actividad}</th>
                                    <input type="Number"hidden class="hidden-md-down" name="idActividad" value="${s.getId_Actividad()}">
                                    <td class="text-center">
                                        <button type="submit" class="btn btn-outline-danger btn-sm ">Eliminar</button>
                                    </td>
                                    </tr>
                                </c:if>
                            </form>
                            <form method="POST" action="ActividadPorSocio?modo=activar&id=${s.getId_Socio()}">
                                <c:if test="${!s.activo}">
                                    <tr>
                                        <th class="text-center">${s.socio.getNombre()}</th>
                                        <th class="text-center">${s.socio.getApellido()}</th>
                                        <th class="text-center">${s.socio.getDni()}</th>
                                        <th class="text-center">${s.actividad.actividad}</th>
                                    <input type="Number"hidden class="hidden-md-down" name="idActividad" value="${s.getId_Actividad()}">
                                    <td class="text-center">
                                        <button type="submit" class="btn btn-outline-success btn-sm ">Activar</button>
                                    </td>
                                    </tr>
                                </c:if>
                            </form>
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
