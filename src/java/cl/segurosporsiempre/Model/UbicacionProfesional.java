
package cl.segurosporsiempre.Model;


public class UbicacionProfesional {
    
    private long id;
    public double longitud;
    public double latitud;

    public UbicacionProfesional() {
    }

    public UbicacionProfesional(long id) {
        this.id = id;
    }

    public UbicacionProfesional(long id, double longitud, double latitud) {
        this.id = id;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

 


 
    
    
}
