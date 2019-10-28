/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Capacitacion;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Profesional;
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
public class CapacitacionDao {

    private Conexion conn;

    public CapacitacionDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean agregarCapacitacion(Capacitacion c) {
        try {
            
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_AGREGAR_CAPACITACION(?,?,?,?,?,?) }"); 
            
            cst.setLong(1, c.getEmpresa().getId());
            cst.setString(2, c.getFecha());
            cst.setString(3, c.getMaterial());
            cst.setString(4, c.getCorreoUsuarioOrigen());
            cst.setInt(5, c.getCantidadAsistentes());
            cst.setString(6, c.getTema());

            cst.execute();
            
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Capacitacion> obtenerCapacitaciones()
    {
        Capacitacion capacitacion;
        Profesional p;
        Empresa emp;
        List<Capacitacion> capacitaciones = new LinkedList<>();
        
        try {
            
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_OBTENER_CAPACITACIONES(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            
            cst.execute();
            
            ResultSet rs = (ResultSet)cst.getObject(1);
            
            while (rs.next())
            {
                capacitacion = new Capacitacion();
                capacitacion.setId(rs.getLong("id_capacitacion"));
                capacitacion.setFecha(rs.getString("fecha"));
                capacitacion.setMaterial(rs.getString("material"));
                capacitacion.setCorreoUsuarioOrigen(rs.getString("correo_usuario_origen"));
                capacitacion.setEstado(rs.getBoolean("estado"));
                capacitacion.setCantidadAsistentes(rs.getInt("numero_asistentes"));
                capacitacion.setTema(rs.getString("tema_capacitacion"));
                
                emp = new Empresa();
                emp.setRazonSocial(rs.getString("razon_social"));
                
                p = new Profesional();
                p.setId(rs.getLong("id_profesional"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("apellidos"));
                p.setEstado(rs.getBoolean("estado_profesional"));
                
                capacitacion.setProfesional(p);
                capacitacion.setEmpresa(emp);
                
                capacitaciones.add(capacitacion);
            }
            
            return capacitaciones;
            
        } catch (SQLException ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean tomarCapacitacion(long idCap, long idPro)
    {
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_TOMAR_CAPACITACION(?,?) }");
            cst.setLong(1, idCap);
            cst.setLong(2, idPro);    
            
            cst.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean activarCapaciontacion(Long id) {
        
        try {
            
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_ACTIVAR_CAPACITACION(?) }");
            cst.setLong(1, id);
            
            cst.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean desactivarCapaciontacion(Long id) {
        
        try {
            
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_DESACTIVAR_CAPACITACION(?) }");
            cst.setLong(1, id);
            
            cst.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
