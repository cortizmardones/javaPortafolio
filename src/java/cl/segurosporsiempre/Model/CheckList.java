
package cl.segurosporsiempre.Model;

public class CheckList {
    
    private Long id;
    private Visita visita;
    private String descripcion;
    private Boolean estado;
    
    //mas completo
    private Profesional profesional;
    private Rubro rubro;
    private Empresa empresa;

    public CheckList(Long id, Visita visita, String descripcion, Boolean estado, Profesional profesional, Rubro rubro, Empresa empresa) {
        this.id = id;
        this.visita = visita;
        this.descripcion = descripcion;
        this.estado = estado;
        this.profesional = profesional;
        this.rubro = rubro;
        this.empresa = empresa;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

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
