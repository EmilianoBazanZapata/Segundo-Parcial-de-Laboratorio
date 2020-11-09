<%-- 
    Document   : AgregarActividad
    Created on : 22 oct. 2020, 19:01:11
    Author     : Emiliano
--%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Actividad</title>
    </head>
    <body>

    <c:choose>
        <c:when test="${usr}">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card card-signin my-5">
                            <div class="card-body">
                                <h5 class="card-title text-center">Agregar Actividad</h5>
                                <form method="POST" action="ABMActividades?modo=agregar" name="AgregarActividad" onsubmit="return validar()">
                                    <table>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">Actividad</label>
                                            <label class="col-sm-2 col-form-label" id="IdActividad" style="color:red" ></label>
                                            <div class="col-sm-12">
                                                <input type="text" class="form-control" name="txtActividad"
                                                       placeholder="Ingrese una Actividad"required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">Precio</label>
                                            <label class="col-sm-2 col-form-label" id="IdPrecio" style="color:red" ></label>
                                            <div class="col-sm-12">
                                                <input type="number" class="form-control" name="txtPrecio"
                                                       placeholder="Ingrese un Precio" min="0" pattern="^[0-9]+"required>
                                            </div>
                                        </div> 
                                        <div>
                                            <button type="submit" class="btn btn-primary btn-block" onclick=" return validar()">Agregar Actividad</button>
                                        </div>
                                    </table>
                                </form>
                                <div>
                                    <a href="ListadoDeActividades?modo=veractividades"type=" submit" class="btn btn-danger btn-block">Volver</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                function validar()
                {
                    var nombre = validarnombre();
                    var precio = ValidarDocumento();
                    if (nombre && precio)
                    {
                        return true;
                    } else
                    {
                        return false;
                    }
                }
                function validarnombre()
                {
                    var nombre = document.AgregarActividad.txtActividad.value;
                    var error = document.getElementById("IdActividad");
                    if (nombre === "")
                    {
                        error.textContent = "no debe ingresar nombres en blanco";
                        return false;
                    } else if (nombre.length < 4)
                    {
                        error.textContent = " El Nombre Es Muy Pequeño";
                        return false;
                    } else if (!validar.test(nombre))
                    {
                        error.textContent = "No Debe Ingresar Numeros";
                        return false;
                    }
                }
                function ValidarDocumento()
                {
                    var precio = document.AgregarActividad.txtPrecio.value;
                    var error = document.getElementById("IdPrecio");
                    if (precio == "")
                    {
                        error.textContent = " Debe Ingresar Un precio Valido";
                        return false;
                    } else if (precio.length < 0)
                    {
                        error.textContent = " El precio Es Muy Pequeño";
                        return false;
                    } else if (isNaN(precio))
                    {
                        error.textContent = " Debe Ingresar Numeros";
                        return false;
                    }
                }
            </script>
        </c:when>
        <c:otherwise>
            <%@include file="infoError.jsp" %>
        </c:otherwise>
    </c:choose>
</body>
</html>
