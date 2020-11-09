<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Bienvenido !!!</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="InicioParaAdministradores.jsp">Inicio <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ListadoDeSocios?modo=versocios">Lista de Socios<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ListadoDeActividades?modo=veractividades">Lista de Actividades<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ListadoNoticia?modo=noticias">Noticias<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ActividadesConMasGanancias?modo=reporte">Reportes<span class="sr-only">(current)</span></a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" method="POST" action="ABMSocio?modo=buscarsocio">
                <input class="form-control mr-sm-2" type="number" placeholder="Ingrese un DNI" aria-label="number"name="txtDocumentoBuscado"required min="0" pattern="^[0-9]+">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" required>Buscar</button>
            </form>
            <form class="form-inline my-2 my-lg-0" method="POST" action="CerrarSesion">
                <button class="btn btn-outline-danger my-2 my-sm-0" type="submit" required>Cerrar Sesion</button>
            </form>
        </div>
    </nav>
</html>
