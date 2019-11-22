/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Model;


/**
 *
 * @author Antonio
 */
public class Item {
    
    private long id;
    private String descripcion;
    private Boolean estado;
    private CheckList checklist;
    private Estado cumple;

    public Item() {
    }

    public Item(long id, String descripcion, Boolean estado, CheckList checklist, Estado cumple) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.checklist = checklist;
        this.cumple = cumple;
    }
    

    public Item(long id_item) {
        this.id = id_item;
    }

    public Estado getCumple() {
        return cumple;
    }

    public void setCumple(Estado cumple) {
        this.cumple = cumple;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public CheckList getChecklist() {
        return checklist;
    }

    public void setChecklist(CheckList checklist) {
        this.checklist = checklist;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", checklist=" + checklist + ", cumple=" + cumple + '}';
    }

   
    
    
    
    
}
