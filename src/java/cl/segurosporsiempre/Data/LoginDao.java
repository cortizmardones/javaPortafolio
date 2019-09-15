/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Login;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Raúl Pardo Zurita
 */
public class LoginDao {
    
    private Conexion conn;

    public LoginDao(Conexion conn) {
        this.conn = conn;
    }
    
    public Login obtenerLogin(Login l)
    {
        Login login;
        
        try {
            CallableStatement pst = conn.getConnection().prepareCall("{ call SP_LOGGIN(?,?,?) }");
            pst.setString(1, l.getCorreo());
            pst.setString(2, l.getPass());
            pst.registerOutParameter(3, OracleTypes.CURSOR);
            
            pst.execute();
            
            ResultSet rs = (ResultSet) pst.getObject(3); 
            
            rs.next();
            
            login = new Login();
            login.setIdLogin(rs.getLong("ID_PERFIL"));
            
            return login;
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}