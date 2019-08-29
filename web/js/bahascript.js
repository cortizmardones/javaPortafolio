function limpiarRutAlFallar() {

    var rutLimpio = $.rut.formatear(document.getElementById("rut").value);

    var rutValido = $.rut.validar(rutLimpio);

    if (!rutValido && document.getElementById("rut").value != null && document.getElementById("rut").value != "") {
        document.getElementById("rut").value = "";
        document.getElementById("rut-error").innerHTML = "RUT no válido, ingresar de nuevo";
    }
    if (rutValido && document.getElementById("rut").value != null && document.getElementById("rut").value != "") {
        document.getElementById("rut-error").innerHTML = "<span style='color: green;'>RUT válido</span>";
    }
}

function validarCorreo(correo)
{
    if (esCorreoElectronico(correo))
    {
        document.getElementById('mjCorreo').innerHTML = '<span style="color: green;">Correo con formato correcto</span>';
    } 
    else
    {
        novalido = '<span style="color: red;">No es un correo electrónico</span>';
        document.getElementById('correo').value = "";
        document.getElementById('mjCorreo').innerHTML = novalido;
    }
}

function esCorreoElectronico(correoElectronico) {
    var patron = /^([a-z]+[a-z1-9._-]*)@{1}([a-z1-9\.]{2,})\.([a-z]{2,3})$/;
    if (!correoElectronico.search(patron))
        return true;
    else
        return false;
}