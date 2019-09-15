package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Rubro;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Raúl Pardo Zurita
 */
public class RubroDao {

    private Conexion conn;

    public RubroDao(Conexion conn) {
        this.conn = conn;
    }

    public List<Rubro> obtenerRubros() {
        Rubro rubro;
        List<Rubro> rubros = new LinkedList<>();

        try {

            CallableStatement pst = conn.getConnection().prepareCall("{ call SP_OBTENER_RUBROS(?) }");
            pst.registerOutParameter(1, OracleTypes.CURSOR);
            pst.execute();

            ResultSet rs = (ResultSet) pst.getObject(1);

            while (rs.next())
            {
                rubro = new Rubro();
                
                rubro.setIdRubro(rs.getInt("ID_RUBRO_EMPRESA"));
                rubro.setNombre(rs.getString("NOMBRE"));
                
                rubros.add(rubro);
            }
            
            return rubros;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
