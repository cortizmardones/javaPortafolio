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
public class Capacitacion {
    
    private Long id;
    private Empresa empresa;
    private Profesional profesional;
    private String fecha;
    private String material;
    private String correoUsuarioOrigen;
    private Boolean estado;
    private Integer cantidadAsistentes;
    private String tema;

    public Capacitacion() {
    }

    public Capacitacion(Long id) {
        this.id = id;
    }

    public Capacitacion(Long id, Empresa empresa, Profesional profesional, String fecha, String material, String correoUsuarioOrigen, Boolean estado, Integer cantidadAsistentes, String tema) {
        this.id = id;
        this.empresa = empresa;
        this.profesional = profesional;
        this.fecha = fecha;
        this.material = material;
        this.correoUsuarioOrigen = correoUsuarioOrigen;
        this.estado = estado;
        this.cantidadAsistentes = cantidadAsistentes;
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCorreoUsuarioOrigen() {
        return correoUsuarioOrigen;
    }

    public void setCorreoUsuarioOrigen(String correoUsuarioOrigen) {
        this.correoUsuarioOrigen = correoUsuarioOrigen;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(Integer cantidadAsistentes) {
        this.cantidadAsistentes = cantidadAsistentes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    @Override
    public String toString() {
        return "Capacitacion{" + "id=" + id + ", empresa=" + empresa + ", profesional=" + profesional + ", fecha=" + fecha + ", material=" + material + ", correoUsuarioOrigen=" + correoUsuarioOrigen + ", estado=" + estado + ", cantidadAsistentes=" + cantidadAsistentes + ", tema=" + tema + '}';
    }
}