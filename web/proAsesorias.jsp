<%-- 
    Document   : adminClientes
    Created on : 17-08-2019, 20:05:06
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

        <title>Seguros por siempre - Administración de Asesorias</title>
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
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=pAccidentes">Accidentes</a></li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=pCapacitaciones">Capacitaciones</a> </li>
                                <li class="nav-item active"> <a class="nav-link active" href="baha?nav=pAsesorias">Asesorias<span
                                            class="sr-only">(current)</span></a> </li>
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
                <c:if test="${mensaje eq 'agregarAsesoriaPos'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Asesoría ingresada con éxito al sistema
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'agregarAsesoriaNeg'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            No se pudo agregar la asesoría en el sistema
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'desactivarAsesoriaPos'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Asesoria dejada pendiente exitosamente
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'desactivarAsesoriaNeg'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            La asesoría no se pudo dejar pendiente
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'activarAsesoriaPos'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Asesoría dejada hecha correctamente
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'activarAsesoriaNeg'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            La asesoría no se pudo dejar hecha
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>        
                <c:if test="${mensaje eq 'asesoriaNoEncontradaMod'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            No se encontró la asesoría que quiere modificar
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>  
                <c:if test="${mensaje eq 'modificarAsesoriaPos'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            La asesoría se modificó exitosamente
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>

                <c:if test="${mensaje eq 'modificarAsesoriaNeg'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            La asesoría no se pudo modificar
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>           
            </div>

            <div class="row no-gutters pt-3" id="asesoriaData">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-primary">Ingreso de asesoría</div>
                        <div class="card-body">
                            <form action="asesoria" method="POST">

                                <label for="empresa">Seleccione empresa: </label> <br>
                                <select id="empresa" class="form-control" name="empresa" required>
                                    <c:forEach items="${emp}" var="empresa">
                                        <option value="${empresa.id}">${empresa.razonSocial}</option>
                                    </c:forEach>
                                </select> <br>

                                <label for="profesional">Seleccione profesional: </label> <br>
                                <select id="profesional" class="form-control" name="profesional" required>
                                    <c:forEach items="${profesionales}" var="profesional">
                                        <option value="${profesional.id}">${profesional.nombres} ${profesional.apellidos}</option>                                    
                                    </c:forEach>                                
                                </select><br>

                                <label for="tipoAsesoria">Seleccione tipo de asesoría: </label> <br>
                                <select id="tipoAsesoria" class="form-control" name="tipoAsesoria" required>
                                    <c:forEach items="${tiposAsesorias}" var="TipoAsesoria">
                                        <option value="${TipoAsesoria.id}">${TipoAsesoria.nombre}</option>
                                    </c:forEach>
                                </select> <br>

                                <br>

                                <label for="fechaIngreso">Fecha de ingreso:</label> <br>
                                <input type="datetime" class="form-control" name="fechaIngreso"  id="fechaIngreso"  required>  <div id="mjfechaIngreso"></div>  <br>                                 

                                <label for="fechaRealizada">Fecha estimada realizada:</label> <br>
                                <input type="datetime" class="form-control" name="fechaRealizada"  id="fechaRealizada"  required>  <div id="mjfechaRealizada"></div>  <br>                                 

                                <input type="hidden" name="accion" value="agregarAsesoria">
                                <input type="submit" class="btn btn-primary" value="Agregar asesoría">

                            </form> 
                        </div>
                    </div>
                </div>
            </div>
            <div class="row no-gutters pt-3" id="clienteData">
                <div class="col-md-12">
                    <div class="card mb-3">

                        <div class="card-header text-white bg-primary"> Listado de Asesorías </div>
                            <div class="card-body" onmouseover="">
                                <table id="t2" class="table table-hover table-responsive-xl  table-dark ts">
                                    <thead>
                                        <tr>
                                            <th scope="col">ID Asesoría</th>
                                            <th scope="col">RUT</th>                                       
                                            <th scope="col">Nombre Empresa</th>
                                            <th scope="col">Fecha de ingreso</th>
                                            <th scope="col">Fecha estimada realización</th>
                                            <th scope="col">Estado</th>
                                            <th scope="col">Dirección</th>
                                            <th scope="col">Rubro</th>
                                            <th scope="col">Operaciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                         <c:forEach items="${asesorias}" var="asesoria">
                                        <tr>
                                            <td>${asesoria.id}</td>
                                            <td>${asesoria.empresa.rut}</td>                                      
                                            <td>${asesoria.empresa.razonSocial}</td>
                                            <td>${asesoria.fechaIngreso}</td>
                                            <td>${asesoria.fechaEstimadaRealizada}</td>
                                            <td><c:choose>
                                                    <c:when test="${asesoria.estado}">
                                                        <span style="color: greenyellow;">REALIZADA</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span style="color: red;">PENDIENTE</span>
                                                    </c:otherwise>
                                                </c:choose>  
                                            </td>
                                            <td>${asesoria.empresa.direccion}</td>
                                            <td>${asesoria.rubro.descripcion}</td>
                                            <td>
                                                <div align="center">
                                                    <c:choose>
                                                        <c:when test="${asesoria.estado}">
                                                            <a href="asesoria?accion=dejarPendiente&id=${asesoria.id}"><img src="img/reloj2.png" onclick="return confirm('Dejará esta asesoría como pendiente ¿Está seguro?')" title="Dejar pendiente" heght="20" width="20"></a> &nbsp;
                                                            </c:when>
                                                            <c:otherwise>
                                                            <a href="asesoria?accion=dejarHecha&id=${asesoria.id}"><img src="img/correcto.png" onclick="return confirm('Dejará esta asesoria como hecha, ¿Está seguro?')" title="Dejar hecha" heght="20" width="20"></a> &nbsp;
                                                            </c:otherwise>
                                                        </c:choose>
                                                    <a href="asesoria?accion=gModificarAsesoria&id=${asesoria.id}"><img src="img/edit.png" title="Modificar" heght="20" width="20"></a>
                                                </div>
                                            </td>
                                        </tr>
                                         </c:forEach>
                                    </tbody>
                                </table>
                            </div>


                      
                        <!--<div class="card-body" onmouseover="limpiarRutAlFallar()">
                            <form action="index.jsp" method="POST" enctype="multipart/form-data">                       
                                
                                <label for="nombre">Nombre de la empresa:</label><br>
                                <input type="text" class="form-control" id="nombre" name="nombre" onblur="validaNombreEmpresa(this.value)" required>  <div id="mjNombre"></div>  <br>

                                <label for="rut">RUT:</label><br>
                                <input type="text" class="form-control input_rut" id="rut" name="rut"
                                       placeholder="16.432.567-K" required> <span id="rut-error" style="color: red"></span>  <div id="mjRut"></div>   <br>

                                <label for="razonSocial">Razón social:</label><br>
                                <input type="text" class="form-control" id="razonSocial" name="razonSocial" onblur="validaRazonSocialEmpresa(this.value)"  required>  <div id="mjRazonSocial"></div>  <br>

                                <label for="logo">Logo:</label><br>
                                <input type="file" class="form-control-file" id="logo" name="logo" accept=".gif,.jpg,.jpeg"  required>  <div id="mjLogo"></div>  <br>                               

                                <label for="fechaContrato">Fecha de contrato</label><br>
                                <input type="datetime" class="form-control" name="fechaContrato"  id="fechaContrato"  required>  <div id="mjFechaContrato"></div>  <br> 

                                <label for="correo">Correo:</label><br>
                                <input type="text" class="form-control" id="correo" name="correo" onblur="validarCorreo(this.value)" required> <div id="mjCorreo"></div> <br>  
                                
                                <label for="direccion">Dirección:</label><br>
                                <input type="text" class="form-control" id="direccion" name="direccion" onblur="validaDireccion(this.value)" required> <div id="mjDireccion"></div> <br>            
                                
                                <label for="fono">Fono:</label><br>
                                <input type="text" class="form-control" id="fono" name="fono" onblur="validaFono(this.value)" minlength="9" maxlength="9" required> <div id="mjFono"></div> <br> 
                                
                                <label for="cantidad">Número de trabajadores:</label><br>
                                <input type="number" class="form-control" id="cantidad" name="cantidad" onblur="" min="0" required> <div id="mjCantidad"></div> <br>                                  
                                
                                <label for="rubro">Rubro:</label><br>
                                <select id="rubro" class="form-control" name="rubro" required>
                        <c:forEach items="${rRubros}" var="rubro">
                            <option value="${rubro.idRubro}">${rubro.nombre}</option>                                        
                        </c:forEach>
                    </select>                                 
                    <div id="mjRubro"></div> <br>                                  
                                                                                  
                    <input type="submit" class="btn btn-primary" value="Agregar Cliente">
                    
                </form>
            </div>-->
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
            $("#fechaIngreso").datetimepicker({
                isRTL: false,
                autoclose: true,
                language: 'es'
            });
        </script> 
        
         <script>
            $("#fechaRealizada").datetimepicker({
                isRTL: false,
                autoclose: true,
                language: 'es'
            });
        </script> 
        <script src="js/bahascript.js"></script>        
    </body>

</html>