<%-- 
    Document   : EditarSocio
    Created on : 22 oct. 2020, 20:56:56
    Author     : Emiliano
--%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="card card-signin my-5 ">
                        <div class="card-body">
                            <h5 class="card-title text-center">Editar Socio</h5>
                            <form method="POST" action="EditarSocio?id=${IdSocio}" name="AgregarSocio">
                                <table>                
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label" id="IdErrorNombre" style="color:red"></label>
                                        <div class="col-sm-12">
                                            <input type="text" class="form-control" name="txtNombreSocio"
                                                   placeholder="Ingrese el Nombre" value="${NombreSocio}"required>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label" id="IdErrorApellido" style="color:red"></label>
                                        <div class="col-sm-12"> 
                                            <input type="text" class="form-control" name="txtApellidoSocio"
                                                   placeholder="Ingrese el Apellido" value="${ApellidoSocio}"required>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label" id="IdErrorDni" style="color:red"></label>
                                        <div class="col-sm-12">
                                            <input type="Number" class="form-control" name="txtDni"
                                                   placeholder="Ingrese el Dni" value="${DniSocio}"required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary btn-block" onclick = "return ValidarSocio()">Editar</button>     
                                    </div>
                                </table>
                            </form>
                            <div>
                                <a href="ListadoDeSocios"type=" submit" class="btn btn-danger btn-block">Volver</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            function ValidarSocio()
            {
                var nombre = ValidarNombre();
                var apellido = ValidarApellido();
                var dni = ValidarDocumento();

                if (nombre && apellido && dni)
                {
                    return true;
                } else
                {
                    return false;
                }
            }
            function ValidarNombre()
            {
                var nombre = document.AgregarSocio.txtNombreSocio.value;
                var error = document.getElementById("IdErrorNombre");
                var validar = /^[a-z-A-Z]{1,64}$/;

                var validar = /^[a-z-A-Z]{1,128}$/;

                if (nombre == "")
                {
                    error.textContent = " Debe Ingresar Un Nombre ";
                    return false;
                } else if (!validar.test(nombre))
                {
                    error.textContent = "No Debe Ingresar Numeros";
                    return false;
                } else if (nombre.length < 4)
                {
                    error.textContent = " El Nombre Es Muy Pequeño";
                    return false;
                } else
                {
                    return true;
                }
            }
            function ValidarApellido()
            {
                var apellido = document.AgregarSocio.txtApellidoSocio.value;
                var error = document.getElementById("IdErrorApellido");
                var validar = /^[a-z-A-Z- -]{1,64}$/;

                if (apellido == "")
                {
                    error.textContent = " Debe Ingresar Un Nombre ";
                    return false;
                } else if (!validar.test(apellido))
                {
                    error.textContent = "No Debe Ingresar Numeros";
                    return false;
                } else if (apellido.length < 4)
                {
                    error.textContent = " El Nombre Es Muy Pequeño";
                    return false;
                } else
                {
                    return true;
                }
            }
            function ValidarDocumento()
            {
                var dni = document.AgregarSocio.txtDni.value;
                var error = document.getElementById("IdErrorDni");
                if (dni === "")
                {
                    error.textContent = " Debe Ingresar Un Dni Valido";
                    return false;
                } else if (dni.length < 8)
                {
                    error.textContent = " El Dni Es Muy Pequeño";
                    return false;
                } else if (isNaN(dni))
                {
                    error.textContent = " Debe Ingresar Numeros";
                    return false;
                } else
                {
                    return true;
                }
            }
        </script>                         
    </body>
</html>
