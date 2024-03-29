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
                        <a class="navbar-brand" href="baha?nav=cPanel">Seguros por siempre</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=cPanel">Inicio</a> </li>
                                <li class="nav-item active"> <a class="nav-link" href="baha?nav=cSolicitudes">Solicitudes<span
                                            class="sr-only">(current)</span></a> </li>
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

                <c:if test="${mensaje eq 'solicitarVisitaPos'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Solicitud de visita realizada con éxito, será atendida por un profesional de Segurita.
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>

                <c:if test="${mensaje eq 'cancelarVisitaPos'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            La visita fue cancelada con éxito.
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>

                <c:if test="${mensaje eq 'cancelarVisitaNeg'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            No se pudo cancelar la visita.
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>

                <c:if test="${mensaje eq 'solicitarVisitaNeg'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Solicitud de visita no realizada.
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>


            </div>  
            
            <div class="row no-gutters pt-3" id="cli1">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-success">Mis solicitudes</div>
                        <div class="card-body">
                            <table id="t2" class="table table-hover table-responsive-xl  table-dark ts">
                                <thead>
                                    <tr>
                                        <th scope="col">ID de solicitud</th>
                                        <th scope="col">Descripcion</th>
                                        <th scope="col">Tipo</th>
                                        <th scope="col">Fecha</th>
                                        <th scope="col">Estado</th>      
                                        <th scope="col">Detalles</th>                                         
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row"> 1 </th>
                                        <td>Una persona se cortó un brazo en mi empresa y necesito la asesoría pertinente para gestionar este caso.</td>
                                        <td>Asesoría por accidente</td>
                                        <td>13-09-2019 18:02</td>                                        
                                        <td>PENDIENTE DE APROBACIÓN</td> 
                                        <td>
                                            <a href="#" class="btn btn-primary">Detalles</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row"> 2 </th>
                                        <td>Mañana viene la ACHS a revisar señaléticas y necesito gestionar las que están en las zonas de seguridad.</td>
                                        <td>Asesoría ante ente fiscalizador</td>
                                        <td>12-09-2019 17:00</td>                                        
                                        <td>APROBADA</td> 
                                        <td>
                                            <a href="#" class="btn btn-primary">Detalles</a>
                                        </td>
                                    </tr>                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div> 
            
            <div class="row no-gutters pt-3" id="cli3">

                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-success"> Listado Visitas </div>
                        <div class="row no-gutters pt-2" id="insercion">
                            <div class="card-body">
                                <table id="t3" class="table table-hover table-responsive-xl  table-dark ts">
                                    <thead>
                                        <tr>
                                            <th scope="col">ID Visita:</th>
                                            <th scope="col">Profesional:</th>
                                            <th scope="col">Nombre Empresa:</th>
                                            <th scope="col">Fecha:</th>
                                            <th scope="col">Estado:</th>
                                            <th score="col">Generer QR</th>
                                            <th scope="col">Operaciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${visitas}" var="visita">
                                            <tr>
                                                <th scope="row"> ${visita.id} </th>
                                                <td> ${visita.profesional.nombres} ${visita.profesional.apellidos} </td>
                                                <td> ${visita.empresa.razonSocial} </td>
                                                <td> ${visita.fecha} </td>
                                                <td>                                                                 
                                                    <c:choose>
                                                        <c:when test="${visita.estado.id == '1'}">
                                                            <span style="color: greenyellow;">${visita.estado.descripcion} POR CLIENTE</span>
                                                        </c:when>
                                                        <c:when test="${visita.estado.id == '2'}">
                                                            <span style="color: goldenrod;">${visita.estado.descripcion} A UN PROFESIONAL</span>
                                                        </c:when>
                                                        <c:when test="${visita.estado.id == '3'}">
                                                            <span style="color: aqua;">${visita.estado.descripcion} POR EL PROFESIONAL</span>
                                                        </c:when>
                                                        <c:when test="${visita.estado.id == '4'}">
                                                            <span style="color: red;">${visita.estado.descripcion} POR UN PROFESIONAL</span>
                                                        </c:when>
                                                        <c:when test="${visita.estado.id == '5'}">
                                                            <span style="color: greenyellow;">${visita.estado.descripcion} POR EL PROFESIONAL</span>
                                                        </c:when>
                                                        <c:when test="${visita.estado.id == '6'}">
                                                            <span style="color: fuchsia;">${visita.estado.descripcion}</span> 
                                                        </c:when>
                                                        <c:when test="${visita.estado.id == '7'}">
                                                            <span style="color: hotpink;">${visita.estado.descripcion}</span>
                                                        </c:when>
                                                        <c:otherwise>${visita.estado.descripcion}</c:otherwise>
                                                    </c:choose>


                                                </td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${visita.estado.id == '3' }">
                                                            <span>                                                                             
                                                                <a href="VisitaController?accion=generarQR&id=${visita.id}" class="btn btn-primary">GENERAR QR</a>
                                                            </span>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a href="#" class="btn btn-secondary" >GENERAR QR</a>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </td>
                                                <td> <c:choose>
                                                        <c:when test="${visita.estado.id == '1' || visita.estado.id == '2' || visita.estado.id == '4' || visita.estado.id == '6'}">
                                                            <span>                                                                             
                                                                <a href=VisitaController?accion=cancelar&id=${visita.id} class="btn btn-danger" onclick="return confirm('¿Desea cancelar esta visita?')">Cancelar</a>                                                                        
                                                            </span>
                                                        </c:when>

                                                        <c:when test="${visita.estado.id == '3'}">
                                                            <span> 
                                                                <a href=VisitaController?accion=cancelar&id=${visita.id} class="btn btn-danger" onclick="return confirm('¿Desea cancelar esta visita?')">Cancelar</a

                                                            </span>
                                                        </c:when>

                                                        <c:when test="${visita.estado.id == '5'}">
                                                            <span> 
                                                                <a href="#" class="btn btn-secondary">SIN ACCIONES</a>

                                                            </span>
                                                        </c:when>
                                                        <c:when test="${visita.estado.id == '7'}">
                                                            <span> 
                                                                <a href="#" class="btn btn-secondary">SIN ACCIONES</a>
                                                            </span>
                                                        </c:when>

                                                        <c:otherwise>SIN ACCIONES</c:otherwise>
                                                    </c:choose></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>


                    <div class="card mb-3 primary">
                        <div class="card-header text-white bg-success">Solicitud de visitas</div>
                        <div class="card-body" onmouseover="limpiarRutAlFallar()">

                            <form action="VisitaController" method="POST" enctype="multipart/form-data">

                                <label for="fecha_for">Fecha: </label><br>
                                <input type="datetime" class="form-control" name="fecha" id="fecha_for" autocomplete="off" required>
                                <br>

                                <input type="hidden" name="accion" value="solicitarVisita">
                                <input type="hidden" name="empresa" value="${usuarioActivo.empresa.id}">   
                                <input type="hidden" name="profesional" value="241">       
                                <input type="submit" class="btn btn-success" value="Solicitar Visita">

                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
            
            
            
            
            
            <div class="row no-gutters pt-3" id="cli2">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-success">Solicitud de modificación de lista de chequeo</div>
                        <div class="card-body">
                            Modificaciones realizadas: 1 <br><br>
                            <label for="descripcionChequeo">Descripción:</label><br>
                            <input type="text" class="form-control" id="descripcionChequeo" name="descripcionChequeo" onblur="" required> <div id="mj"></div><br>
                            <label for="criterio">Criterio(s):</label><br>
                            <input type="text" class="form-control" id="criterio" name="criterio" onblur="" required> <div id="mj"></div><br>  
                            <label for="modc">Modificación(es):</label><br>
                            <input type="text" class="form-control" id="modc" name="modc" onblur="" required> <div id="mj"></div><br> 
                            <a href="#" class="btn btn-success">Solicitar</a>                           
                        </div>
                    </div>
                </div>
            </div>
            <div class="row no-gutters pt-3" id="cli3">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-success">Solicitud de capacitación</div>
                        <div class="card-body">
                            <form action="capacitacion" method="POST">
                                <label for="fechaCapacitacion">Fecha:</label><br>
                                <input type="datetime" class="form-control" id="fechaCapacitacion" name="fechaCapacitacion" onblur="" required> <div id="mj"></div><br>  

                                <label for="material">Material:</label><br>
                                <input type="text" class="form-control" id="material" name="materiales" onblur="" required> <div id="mj"></div><br>

                                <label for="asistentes">Número de asistentes:</label><br>
                                <input type="number" class="form-control" id="asistentes" name="asistentes" onblur="" required> <div id="mj"></div><br>

                                <label for="tema">Tema:</label><br>
                                <input type="text" class="form-control" id="tema" name="tema" onblur="" required> <div id="mj"></div><br> 

                                <input type="hidden" name="accion" value="agregarCapacitacion">
                                <input type="hidden" name="idEmpresa" value="${usuarioActivo.empresa.id}">
                                <input type="hidden" name="correo" value="${usuarioActivo.correo}">

                                <input type="submit" class="btn btn-success" value="Solicitar capacitacion">
                            </form>                            
                        </div>
                    </div>
                </div>
            </div> 
            <div class="row no-gutters pt-3" id="cli3">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-success">Solicitud de informe extra</div>
                        <div class="card-body">
                            <label for="descInforme">Descripción:</label><br>
                            <input type="text" class="form-control" id="descInforme" name="descInforme" onblur="" required> <div id="mj"></div><br>  

                            <a href="#" class="btn btn-success">Solicitar</a> 
                        </div>
                    </div>
                </div>
            </div>  
            <div class="row no-gutters pt-3" id="cli3">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-success">Solicitud de asesoría</div>                     
                        <div class="card-body">
                            Asesorías concretadas: 5 <br> <br>

                            <label for="descAsesoria">Descripción:</label><br>
                            <input type="text" class="form-control" id="descAsesoria" name="descAsesoria" onblur="" required> <div id="mj"></div><br>  

                            <label for="mot">Motivo:</label><br>
                            <select name="mot" class="form-control">
                                <option value="a1">Accidente</option>
                                <option value="a2">Fiscalización</option>
                            </select>
                            <br>
                            <a href="#" class="btn btn-success">Solicitar</a> 
                        </div>




                    </div>
                </div>
            </div> 
                                
            

        </div>

        <!-- Modal -->
        <div class="modal fade" id="imagen" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
             aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle"CÓDIGO QR</h5>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <form action="visita" method="POST">
                        <div class="modal-body">

                            <img src="${imagen}" class="img-fluid">

                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            <a href=baha?nav=cSolicitudes" class="btn btn-danger"



                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>

                    </div>                        
                </form>
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

<script type="text/javascript">
    $(document).ready(function () {
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

<script>
    $("#fecha_for").datetimepicker({
        isRTL: false,
        autoclose: true,
        language: 'es'
    });
</script>

</body>
</html>