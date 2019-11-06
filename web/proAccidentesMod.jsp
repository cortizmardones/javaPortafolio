<%-- 
    Document   : proAccidentesMod
    Created on : 26-10-2019, 02:57:25
    Author     : Tonino
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

        <title>Seguros por siempre - Administración de Accidentes</title>
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
                                <li class="nav-item active"> <a class="nav-link active" href="baha?nav=pAccidentes">Accidentes<span
                                            class="sr-only">(current)</span></a></li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=pCapacitaciones">Capacitaciones</a> </li>
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

            <div class="row no-gutters pt-4">
                <c:if test="${mensaje eq 'agregarAccidentePos'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Accidente ingresado con éxito al sistema
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'agregarAccidenteNeg'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            No se pudo agregar el accidente en el sistema
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'desactivarAccidentePos'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Desactivación de accidente exitosa
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'desactivarAccidenteNeg'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            El accidente no se pudo desactivar
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'activarAccidentePos'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Activación de accidente exitosa
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'activarAccidenteNeg'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            El accidente no se pudo activar
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>        
                <c:if test="${mensaje eq 'accidenteNoEncontradoMod'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            No se encontró el accidente a modificar
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>  
                <c:if test="${mensaje eq 'modificarAccidentePos'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Modificación de accidente realizada correctamente
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>

                <c:if test="${mensaje eq 'modificarAccidenteNeg'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            La modificación del accidente no se pudo realizar
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>           
            </div>

            <div class="row no-gutters pt-3" id="accidenteData">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-primary">Ingreso de accidente</div>
                        <div class="card-body">
                            <form action="accidentepro" method="POST">
                                <br>
                                <label for="empresa">Seleccione empresa: </label> <br>
                                <select id="empresa" class="form-control" name="empresa" required>
                                    <c:forEach items="${emp}" var="empresa">
                                        <c:choose>
                                            <c:when test="${atrAccidente.emprea.id eq empresa.id}">
                                                <option value="${empresa.id}" selected>${empresa.razonSocial}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${empresa.id}">${empresa.razonSocial}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select> <br>

                                <label for="tipoAccidente">Seleccione el tipo de accidente: </label> <br>
                                <select id="tipoAccidente" class="form-control" name="tipoAccidente" required>
                                    <c:forEach items="${tiposAccidente}" var="tipoAccidente">
                                        <c:choose>
                                            <c:when test="${atrAccidente.tipo.id eq tipoAccidente.id}">
                                                <option value="${tipoAccidente.id}" selected>${tipoAccidente.nombre}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${tipoAccidente.id}">${tipoAccidente.nombre}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select> <br>


                                <label for="fecha">Fecha del accidente:</label> <br>
                                <input type="datetime" class="form-control" name="fecha"  id="fecha"  value="${atrAccidente.fecha}" required>  <div id="mjfecha" required></div>  <br>   

                                <label for="causa">Causa del accidente:</label> <br>
                                <input type="text" class="form-control" id="causa" name="causa" value="${atrAccidente.causa}" required><br>

                                <label for="detalle">Detalle del accidente:</label> <br>                            

                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Detalle:<BR>(Max.250 caracteres)</span>
                                    </div>
                                    <textarea class="form-control" aria-label="Detalles" title="Detalle accidente"id="detalle" name="detalle" maxlength="250" required>${atrAccidente.detalle}</textarea>
                                </div>
                                <br>


                                <input type="hidden" name="accion" value="modificarAccidente">
                                <input type="hidden" name="id" value="${atrAccidente.id}">
                                <input type="submit" class="btn btn-primary" value="Modificar accidente">
                            </form>                            
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row no-gutters pt-2" id="insercion">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <!--<div class="card-header text-white bg-primary"> Lista de clientes </div>
                        <div class="card-body">
                            <table id="t2" class="table table-hover table-responsive-xl  table-dark ts">
                                <thead>
                                    <tr>
                                        <th scope="col">ID de cliente</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Logo</th>
                                        <th scope="col">RUT</th>                                       
                                        <th scope="col">Razón Social</th>
                                        <th scope="col">Fecha de contrato</th>
                                        <th scope="col">Fecha de ingreso</th>
                                        <th scope="col">Fecha de término</th>
                                        <th scope="col">Estado</th>
                                        <th scope="col">Correo</th>
                                        <th scope="col">Dirección</th>
                                        <th scope="col">Rubro</th>
                                        <th scope="col">Operaciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row"> 1 </th>
                                        <td>Aramark</td>
                                        <td><img src="https://tecnohoreca.com/wp-content/uploads/2018/06/aramark-1500x789.jpg" width="100" height="40" alt="Aramark"></td>
                                        <td>76.876.234-K</td>                                      
                                        <td>Aramark S.A.</td>
                                        <td>11-07-2019 17:00</td>
                                        <td>12-07-2019 10:00</td>
                                        <td>- No Disponible-</td>
                                        <td>ACTIVO</td>
                                        <td>r.pardo@aramark.cl</td>
                                        <td>Los Siameses #765</td>
                                        <td>PYME</td>
                                        <td>
                                            <div align="center">
                                                <a href=""><img src="img/delete.png" heght="20" width="20"></a> &nbsp;
                                                <a href=""><img src="img/edit.png" heght="20" width="20"></a>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>-->
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
            $("#fecha").datetimepicker({
                isRTL: false,
                autoclose: true,
                language: 'es'
            });
        </script> 
        
        <script src="js/bahascript.js"></script>   
        
        <!-- SCRIPT MAXLENGTH -->
        <script src="js/bootstrap-maxlength.min.js"></script>
        
        <script type="text/javascript">

                $('textarea').maxlength({

              alwaysShow: true,
                  threshold: 10,
                  warningClass: "label label-success",
                  limitReachedClass: "label label-danger",
                  separator: ' de ',
                  preText: 'Ha escrito ',
                  postText: ' caracteres disponibles.',
                  validate: true

        });

        </script>
        
    </body>

</html>