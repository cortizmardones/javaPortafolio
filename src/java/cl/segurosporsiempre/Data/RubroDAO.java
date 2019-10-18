package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Rubro;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

public class RubroDAO {

    private Conexion conn;

    public RubroDAO(Conexion conn) {
        this.conn = conn;
    }

    public List<Rubro> obtenerRubros() {
        List<Rubro> rubros = new LinkedList<>();
        Rubro rubro;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_OBTENER_RUBROS(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                rubro = new Rubro();
                rubro.setNombre(rs.getString("nombre"));
                rubro.setDescripcion(rs.getString("descripcion"));
                rubro.setEstado(rs.getBoolean("estado"));
                
                rubros.add(rubro);
            }

            return rubros;

        } catch (SQLException ex) {
            Logger.getLogger(RubroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(RubroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
