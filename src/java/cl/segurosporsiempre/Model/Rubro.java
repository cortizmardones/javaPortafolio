/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Model;

/**
 *
 * @author Raúl Pardo Zurita
 */
public class Rubro {
    private Integer idRubro;
    private String nombre;
    private String descripcion;

    public Rubro() {
    }

    public Rubro(Integer idRubro) {
        this.idRubro = idRubro;
    }

    public Rubro(Integer idRubro, String nombre, String descripcion) {
        this.idRubro = idRubro;
        this.nombre = nombre;
    }
   
    public Integer getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(Integer idRubro) {
        this.idRubro = idRubro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}