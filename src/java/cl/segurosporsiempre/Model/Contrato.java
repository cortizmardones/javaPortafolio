/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Model;

/**
 *
 * @author raulp
 */
public class Contrato {
    
    private Long id;
    private String fechaIngreso;
    private String fechaTermino;
    private String fechaContrato;
    private Boolean estado;

    public Contrato() {
    }

    public Contrato(Long id) {
        this.id = id;
    }

    public Contrato(Long id, String fechaIngreso, String fechaTermino, String fechaContrato, Boolean estado) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.fechaTermino = fechaTermino;
        this.fechaContrato = fechaContrato;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Contrato{" + "id=" + id + ", fechaIngreso=" + fechaIngreso + ", fechaTermino=" + fechaTermino + ", fechaContrato=" + fechaContrato + ", estado=" + estado + '}';
    }
}