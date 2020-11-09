<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Socios Activos</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${usr}">
                <%@include file="Menues/MenuSocio.jsp" %>
                <h1 class="text-center">Lista de Socios</h1>
                <h1 class="text-center">Monto Total Ganado : ${monto}</h1>
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
                            <th class="text-center">ACTIVO</th>
                            <th class="text-center">ACCIONES</th>
                        </tr>
                        <c:forEach items="${listadeSocios}" var="s">

                            <c:if test="${s.activo}">
                                <tr>
                                    <th class="text-center">${s.nombre}</th>
                                    <th class="text-center">${s.apellido}</th>
                                    <th class="text-center">${s.dni}</th>
                                    <th class="text-center alert-success">SI</th>
                                    <td class="text-center">
                                        <a href="ABMSocio?modo=editar&id=${s.id_socio}" class="btn btn-outline-success btn-sm ">Editar</a>
                                        <a href="ABMSocio?modo=eliminar&id=${s.id_socio}" class="btn btn-outline-danger btn-sm ">Dar de baja</a>
                                        <a href="ABMSocio?modo=agregaractividad&id=${s.id_socio}" class="btn btn-outline-info btn-sm ">Agregar Actividad</a>
                                        <a href="ABMSocio?modo=listadodeactividades&id=${s.id_socio}" class="btn btn-outline-secondary btn-sm ">Ver Actividades</a>
                                        <a href="ABMSocio?modo=pagarfactura&id=${s.id_socio}" class="btn btn-outline-warning btn-sm ">Pagar Cuota</a>
                                        <a href="ABMSocio?modo=vercuotas&id=${s.id_socio}" class="btn btn-outline-dark btn-sm ">Cuotas Pagas</a>
                                    </td>
                                </tr> 
                            </c:if>
                            <c:if test="${!s.activo}">
                                <tr>
                                    <th class="text-center">${s.nombre}</th>
                                    <th class="text-center">${s.apellido}</th>
                                    <th class="text-center">${s.dni}</th>
                                    <th class="text-center alert-danger">NO</th>
                                    <td class="text-center">
                                        <a href="ABMSocio?modo=reactivar&id=${s.id_socio}" class="btn btn-outline-danger btn-sm ">Reactivar</a>
                                    </td>
                                </tr> 
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
