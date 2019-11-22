/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.CheckList;
import cl.segurosporsiempre.Model.Estado;
import cl.segurosporsiempre.Model.Item;
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
 * @author Tonino
 */
public class ItemsDAO {
    
    public Conexion conn;
    
    public ItemsDAO(Conexion conn)
    {
        this.conn = conn;
    }
    
    
    //OBTENER LISTADO DE ESTADOS DE ITEMS
    public List<Estado> obtenerEstados()
    {
        Estado ed;
        List<Estado> edos = new LinkedList<>();
        
        try {
            
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_OBTENER_ESTADOS(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);            
            cst.execute();            
            ResultSet rs = (ResultSet) cst.getObject(1);
            
            while (rs.next())
            {
                ed = new Estado();
                ed.setId(rs.getLong("id_estado"));
                ed.setNombre(rs.getString("nombre"));
                edos.add(ed);
            }
            
            return edos;
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    //Listar ITEMS
    public List<Item> obtenerItem() {
        Item ite;
	Estado edo;
        CheckList chk;
		
        List<Item> items = new LinkedList<>();

        try {
            
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_LISTAR_ITEMSXCHECKLIST(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                ite = new Item();
		chk = new CheckList();
                chk.setId(rs.getLong("id_checklist"));
                ite.setChecklist(chk);
                ite.setId(rs.getLong("id_item"));
                ite.setDescripcion(rs.getString("descripcion_item"));
                ite.setEstado(rs.getBoolean("estado_item"));
                edo = new Estado();
                edo.setNombre(rs.getString("cumple"));
                ite.setCumple(edo);
                items.add(ite);
            }

            return items;

        } catch (SQLException ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    
    //Listar ITEMS x ID (busqueda específica por ID Checklist)
    public List<Item> obtenerItemxId(Long id) {
        Item ite;
	Estado edo;
        CheckList chk;
        List<Item> items = new LinkedList<>();

        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_LISTAR_ITEMSXID(?,?) }");
            cst.setLong(1, id);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(2);

            while (rs.next()) {
                ite = new Item();
		chk = new CheckList();
                chk.setId(rs.getLong("id_checklist"));
                ite.setChecklist(chk);
                ite.setId(rs.getLong("id_item"));
                ite.setDescripcion(rs.getString("descripcion_item"));
                ite.setEstado(rs.getBoolean("estado_item"));
                edo = new Estado();
                edo.setNombre(rs.getString("cumple"));
                ite.setCumple(edo);
                items.add(ite);
            }

            return items;

        } catch (SQLException ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ItemsDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
