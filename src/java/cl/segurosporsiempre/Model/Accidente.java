/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Model;

/**
 *
 * @author PFT
 */
public class Accidente {
    
    private Long id;
    private TipoAccidente tipo;
    private Empresa emprea;
    private String fecha;
    private String causa;
    private String detalle;
    private Boolean estado;

    public Accidente() {
    }

    public Accidente(Long id) {
        this.id = id;
    }

    public Accidente(Long id, TipoAccidente tipo, Empresa emprea, String fecha, String causa, String detalle, Boolean estado) {
        this.id = id;
        this.tipo = tipo;
        this.emprea = emprea;
        this.fecha = fecha;
        this.causa = causa;
        this.detalle = detalle;
        this.estado = estado;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoAccidente getTipo() {
        return tipo;
    }

    public void setTipo(TipoAccidente tipo) {
        this.tipo = tipo;
    }

    public Empresa getEmprea() {
        return emprea;
    }

    public void setEmprea(Empresa emprea) {
        this.emprea = emprea;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Accidente{" + "id=" + id + ", tipo=" + tipo + ", emprea=" + emprea + ", fecha=" + fecha + ", causa=" + causa + ", detalle=" + detalle + ", estado=" + estado + '}';
    }
}