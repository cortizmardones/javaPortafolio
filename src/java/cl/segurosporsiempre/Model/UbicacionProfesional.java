
package cl.segurosporsiempre.Model;


public class UbicacionProfesional {
    
    private int id;
    private double longitud;
    private double latitud;

    public UbicacionProfesional() {
    }

    public UbicacionProfesional(int id) {
        this.id = id;
    }

    public UbicacionProfesional(int id, double longitud, double latitud) {
        this.id = id;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
