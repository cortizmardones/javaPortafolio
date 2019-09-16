/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Cliente;
import cl.segurosporsiempre.Model.Login;
import cl.segurosporsiempre.Model.Perfil;
import cl.segurosporsiempre.Model.Representante;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author Raúl Pardo Zurita
 */
public class CredencialDao {
    
    private Conexion conn;

    public CredencialDao(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean agregarCredencial(Login login)
    {
        Representante r;
        
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_AGREGAR_CREDENCIAL(?,?,?,?,?,?,?) }");
            
            
            cst.setString(1, login.getCorreo());
            cst.setString(2, login.getPass());
            cst.setLong(3, login.getPerfil().getIdPerfil());
            cst.setLong(4, login.getCliente().getIdCliete());
            cst.setBoolean(5, login.getActivado());
            cst.setString(6, login.getRespresentante().getNombre());
            cst.setString(7, login.getRespresentante().getRut());
            
            cst.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(CredencialDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(CredencialDao.class.getName()).log(Level.SEVERE, null, ex);           
            return false;
        }        
    }
    
    public List<Login> obtenerCredenciales()
    {
        Login login;
        Cliente cliente;
        Representante representante;
        Perfil perfil;
        List<Login> credenciales = new LinkedList<>();
        
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_OBTENER_CREDENCIALES(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            
            cst.execute();
            
            ResultSet rs = (ResultSet)cst.getObject(1);
            
            while (rs.next())
            {
                cliente = new Cliente();
                representante = new Representante();
                perfil = new Perfil();
                login = new Login();
                
                representante.setNombre(rs.getString("nombre"));
                representante.setRut(rs.getString("rut"));
                perfil.setNombre(rs.getString("perfil"));
                cliente.setNombre(rs.getString("nombreEmpresa"));
                
                login.setCorreo(rs.getString("login"));
                login.setIdLogin(rs.getLong("id"));
                login.setActivado(rs.getBoolean("activado"));
                login.setPerfil(perfil);
                login.setRespresentante(representante);
                login.setCliente(cliente);
                login.setPass(rs.getString("clave"));
                
                credenciales.add(login);
                
            }
            
            return credenciales;
            
        } catch (SQLException ex) {
            Logger.getLogger(CredencialDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(CredencialDao.class.getName()).log(Level.SEVERE, null, ex);           
            return null;
        }
    }

    public boolean desactivarCredencial(Long id) {
        
        try {
            
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_DESACTIVAR_CREDENCIAL(?) }");
            cst.setLong(1, id);
            System.out.println(id);
            cst.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(CredencialDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(CredencialDao.class.getName()).log(Level.SEVERE, null, ex);           
            return false;
        }
    }
}
