/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Cliente;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

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
      
    public List<Cliente> obtenerClientesR()
    {
        try {
            List<Cliente> clientes = new LinkedList<>();
            Cliente c;
            
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_OBTENER_CLIENTES(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            
            cst.execute();
            
            ResultSet rs = (ResultSet)cst.getObject(1);
            
            while (rs.next())
            {
                c = new Cliente();
                c.setIdCliete(rs.getLong("ID_EMPRESA"));
                c.setNombre(rs.getString("NOMBRE"));
                
                clientes.add(c);
            }
            
            return clientes;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);           
            return null;
        }
    }    
}