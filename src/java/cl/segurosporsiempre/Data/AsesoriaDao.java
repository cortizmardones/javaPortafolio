/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Asesoria;
import cl.segurosporsiempre.Model.ContadorAsesoria;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Profesional;
import cl.segurosporsiempre.Model.Rubro;
import cl.segurosporsiempre.Model.TipoAsesoria;
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
public class AsesoriaDao {

    public Conexion conn;

    public AsesoriaDao(Conexion conn) {
        this.conn = conn;
    }

    //Agregar asesoria al sistema
    public boolean agregarAsesoria(Asesoria a) {
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_AGREGAR_ASESORIA(?,?,?,?,?) }");
            cst.setLong(1, a.getTipoAsesoria().getId());
            cst.setLong(2, a.getProfesional().getId());
            cst.setLong(3, a.getEmpresa().getId());
            cst.setString(4, a.getFechaIngreso());
            cst.setString(5, a.getFechaEstimadaRealizada());
            cst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } catch (Exception ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //Listado de tipos de Asesoria
    public List<TipoAsesoria> obtenerTiposAsesoria() {
        List<TipoAsesoria> list = new LinkedList<>();
        TipoAsesoria tipAso; //TipAso?? TROLAZOOOOO!!!

        try {
            CallableStatement cst = conn.getConnection().prepareCall(" { call SP_OBTENER_TIPOS_ASESORIA(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(1);
            while (rs.next()) {
                tipAso = new TipoAsesoria();
                tipAso.setId(rs.getInt("ID_TIPO_ASESORIA"));
                tipAso.setNombre(rs.getString("NOMBRE"));
                tipAso.setDescripcion(rs.getString("DESCRIPCION"));
                list.add(tipAso);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //Listar asesorias
    public List<Asesoria> obtenerAsesorias() {
        Asesoria aso;
        Empresa emp;
        Rubro rub;
        List<Asesoria> asesorias = new LinkedList<>();

        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_LISTAR_ASESORIA(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                aso = new Asesoria();
                emp = new Empresa();
                rub = new Rubro();

                emp.setRut(rs.getString("rut_empresa"));
                emp.setRazonSocial(rs.getString("nombre_empresa"));
                emp.setDireccion(rs.getString("direccion"));
                rub.setDescripcion(rs.getString("rubro"));

                aso.setId(rs.getLong("id_asesoria"));
                aso.setEmpresa(emp);
                aso.setRubro(rub);
                aso.setFechaIngreso(rs.getString("fecha_ingreso").substring(0, 16));
                aso.setFechaEstimadaRealizada(rs.getString("fecha_realizada").substring(0, 16));
                aso.setEstado(rs.getBoolean("estado"));

                asesorias.add(aso);
            }

            return asesorias;

        } catch (SQLException ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //Activar Asesoria
    public boolean activarAsesoria(Long id) {
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_ACTIVAR_ASESORIA(?)}");
            cst.setLong(1, id);
            cst.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    //Desactivar Asesoria
    public boolean desactivarAsesoria(Long id) {
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_DESACTIVAR_ASESORIA(?) }");
            cst.setLong(1, id);
            cst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //Modificar asesoria
    public Boolean modificarAsesoria(Asesoria a) {
        /**
         * Modifica una asesoria
         *
         * @return Retorna un valor booleano si resulta exitoso o no el proceso.
         */

        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_ACTUALIZAR_ASESORIA(?,?,?,?,?,?) }");

            cst.setLong(1, a.getId());
            cst.setLong(2, a.getTipoAsesoria().getId());
            cst.setLong(3, a.getProfesional().getId());
            cst.setLong(4, a.getEmpresa().getId());
            cst.setString(5, a.getFechaIngreso());
            cst.setString(6, a.getFechaEstimadaRealizada());

            cst.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    //Buscar Asesoria x ID
    public Asesoria buscarAsesoriaxId(Long id) {
        Asesoria asesoria;
        TipoAsesoria tipoAsesoria;
        Profesional profesional;
        Empresa empresa;

        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_BUSCAR_ASESORIA(?,?) }");
            cst.setLong(1, id);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(2);
            rs.next();
            asesoria = new Asesoria();
            asesoria.setId(rs.getLong("id_asesoria"));
            tipoAsesoria = new TipoAsesoria();
            tipoAsesoria.setId(rs.getInt("id_tipo_asesoria"));
            asesoria.setTipoAsesoria(tipoAsesoria);
            profesional = new Profesional();
            profesional.setId(rs.getLong("id_profesional"));
            asesoria.setProfesional(profesional);
            empresa = new Empresa();
            empresa.setId(rs.getLong("id_empresa"));
            asesoria.setEmpresa(empresa);
            asesoria.setFechaIngreso(rs.getString("fecha_ingreso").substring(0, 16));
            asesoria.setFechaEstimadaRealizada(rs.getString("fecha_realizada").substring(0, 16));

            return asesoria;

        } catch (SQLException ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ContadorAsesoria> obtenerCantidadAsesoriasRealizadas(Empresa empresa) {
        List<ContadorAsesoria> listaContadorAsesoria = new LinkedList<>();
        ContadorAsesoria contadorAsesoria;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_ASES_REALIZADAS(?,?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setLong(2, empresa.getId());

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                contadorAsesoria = new ContadorAsesoria();
                contadorAsesoria.setContador(rs.getLong("CANTIDAD"));

                listaContadorAsesoria.add(contadorAsesoria);
            }

            return listaContadorAsesoria;

        } catch (SQLException ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ContadorAsesoria> obtenerCantidadAsesoriasPendientes(Empresa empresa) {
        List<ContadorAsesoria> listaContadorAsesoria = new LinkedList<>();
        ContadorAsesoria contadorAsesoria;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_ASES_PENDIENTES(?,?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setLong(2, empresa.getId());

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                contadorAsesoria = new ContadorAsesoria();
                contadorAsesoria.setContador(rs.getLong("CANTIDAD"));

                listaContadorAsesoria.add(contadorAsesoria);
            }

            return listaContadorAsesoria;

        } catch (SQLException ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ContadorAsesoria> obtenerCantidadAsesoriasCanceladas(Empresa empresa) {
        List<ContadorAsesoria> listaContadorAsesoria = new LinkedList<>();
        ContadorAsesoria contadorAsesoria;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_ASES_CANCELADAS(?,?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setLong(2, empresa.getId());

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                contadorAsesoria = new ContadorAsesoria();
                contadorAsesoria.setContador(rs.getLong("CANTIDAD"));

                listaContadorAsesoria.add(contadorAsesoria);
            }

            return listaContadorAsesoria;

        } catch (SQLException ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(AsesoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
