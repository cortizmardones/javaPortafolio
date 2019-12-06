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
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=cPagos">Finanzas</a> </li>
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
            <div class="row no-gutters pt-2">
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
                        <div class="card-header text-white bg-dark">Mis datos</div>
                        <div class="card-body">
                            <div align="center">
                                <div align="center">
                                    <img src="https://www.segurosporsiempre.cl/fotosEmpr/shell.png"  height="100"  width="100" alt="" />    
                                </div>
                                <b><u>Empresa:</u></b> ${usuarioActivo.empresa.razonSocial} <br>                               
                                <b><u>Dirección:</u></b> ${usuarioActivo.empresa.direccion} <br>
                                <b><u>Correo:</u></b> ${usuarioActivo.correo}<br> <br>
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
                        <div class="card-header text-white bg-dark">Resumen Servicios (Diciembre 2019): </div>
                        <div class="card-body">

                            <div class="row">

                                <div class="col-xl-3">
                                    <div class="card border-success mb-3">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title text-center">Accidentes Leves</h5>
                                            <c:forEach items="${aLeves}" var="ContadorAccidente">
                                                <p class="card-text text-center"> ${ContadorAccidente.contador}</p>  
                                            </c:forEach>    
                                        </div>
                                    </div> 
                                </div>

                                <div class="col-xl-3">
                                    <div class="card border-success mb-3">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title text-center">Visitas Realizadas</h5>
                                            <c:forEach items="${vRealizadas}" var="ContadorVisita">
                                                <p class="card-text text-center"> ${ContadorVisita.contador}</p>  
                                            </c:forEach>

                                        </div>
                                    </div> 
                                </div>

                                <div class="col-xl-3">
                                    <div class="card border-success mb-3">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title text-center">Capacitaciones Realizadas</h5>
                                            <c:forEach items="${cRealizadas}" var="ContadorCapacitacion">
                                                <p class="card-text text-center"> ${ContadorCapacitacion.contador}						</p>  
                                            </c:forEach>
                                        </div>
                                    </div> 
                                </div>

                                <div class="col-xl-3">
                                    <div class="card border-success mb-3">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title text-center"> Asesorías Realizadas</h5>
                                            <c:forEach items="${aRealizadas}" var="ContadorAsesoria">
                                                <p class="card-text text-center"> ${ContadorAsesoria.contador}</p>  
                                            </c:forEach>     
                                        </div>
                                    </div> 
                                </div>

                            </div>

                            <div class="row">

                                <div class="col-xl-3">
                                    <div class="card border-warning mb-3">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title text-center">Accidente Incapacitante</h5>
                                            <c:forEach items="${aMedios}" var="ContadorAccidente">
                                                <p class="card-text text-center"> ${ContadorAccidente.contador}</p>  
                                            </c:forEach>  

                                        </div>
                                    </div> 
                                </div>

                                <div class="col-xl-3">
                                    <div class="card border-warning mb-3">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title text-center">Visitas Pendientes</h5>
                                            <c:forEach items="${vPendientes}" var="ContadorVisita">
                                                <p class="card-text text-center"> ${ContadorVisita.contador}</p>  
                                            </c:forEach>  

                                        </div>
                                    </div> 
                                </div>

                                <div class="col-xl-3">
                                    <div class="card border-warning mb-3">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title text-center">Capacitaciones Pendientes</h5>
                                            <c:forEach items="${cPendientes}" var="ContadorCapacitacion">
                                                <p class="card-text text-center"> ${ContadorCapacitacion.contador}						</p>  
                                            </c:forEach>  

                                        </div>
                                    </div> 
                                </div>

                                <div class="col-xl-3">
                                    <div class="card border-warning mb-3">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title text-center"> Asesorías Pendientes</h5>
                                            <c:forEach items="${aPendientes}" var="ContadorAsesoria">
                                                <p class="card-text text-center"> ${ContadorAsesoria.contador}</p>  
                                            </c:forEach>   
                                        </div>
                                    </div> 
                                </div>

                            </div>

                            <div class="row">

                                <div class="col-xl-3">
                                    <div class="card border-danger mb-3">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title text-center">Accidentes Fatales</h5>
                                            <c:forEach items="${aGraves}" var="ContadorAccidente">
                                                <p class="card-text text-center"> ${ContadorAccidente.contador}</p>  
                                            </c:forEach>  

                                        </div>
                                    </div> 
                                </div>

                                <div class="col-xl-3">
                                    <div class="card border-danger mb-3">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title text-center">Visitas Canceladas</h5>
                                            <c:forEach items="${vCanceladas}" var="ContadorVisita">
                                                <p class="card-text text-center"> ${ContadorVisita.contador}</p>  
                                            </c:forEach>  

                                        </div>
                                    </div> 
                                </div>

                                <div class="col-xl-3">
                                    <div class="card border-danger mb-3">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title text-center">Capacitaciones Canceladas</h5>
                                            <c:forEach items="${cCanceladas}" var="ContadorCapacitacion">
                                                <p class="card-text text-center"> ${ContadorCapacitacion.contador}						</p>  
                                            </c:forEach>    
                                        </div>
                                    </div> 
                                </div>

                                <div class="col-xl-3">
                                    <div class="card border-danger mb-3">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title text-center"> Asesorías Canceladas</h5>
                                            <c:forEach items="${aCanceladas}" var="ContadorAsesoria">
                                                <p class="card-text text-center"> ${ContadorAsesoria.contador}</p>  
                                            </c:forEach>  
                                        </div>
                                    </div> 
                                </div>


                            </div>

                        </div>
                    </div>
                </div>
            </div>      

            <div class="row" id="clidata">

                <div class="col-md-12">
                    <div class="card">

                        <div class="card-header text-white bg-dark">
                            Números de accidentes por meses (2019): 
                        </div>

                        <div class="card-body">
                            <!--ACÁ VOY A CONSTRUIR EL GRÁFICO-->
                            <div class="container">
                                <div class="container">
                                    <div class="container">
                                        <div class="container">
                                            <div class="container">
                                                <div class="container">
                                                    <div class="container">
                                                        <c:forEach items="${graficos}" var="ContadorTotalAccidente">
                                                            <input type="text" id="enero" value="${ContadorTotalAccidente.enero}" hidden="">
                                                            <input type="text" id="febrero" value="${ContadorTotalAccidente.febrero}" hidden="">
                                                            <input type="text" id="marzo" value="${ContadorTotalAccidente.marzo}" hidden="">
                                                            <input type="text" id="abril" value="${ContadorTotalAccidente.abril}" hidden="">
                                                            <input type="text" id="mayo" value="${ContadorTotalAccidente.mayo}" hidden="">
                                                            <input type="text" id="junio" value="${ContadorTotalAccidente.junio}" hidden="">
                                                            <input type="text" id="julio" value="${ContadorTotalAccidente.julio}" hidden="">
                                                            <input type="text" id="agosto" value="${ContadorTotalAccidente.agosto}" hidden="">
                                                            <input type="text" id="septiembre" value="${ContadorTotalAccidente.septiembre}" hidden="">
                                                            <input type="text" id="octubre" value="${ContadorTotalAccidente.octubre}" hidden="">
                                                            <input type="text" id="noviembre" value="${ContadorTotalAccidente.noviembre}" hidden="">
                                                            <input type="text" id="diciembre" value="${ContadorTotalAccidente.diciembre}" hidden="">
                                                        </c:forEach>
                                                        <canvas id="myChart" width="auto" height="auto"></canvas>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <script src="js/grafico/grafico.js" type="text/javascript"></script>
                            <script src="js/grafico/jquery.js" type="text/javascript"></script>

                            <script>
                                var enero = $("#enero").val();
                                var febrero = $("#febrero").val();
                                var marzo = $("#marzo").val();
                                var abril = $("#abril").val();
                                var mayo = $("#mayo").val();
                                var junio = $("#junio").val();
                                var julio = $("#julio").val();
                                var agosto = $("#agosto").val();
                                var septiembre = $("#septiembre").val();
                                var octubre = $("#octubre").val();
                                var noviembre = $("#noviembre").val();
                                var diciembre = $("#diciembre").val();

                                var ctx = document.getElementById('myChart').getContext('2d');
                                var myChart = new Chart(ctx, {
                                    type: 'bar',
                                    data: {
                                        labels: ['1.Enero', '2.Febrero', '3.Marzo', '4.Abril', '5.Mayo', '6.Junio', '7.Julio', '8.Agosto', '9.Septiembre', '10.Octubre', '11.Noviembre', '12.Diciembre'],
                                        datasets: [{
                                                label: 'Cantidad de accidentes / Meses',
                                                data: [enero, febrero, marzo, abril, mayo, junio, julio, agosto, septiembre, octubre, noviembre, diciembre],
                                                backgroundColor: [
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(255, 99, 132, 0.6)'
                                                ],
                                                borderColor: [
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)'
                                                ],
                                                borderWidth: 1
                                            }]
                                    },
                                    options: {
                                        scales: {
                                            yAxes: [{
                                                    ticks: {
                                                        beginAtZero: true
                                                    }
                                                }]
                                        }
                                    }
                                });
                            </script>
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