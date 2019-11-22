
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.CheckList;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Profesional;
import cl.segurosporsiempre.Model.Rubro;
import cl.segurosporsiempre.Model.Visita;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

public class CheckListDAO {
    
       private Conexion conn;
    
     public CheckListDAO(Conexion conn) {
        this.conn = conn;
    }
     
        
     public List<CheckList> obtenerCheckList() {
        List<CheckList> checklists = new LinkedList<>();
        CheckList checklist;
        Visita visita;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_OBTENER_CHECKLIST(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                checklist = new CheckList();
                checklist.setId(rs.getLong("id_check_list"));
                
                visita = new Visita();
                visita.setId(rs.getLong("id_visita"));
                checklist.setVisita(visita);
                
                checklist.setDescripcion(rs.getString("descripcion"));
   
                checklist.setEstado(rs.getBoolean("estado"));
           
                checklists.add(checklist);
            }

            return checklists;

        } catch (SQLException ex) {
            Logger.getLogger(CheckListDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(CheckListDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     
    //LISTADO MÁS COMPLETO
    public List<CheckList> listarCheckList() {
        List<CheckList> checklists = new LinkedList<>();
        CheckList checklist;
        Visita visita;
        Empresa empresa;
        Profesional profesional;
        Rubro rubro;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_LISTAR_CHECKLIST(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                checklist = new CheckList();
                checklist.setId(rs.getLong("id_checklist"));

                visita = new Visita();
                visita.setId(rs.getLong("id_visita"));
                checklist.setVisita(visita);

                checklist.setDescripcion(rs.getString("descripcion"));

                empresa = new Empresa();
                empresa.setRazonSocial(rs.getString("nombre_empresa"));
                checklist.setEmpresa(empresa);

                rubro = new Rubro();
                rubro.setNombre(rs.getString("rubro"));
                checklist.setRubro(rubro);

                profesional = new Profesional();
                profesional.setNombres(rs.getString("nombre_profesional"));
                profesional.setApellidos(rs.getString("apellidos_profesional"));
                checklist.setProfesional(profesional);

                checklist.setEstado(rs.getBoolean("estado_checklist"));

                checklists.add(checklist);
            }

            return checklists;

        } catch (SQLException ex) {
            Logger.getLogger(CheckListDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(CheckListDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }     
    
}
