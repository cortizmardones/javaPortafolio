<%-- 
    Document   : pCliente
    Created on : 12-09-2019, 1:03:14
    Author     : raulp / cortiz / dsuarez
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
                                <li class="nav-item active"> <a class="nav-link" href="baha?nav=pPanel">Inicio <span
                                            class="sr-only">(current)</span></a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=pVisitas">Visitas</a> </li>
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
            <div class="row no-gutters pt-3" id="cli">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-primary">Mis datos</div>
                        <div class="card-body">
                            <div align="center">
                                <img src="${usuarioActivo.profesional.avatar}" class="rounded mx-auto d-block" high="100" width="100">                                
                                <b><u>Nombre:</u></b> ${usuarioActivo.profesional.nombres} ${usuarioActivo.profesional.apellidos} <br> 
                                <b><u>RUT:</u></b> ${usuarioActivo.profesional.rut} <br>                                 
                                <b><u>Dirección:</u></b> ${usuarioActivo.profesional.direccion} <br>
                                <b><u>Correo:</u></b> ${usuarioActivo.correo}<br> <br>
                            </div>
                            <div align="center">
                                <!--<a class="btn btn-warning" style="color: black;" href="" role="button">Modificar datos</a>-->
                                <a class="btn btn-warning" style="color: black;" href="pro?accion=gatillarModPass" role="button">Modificar contraseña</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--para exponer los graficos-->
            <div class="row no-gutters pt-3" id="clidata">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-primary">Evaluacion de Actividades:</div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-xl-3">
                                    <div class="card border-danger mb-3" style="max-width: 18rem;">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title">Visitas</h5>
                                            <!-- <p class="card-text">- Capacitación Laboral</p>
                                            <p class="card-text">- 29 - Septiembre - 2019</p>
                                            <p class="card-text">- 20 Personas</p>
                                            <p class="card-text">- Uso de EPP</p>
                                            <hr>
                                            <p class="card-text">ESTADO: PENDIENTE</p> -->                                 
                                        </div>
                                    </div> 
                                </div>
                                <div class="col-xl-3">
                                    <div class="card border-success mb-3" style="max-width: 18rem;">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title">Registros de Accidentes</h5>
                                            <!-- <p class="card-text">- Asesoría Legal</p>
                                            <p class="card-text">- 15 - Octubre - 2019</p>
                                            <p class="card-text">- 01 Personas</p>
                                            <p class="card-text">- Documentación Accidente</p>
                                            <hr>
                                            <p class="card-text">ESTADO: PENDIENTE</p>  -->
                                        </div>
                                    </div> 
                                </div> 
                                <div class="col-xl-3">
                                    <div class="card border-primary mb-3" style="max-width: 18rem;">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title">Capacitaciones</h5>
                                            <!-- <p class="card-text">- Visita revisión checklist</p>
                                            <p class="card-text">- 01 - Noviembre - 2019</p>
                                            <p class="card-text">- 01 Personas</p>
                                            <p class="card-text">- Visita programada</p>
                                            <hr>
                                            <p class="card-text">ESTADO: PENDIENTE</p> -->                                
                                        </div>
                                    </div> 
                                </div>
                                <div class="col-xl-3">
                                    <div class="card border-warning mb-3" style="max-width: 18rem;">
                                        <div class="card-body text-dark">
                                            <h5 class="card-title">Asesorias</h5>
                                            <!-- <p class="card-text">- Capacitación Laboral</p>
                                            <p class="card-text">- 02 - Noviembre - 2019</p>
                                            <p class="card-text">- 25 Personas</p>
                                            <p class="card-text">- Normas de bioseguridad</p>
                                            <hr>
                                            <p class="card-text">ESTADO: PENDIENTE</p> -->                                   
                                        </div>
                                    </div> 
                                </div>                                 
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
        <!--modal para boton cambiar contrseña-->            
        <div class="modal fade" id="cambiarPassProfesional" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
             aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Cambio de contraseña</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">
                        <form action="login" method="POST">
                            <!--<i style="color: red; font-size: small;"></i> <br> <br>-->

                            <label for="password">Ingrese la nueva contraseña</label>
                            <input id="password" name="password" class="form-control" type="password" pattern="^\S{6,}$"
                                   onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Debe tener al menos 6 caracteres' : '');
                                           if (this.checkValidity())
                                               form.password_two.pattern = this.value;" placeholder="Contraseña" required>
                            <br>


                            <label for="password_two">Repita contraseña</label>
                            <input id="password_two" name="password_two" class="form-control" type="password"
                                   pattern="^\S{6,}$"
                                   onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Debe ingresar la misma contraseña de arriba' : '');"
                                   placeholder="Confirmar contraseña" required> <br>

                            <input type="hidden" name="accion" value="cambiarPassRec" >
                            <input type="hidden" name="id" value="${usuarioActivo.id}" >      
                            <input type="hidden" name="categoria" value="Profesional" >                              

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                <input type="submit" class="btn btn-primary" value="Guardar Cambios">
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
            <!--java script para modal-->
            <script type="text/javascript">
                $(window).on('load', function () {
                    $('#${modal}').modal('show');
                });
            </script> 
    </body>
</html>