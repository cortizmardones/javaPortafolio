
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

    <c:forEach items="${ubicacion}" var="ubicacionProfesional">
        <input type="number" step="any" id="longitud" value="${ubicacionProfesional.longitud}" >
        <input type="number" step="any" id="latitud" value="${ubicacionProfesional.latitud}">
    </c:forEach>
            
    <div id="map"></div>
    <hr>
    <a href="pAdmin.jsp"><button class="btn btn-success">Volver</button></a>

    <script>

        //var longitud = document.getElementById('longitud');
        //var latitud = document.getElementById('latitud');

        var longitud = -33.5833;
        var latitud = -70.7;

        var map;

        function initMap() {
            map = new google.maps.Map(document.getElementById('map'), {
                //center: {lat: latitud, lng: longitud},
                center: {lat: longitud, lng: latitud},
                zoom: 16
            });
        }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD12RTFCnDLUOfhQjKSj2PvLkBESgB6mSg&callback=initMap"
    async defer></script>
</body>
</html>