<%-- 
    Document   : proVisitas
    Created on : 16-10-2019, 20:05:06
    Author     : Carlos Ortiz Mardones
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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.18/datatables.min.css" />
        <link rel='icon' href='img/favicon.ico' type='image/x-icon' />
        <link href="css/jquery.datetimepicker.css" rel="stylesheet" />
        <link href="css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="css/bahastyles.css">
        <title>Seguros por siempre - Administración de clientes</title>
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
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=pPanel">Inicio</a> </li>
                                <li class="nav-item active"> <a class="nav-link active" href="baha?nav=pVisitas">Visitas<span class="sr-only">(current)</span></a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=pAccidentes">Accidentes</a> </li>
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
                <c:if test="${mensaje eq 'agregarVisitaExito'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Visita agregada al sistema exitosamente
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'agregarVisitaFracaso'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            La visita no se pudo agregar al sistema
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if> 
                <c:if test="${mensaje eq 'activarVisitaExito'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Visita activada
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if> 
                <c:if test="${mensaje eq 'activarVisitaFracaso'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            La visita no se pudo activar
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if> 
                <c:if test="${mensaje eq 'desactivarVisitaExito'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Visita desactivada
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if> 
                <c:if test="${mensaje eq 'desactivarVisitaFracaso'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            La visita no se pudo desactivar
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>    
                <c:if test="${mensaje eq 'ModFracaso'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            No se pudo encontrar la empresa
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'modificarVisitaExito'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            La visita se modifico correctamente
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'modificarVisitasFracaso'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            La visita no se puedo modificar
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
            </div>


            <div class="row no-gutters pt-3" id="insercion">
                <div class="col-md-12">
                    <div class="card mb-3 primary">
                        <div class="card-header text-white bg-primary"> Creación de visitas</div>
                        <div class="card-body" onmouseover="limpiarRutAlFallar()">

                            <form action="VisitaController" method="POST" enctype="multipart/form-data">

                                <label>Profesional: </label><br>
                                <select id="profesional" class="form-control" name="profesional" required>
                                    <c:forEach items="${profesionales}" var="profesional">
                                        <option value="${profesional.id}"> ${profesional.nombres} ${profesional.apellidos} </option>
                                    </c:forEach>
                                </select>
                                <br>

                                <label>Empresa: </label><br>
                                <select id="empresa" class="form-control" name="empresa" required>
                                    <c:forEach items="${emp}" var="empresa">
                                        <option value="${empresa.id}">${empresa.razonSocial} </option>
                                    </c:forEach>
                                </select>
                                <br>

                                <label for="fecha_for">Fecha: </label><br>
                                <input type="datetime" class="form-control" name="fecha" id="fecha_for" autocomplete="off" required>
                                <br>


                                <label>Lista Cotejo: </label><br>
                                <select id="lista" class="form-control" name="lista" required>
                                    <c:forEach items="${checklists}" var="checklist">
                                        <option value="${checklist.id}">${checklist.descripcion} </option>
                                    </c:forEach>
                                </select>
                                <br>

                                <input type="hidden" name="accion" value="agregarVisita">
                                <input type="submit" class="btn btn-primary" value="Agregar Visita">

                            </form>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row no-gutters pt-3" id="clienteData">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-primary"> Listado Visitas </div>
                        <div class="row no-gutters pt-2" id="insercion">
                            <div class="card-body">
                                <table id="t2" class="table table-hover table-responsive-xl  table-dark ts">
                                    <thead>
                                        <tr>
                                            <th scope="col">ID Visita:</th>
                                            <th scope="col">Profesional:</th>
                                            <th scope="col">Nombre Empresa:</th>
                                            <th scope="col">Fecha:</th>
                                            <th scope="col">Estado:</th>
                                            <th scope="col">Operaciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${visitas}" var="visita">
                                            <tr>
                                                <th scope="row"> ${visita.id} </th>
                                                <td> ${visita.profesional.nombres} </td>
                                                <td> ${visita.empresa.razonSocial} </td>
                                                <td> ${visita.fecha} </td>
                                                <td> 
                                                    <c:choose>
                                                        <c:when test="${visita.estado}">
                                                            <span style="color: greenyellow;">ACTIVO</span>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <span style="color: red;">INACTIVO</span>
                                                        </c:otherwise>
                                                    </c:choose>   
                                                </td>
                                                <td>
                                                    <div align="center">
                                                        <c:choose>
                                                            <c:when test="${visita.estado}">
                                                                <a href="VisitaController?accion=desactivar&id=${visita.id}"><img src="img/delete.png" onclick="return confirm('¿Desea desactivar esta visita?')" title="Desactivar" heght="20" width="20"></a> &nbsp;
                                                                </c:when>
                                                                <c:otherwise>
                                                                <a href="VisitaController?accion=activar&id=${visita.id}"><img src="img/correcto.png" onclick="return confirm('¿Desea activar esta visita?')" title="Activar" heght="20" width="20"></a> &nbsp;
                                                                </c:otherwise>
                                                            </c:choose>
                                                        <a href="VisitaController?accion=gModificar&id=${visita.id}"><img src="img/edit.png" title="Modificar" heght="20" width="20"></a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
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
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
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
            $("#fecha_for").datetimepicker({
                isRTL: false,
                autoclose: true,
                language: 'es'
            });
        </script>
        <script src="js/bahascript.js"></script>
    </body>

</html>