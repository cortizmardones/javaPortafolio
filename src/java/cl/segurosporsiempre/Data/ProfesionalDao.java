
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Profesional;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_AGREGAR_PROFESIONAL(?,?,?,?,?,?,?,?) }");
            cst.setString(1, p.getNombres());
            cst.setString(2, p.getApellidos());
            cst.setString(3, p.getRut());
            cst.setString(4, p.getAvatar());
            cst.setString(5, p.getDireccion());
            cst.setInt(6, p.getFono());
            cst.setString(7, p.getFechaNacimiento());
            cst.setString(8, p.getContrato().getFechaContrato());
            
            cst.execute();
            
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfesionalDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(ProfesionalDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }  
}
