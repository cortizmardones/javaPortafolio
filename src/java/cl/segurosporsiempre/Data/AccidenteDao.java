/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Accidente;
import cl.segurosporsiempre.Model.ContadorAccidente;
import cl.segurosporsiempre.Model.ContadorTotalAccidente;
import cl.segurosporsiempre.Model.Empresa;
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
 * @author PFT & Tonino (AUMMMM TROLAZOO)
 */
public class AccidenteDao {

    private Conexion conn;

    public AccidenteDao(Conexion conn) {
        this.conn = conn;
    }

    public List<TipoAccidente> obtenerTiposAccidente() {
        TipoAccidente ta;
        List<TipoAccidente> tas = new LinkedList<>();

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_OBTENER_TIPOS_ACCIDENTE(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
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

    //CODIGO AGREGAR ACCIDENTE (SIRVE PARA EL CLIENTE Y PARA EL PROFESIONAL, SAPBEEEEEEE!!!
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

    //Listar accidentes
    public List<Accidente> obtenerAccidentes() {
        Accidente acc;
        TipoAccidente tacc;
        Empresa emp;
        List<Accidente> accidentes = new LinkedList<>();

        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_OBTENER_ACCIDENTE(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                acc = new Accidente();
                tacc = new TipoAccidente();
                emp = new Empresa();

                acc.setId(rs.getLong("ID_ACCIDENTE"));
                tacc.setNombre(rs.getString("TIPO_ACCIDENTE"));
                acc.setTipo(tacc);
                emp.setRazonSocial(rs.getString("NOMBRE_EMPRESA"));
                acc.setEmprea(emp);
                acc.setFecha(rs.getString("FECHA").substring(0, 16));
                acc.setCausa(rs.getString("CAUSA"));
                acc.setDetalle(rs.getString("DETALLE"));
                acc.setEstado(rs.getBoolean("ESTADO"));

                accidentes.add(acc);
            }

            return accidentes;

        } catch (SQLException ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //Activar accidente
    public boolean activarAccidente(Long id) {
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_ACTIVAR_ACCIDENTE(?)}");
            cst.setLong(1, id);
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

    //Desactivar accidente
    public boolean desactivarAccidente(Long id) {
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_DESACTIVAR_ACCIDENTE(?)}");
            cst.setLong(1, id);
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

    //Buscar accidente x ID
    public Accidente buscarAccidentexId(Long id) {
        Accidente accidente;
        Empresa empresa;
        TipoAccidente tipoAccidente;
        CallableStatement cst;

        try {
            cst = conn.getConnection().prepareCall("{ call SP_BUSCAR_ACCIDENTE(?,?) }");
            cst.setLong(1, id);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(2);
            rs.next();

            accidente = new Accidente();
            accidente.setId(rs.getLong("id_accidente"));
            tipoAccidente = new TipoAccidente();
            tipoAccidente.setId(rs.getInt("id_tipo_accidente"));
            accidente.setTipo(tipoAccidente);
            empresa = new Empresa();
            empresa.setId(rs.getLong("id_empresa"));
            accidente.setEmprea(empresa);
            accidente.setFecha(rs.getString("fecha").substring(0, 16));
            accidente.setCausa(rs.getString("causa"));
            accidente.setDetalle(rs.getString("detalle"));
            return accidente;

        } catch (SQLException ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //Modificar accidente
    public boolean modificarAccidente(Accidente a) {
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_ACTUALIZAR_ACCIDENTE(?,?,?,?,?,?) }");
            cst.setLong(1, a.getId());
            cst.setLong(2, a.getTipo().getId());
            cst.setLong(3, a.getEmprea().getId());
            cst.setString(4, a.getFecha());
            cst.setString(5, a.getCausa());
            cst.setString(6, a.getDetalle());
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

    public List<ContadorAccidente> obtenerCantidadAccidentesLeves(Empresa empresa) {
        List<ContadorAccidente> listaContadorAccidentes = new LinkedList<>();
        ContadorAccidente contadorAccidente;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_ACCIDENTE_LEVE(?,?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setLong(2, empresa.getId());

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                contadorAccidente = new ContadorAccidente();
                contadorAccidente.setContador(rs.getLong("CANTIDAD"));

                listaContadorAccidentes.add(contadorAccidente);
            }

            return listaContadorAccidentes;

        } catch (SQLException ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ContadorAccidente> obtenerCantidadAccidentesMedios(Empresa empresa) {
        List<ContadorAccidente> listaContadorAccidentes = new LinkedList<>();
        ContadorAccidente contadorAccidente;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_ACCIDENTE_MEDIO(?,?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setLong(2, empresa.getId());

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                contadorAccidente = new ContadorAccidente();
                contadorAccidente.setContador(rs.getLong("CANTIDAD"));

                listaContadorAccidentes.add(contadorAccidente);
            }

            return listaContadorAccidentes;

        } catch (SQLException ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ContadorAccidente> obtenerCantidadAccidentesGraves(Empresa empresa) {
        List<ContadorAccidente> listaContadorAccidentes = new LinkedList<>();
        ContadorAccidente contadorAccidente;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_ACCIDENTE_GRAVE(?,?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setLong(2, empresa.getId());
            
            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                contadorAccidente = new ContadorAccidente();
                contadorAccidente.setContador(rs.getLong("CANTIDAD"));

                listaContadorAccidentes.add(contadorAccidente);
            }

            return listaContadorAccidentes;

        } catch (SQLException ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ContadorTotalAccidente> obtenerGraficoAccidenteEmpresa(Empresa empresa) {
        List<ContadorTotalAccidente> listaGraficoAccidentes = new LinkedList<>();
        ContadorTotalAccidente contadorTotalAccidente;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_ACCIDENTE_TOTAL(?,?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setLong(2, empresa.getId());

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                contadorTotalAccidente = new ContadorTotalAccidente();

                contadorTotalAccidente.setId(rs.getLong("id_cantidad_accidente"));
                contadorTotalAccidente.setEnero(rs.getInt("enero"));
                contadorTotalAccidente.setFebrero(rs.getInt("febrero"));
                contadorTotalAccidente.setMarzo(rs.getInt("marzo"));
                contadorTotalAccidente.setAbril(rs.getInt("abril"));
                contadorTotalAccidente.setMayo(rs.getInt("mayo"));
                contadorTotalAccidente.setJunio(rs.getInt("junio"));
                contadorTotalAccidente.setJulio(rs.getInt("julio"));
                contadorTotalAccidente.setAgosto(rs.getInt("agosto"));
                contadorTotalAccidente.setSeptiembre(rs.getInt("septiembre"));
                contadorTotalAccidente.setOctubre(rs.getInt("octubre"));
                contadorTotalAccidente.setNoviembre(rs.getInt("noviembre"));
                contadorTotalAccidente.setDiciembre(rs.getInt("diciembre"));

                /*Empresa empresa2 = new Empresa();
                empresa.setId(rs.getLong("id_empresa"));
                contadorTotalAccidente.setEmpresa(empresa2);
                */

                listaGraficoAccidentes.add(contadorTotalAccidente);
            }

            return listaGraficoAccidentes;

        } catch (SQLException ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ContadorTotalAccidente> obtenerGraficoAccidenteAdmin() {
        List<ContadorTotalAccidente> listaGraficoAccidentes = new LinkedList<>();
        ContadorTotalAccidente contadorTotalAccidente;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_ACCIDENTE_TOTAL2(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                contadorTotalAccidente = new ContadorTotalAccidente();

                contadorTotalAccidente.setId(rs.getLong("id_cantidad_accidente"));
                contadorTotalAccidente.setEnero(rs.getInt("enero"));
                contadorTotalAccidente.setFebrero(rs.getInt("febrero"));
                contadorTotalAccidente.setMarzo(rs.getInt("marzo"));
                contadorTotalAccidente.setAbril(rs.getInt("abril"));
                contadorTotalAccidente.setMayo(rs.getInt("mayo"));
                contadorTotalAccidente.setJunio(rs.getInt("junio"));
                contadorTotalAccidente.setJulio(rs.getInt("julio"));
                contadorTotalAccidente.setAgosto(rs.getInt("agosto"));
                contadorTotalAccidente.setSeptiembre(rs.getInt("septiembre"));
                contadorTotalAccidente.setOctubre(rs.getInt("octubre"));
                contadorTotalAccidente.setNoviembre(rs.getInt("noviembre"));
                contadorTotalAccidente.setDiciembre(rs.getInt("diciembre"));

                Empresa empresa = new Empresa();
                empresa.setId(rs.getLong("id_empresa"));
                contadorTotalAccidente.setEmpresa(empresa);

                listaGraficoAccidentes.add(contadorTotalAccidente);
            }

            return listaGraficoAccidentes;

        } catch (SQLException ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AccidenteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
