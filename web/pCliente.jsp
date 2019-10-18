<%-- 
    Document   : pCliente
    Created on : 12-09-2019, 1:03:14
    Author     : raulp
--%>

<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="es">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <link rel="stylesheet" href="css/bahastyles.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.18/datatables.min.css" />   
        <link rel='icon' href='img/favicon.ico' type='image/x-icon' />      

        <title>Seguros por siempre - Clientes</title>

        <!-- Start of  Zendesk Widget script -->
        <script id="ze-snippet" src="https://static.zdassets.com/ekr/snippet.js?key=b79f88eb-4907-4e36-80ad-d601fb67032c"></script>
        <!-- End of  Zendesk Widget script --> 
        <link href="css/jquery.datetimepicker.css" rel="stylesheet" />
        <link href="css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css"/>          
       
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <img src="img/spsbanner.png" alt="Seguros por siempre - Dashboard Administrador" class="img-fluid">
                </div>
            </div>
            <div class="row no-gutters">
                <div class="col-xl-10">
                    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                        <a class="navbar-brand" href="baha?nav=cPanel">Seguros por siempre</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item active"> <a class="nav-link" href="baha?nav=cPanel">Inicio <span
                                            class="sr-only">(current)</span></a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=cSolicitudes">Solicitudes</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=cPagos">Pagos</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=cReportes">Reportes</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="accidente?accion=reportarAccidente"><img src="img/reportar.png" title="Reportar accidente" height="25" width="25"></a> </li>
                            </ul>
                        </div>
                    </nav>
                </div>
                <div class="col-xl-2 pt-2 pr-2 bg-dark">
                    <div align="right">
                        <a href="logout" class="btn btn-danger">Salir</a>
                    </div>
                </div>                  
            </div>
            <div class="row no-gutters pt-4">
                <c:if test="${user != null}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Bienvenido(a) ${user.respresentante.nombre}
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="row no-gutters pt-4">
                <c:if test="${mensaje eq 'accidenteReportarExito'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Accidente reportado, un profesional de Segurita se comunicará con Ud. en la brevedad
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'accidenteReportarFracaso'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            No se pudo reportar accidente, contacte con un profesional de Segurita.
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>                
            </div>
            <div class="row no-gutters pt-3" id="cli">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-success">Mis datos</div>
                        <div class="card-body">
                            <div align="center">
                                <div align="center">
                                    <img src="img/aramark-1500x789.jpg"  height="200"  width="180" alt="" />    
                                </div>
                                <b><u>Nombre:</u></b> Aramark <br>                               
                                <b><u>Dirección:</u></b> Los Aromos 2050 <br>
                                <b><u>Correo:</u></b> ert.uiy@aramark.cl<br> <br>
                            </div>
                            <div align="center">
                                <a class="btn btn-warning" style="color: black;" href="" role="button">Modificar datos</a>
                                <a class="btn btn-warning" style="color: black;" href="" role="button">Modificar
                                    contraseña</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row no-gutters pt-3" id="clidata">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-success">Servicios</div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-xl-3">
                                    <div class="card border-danger mb-3" style="max-width: 18rem;">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title">Servicio base</h5>
                                            <p class="card-text">- 2 visitas al mes</p>
                                            <p class="card-text">- 10 asesorías</p>
                                            <p class="card-text">- 1 capacitación cada 2 meses</p>
                                            <p class="card-text">- 1 reporte</p>
                                            <p class="card-text">- Servicio de chat</p>
                                            <hr>
                                            <p class="card-text">ESTADO: ACTIVO</p>                                    
                                        </div>
                                    </div> 
                                </div>
                                <div class="col-xl-3">
                                    <div class="card border-success mb-3" style="max-width: 18rem;">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title">Servicio extra</h5>
                                            <h6 class="card-subtitle mb-2 text-muted">Modificación de lista de chequeo</h6><br>                                            
                                            <p class="card-text">Número de modificación: 2</p>
                                            <p>Fecha de solicitud: 13-09-2019 18:40</p>
                                            <hr>
                                            <p class="card-text">ESTADO: ACEPTADO</p>                                    
                                        </div>
                                    </div> 
                                </div>                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
            <div class="row no-gutters pt-3" id="footer">
                <div class="col-md-12 bg-dark text-white text-center py-4">
                    Copyright &copy;Seguros por siempre
                </div>
            </div>
        </div>
        

        <!-- Modal -->
        <div class="modal fade" id="reporteAccidente" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
             aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Reporte accidente</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="accidente" method="POST">
                        <div class="modal-body">
                            
                            <label for="causa">Causa:</label><br>
                            <input type="text" class="form-control" id="causa" name="causa" onblur="validaCausa(this.value)" required> <div id="mjCausa"></div> <br>  

                            <label for="detalle">Detalle:</label><br>
                            <textarea id="detalle" class="form-control" name="detalle"></textarea> <br>  

                            <label for="fecha">Fecha de ocurrencia</label><br>
                            <input type="datetime" class="form-control" name="fecha"  id="fecha"  required>  <div id="mjFechaOcurrencia"></div>  <br>                             


                            <label for="tipo">Tipo:</label><br>
                            <select name="tipo" id="tipo" class="form-control" required>
                                <c:forEach items="${tiposAccidente}" var="ta">
                                    <option value="${ta.id}">${ta.nombre}</option>
                                </c:forEach>
                            </select>  <br>                             
                            
                            <!-- empre -->
                            <input type="hidden" name="idEmpresa" value="${usuarioActivo.empresa.id}">  
                            <!-- idusu -->
                            <input type="hidden" name="idCliente" value="${usuarioActivo.id}">
                            
                            <input type="hidden" name="accion" value="consolidarReporte">
                            
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <input type="submit" class="btn btn-danger" value="Reportar accidente">
                        </div>                        
                    </form>
                </div>
            </div>          
        </div>                    
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.18/datatables.min.js"></script>
        <script type="text/javascript">
$(document).ready(function () {
    $('#t2').DataTable({
        "language": {
            "sProcessing": "Procesando...",
            "sLengthMenu": "Mostrar _MENU_ registros",
            "sZeroRecords": "No se encontraron resultados",
            "sEmptyTable": "Ningún dato disponible en esta tabla",
            "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "sInfoThousands": ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        }
    });
});
        </script>
        
        <script src="js/bootstrap-datetimepicker.js" type="text/javascript"></script>
        <script src="js/locales/bootstrap-datetimepicker.es.js" type="text/javascript"></script>          
        <script type="text/javascript">
            $(window).on('load', function () {
                $('#${modal}').modal('show');
            });
        </script>  
        <script>
            $("#fecha").datetimepicker({
                isRTL: false,
                autoclose: true,
                language: 'es'
            });
        </script>         
    </body>
</html>