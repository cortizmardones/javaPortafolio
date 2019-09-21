<%-- 
    Document   : cliReportes
    Created on : 14-09-2019, 1:00:23
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
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=cPanel">Inicio</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=cSolicitudes">Solicitudes</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=cPagos">Pagos</a> </li>
                                <li class="nav-item active"> <a class="nav-link" href="baha?nav=cReportes">Reportes<span
                                            class="sr-only">(current)</span></a> </li>
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
            <div class="row no-gutters pt-3" id="infor1">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-success">Mis informes mensuales</div>
                        <div class="card-body">                            
                            <table id="t1" class="table table-hover table-responsive-xl  table-dark ts">
                                <thead>
                                    <tr>
                                        <th scope="col">ID de informe</th>
                                        <th scope="col">Descripción</th>                                       
                                        <th scope="col">Fecha de generación</th>
                                        <th scope="col">Estado</th>
                                        <th scope="col">Accidentabilidad</th>
                                        <th scope="col">Rendimiento</th>                                        
                                        <th scope="col">Operaciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Informe 07-2019</td>                                                                            
                                        <td>02-08-2019 10:00</td>
                                        <td>LISTO PARA DESCARGA</td>
                                        <td><span style="color: red;">8%</span></td>      
                                        <td>
                                            <img src="img/estrella1.png" width="20" heigth="20" alt="estrella"/>
                                            <img src="img/estrella1.png" width="20" heigth="20" alt="estrella"/>
                                            <img src="img/estrella1.png" width="20" heigth="20" alt="estrella"/>
                                        </td> 
                                        <td><a href=""><img src="img/descargar2.png" width="20" height="20" alt="Descargar"/></a></td>
                                    </tr>                                     
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>Informe 08-2019</td>                                                                            
                                        <td>02-09-2019 10:00</td>
                                        <td>LISTO PARA DESCARGA</td>
                                        <td><span style="color: orange;">6%</span></td>      
                                        <td>
                                            <img src="img/estrella1.png" width="20" heigth="20" alt="estrella"/>
                                            <img src="img/estrella1.png" width="20" heigth="20" alt="estrella"/>
                                            <img src="img/estrella1.png" width="20" heigth="20" alt="estrella"/>
                                            <img src="img/estrella1.png" width="20" heigth="20" alt="estrella"/>
                                            <img src="img/estrella1.png" width="20" heigth="20" alt="estrella"/>
                                        </td> 
                                        <td><a href=""><img src="img/descargar2.png" width="20" height="20" alt="Descargar"/></a></td>
                                    </tr>                                   
                                </tbody>
                            </table>                            
                        </div>
                    </div>
                </div>
            </div>  
            <div class="row no-gutters pt-3" id="infor2">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-success">Mis informes generales</div>
                        <div class="card-body">                            
                            <table id="t2" class="table table-hover table-responsive-xl  table-dark ts">
                                <thead>
                                    <tr>
                                        <th scope="col">ID de informe</th>
                                        <th scope="col">Descripción</th>                                       
                                        <th scope="col">Fecha de generación</th>
                                        <th scope="col">Estado</th>
                                        <th scope="col">Accidentabilidad(promedio)</th>
                                        <th scope="col">Rendimiento(tendencia)</th>                                        
                                        <th scope="col">Operaciones</th>
                                    </tr>
                                </thead>
                                <tbody>                                  
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Informe General - 2018</td>                                                                            
                                        <td>02-01-2019 10:00</td>
                                        <td>LISTO PARA DESCARGA</td>
                                        <td><span style="color: greenyellow;">1,5%</span></td>      
                                        <td>
                                            <img src="img/estrella1.png" width="20" heigth="20" alt="estrella"/>
                                            <img src="img/estrella1.png" width="20" heigth="20" alt="estrella"/>
                                            <img src="img/estrella1.png" width="20" heigth="20" alt="estrella"/>
                                            <img src="img/estrella1.png" width="20" heigth="20" alt="estrella"/>
                                        </td> 
                                        <td><a href=""><img src="img/descargar2.png" width="20" height="20" alt="Descargar"/></a></td>
                                    </tr>                                   
                                </tbody>
                            </table>                          
                        </div>
                    </div>
                </div>
            </div>                
            <div class="row no-gutters pt-3" id="infor3">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-success">Otros</div>
                        <div class="card-body">                            
                            <table id="t3" class="table table-hover table-responsive-xl  table-dark ts">
                                <thead>
                                    <tr>
                                        <th scope="col">ID de informe</th>
                                        <th scope="col">Descripción</th>                                       
                                        <th scope="col">Fecha de generación</th>
                                        <th scope="col">Estado</th>                                        
                                        <th scope="col">Operaciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Informe lista de cotejo 07-08-2019</td>                                                                            
                                        <td>07-08-2019 10:00</td>
                                        <td>LISTO PARA DESCARGA</td> 
                                        <td><a href=""><img src="img/descargar2.png" width="20" height="20" alt="Descargar"/></a></td>
                                    </tr>                                                                    
                                </tbody>
                            </table>                            
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
                $('#t1').DataTable({
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
                $('#t3').DataTable({
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
    </body>
</html>