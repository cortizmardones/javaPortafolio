
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Profesional;
import cl.segurosporsiempre.Model.Visita;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

public class VisitaDAO {
    
    private Conexion conn;
    
    public VisitaDAO(Conexion conn) {
        this.conn = conn;
    }
       
    public boolean agregarVisita (Visita v){
         try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_AGREGAR_VISITA(?,?,?) }");
            cst.setLong(1, v.getProfesional().getId());
            cst.setLong(2, v.getEmpresa().getId());
            cst.setString(3, v.getFecha());

            cst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     }
    
    
        public List<Visita> obtenerVisitas() {
        List<Visita> visitas = new LinkedList<>();
        Visita visita;
        Profesional profesional;
        Empresa empresa;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_OBTENER_VISITAS(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                
                visita = new Visita();
                visita.setId(rs.getLong("id_visita"));
               
                profesional = new Profesional();
                profesional.setId(rs.getLong("id_profesional"));
                profesional.setNombres(rs.getString("nombres"));
                
                empresa = new Empresa();
                empresa.setId(rs.getLong("id_empresa"));
                empresa.setRazonSocial(rs.getString("razon_social"));
               
                visita.setFecha(rs.getString("fecha"));
                visita.setEstado(rs.getBoolean("Estado"));
                
                visita.setProfesional(profesional);
                visita.setEmpresa(empresa);
                
                visitas.add(visita);
            }

            return visitas;

        } catch (SQLException ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}
