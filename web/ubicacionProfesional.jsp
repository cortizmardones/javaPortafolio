
<%@page import="cl.segurosporsiempre.Model.UbicacionProfesional"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Simple Map</title>
        <meta name="viewport" content="initial-scale=1.0">
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            /* Always set the map height explicitly to define the size of the div
             * element that contains the map. */
            #map {
                height: 100%;
            }
            /* Optional: Makes the sample page fill the window. */
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
            }
        </style>
    </head>
    <body>

        <%

            List<UbicacionProfesional> lista = (List<UbicacionProfesional>) request.getAttribute("ubicacion");

            for (UbicacionProfesional x : lista) {

                out.print("<input type='number' step='any' id='latitud' value='");
                out.print(x.latitud);
                out.print("'>");

                out.print("<input type='number' step='any' id='longitud' value='");
                out.print(x.longitud);
                out.print("'>");
            }
        %>

        <a href="pAdmin.jsp"><button class="btn btn-success">Volver</button></a>    

        <div id="map"></div>

        <script>
            // Initialize and add the map
            function initMap() {
                // The location of Uluru
                //var latitud = document.getElementById('latitud');
                //var longitud = document.getElementById('longitud');
                
                var latitud = parseFloat(document.getElementById('latitud').value);
                var longitud = parseFloat(document.getElementById('longitud').value);

                //var latitudDecimal = latitud.toFixed(4);
                //var longitudDecimal = longitud.toFixed(1);

                //var latitudDecimal = latitud.replace(.,,);
                //var longitudDecimal = longitud.replace(.,,);

                //var latitud = -33.5833;
                //var longitud = -70.7;

                console.log(latitud);
                console.log(longitud);

                var uluru = {lat: latitud, lng: longitud};
                // The map, centered at Uluru
                var map = new google.maps.Map(
                        document.getElementById('map'), {zoom: 15, center: uluru});
                // The marker, positioned at Uluru
                var marker = new google.maps.Marker({position: uluru, map: map});
            }
        </script>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD12RTFCnDLUOfhQjKSj2PvLkBESgB6mSg&callback=initMap">
        </script>

    </body>

</html>