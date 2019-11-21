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
public class Asistente {
    
    private Long id;
    private Capacitacion capacitacion;
    private String nombre;
    private Integer puntaje;
    private Double nota;

    public Asistente() {
    }

    public Asistente(Long id) {
        this.id = id;
    }

    public Asistente(Long id, Capacitacion capacitacion, String nombre, Integer puntaje, Double nota) {
        this.id = id;
        this.capacitacion = capacitacion;
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.nota = nota;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Asistente{" + "id=" + id + ", capacitacion=" + capacitacion + ", nombre=" + nombre + ", puntaje=" + puntaje + ", nota=" + nota + '}';
    }
    
}