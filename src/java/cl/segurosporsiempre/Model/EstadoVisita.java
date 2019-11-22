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
public class EstadoVisita {
    
    private long id;
    private String descripcion;

    public EstadoVisita() {
    }

    public EstadoVisita(long id) {
        this.id = id;
    }

    public EstadoVisita(long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "EstadoVisita{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
    
}
