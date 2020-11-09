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
    <%@include file="Menues/MenuGeneral.jsp" %>
    <body>
        <c:choose>
            <c:when test="${usr}">
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
            </c:when>
            <c:otherwise>
                <%@include file="infoError.jsp" %>
            </c:otherwise>
        </c:choose>
    </body>
</html>
