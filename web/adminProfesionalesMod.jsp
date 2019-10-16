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
            <div class="row no-gutters pt-4">
                <c:if test="${mensaje eq 'agregarProfesionalExito'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Profesional agregado al sistema exitosamente
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'agregarProfesionalFracaso'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            El profesional no se pudo agregar al sistema
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if> 
                <c:if test="${mensaje eq 'activarProfesionalExito'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Profesional activado
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if> 
                <c:if test="${mensaje eq 'activarProfesionalFracaso'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            Profesional no se pudo activar
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if> 
                <c:if test="${mensaje eq 'desactivarProfesionalExito'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Profesional desactivado
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if> 
                <c:if test="${mensaje eq 'desactivarProfesionalFracaso'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            Profesional no se pudo desactivar
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if> 
                <c:if test="${mensaje eq 'modificarProfesionalFracaso'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            El profesional no se pudo modificar
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>                 
            </div>
            <div class="row no-gutters pt-3" id="clienteData">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-dark"> Datos del profesional </div>
                        <div class="card-body" onmouseover="limpiarRutAlFallar()" onload="validarActualizarFoto()">                           
                            <form action="pro" method="post" enctype="multipart/form-data">                     

                                <label for="nombres">Nombres:</label><br>
                                <input type="text" class="form-control" id="nombres" name="nombres" onblur="validaNombres(this.value)" value="${proActivo.nombres}" required>  <div id="mjNombres"></div>  <br>

                                <label for="apellidos">Apellidos:</label><br>
                                <input type="text" class="form-control" id="apellidos" name="apellidos" onblur="validaApellidos(this.value)" value="${proActivo.apellidos}" required>  <div id="mjApellidos"></div>  <br>

                                ¿Desea actualizar foto? <br>
                                <input type="radio" id="r10" name="actualizarFoto" onclick="validarActualizarFoto()" value="indefinido"> Sí &nbsp;
                                <input type="radio" id="r11" name="actualizarFoto" onclick="validarActualizarFoto()" value="definido" checked> No &nbsp;
                                <input type="hidden" name="urlFoto" value="${proActivo.avatar}">
                                
                                <div id="baha-fotoupdate">
                                    <input type="hidden" name="status" value="non-part">
                                </div>

                                <label for="direccion">Dirección:</label><br>
                                <input type="text" class="form-control" id="direccion" name="direccion" onblur="validaDireccion(this.value)"  value="${proActivo.direccion}" required> <div id="mjDireccion"></div> <br> 
                                

                                <label for="correo">Correo (login):</label><br>
                                <input type="text" class="form-control" id="correo" name="correo" value="${proActivo.usuario.correo}"
                                       onblur="validarCorreo(this.value)" required>
                                <div id="mjCorreo"></div><br>                                

                                <label for="fono">Fono:</label><br>
                                <input type="text" class="form-control" id="fono" name="fono" onblur="validaFono(this.value)" minlength="9" maxlength="9"  value="${proActivo.fono}" required> <div id="mjFono"></div> <br>                                  

                                <label for="fechaNacimiento">Fecha de nacimiento</label><br>
                                <input type="datetime" class="form-control" name="fechaNacimiento"  id="fechaNacimiento"  value="${proActivo.fechaNacimiento}"  required>  <div id="mjFechaNacimiento"></div>  <br>     

                                <label for="fechaContrato">Fecha de contrato</label><br>
                                <input type="datetime" class="form-control" name="fechaContrato"  id="fechaContrato"  value="${proActivo.contrato.fechaContrato}"  required>  <div id="mjFechaContrato"></div>  <br> 

                                <label for="fechaTermino">Fecha de término</label><br>                               
                                <c:if test="${proActivo.contrato.fechaTermino != 'INDEFINIDO'}">
                                    <input type="radio" id="r1" name="indefinido" onclick="cambiarEstadoFechaTermino()" value="indefinido"> Sin fecha de termino &nbsp;
                                    <input type="radio" id="r2"  name="indefinido" onclick="cambiarEstadoFechaTermino()" checked value="definido"> Con fecha de termino                                    
                                </c:if>
                                <c:if test="${proActivo.contrato.fechaTermino == 'INDEFINIDO'}">
                                    <input type="radio" id="r1" name="indefinido" onclick="cambiarEstadoFechaTermino()" checked value="indefinido"> Sin fecha de termino &nbsp;
                                    <input type="radio" id="r2"  name="indefinido" onclick="cambiarEstadoFechaTermino()" value="definido"> Con fecha de termino                                     
                                </c:if>

                                <input type="hidden" name="fechaTerminoReservada" id="fechaTerminoReservada" value="${proActivo.contrato.fechaTermino}" >

                                <c:if test="${proActivo.contrato.fechaTermino != 'INDEFINIDO'}">
                                    <input type="datetime" class="form-control" name="fechaTermino"  id="fechaTermino"  value="${proActivo.contrato.fechaTermino}"  required>  <div id="mjFechaTermino"></div>  <br>                                        
                                </c:if>
                                <c:if test="${proActivo.contrato.fechaTermino == 'INDEFINIDO'}">
                                    <input type="datetime" class="form-control" name="fechaTermino"  id="fechaTermino"  value="${proActivo.contrato.fechaTermino}"  required>  <div id="mjFechaTermino"></div>  <br>                                    
                                </c:if>                                

                                <input type="hidden" name="accion" value="modificarProfesional">
                                <input type="hidden" name="id" value="${proActivo.id}">

                                <input type="submit" class="btn btn-primary" value="Modificar Profesional">
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
        <script>
            $("#fechaNacimiento").datetimepicker({
                isRTL: false,
                autoclose: true,
                language: 'es'
            });
        </script>  
        <script>
            $("#fechaTermino").datetimepicker({
                isRTL: false,
                autoclose: true,
                language: 'es'
            });
        </script>        
        <script src="js/bahascript.js"></script>        
    </body>

</html>