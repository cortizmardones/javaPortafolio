<%-- 
    Document   : adminHistorial
    Created on : 11-09-2019, 1:53:03
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

        <title>Seguros por siempre - Mantención de personas</title>
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
                        <a class="navbar-brand" href="baha?nav=aPanel">Seguros por siempre</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=aPanel">Inicio</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=aProfesionales">Profesionales</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=aClientes">Clientes</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=aPagos">Pagos</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=aOperaciones">Operaciones</a></li>
                                <li class="nav-item"> <a class="nav-link active" href="baha?nav=aCredenciales">Credenciales<span
                                            class="sr-only">(current)</span></a> </li>               
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
            <div class="row no-gutters pt-4">
                <c:if test="${mensaje eq 'agregarCredencialPos'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Persona ingresada con éxito al sistema
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'agregarCredencialNeg'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            No se pudo agregar la persona
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if> 
                <c:if test="${mensaje eq 'desactivarCredencialPos'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Persona desactivada exitosamente
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'desactivarCredencialNeg'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            Persona  no se pudo desactivar
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>  
                <c:if test="${mensaje eq 'activarCredencialPos'}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Persona activada exitosamente
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${mensaje eq 'activarCredencialNeg'}">
                    <div class="col-md-12">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            Persona  no se pudo activar
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>                 
            </div>
            <div class="row no-gutters pt-3" id="clienteDatwa">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-dark">Ingreso de personas y credenciales</div>
                        <div class="card-body"  onmouseover="limpiarRutAlFallar()">
                            <form action="credencial" method="POST">
                                <label for="correo">Correo (login):</label><br>
                                <input type="text" class="form-control" id="correo" name="correo" onblur="validarCorreo(this.value)" required> <div id="mjCorreo"></div> <br>  

                                <label for="nombre">Nombre del representate/profesional:</label><br>
                                <input type="text" class="form-control" id="nombre" name="nombre" onblur="validaNombrePersona(this.value)" required>  <div id="mjNombre"></div>  <br>   

                                <label for="rut">RUT:</label><br>
                                <input type="text" class="form-control input_rut" id="rut" name="rut"
                                       placeholder="16.432.567-K" required> <span id="rut-error" style="color: red"></span>  <div id="mjRut"></div>   <br>                            

                                <label for="password">Ingrese contraseña</label>
                                <input id="password" name="password" class="form-control" type="password" pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Debe tener al menos 6 caracteres' : '');
                                        if (this.checkValidity())
                                            form.password_two.pattern = this.value;"
                                       placeholder="Contraseña" required> <br>

                                <label for="password_two">Repita contraseña</label>
                                <input id="password_two" name="password_two" class="form-control" type="password" pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Debe ingresar la misma contraseña de arriba' : '');"
                                       placeholder="Confirmar contraseña" required> <br> 
                              
                                <label for="empresa">Empresa/Perfil:</label><br>
                                <select id="empresa" class="form-control" name="empresa" required>
                                    <c:forEach items="${rClientes}" var="empresa">
                                        <option value="${empresa.idCliete}">${empresa.nombre}</option>                                        
                                    </c:forEach>
                                </select>                                 
                                <div id="mjRubro"></div> <br>  
                                
                                <input type="hidden" name="accion" value="agregarCredencial">

                                <input type="submit" class="btn btn-primary" value="Agregar persona">
                            </form>
                        </div>
                    </div>
                </div>
            </div>             
            <div class="row no-gutters pt-3" id="clienteDatwa">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-dark">Personas en el sistema</div>
                        <div class="card-body" onmouseover="">
                            <table id="t2" class="table table-hover table-responsive-xl  table-dark ts">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Perfil</th>                                        
                                        <th scope="col">RUT</th>                                       
                                        <th scope="col">Correo</th> 
                                        <th scope="col">Estado</th>                                             
                                        <th scope="col">Operaciones</th>                                             
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${rCredenciales}" var="credencial">
                                        <tr>
                                            <td>${credencial.idLogin}</td>
                                            <td>${credencial.respresentante.nombre}</td>
                                            <td>${credencial.perfil.nombre}</td>
                                            <td>${credencial.respresentante.rut}</td>
                                            <td>${credencial.correo}</td>
                                            <td>
                                                <c:if test="${credencial.activado}">
                                                    <span style="color: #00FF41">ACTIVADO</span>
                                                </c:if>
                                                <c:if test="${!credencial.activado}">
                                                    <span style="color: red;">DESHABILITADO</span>
                                                </c:if>
                                            </td>
                                            <td>
                                                <div align="center">
                                                <c:if test="${credencial.activado}">
                                                    <a href="credencial?accion=desactivarPersona&id=${credencial.idLogin}"><img src="img/delete.png" onclick="return confirm('¿Desea desactivar este usuario?')" heght="20" width="20"></a> &nbsp;
                                                </c:if>
                                                <c:if test="${!credencial.activado}">
                                                   <a href="credencial?accion=activarPersona&id=${credencial.idLogin}"><img src="img/correcto.png" onclick="return confirm('¿Desea activar este usuario?')" heght="20" width="20"></a> &nbsp;
                                                </c:if> 
                                                    <a href="credencial?accion=gModificarPersona&id=${credencial.idLogin}"><img src="img/edit.png" onclick="return confirm('¿Desea modificar este usuario?')" heght="20" width="20"></a>
                                                    <a href="credencial?accion=gModificarPass&id=${credencial.idLogin}"><img src="img/candado.png" onclick="return confirm('¿Desea modificar la contraseña de este usuario?')" heght="20" width="20">
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