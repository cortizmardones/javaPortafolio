/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Model;

import java.util.List;

/**
 *
 * @author raulp
 */
public class Capacitacion {
    
    private Long id;
    private Empresa empresa;
    private Profesional profesional;
    private Prueba prueba;
    private List<Asistente> asistentes;
    private String fecha;
    private String materiales;
    private String correo;
    private Integer numeroAsistentes;
    private EstadoCapacitacion estadoCapacitacion;

    public Capacitacion() {
    }

    public Capacitacion(Long id) {
        this.id = id;
    }

    public Capacitacion(Long id, Empresa empresa, Profesional profesional, String fecha, String materiales, String correo, Integer numeroAsistentes, EstadoCapacitacion estadoCapacitacion) {
        this.id = id;
        this.empresa = empresa;
        this.profesional = profesional;
        this.fecha = fecha;
        this.materiales = materiales;
        this.correo = correo;
        this.numeroAsistentes = numeroAsistentes;
        this.estadoCapacitacion = estadoCapacitacion;
    }

    public EstadoCapacitacion getEstadoCapacitacion() {
        return estadoCapacitacion;
    }

    public void setEstadoCapacitacion(EstadoCapacitacion estadoCapacitacion) {
        this.estadoCapacitacion = estadoCapacitacion;
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

    public Prueba getPrueba() {
        return prueba;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    public List<Asistente> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<Asistente> asistentes) {
        this.asistentes = asistentes;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getNumeroAsistentes() {
        return numeroAsistentes;
    }

    public void setNumeroAsistentes(Integer numeroAsistentes) {
        this.numeroAsistentes = numeroAsistentes;
    }

    @Override
    public String toString() {
        return "Capacitacion{" + "id=" + id + ", empresa=" + empresa + ", profesional=" + profesional + ", prueba=" + prueba + ", asistentes=" + asistentes + ", fecha=" + fecha + ", materiales=" + materiales + ", correo=" + correo + ", numeroAsistentes=" + numeroAsistentes + ", estadoCapacitacion=" + estadoCapacitacion + '}';
    }
}