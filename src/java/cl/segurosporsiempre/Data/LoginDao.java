/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.ContratoProfesional;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Perfil;
import cl.segurosporsiempre.Model.Profesional;
import cl.segurosporsiempre.Model.Usuario;
import cl.segurosporsiempre.Model.UsuarioProfesional;
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
    
    public UsuarioProfesional obtenerUsuarioProfesional(String login) {
        
        UsuarioProfesional usuario;
        Perfil perfil;
        Profesional profesional;
        ContratoProfesional contrato;
        
        try {
        
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_BUSCAR_USUARIO_PRO_LOGIN(?,?) }");
            cst.setString(1, login);
            cst.registerOutParameter(2, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(2);

            rs.next();

            perfil = new Perfil();
            perfil.setId(rs.getInt("id_perfil"));
            
            usuario = new UsuarioProfesional();
            usuario.setId(rs.getLong("id_usuario"));
            usuario.setPerfil(perfil);
            usuario.setCorreo(rs.getString("correo_electronico"));
            usuario.setPassword(rs.getString("clave"));
            usuario.setEstado(rs.getBoolean("ESTADO_CUENTA"));
            usuario.setPrimeraVez(rs.getBoolean("primera_vez"));
            
            
            contrato = new ContratoProfesional();
            contrato.setId(rs.getLong("id_contrato"));
            contrato.setFechaIngreso(rs.getString("fecha_ingreso"));
            contrato.setFechaTermino(rs.getString("fecha_termino"));
            contrato.setEstado(rs.getBoolean("ESTADO_CONTRATO"));
            contrato.setFechaContrato(rs.getString("fecha_contrato"));
            
            
            profesional = new Profesional();
            profesional.setId(rs.getLong("id_profesional"));
            profesional.setRut(rs.getString("rut_profesional"));
            profesional.setNombres(rs.getString("nombres"));
            profesional.setApellidos(rs.getString("apellidos"));
            profesional.setAvatar(rs.getString("avatar"));
            profesional.setDireccion(rs.getString("direccion"));
            profesional.setFono(rs.getInt("fono"));
            profesional.setFechaNacimiento(rs.getString("fecha_nacimiento"));
            profesional.setUsuario(usuario);
            profesional.setContrato(contrato);
            
            usuario.setProfesional(profesional);
            
            return usuario;
            
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
    
    public boolean modificarPassLogin(UsuarioProfesional u) {
        
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_ACTUALIZAR_CLAVE_PRO_IPV(?,?) }");
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