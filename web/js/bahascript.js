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
    } else
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

function validaNombreEmpresa(input)
{
    var patron = /^[a-zñáéíóúüA-ZÑÁÉÍÓÚÜ0-9 ]+$/i;
    var patron2 = /^[^\s].+[^\s]$/

    nom = input.search(patron);
    nom2 = input.search(patron2);

    if (nom || nom2) {
        
        var novalido;
        
        if (nom)
        {
            novalido = '<span style="color: red;">El nombre de la empresa debe contener solamente letras o números</span>';
        }
        if (nom2)
        {
            novalido = '<span style="color: red;">El nombre no puede comenzar ni terminar con espacios</span>';
        }
        
        document.getElementById('nombre').value = "";
        document.getElementById('mjNombre').innerHTML = novalido;
    } else
    {
        document.getElementById('mjNombre').innerHTML = "";
    }
}

function validaRazonSocialEmpresa(input)
{
    var patron = /^[a-zñáéíóúüA-ZÑÁÉÍÓÚÜ0-9 ]+$/i;
    var patron2 = /^[^\s].+[^\s]$/

    nom = input.search(patron);
    nom2 = input.search(patron2);

    if (nom || nom2) {

        var novalido;
        
        if (nom)
        {
            novalido = '<span style="color: red;">La razón social debe contener solamente letras o números</span>';
        }
        if (nom2)
        {
            novalido = '<span style="color: red;">La razón social no puede comenzar ni terminar con espacios</span>';
        }
        
        document.getElementById('razonSocial').value = "";
        document.getElementById('mjRazonSocial').innerHTML = novalido;
    } else
    {
        document.getElementById('mjRazonSocial').innerHTML = "";
    }
}

function validaDireccion(input)
{
    var patron = /^[a-zñáéíóúüA-ZÑÁÉÍÓÚÜ0-9 ]+$/i;
    var patron2 = /^[^\s].+[^\s]$/

    nom = input.search(patron);
    nom2 = input.search(patron2);

    if (nom || nom2) {

        var novalido;
        
        if (nom)
        {
            novalido = '<span style="color: red;">La dirección debe contener solo letras o números</span>';
        }
        if (nom2)
        {
            novalido = '<span style="color: red;">La dirección no puede comenzar ni terminar con espacios</span>';
        }
        
        document.getElementById('direccion').value = "";
        document.getElementById('mjDireccion').innerHTML = novalido;
    } else
    {
        document.getElementById('mjDireccion').innerHTML = "";
    }
}

function validaFono(input)
{
    var patron = /^[0-9]+$/i;
    var patron2 = /^[^\s].+[^\s]$/

    nom = input.search(patron);
    nom2 = input.search(patron2);

    if (nom || nom2) {

        var novalido;
        
        if (nom)
        {
            novalido = '<span style="color: red;">El fono puede contener solo números, sin espacios intermedios</span>';
        }
        if (nom2)
        {
            novalido = '<span style="color: red;">No pueden haber espacios ni al comienzo ni al final del fono</span>';
        }
        
        document.getElementById('fono').value = "";
        document.getElementById('mjFono').innerHTML = novalido;
    } else
    {
        document.getElementById('mjFono').innerHTML = "";
    }    
}