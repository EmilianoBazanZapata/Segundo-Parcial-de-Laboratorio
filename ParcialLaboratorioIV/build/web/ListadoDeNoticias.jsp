<%-- 
    Document   : ListadoDeNoticias
    Created on : 24 oct. 2020, 2:20:43
    Author     : Emiliano
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>

        <c:choose>
            <c:when test="${usr}">
                <%@include file="Menues/MenuGeneral.jsp" %>
                <div>
                    <table class="table table-bordered table-responsive">

                        <tr>
                            <td class="text-center">
                                <a href="ABMNoticia?modo=agregar" class="btn btn-outline-info btn-sm ">Agregar Noticia</a>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="container" >
                    <table class="table table-bordered" >
                        <c:forEach items="${listadeNoticias}" var="s">
                            <c:if test="${s.activo}">
                                <div class="jumbotron">
                                    <h1 class="display-4">${s.titulo}</h1>
                                    <p class="lead">${s.noticia}</p>
                                    <hr class="my-4">
                                    <p></p>
                                    <a class="btn btn-primary btn-lg" href="ABMNoticia?modo=buscar&id=${s.actividad.getId_actividad()}" role="button">Buscar Solo Noticias de ${s.actividad.getActividad()}</a>

                                    <a class="btn btn-danger btn-lg" href="ABMNoticia?modo=eliminar&id=${s.id_noticia}" role="button">Eliminar</a>
                                </div>
                            </c:if>
                            <c:if test="${!s.activo}">
                                <div class="jumbotron">
                                    <h1 class="display-4">${s.titulo}</h1>
                                    <p class="lead">${s.noticia}</p>
                                    <hr class="my-4">
                                    <p></p>
                                    <a class="btn btn-success btn-lg" href="ABMNoticia?modo=habilitar&id=${s.id_noticia}" role="button">Habilitar</a>
                                </div>
                            </c:if>
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
