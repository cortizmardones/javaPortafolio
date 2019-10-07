
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Profesional;

/**
 *
 * @author raulp
 */
public class ProfesionalDao {
    
    private Conexion conn;

    public ProfesionalDao(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean agregarProfesional(Profesional p)
    {
       return true; 
    }  
}
