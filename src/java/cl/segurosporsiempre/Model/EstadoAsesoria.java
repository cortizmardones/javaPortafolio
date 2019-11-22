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
public class EstadoAsesoria {
    
    private Long id;
    private String descripcion;

    public EstadoAsesoria() {
    }

    public EstadoAsesoria(Long id) {
        this.id = id;
    }

    public EstadoAsesoria(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "EstadoAsesoria{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
}
