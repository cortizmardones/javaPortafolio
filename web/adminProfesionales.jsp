<%-- 
    Document   : adminProfesionales
    Created on : 17-08-2019, 20:07:03
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

        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.18/datatables.min.css" />
        <link rel='icon' href='img/favicon.ico' type='image/x-icon' />   
        <link href="css/jquery.datetimepicker.css" rel="stylesheet" />
        <link href="css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css"/>   
        <link rel="stylesheet" href="css/bahastyles.css">

        <title>Seguros por siempre - Administración de profesionales</title>
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
                        <a class="navbar-brand" href="baha?nav=aPanel">Seguros por siempre</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=aPanel">Inicio </a> </li>
                                <li class="nav-item active"> <a class="nav-link" href="baha?nav=aProfesionales">Profesionales <span
                                            class="sr-only">(current)</span></a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=aClientes">Clientes </a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=aPagos">Pagos</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=aOperaciones">Operaciones</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=aCredenciales">Credenciales</a></li>                                 
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
                <div class="col-xl-2 pt-2 pr-2 bg-dark">
                    <div align="right">
                        <a href="logout" class="btn btn-danger">Salir</a>
                    </div>
                </div>                  
            </div>            
            <div class="row no-gutters pt-3" id="clienteData">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-dark"> Datos del profesional </div>
                        <div class="card-body" onmouseover="limpiarRutAlFallar()">
                            <form action="index.jsp" method="POST" enctype="multipart/form-data">                     

                                <label for="pnombre">Primer nombre:</label><br>
                                <input type="text" class="form-control" id="pnombre" name="pnombre" onblur="validaLetra(this.value, 'pnombre')" required>  <div id="mjPnombre"></div>  <br>

                                <label for="snombre">Segundo nombre:</label><br>
                                <input type="text" class="form-control" id="snombre" name="snombre" onblur="validaLetra(this.value, 'snombre')" required>  <div id="mjSnombre"></div>  <br>                                

                                <label for="appaterno">Apellido paterno:</label><br>
                                <input type="text" class="form-control" id="appaterno" name="appaterno" onblur="validaLetra(this.value, 'appaterno')" required>  <div id="mjAppaterno"></div>  <br>

                                <label for="apmaterno">Apellido materno:</label><br>
                                <input type="text" class="form-control" id="apmaterno" name="apmaterno" onblur="validaLetra(this.value, 'apmaterno')" required>  <div id="mjApmaterno"></div>  <br>

                                <label for="rut">RUT:</label><br>
                                <input type="text" class="form-control input_rut" id="rut" name="rut"
                                       placeholder="16.432.567-K" required> <span id="rut-error" style="color: red"></span>  <div id="mjRut"></div>   <br>

                                <label for="foto">Foto:</label><br>
                                <input type="file" class="form-control-file" id="foto" name="foto" accept=".gif,.jpg,.jpeg" required>  <div id="mjLogo"></div>  <br>                                   

                                <label for="fechaContrato">Fecha de contrato</label><br>
                                <input type="datetime" class="form-control" name="fechaContrato"  id="fechaContrato"  required>  <div id="mjFechaContrato"></div>  <br> 

                                <label for="correo">Correo:</label><br>
                                <input type="text" class="form-control" id="correo" name="correo" onblur="validarCorreo(this.value)" required> <div id="mjCorreo"></div> <br>  

                                <label for="direccion">Dirección:</label><br>
                                <input type="text" class="form-control" id="direccion" name="direccion" onblur="validaDireccion(this.value)" required> <div id="mjDireccion"></div> <br>            

                                <label for="fono">Fono:</label><br>
                                <input type="text" class="form-control" id="fono" name="fono" onblur="validaFono(this.value)" minlength="9" maxlength="9" required> <div id="mjFono"></div> <br>  

                                <input type="submit" class="btn btn-primary" value="Agregar Profesional">

                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row no-gutters pt-2" id="insercion">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-dark"> Lista de profesionales </div>
                        <div class="card-body">
                            <table id="t2" class="table table-hover table-responsive-xl  table-dark ts">
                                <thead>
                                    <tr>
                                        <th scope="col">ID de profesional</th>
                                        <th scope="col">Nombre completo</th>
                                        <th scope="col">RUT</th>                                       
                                        <th scope="col">Fecha de contrato</th>
                                        <th scope="col">Fecha de ingreso</th>
                                        <th scope="col">Fecha de término</th>
                                        <th scope="col">Estado</th>
                                        <th scope="col">Correo</th>
                                        <th scope="col">Fono</th>                                        
                                        <th scope="col">Dirección</th>
                                        <th scope="col">Operaciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row"> 1 </th>
                                        <td>Carlos Luis Pederneras Mena</td>                                       
                                        <td>16.785.699-4</td>                                      
                                        <td>11-07-2019 17:00</td>
                                        <td>12-07-2019 10:00</td>
                                        <td>- No Disponible-</td>
                                        <td>ACTIVO</td>
                                        <td>c.pedernerasm@alumnos.duoc.cl</td>
                                        <td>966255680</td>                                        
                                        <td>Los Siameses #765</td>
                                        <td>
                                            <div align="center">
                                                <a href=""><img src="img/delete.png" heght="20" width="20"></a> &nbsp;
                                                <a href=""><img src="img/edit.png" heght="20" width="20"></a>
                                            </div>
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
        <script src="js/jquery.rut.chileno.js"></script>
        <script type="text/javascript">
                                    jQuery(document).ready(function ($) {
                                        $('.input_rut').rut();
                                    });
        </script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $('.rut_rep').rut();
            });
        </script>        
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
        <script>
            $("#fechaContrato").datetimepicker({
                isRTL: false,
                autoclose: true,
                language: 'es'
            });
        </script> 
        <script src="js/bahascript.js"></script>        
    </body>

</html>