/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Model;

/**
 *
 * @author Raúl Pardo Zurita
 */
public class Cliente {
    
    private Long idCliete;
    private String nombre;
    private String descripcion;
    private Rubro rubro;
    private String rut;
    private Boolean estado;
    private String imagen;
    private String correo;
    private String razonSocial;
    private String direccion;
    private Contrato contrato;

    public Cliente() {
        this.descripcion = " ";        
    }

    public Cliente(Long idCliete) {
        this.idCliete = idCliete;
        this.descripcion = " ";       
    }

    public Cliente(Long idCliete, String nombre, Rubro rubro, String rut, Boolean estado, String imagen, String correo, String razonSocial, String direccion, Contrato contrato) {
        this.idCliete = idCliete;
        this.nombre = nombre;
        this.rubro = rubro;
        this.rut = rut;
        this.estado = estado;
        this.imagen = imagen;
        this.correo = correo;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.contrato = contrato;
        this.descripcion = " ";
    }

    public Long getIdCliete() {
        return idCliete;
    }

    public void setIdCliete(Long idCliete) {
        this.idCliete = idCliete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliete=" + idCliete + ", nombre=" + nombre + ", descripcion=" + descripcion + ", rubro=" + rubro + ", rut=" + rut + ", estado=" + estado + ", imagen=" + imagen + ", correo=" + correo + ", razonSocial=" + razonSocial + ", direccion=" + direccion + ", contrato=" + contrato + '}';
    }
    
    
}
