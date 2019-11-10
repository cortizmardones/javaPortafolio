<%-- 
    Document   : index
    Created on : 17-08-2019, 20:04:05
    Author     : Raúl Pardo Zurita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico">

        <title>Bienvenido a Seguros por siempre</title>

        <!-- Bootstrap core CSS -->
        <link href="css/altsbaha/bootstrap.min.css" rel="stylesheet">

        <!-- Estilos de plantilla -->
        <link href="css/altsbaha/floating-labels.css" rel="stylesheet">

        <link rel='icon' href='img/favicon.ico' type='image/x-icon' /> 

        <!-- Start of  Zendesk Widget script -->
        <script id="ze-snippet" src="https://static.zdassets.com/ekr/snippet.js?key=b79f88eb-4907-4e36-80ad-d601fb67032c"></script>
        <!-- End of  Zendesk Widget script --> 

    </head>

    <body>
        <form class="form-signin" action="login" method="POST">
            <div class="text-center mb-4">
                <h1 class="h3 mb-3 font-weight-normal">Seguros por siempre</h1>
                <p>Ingrese sus credenciales</p>
            </div>

            <div class="form-label-group">
                <input type="email" id="inputEmail" name="correo" class="form-control" placeholder="correo@dominio.com" required="" autofocus="">
                <label for="inputEmail">Correo electrónico</label>
            </div>

            <div class="form-label-group">
                <input type="password" id="inputPassword" name="contrasenia" class="form-control" placeholder="Contraseña" required="" autocomplete="off">
                <label for="inputPassword">Contraseña</label>
            </div> 

            <div id="categorias" align="center">
                <input type="radio" value="administrador" name="categoria" checked> Administrador &nbsp;
                <input type="radio" value="profesional" name="categoria"> Profesional &nbsp;
                <input type="radio" value="empresa" name="categoria"> Empresa &nbsp; <br> <br>
            </div>

            <input type="hidden" name="accion" value="login">    
            <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
            <p align="center"><a href='login?accion=recuperarPass'>¿Olvidó sus credenciales?</a></p>

            <p style="color: red;">${mensaje}</p>
            <p class="mt-5 mb-3 text-muted text-center">© Seguros por siempre</p>
        </form>

        <!-- Modales -->
        <div class="modal fade" id="cambiarPass" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
             aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Cambio de contraseña</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="login" method="POST">
                        <div class="modal-body">
                            <i style="color: red; font-size: small;">El cambio de contraseña es imperativo la primera vez que ingresa o si quiere reestablecer su contraseña</i> <br> <br>

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

                            <input type="hidden" name="accion" value="ingresarPrimeraVez" >
                            <input type="hidden" name="id" value="${idTemporal}" > 
                            <input type="hidden" name="loginTemporal" value="${loginTemporal}" >       
                            <input type="hidden" name="categoria" value="${categoria}" >                              

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                <input type="submit" class="btn btn-primary" value="Guardar Cambios">
                            </div>
                    </form>
                </div>
            </div>
        </div>  
    </div> 

    <div class="modal fade" id="pasoUno" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
         aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalCenterTitle"><b style="color: blue;">PASO 1 - Ingreso de correo</b></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form class="form-signin" action="login" method="POST">
                        
                        <label for="correo">Ingrese su correo electrónico:</label>
                        <input type="email" id="correo" name="correo" class="form-control" placeholder="correo@dominio.com" required="" autofocus=""> <br>
                        <input type="hidden" name="accion" value="pasarSegundaEtapa">
                        <div align="center">
                            <input type="submit" class="btn btn-primary" value="Siguiente" >
                        </div>                      
                </form>
            </div>
        </div>
    </div>  
                            
    <div class="modal fade" id="pasoDos" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
         aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalCenterTitle"><b style="color: blue;">PASO 2 - Verificación de identidad</b></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <h4>Revise su correo electrónico e ingrese abajo el código recibido</h4>
                <form action="login" method="POST">
                        
                        <label for="codigo">Ingrese el código:</label>
                        <input type="email" id="codigo" name="codigo" class="form-control" placeholder="correo@dominio.com" required="" autofocus=""> <br>
                        <input type="hidden" name="accion" value="pasarEtapaMod">
                        <input type="hidden" name="correo" value="${activeCorreo}">
                        <div align="center">
                            <input type="submit" class="btn btn-primary" value="Siguiente" >
                        </div>                      
                </form>
            </div>
        </div>
    </div>  
                            
</div>                              

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>                        
<script type="text/javascript">
                               $(window).on('load', function () {
                                   $('#${modal}').modal('show');
                               });
</script> 

</body>
</html>