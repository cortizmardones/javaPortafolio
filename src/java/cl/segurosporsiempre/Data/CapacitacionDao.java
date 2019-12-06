/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Capacitacion;
import cl.segurosporsiempre.Model.ContadorCapacitacion;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.EstadoCapacitacion;
import cl.segurosporsiempre.Model.Profesional;
import cl.segurosporsiempre.Model.Prueba;
import cl.segurosporsiempre.Model.Utils;
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

    public List<Capacitacion> obtenerCapacitaciones() {
        Capacitacion capacitacion;
        EstadoCapacitacion estado;
        Profesional profesional;
        Empresa empresa;

        List<Capacitacion> capacitaciones = new LinkedList<>();

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_OBTENER_CAPACITACIONES(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                estado = new EstadoCapacitacion();
                estado.setId(rs.getLong("ID_ESTADO"));
                estado.setDescripcion(rs.getString("DESCRIPCION"));

                empresa = new Empresa();
                empresa.setId(rs.getLong("ID_EMPRESA"));
                empresa.setRazonSocial(rs.getString("RAZON_SOCIAL"));

                profesional = new Profesional();
                profesional.setNombres(rs.getString("NOMBRES"));
                profesional.setApellidos(rs.getString("APELLIDOS"));
                profesional.setId(rs.getLong("ID_PROFESIONAL"));

                capacitacion = new Capacitacion();
                capacitacion.setId(rs.getLong("ID_CAPACITACION"));
                capacitacion.setCorreo(rs.getString("CORREO_USUARIO_ORIGEN"));
                capacitacion.setFecha(Utils.FECHATRANSFORMADA(rs.getString("FECHA")));
                capacitacion.setMateriales(rs.getString("MATERIAL"));
                capacitacion.setNumeroAsistentes(rs.getInt("NUMERO_ASISTENTES"));
                capacitacion.setEmpresa(empresa);
                capacitacion.setProfesional(profesional);
                capacitacion.setEstadoCapacitacion(estado);

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

    public Prueba obtenerPruebaPorCapacitacion(Long id) {
        Prueba p;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_BUSCAR_PRUEBA_CAPACITACION(?,?) }");
            cst.setLong(1, id);
            cst.registerOutParameter(2, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(2);

            rs.next();

            p = new Prueba();
            p.setId(rs.getLong("ID_PRUEBA"));
            p.setCapacitacion(new Capacitacion(rs.getLong("ID_CAPACITACION")));
            p.setDescripcion(rs.getString("DESCRIPCION"));
            p.setFecha(Utils.FECHATRANSFORMADA(rs.getString("FECHA")));

            return p;

        } catch (SQLException ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ContadorCapacitacion> obtenerCantidadCapacitacionesRealizadas() {
        List<ContadorCapacitacion> listaContadorCapacitacion = new LinkedList<>();
        ContadorCapacitacion contadorCapacitacion;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_CAPAC_REALIZADAS(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                contadorCapacitacion = new ContadorCapacitacion();
                contadorCapacitacion.setContador(rs.getLong("CANTIDAD"));

                listaContadorCapacitacion.add(contadorCapacitacion);
            }

            return listaContadorCapacitacion;

        } catch (SQLException ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ContadorCapacitacion> obtenerCantidadCapacitacionesPendientes() {
        List<ContadorCapacitacion> listaContadorCapacitacion = new LinkedList<>();
        ContadorCapacitacion contadorCapacitacion;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_CAPAC_PENDIENTES(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                contadorCapacitacion = new ContadorCapacitacion();
                contadorCapacitacion.setContador(rs.getLong("CANTIDAD"));

                listaContadorCapacitacion.add(contadorCapacitacion);
            }

            return listaContadorCapacitacion;

        } catch (SQLException ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ContadorCapacitacion> obtenerCantidadCapacitacionesCanceladas() {
        List<ContadorCapacitacion> listaContadorCapacitacion = new LinkedList<>();
        ContadorCapacitacion contadorCapacitacion;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_CAPAC_CANCELADAS(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                contadorCapacitacion = new ContadorCapacitacion();
                contadorCapacitacion.setContador(rs.getLong("CANTIDAD"));

                listaContadorCapacitacion.add(contadorCapacitacion);
            }

            return listaContadorCapacitacion;

        } catch (SQLException ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(CapacitacionDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
