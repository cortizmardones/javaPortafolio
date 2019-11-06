/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Model;

/**
 *
 * @author Tonino
 */
public class Asesoria {
    
    private Long id;
    private Empresa empresa;
    private Rubro rubro;
    private Profesional profesional;
    private TipoAsesoria tipoAsesoria;
    private String fechaIngreso;
    private String fechaEstimadaRealizada;
    private Boolean estado;
    

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
        

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaEstimadaRealizada() {
        return fechaEstimadaRealizada;
    }

    public void setFechaEstimadaRealizada(String fechaEstimadaRealizada) {
        this.fechaEstimadaRealizada = fechaEstimadaRealizada;
    }

    public Boolean getEstado() {
        return estado;
    }

    public TipoAsesoria getTipoAsesoria() {
        return tipoAsesoria;
    }

    public void setTipoAsesoria(TipoAsesoria tipoAsesoria) {
        this.tipoAsesoria = tipoAsesoria;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    //Constructor General
    public Asesoria(Long id, Empresa empresa, Profesional profesional, TipoAsesoria tipoAsesoria, String fechaIngreso, String fechaEstimadaRealizada, Boolean estado) {
        this.id = id;
        this.empresa = empresa;
        this.profesional = profesional;
        this.tipoAsesoria = tipoAsesoria;
        this.fechaIngreso = fechaIngreso;
        this.fechaEstimadaRealizada = fechaEstimadaRealizada;
        this.estado = estado;
    }
    
    



    public Asesoria(Long id) {
        this.id = id;
    }
    
 
    public Asesoria(){}

//    public Asesoria(Long id, Empresa empresa, Rubro rubro, Profesional profesional, TipoAsesoria tipoAsesoria, String fechaIngreso, String fechaEstimadaRealizada, Boolean estado) {
//        this.id = id;
//        this.empresa = empresa;
//        this.rubro = rubro;
//        this.profesional = profesional;
//        this.tipoAsesoria = tipoAsesoria;
//        this.fechaIngreso = fechaIngreso;
//        this.fechaEstimadaRealizada = fechaEstimadaRealizada;
//        this.estado = estado;
//    }

    @Override
    public String toString() {
        return "Asesoria{" + "id=" + id + ", empresa=" + empresa + ", rubro=" + rubro + ", profesional=" + profesional + ", tipoAsesoria=" + tipoAsesoria + ", fechaIngreso=" + fechaIngreso + ", fechaEstimadaRealizada=" + fechaEstimadaRealizada + ", estado=" + estado + '}';
    }
    
    
    
    
    
    
   
    
    
}
