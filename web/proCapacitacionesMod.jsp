<%-- 
    Document   : cliSolicitudes
    Created on : 12-09-2019, 1:03:37
    Author     : Raúl Pardo Zurita
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
                        <a class="navbar-brand" href="baha?nav=pPanel">Seguros por siempre</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=pPanel">Inicio</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=pVisitas">Visitas</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=pAccidentes">Accidentes</a> </li>
                                <li class="nav-item active"> <a class="nav-link" href="baha?nav=pCapacitaciones">Capacitaciones<span
                                            class="sr-only">(current)</span></a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=pAsesorias">Asesorias</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="https://segurosporsiempre7.zendesk.com/chat/agent?email-id=31423#home" target="_blank">Chat</a> </li>
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
            <div class="row no-gutters pt-2">
                <c:if test="${mensaje eq 'agregarCapacitacionExito'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Capacitación solicitada, espere confirmación de un prevensionista de Segurita.
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'agregarCapacitacionFracaso'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            La capacitación no se pudo agendar, intente nuevamente o hable con un profesional
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>                
            </div>                    
            <div class="row no-gutters pt-3" id="cli3">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-primary">Modificar capacitación</div>
                        <div class="card-body">
                            <form action="capacitacion" method="POST">
                                
                                <label for="fechaCapacitacion">Fecha:</label><br>
                                <input type="datetime" class="form-control" id="fechaCapacitacion" name="fechaCapacitacion" value="${rCapa.fecha}" onblur="" required> <div id="mj"></div><br>
                                
                                <label for="pro">Cambiar profesional:</label><br>
                                <select id="pro" name="pro" class="form-control">
                                    <c:forEach items="${profesionales}" var="pro">
                                        <c:choose>
                                            <c:when test="${pro.id eq rCapa.profesional.id}">
                                                <option value="${pro.id}" selected>${pro.nombres} ${pro.apellidos} </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${pro.id}">${pro.nombres} ${pro.apellidos} </option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select><br>                                

                                <label for="material">Material:</label><br>
                                <input type="text" class="form-control" id="material" name="materiales" onblur="" value="${rCapa.material}" required> <div id="mj"></div><br>

                                <label for="asistentes">Número de asistentes:</label><br>
                                <input type="number" class="form-control" id="asistentes" name="asistentes" onblur="" value="${rCapa.cantidadAsistentes}"  required> <div id="mj"></div><br>

                                <label for="tema">Tema:</label><br>
                                <input type="text" class="form-control" id="tema" name="tema" onblur="" value="${rCapa.tema}"  required> <div id="mj"></div><br> 
                                
                                <input type="hidden" name="accion" value="modificarCapacitacion">
                                <input type="hidden" name="id" value="${rCapa.id}">
                                
                                <input type="submit" class="btn btn-primary" value="Modificar capacitacion">
                                
                            </form>                            
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
            $("#fechaCapacitacion").datetimepicker({
                isRTL: false,
                autoclose: true,
                language: 'es'
            });
        </script>           
    </body>
</html>