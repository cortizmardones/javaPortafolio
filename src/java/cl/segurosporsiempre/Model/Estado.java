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
public class Estado {
    
    private Long id;
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estado() {
    }

    public Estado(Long id_estado) {
        this.id = id_estado;
    }

    public Estado(Long id_estado, String nombre) {
        this.id = id_estado;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    

  
    
}
