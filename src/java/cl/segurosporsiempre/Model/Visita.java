
package cl.segurosporsiempre.Model;

public class Visita {

    private long id;
    private Profesional profesional;
    private Empresa empresa;
    private String fecha;
    private Boolean estado;
    
    public Visita() {
    }

    public Visita(long id) {
        this.id = id;
    }

    public Visita(long id, Profesional profesional, Empresa empresa, String fecha, Boolean estado) {
        this.id = id;
        this.profesional = profesional;
        this.empresa = empresa;
        this.fecha = fecha;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Visita{" + "id=" + id + ", profesional=" + profesional + ", empresa=" + empresa + ", fecha=" + fecha + ", estado=" + estado + '}';
    }
     
    
    
}
