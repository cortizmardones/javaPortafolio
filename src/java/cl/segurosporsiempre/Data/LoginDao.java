/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Perfil;
import cl.segurosporsiempre.Model.Usuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author raulp
 */
public class LoginDao {

    private Conexion conn;

    public LoginDao(Conexion conn) {
        this.conn = conn;
    }

    public Usuario obtenerUsuario(String login) {
        
        Usuario lsp;
        Perfil prf;
        Empresa emp;
        
        try {
        
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_BUSCAR_USUARIO_LOGIN(?,?) }");
            cst.setString(1, login);
            cst.registerOutParameter(2, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(2);

            rs.next();

            prf = new Perfil();
            prf.setNombre(rs.getString("tipo_usuario"));
            prf.setId(rs.getInt("id_perfil"));

            emp = new Empresa();
            emp.setRazonSocial(rs.getString("nombre_empresa"));

            lsp = new Usuario();
            lsp.setId(rs.getLong("id_usuario"));
            lsp.setCorreo(rs.getString("correo_electronico"));
            lsp.setPerfil(prf);
            lsp.setEmpresa(emp);
            lsp.setEstado(rs.getBoolean("estado_usuario"));
            lsp.setPrimeraVez(rs.getBoolean("primera_vez"));
            lsp.setPassword(rs.getString("clave"));

            return lsp;

        } catch (SQLException ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean modificarPassLogin(Usuario u) {
        
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_ACTUALIZAR_CLAVE_IPV(?,?) }");
            cst.setLong(1, u.getId());
            cst.setString(2, u.getPassword());
            
            cst.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}