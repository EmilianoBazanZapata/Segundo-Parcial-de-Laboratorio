<%-- 
    Document   : AgregarNoticia
    Created on : 24 oct. 2020, 1:37:25
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
        <table border ="1">
        </table>
        <div class="container">
            <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <h5 class="card-title text-center">Agregar Noticia</h5>
                            <form method="POST" action="AgregarNoticia">
                                <table>                
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Titulo</label>
                                        <div class="col-sm-7">
                                            <input type="text" class="form-control" name="txtTitulo"
                                                   placeholder="Ingrese El Titulo"required>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Noticia</label>
                                        <div class="col-sm-7">
                                            <input type="text" class="form-control" name="txtNoticia"
                                                   placeholder="Ingrese La Noticia"required>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Categoria</label>
                                        <div class="col-sm-7">
                                            <select name="cboActividades">
                                                <c:forEach items="${Actividades}" var="p">
                                                    <option value="${p.getId_actividad()}">${p.getActividad()}
                                                    </c:forEach>  
                                            </select>
                                        </div>
                                    </div>
                                    <tr>
                                        <td> 
                                            <button type="submit" class="btn btn-primary">Agregar</button>

                                        </td>
                                    </tr>
                                </table>
                            </form>
                            <div>
                                <a href="ListadoDeSocios"type=" submit" class="btn btn-danger">Volver</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
