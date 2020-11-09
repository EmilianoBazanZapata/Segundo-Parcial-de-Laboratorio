<%-- 
    Document   : PagarFactura
    Created on : 25 oct. 2020, 14:26:34
    Author     : Emiliano
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <c:choose>
            <c:when test="${usr}">
                <form method="POST" action="ABMSocio?modo=pagarfactura&id=${IdSocio}">
                    <table>                
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" >Nombre</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtNombreSocio"
                                       placeholder="Ingrese el Nombre" value="${NombreSocio}"required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Apellido</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtApellidoSocio"
                                       placeholder="Ingrese el Apellido" value="${ApellidoSocio}"required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Dni</label>
                            <div class="col-sm-7">
                                <input type="Number" class="form-control" name="txtDni"
                                       placeholder="Ingrese el Dni" value="${DniSocio}"required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Forma de Pago</label>
                            <div class="col-sm-7">
                                <select name="cboFormadePago">
                                    <c:forEach items="${Forma_de_Pago}" var="p">
                                        <option value="${p.getId_Pago()}">${p.getForma_de_pago()}
                                        </c:forEach>  
                                </select>
                            </div>
                        </div>
                        <tr>
                            <td> 
                                <button type="submit" class="btn btn-primary">Pagar Cuota</button>
                            </td>
                        </tr>
                    </table>
                </form>
                <div>
                    <a href="ListadoDeSocios?modo=versocios"type=" submit" class="btn btn-danger">Volver</a>
                </div>
            </c:when>
            <c:otherwise>
                <%@include file="infoError.jsp" %>
            </c:otherwise>
        </c:choose>
    </body>
</html>
