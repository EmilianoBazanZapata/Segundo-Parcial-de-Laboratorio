<%-- 
    Document   : ActividadporSocio
    Created on : 23 oct. 2020, 17:12:45
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
        <c:choose>
            <c:when test="${usr}">

                <div>
                    <table class="table table-bordered table-responsive table-responsive-xl">
                        <tr>
                            <td class="text-center">      
                                <form method="post" action="ABMSocio?modo=agregaractividad&id=${IdSocio}">
                                    <select name="cboActividades">
                                        <c:forEach items="${Actividades}" var="p">
                                            <option value="${p.getId_actividad()}">${p.getActividad()}
                                            </c:forEach>  
                                    </select>
                                    <tr>
                                        <td> 
                                            <button type="submit" class="btn btn-primary">Agregar Actividad</button>
                                        </td>
                                    </tr>
                                </form>
                            </td>
                        </tr>
                    </table>
                </div>
            </c:when>
            <c:otherwise>
                <%@include file="infoError.jsp" %>
            </c:otherwise>
        </c:choose>
    </body>
</html>
