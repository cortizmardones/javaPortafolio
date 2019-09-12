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
    </head>

    <body>
        <form class="form-signin" action="pAdmin.jsp" method="POST">
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
            <input type="hidden" name="accion" value="login">    
            <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
            <p style="color: red;">${mensaje}</p>
            <p class="mt-5 mb-3 text-muted text-center">© Seguros por siempre</p>
        </form>
    </body>

</html>