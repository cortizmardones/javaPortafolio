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
public class Prueba {
    
    private Long id;
    private Capacitacion capacitacion;
    private String descripcion;
    private String fecha;

    public Prueba() {
    }

    public Prueba(Long id) {
        this.id = id;
    }

    public Prueba(Long id, Capacitacion capacitacion, String descripcion, String fecha) {
        this.id = id;
        this.capacitacion = capacitacion;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Capacitacion getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Prueba{" + "id=" + id + ", capacitacion=" + capacitacion + ", descripcion=" + descripcion + ", fecha=" + fecha + '}';
    }
}