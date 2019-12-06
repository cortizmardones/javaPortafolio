<%-- 
    Document   : pAdmin
    Created on : 17-08-2019, 20:04:07
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

        <title>Seguros por siempre - Administrador</title>
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
                                <li class="nav-item active"> <a class="nav-link" href="baha?nav=aPanel">Inicio <span
                                            class="sr-only">(current)</span></a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=aProfesionales">Profesionales</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="baha?nav=aClientes">Clientes</a> </li>
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
                <c:if test="${usuarioActivo != null}">
                    <div class="col-md-12">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            Bienvenido(a) al sistema
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="row no-gutters pt-3" id="admindata">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-dark"> Mis datos </div>
                        <div class="card-body">
                            <div align="center">
                                <img class="border border-success" src="img/nrt.jpg" height="200"
                                     width="180" alt="CP"> <br> <br>
                                <!--Esto viene de LoginCOntroller-->
                                <b><u>Correo:</u></b> ${usuarioActivo.correo}<br>
                                <b><u>Perfil:</u></b> ${usuarioActivo.perfil.nombre} <br><br>
                            </div>
                            <div align="center">
                                <a class="btn btn-warning" style="color: black;" href="" role="button">Modificar datos</a>
                                <a class="btn btn-warning" style="color: black;" href="" role="button">Modificar
                                    contraseña</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row no-gutters pt-2" id="insercion">
                <div class="col-md-12">
                    <div class="card mb-3">
                        <div class="card-header text-white bg-dark">Envío de mensajes</div>
                        <div class="card-body">
                            <form>
                                <label for="cs">Seleccione cliente: </label>
                                <select name="cs" id="cs" class="form-control">
                                    <option value="v1">CLIENTE 1</option>
                                    <option value="v2">CLIENTE 2</option>
                                    <option value="v3">CLIENTE 3</option>
                                    <option value="v4">CLIENTE 4</option>
                                </select>                                
                                <br>
                                <label for="subject">Asunto: </label>
                                <input type="text" class="form-control" id="subject" name="subject" required>
                                <br>
                                <label for="mencuerpo">Mensaje:</label> &nbsp; &nbsp;
                                <textarea id="mencuerpo" name="mencuerpo" class="form-control" required></textarea> <br> <br>
                                <input type="submit" class="btn btn-primary" value="Notificar">
                            </form>
                        </div>
                    </div>
                </div>
            </div>



            <div class="row" id="clidata">

                <div class="col-md-12">
                    <div class="card">

                        <div class="card-header text-white bg-dark">
                            Gráficos de total de accidentes (2019): 
                        </div>

                        <div class="card-body">
                            <!--ACÁ VOY A CONSTRUIR EL GRÁFICO-->
                            <div class="container">
                                <div class="container">
                                    <div class="container">
                                        <div class="container">
                                            <div class="container">
                                                <div class="container">
                                                    <div class="container">
                                                        <c:forEach items="${graficos}" var="ContadorTotalAccidente">
                                                            <input type="text" id="enero" value="${ContadorTotalAccidente.enero}" hidden="">
                                                            <input type="text" id="febrero" value="${ContadorTotalAccidente.febrero}" hidden="">
                                                            <input type="text" id="marzo" value="${ContadorTotalAccidente.marzo}" hidden="">
                                                            <input type="text" id="abril" value="${ContadorTotalAccidente.abril}" hidden="">
                                                            <input type="text" id="mayo" value="${ContadorTotalAccidente.mayo}" hidden="">
                                                            <input type="text" id="junio" value="${ContadorTotalAccidente.junio}" hidden="">
                                                            <input type="text" id="julio" value="${ContadorTotalAccidente.julio}" hidden="">
                                                            <input type="text" id="agosto" value="${ContadorTotalAccidente.agosto}" hidden="">
                                                            <input type="text" id="septiembre" value="${ContadorTotalAccidente.septiembre}" hidden="">
                                                            <input type="text" id="octubre" value="${ContadorTotalAccidente.octubre}" hidden="">
                                                            <input type="text" id="noviembre" value="${ContadorTotalAccidente.noviembre}" hidden="">
                                                            <input type="text" id="diciembre" value="${ContadorTotalAccidente.diciembre}" hidden="">
                                                        </c:forEach>
                                                        <canvas id="myChart" width="auto" height="auto"></canvas>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <script src="js/grafico/grafico.js" type="text/javascript"></script>
                            <script src="js/grafico/jquery.js" type="text/javascript"></script>

                            <script>
                                var enero = $("#enero").val();
                                var febrero = $("#febrero").val();
                                var marzo = $("#marzo").val();
                                var abril = $("#abril").val();
                                var mayo = $("#mayo").val();
                                var junio = $("#junio").val();
                                var julio = $("#julio").val();
                                var agosto = $("#agosto").val();
                                var septiembre = $("#septiembre").val();
                                var octubre = $("#octubre").val();
                                var noviembre = $("#noviembre").val();
                                var diciembre = $("#diciembre").val();

                                var ctx = document.getElementById('myChart').getContext('2d');
                                var myChart = new Chart(ctx, {
                                    type: 'bar',
                                    data: {
                                        labels: ['1.Enero', '2.Febrero', '3.Marzo', '4.Abril', '5.Mayo', '6.Junio', '7.Julio', '8.Agosto', '9.Septiembre', '10.Octubre', '11.Noviembre', '12.Diciembre'],
                                        datasets: [{
                                                label: 'Cantidad de accidentes / Meses',
                                                data: [enero, febrero, marzo, abril, mayo, junio, julio, agosto, septiembre, octubre, noviembre, diciembre],
                                                backgroundColor: [
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(54, 162, 235, 0.6)',
                                                    'rgba(255, 99, 132, 0.6)'
                                                ],
                                                borderColor: [
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)',
                                                    'rgba(0, 0, 0, 1)'
                                                ],
                                                borderWidth: 1
                                            }]
                                    },
                                    options: {
                                        scales: {
                                            yAxes: [{
                                                    ticks: {
                                                        beginAtZero: true
                                                    }
                                                }]
                                        }
                                    }
                                });
                            </script>
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
    </body>

</html>