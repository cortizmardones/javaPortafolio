/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Accidente;
import cl.segurosporsiempre.Model.TipoAccidente;
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
 * @author PFT
 */
public class AccidenteDao {
    
    private Conexion conn;

    public AccidenteDao(Conexion conn) {
        this.conn = conn;
    }
    
    public List<TipoAccidente> obtenerTiposAccidente()
    {
        TipoAccidente ta;
        List<TipoAccidente> tas = new LinkedList<>();
        
        try {
            
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_OBTENER_TIPOS_ACCIDENTE(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            
            cst.execute();
            
            ResultSet rs = (ResultSet) cst.getObject(1);
            
            while (rs.next())
            {
                ta = new TipoAccidente();
                ta.setId(rs.getInt("id_tipo_accidente"));
                ta.setDescripcion(rs.getString("descripcion"));
                ta.setNombre(rs.getString("nombre"));
                
                tas.add(ta);
                
            }
            
            return tas;
            
        } catch (SQLException ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean agregarAccidente(Accidente acc) {
    
        try {
            
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_AGREGAR_ACCIDENTE_REP(?,?,?,?,?) }");
            cst.setInt(1, acc.getTipo().getId());
            cst.setLong(2, acc.getEmprea().getId());
            cst.setString(3, acc.getFecha());
            cst.setString(4, acc.getCausa());
            cst.setString(5, acc.getDetalle());
            
            cst.execute();
            
            return true;

            
        } catch (SQLException ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
        
        
    }
}
