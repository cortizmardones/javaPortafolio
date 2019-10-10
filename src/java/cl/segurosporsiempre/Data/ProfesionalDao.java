
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.ContratoProfesional;
import cl.segurosporsiempre.Model.Profesional;
import cl.segurosporsiempre.Model.Utils;
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
    
    public List<Profesional> obtenerProfesionales()
    {
        List<Profesional> profesionales = new LinkedList<>();
        Profesional profesional;
        ContratoProfesional contrato;
        
        try {
            
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_OBTENER_PROFESIONALES(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            
            cst.execute();
            
            ResultSet rs = (ResultSet)cst.getObject(1);
            
            while (rs.next())
            {
                profesional = new Profesional();
                profesional.setNombres(rs.getString("nombres"));
                profesional.setApellidos(rs.getString("apellidos"));
                profesional.setEstado(rs.getBoolean("estado"));
                profesional.setId(rs.getLong("id_profesional"));
                profesional.setRut(rs.getString("rut_profesional"));
                profesional.setDireccion(rs.getString("direccion"));
                profesional.setAvatar(rs.getString("avatar"));
                profesional.setFono(rs.getInt("fono"));
                profesional.setFechaNacimiento(Utils.FECHATRANSFORMADA(rs.getString("fecha_nacimiento").substring(0, 16)));
                
                contrato = new ContratoProfesional();
                contrato.setEstado(rs.getBoolean("estado_contrato"));
                contrato.setFechaContrato(Utils.FECHATRANSFORMADA(rs.getString("fecha_contrato").substring(0, 16)));
                contrato.setFechaIngreso(Utils.FECHATRANSFORMADA(rs.getString("fecha_ingreso").substring(0, 16)));
                contrato.setId(rs.getLong("id_contrato"));
                
                String termino = rs.getString("fecha_termino");
                
                if (termino != null)
                {
                    contrato.setFechaTermino(Utils.FECHATRANSFORMADA(termino.substring(0, 16)));
                }
                else
                {
                    contrato.setFechaTermino("INDEFINIDO");
                }
                
                profesional.setContrato(contrato);
                
                profesionales.add(profesional);
            }
            
            return profesionales;
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfesionalDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ProfesionalDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
