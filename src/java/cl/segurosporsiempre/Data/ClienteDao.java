/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Cliente;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Raúl Pardo Zurita
 */
public class ClienteDao {
    
    private Conexion conn;

    public ClienteDao(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean agregarCliente(Cliente c)
    {
        try {
            
            CallableStatement pst = conn.getConnection().prepareCall("{ call SP_INSERTAR_EMPRESA(?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            pst.setString(1, c.getNombre());
            pst.setString(2, c.getDescripcion());
            pst.setInt(3, c.getRubro().getIdRubro());
            pst.setString(4, c.getRut());            
            pst.setBoolean(5, c.getEstado()); 
            pst.setString(6, c.getImagen()); 
            pst.setString(7, c.getCorreo()); 
            pst.setString(8, c.getRazonSocial()); 
            pst.setString(9, c.getDireccion()); 
            pst.setString(10, c.getContrato().getDescripcion()); 
            pst.setString(11, c.getContrato().getFechaInicio()); 
            pst.setBoolean(12, c.getEstado()); 
            pst.setString(13, c.getContrato().getFechaTermino() ); 
            
            pst.execute();
            
            return true;
            
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
           return false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());            
           return false;
        }
    }    
}