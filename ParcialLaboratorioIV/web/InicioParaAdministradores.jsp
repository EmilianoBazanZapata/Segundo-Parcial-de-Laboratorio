<%-- 
    Document   : InicioParaAdministradores
    Created on : 27 oct. 2020, 9:49:04
    Author     : Emiliano
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Pagina Inicial</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="InicioParaAdministradores.jsp">Inicio <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ListadoDeSocios">Lista de Socios<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ListadoDeActividades">Lista de Actividades<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ListadoNoticia">Noticias<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ActividadesConMasGanancias">Reportes<span class="sr-only">(current)</span></a>
                </li>
            </ul>
        </div>
    </nav>
    <body>
        <div class="contact-info-area white-bg section-pt" style="padding-top: 100px">
            <div class="container-fluid">
                <div class="row row-eq-height no-gutter">
                    <div class="hidden-xs hidden-sm col-md-6 add-image-2" >
                        <img src="https://www.sanfernando.gob.ar/images/principales/1440x810_DJI0004-edit.jpg" width="100%"/>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-6 separador">
                        <div class="equal-style height-600 d-table" style="margin: auto;">
                            <div class="row dt-cell text-center" style="color: #333333;">
                                <div class="col-xs-12 col-sm-6 mobi-mb-30 separador-1">
                                    <div class="col-sm-6" style="max-width: 100%!important">
                                        <div class="info-box mb-135">
                                            <i class="fa fa-location-arrow fa-2x"></i>
                                            <h6>DIRECCI�N</h6>
                                            <p style="font-size: 16px">
                                                Calle Gral. Bustos 1508<br /> Jesus Mar�a, C�rdoba
                                            </p>
                                        </div>
                                    </div>
                                    <div class="col-sm-6" style="max-width: 100%!important">
                                        <div class="info-box">
                                            <i class="fa fa-envelope-o fa-2x"></i>
                                            <h6>Email</h6>
                                            <p>
                                                <a font-size: 16px">Polideportivomunicipal@gmail.com</a><br>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-6 separador-1">
                                    <div class="col-sm-6" style="max-width: 100%!important">
                                        <div class="info-box mb-135">
                                            <i class="fa fa-phone fa-2x"></i>
                                            <h6>TELEFONO DE CONTACTO</h6>
                                            <p>
                                                <a font-size: 16px;">03525 - 443732</a><br>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="col-sm-6" style="max-width: 100%!important">
                                        <div class="info-box">
                                            <i class="fa fa-clock-o fa-2x"></i>
                                            <h6>HORARIO</h6>
                                            <p style="font-size: 16px;">Lun a Vie ? 9:00 AM a 6:00 PM</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="card-body d-flex ">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                </div>
            </div>
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                </div>
            </div>
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                </div>
            </div>
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                </div>
            </div>
        </div>
    </body>
</html>