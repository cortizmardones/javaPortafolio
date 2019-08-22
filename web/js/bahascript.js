function limpiarRutAlFallar() {

    var rutLimpio = $.rut.formatear(document.getElementById("rut").value);

    var rutValido = $.rut.validar(rutLimpio);

    if (!rutValido && document.getElementById("rut").value != null  && document.getElementById("rut").value != "") {
        document.getElementById("rut").value = "";
        document.getElementById("rut-error").innerHTML= "RUT no válido, ingresar de nuevo";
    }
    if (rutValido && document.getElementById("rut").value != null  && document.getElementById("rut").value != "") {
        document.getElementById("rut-error").innerHTML= "<span style='color: green;'>RUT válido</span>";
    }    
}

function esCorreoElectronico(correoElectronico){
                 
    var patron = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(!correoElectronico.search(patron))
      return true;
    else
      return false;
}

