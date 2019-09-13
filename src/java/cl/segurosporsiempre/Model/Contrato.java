/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Model;

/**
 *
 * @author Raúl Pardo Zurita
 */
public class Contrato {
    
    private Long idContrato;
    private Cliente cliente;
    private String descripcion;
    private String fechaInicio;
    private Boolean estado;
    private String fechaTermino;

    public Contrato() {
    }

    public Contrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public Contrato(Long idContrato, Cliente cliente, String descripcion, String fechaInicio, Boolean estado, String fechaTermino) {
        this.idContrato = idContrato;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.fechaTermino = fechaTermino;
    }

    public Long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }
}