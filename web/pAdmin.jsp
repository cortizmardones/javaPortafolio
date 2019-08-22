<%-- 
    Document   : pAdmin
    Created on : 17-08-2019, 20:04:07
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

        <title>Seguros por siempre - Administrador</title>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <img src="img/spsbanner.png" alt="Seguros por siempre - Dashboard Administrador" class="img-fluid">
                </div>
            </div>
            <div class="row">
                <div class="col-xl-12">
                    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                        <a class="navbar-brand" href="#">Seguros por siempre</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item active"> <a class="nav-link" href="#">Inicio <span
                                            class="sr-only">(current)</span></a> </li>
                                <li class="nav-item"> <a class="nav-link" href="#">Profesionales</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="#">Clientes</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="#">Pagos</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="#">Operaciones</a> </li>
                                <li class="nav-item dropdown bg-dark">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Reportes
                                    </a>
                                    <div class="dropdown-menu bg-dark" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" style="color: #ff7b25" href="#">Clientes</a>
                                        <a class="dropdown-item" style="color: #ff7b25" href="#">Globales</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" style="color: #00FF41" href="#">Accidentabilidad</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
            <div class="row no-gutters pt-3" id="admindata">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-dark"> Mis datos </div>
                        <div class="card-body">
                            <div align="center">
                                <img class="border border-success" src="img/nachoql.png" height="200"
                                     width="180" alt="Nacho hueco"> <br> <br>
                                <b><u>Nombre:</u></b> Ignacio Villaroel <br>
                                <b><u>Perfil:</u></b> Administrador <br>
                                <b><u>Correo:</u></b> nacho@duoc.cl <br> <br>
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
            <div class="row no-gutters pt-2" id="insercion">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-dark"> Últimas operaciones </div>
                        <div class="card-body">
                            <table id="t2" class="table table-hover table-responsive-xl  table-dark ts">
                                <thead>
                                    <tr>
                                        <th scope="col">ID de operación</th>
                                        <th scope="col">Descripción</th>
                                        <th scope="col">Tipo</th>
                                        <th scope="col">Realizada por</th>
                                        <th scope="col">Fecha y hora</th>
                                        <th scope="col">Operaciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row"> 1 </th>
                                        <td> Pago 08-09</td>
                                        <td> Pago </td>
                                        <td>Aramark</td>
                                        <td>07-08-2019 18:30</td>
                                        <td> <a class="btn btn-primary" style="color: white;" href="" role="button">Ver
                                                detalle</a> &nbsp; &nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row"> 2 </th>
                                        <td> Desactivación cliente DUOC.CL</td>
                                        <td> Cese de servicios </td>
                                        <td>DUOC</td>
                                        <td>01-08-2019 00:00</td>
                                        <td> <a class="btn btn-primary" style="color: white;" href="" role="button" disabled>Ver
                                                detalle</a> &nbsp; &nbsp;
                                        </td>
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
    </body>

</html>