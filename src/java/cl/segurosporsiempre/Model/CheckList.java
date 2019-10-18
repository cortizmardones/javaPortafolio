
package cl.segurosporsiempre.Model;

public class CheckList {
    
    private Long id;
    private Visita visita;
    private String descripcion;
    private Boolean estado;

    public CheckList() {
    }

    public CheckList(Long id) {
        this.id = id;
    }

    public CheckList(Long id, Visita visita, String descripcion, Boolean estado) {
        this.id = id;
        this.visita = visita;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Visita getVisita() {
        return visita;
    }

    public void setVisita(Visita visita) {
        this.visita = visita;
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

    @Override
    public String toString() {
        return "CheckList{" + "id=" + id + ", visita=" + visita + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }
    
    
    
}
