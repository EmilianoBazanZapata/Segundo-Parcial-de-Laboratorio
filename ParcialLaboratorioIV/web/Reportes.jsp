<%-- 
    Document   : Reportes
    Created on : 26 oct. 2020, 12:58:27
    Author     : Emiliano
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    </head>
    <body>
        <c:choose>
            <c:when test="${usr}">
                <%@include file="Menues/MenuGeneral.jsp" %>
                <h1 class="text-center">Actividades Con Mas Ganancias</h1>
                <table class="table table-bordered" >
                    <tr class="text-primary thead-dark">
                        <th class="text-center">ACTIVIDAD</th>
                        <th class="text-center">MONTO</th>
                    </tr>
                    <c:forEach items="${ActividadesConMasGanancias}" var="s">
                        <tr>
                            <th class="text-center">${s.actividad}</th>
                            <th class="text-center">${s.monto}</th>
                            </td>
                        </tr> 
                    </c:forEach> 

                </table>
                <h1 class="text-center">Monto Total Ganado</h1>
                <table class="table table-bordered" >
                    <tr class="text-primary thead-dark">
                        <th class="text-center">MONTO TOTAL GANADO</th>
                    </tr>
                    <c:forEach items="${monto}" var="s">
                        <tr>
                            <th class="text-center">${s.totalganado}</th>
                            </td>
                        </tr> 
                    </c:forEach> 
                </table>
                <div id="donutchart" style="width: 900px; height: 500px;"></div>

            </c:when>
            <c:otherwise>
                <%@include file="infoError.jsp" %>
            </c:otherwise>
        </c:choose>
    </body>
</html>
