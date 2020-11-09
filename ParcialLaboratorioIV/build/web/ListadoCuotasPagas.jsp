<%-- 
    Document   : ListadoCuotasPagas
    Created on : 26 oct. 2020, 2:53:57
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
    <%@include file="Menues/MenuGeneral.jsp" %>
    <body> 
        <c:choose>
            <c:when test="${usr}">
                <table class="table table-bordered" >
                    <tr class="text-primary thead-dark">
                        <th class="text-center">FECHA DE PAGO</th>
                        <th class="text-center">MONTO TOTAL PAGADO</th>
                    </tr>
                    <c:forEach items="${listadeCuotasPagas}" var="s">
                        <tr>
                            <th class="text-center">${s.fecha}</th>
                            <th class="text-center">${s.total}</th>
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
