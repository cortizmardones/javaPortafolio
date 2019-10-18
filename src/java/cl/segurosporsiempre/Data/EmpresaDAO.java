
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.ContratoEmpresa;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Rubro;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

public class EmpresaDAO {
    
    private Conexion conn;
    
     public EmpresaDAO(Conexion conn) {
        this.conn = conn;
    }
    
     public boolean agregarEmpresa (Empresa p){
         try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_AGREGAR_EMPRESA(?,?,?,?,?,?,?,?,?) }");
            cst.setString(1, p.getRut());
            cst.setString(2, p.getRazonSocial());
            cst.setString(3, p.getLogo());
            cst.setString(4, p.getEmail());
            cst.setString(5, p.getDireccion());
            cst.setInt(6, p.getFono());
            cst.setInt(7, p.getNumeroTrabajadores());
            cst.setInt(8,p.getRubro().getId());
            cst.setString(9,p.getContrato().getFechaContrato());

            cst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     }
     
     
     
      public List<Empresa> obtenerEmpresas() {
        List<Empresa> empresas = new LinkedList<>();
        Empresa empresa;
        ContratoEmpresa contrato;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_OBTENER_EMPRESAS(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                empresa = new Empresa();
                empresa.setId(rs.getLong("id_empresa"));
                empresa.setRut(rs.getString("rut_empresa"));
                empresa.setRazonSocial(rs.getString("razon_social"));
                empresa.setLogo(rs.getString("logo"));
                empresa.setEmail(rs.getString("correo_electronico"));
                empresa.setDireccion(rs.getString("direccion"));
                empresa.setFono(rs.getInt("fono"));
                empresa.setNumeroTrabajadores(rs.getInt("numero_trabajadores"));
                empresa.setEstado(rs.getBoolean("estado"));
             
                empresas.add(empresa);
            }

            return empresas;

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

     
     public boolean activarEmpresa(Long id) {

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_ACTIVAR_EMPRESA(?) }");
            cst.setLong(1, id);

            cst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     
      
      
       public boolean desactivarEmpresa(Long id) {
        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_DESACTIVAR_EMPRESA(?) }");
            cst.setLong(1, id);

            cst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
      
   public Empresa obtenerEmpresaPorId(Long id) {
        
        Empresa empresa;
        Rubro rubro;
        
        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_BUSCAR_EMPRESA(?,?) }");
            cst.setLong(1, id);
            cst.registerOutParameter(2, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(2);

            rs.next();

            empresa = new Empresa();
            empresa.setId(rs.getLong("id_empresa"));
            empresa.setRut(rs.getString("rut_empresa"));
            empresa.setRazonSocial(rs.getString("razon_social"));
            empresa.setEmail(rs.getString("correo_electronico"));
            empresa.setDireccion(rs.getString("direccion"));
            empresa.setFono(rs.getInt("fono"));
            empresa.setNumeroTrabajadores(rs.getInt("numero_trabajadores"));
            
            rubro = new Rubro();
            rubro.setId(rs.getInt("id_rubro"));
            rubro.setNombre(rs.getString("nombre"));
            empresa.setRubro(rubro);
            
            empresa.setEstado(rs.getBoolean("estado"));

            return empresa;

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
       
   
   public boolean modificarEmpresa(Empresa e){
         try {
           
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_ACTUALIZAR_EMPRESA(?,?,?,?,?,?,?) }");
            cst.setString(1, e.getRut());
            cst.setString(2, e.getRazonSocial());
            cst.setString(3,e.getEmail());
            cst.setString(4,e.getDireccion());
            cst.setInt(5, e.getFono());
            cst.setInt(6, e.getNumeroTrabajadores());
            cst.setLong(7,(e.getId()));
            
            cst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }     
        
    }
       
       
       
       
       
       
       
      
      
      
      
      
      
     
     
     
     
}
