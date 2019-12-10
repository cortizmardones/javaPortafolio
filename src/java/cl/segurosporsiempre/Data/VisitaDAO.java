package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.CheckList;
import cl.segurosporsiempre.Model.ContadorVisita;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Profesional;
import cl.segurosporsiempre.Model.Visita;
import cl.segurosporsiempre.Model.EstadoVisita;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

public class VisitaDAO {

    private Conexion conn;

    public VisitaDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean agregarVisita(Visita v) {
        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_AGREGAR_VISITA_V2(?,?,?) }");
            cst.setLong(1, v.getProfesional().getId());
            cst.setLong(2, v.getEmpresa().getId());
            cst.setString(3, v.getFecha());

            cst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Visita> obtenerVisitas() {
        List<Visita> visitas = new LinkedList<>();
        Visita visita;
        Profesional profesional;
        Empresa empresa;
        EstadoVisita estado;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_OBTENER_VISITAS_V2(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                visita = new Visita();
                visita.setId(rs.getLong("id_visita"));

                profesional = new Profesional();
                profesional.setId(rs.getLong("id_profesional"));
                profesional.setNombres(rs.getString("nombres"));
                profesional.setApellidos(rs.getString("apellidos"));

                empresa = new Empresa();
                empresa.setId(rs.getLong("id_empresa"));
                empresa.setRazonSocial(rs.getString("RAZON_SOCIAL"));

                visita.setFecha(rs.getString("fecha"));

                //visita.setEstado(rs.getBoolean("Estado"));
                //visita.setEstado(rs.getLong("id_estado"));
                estado = new EstadoVisita();
                estado.setId(rs.getLong("id_estado"));
                estado.setDescripcion(rs.getString("DESCRIPCION_ESTADO"));

                visita.setProfesional(profesional);
                visita.setEmpresa(empresa);
                visita.setEstado(estado);

                visitas.add(visita);
            }

            return visitas;

        } catch (SQLException ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean activarVisita(Long id) {

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_ACTIVAR_VISITA_V2(?) }");
            cst.setLong(1, id);

            cst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean desactivarVisita(Long id) {
        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_DESACTIVAR_VISITA_V2(?) }");
            cst.setLong(1, id);

            cst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Visita obtenerVisitaPorId(Long id) {

        Visita visita;
        Profesional profesional;
        Empresa empresa;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_BUSCAR_VISITA_V2(?,?) }");
            cst.setLong(1, id);
            cst.registerOutParameter(2, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(2);

            rs.next();

            visita = new Visita();
            visita.setId(rs.getLong("id_visita"));
            visita.setFecha(rs.getString("fecha"));
            //visita.setEstado(rs.getBoolean("estado"));

            profesional = new Profesional();
            profesional.setId(rs.getLong("id_profesional"));
            profesional.setRut(rs.getString("rut_profesional"));
            profesional.setNombres(rs.getString("nombres"));
            profesional.setApellidos(rs.getString("apellidos"));
            visita.setProfesional(profesional);

            empresa = new Empresa();
            empresa.setId(rs.getLong("id_empresa"));
            empresa.setRut(rs.getString("rut_empresa"));
            empresa.setRazonSocial(rs.getString("razon_social"));
            visita.setEmpresa(empresa);

            return visita;

        } catch (SQLException ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean modificarVisita(Visita v, CheckList c) {
        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_ACTUALIZAR_VISITA_V2(?,?,?) }");
            cst.setLong(1, v.getId());
            cst.setString(2, v.getFecha());

            //CheckList checklist = new CheckList();
            cst.setString(3, c.getDescripcion());

            cst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    //PORCLIENTE
    public boolean solicitarVisita(Visita v) {
        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_AGREGAR_VISITA_V2(?,?,?) }");
            //DEJARE A ERIKA ELENIAK COMO DEFAULT
            cst.setLong(1, 241);
            cst.setLong(2, v.getEmpresa().getId());
            cst.setString(3, v.getFecha());

            cst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<ContadorVisita> obtenerCantidadVisitasRealizadas(Empresa empresa) {
        List<ContadorVisita> listaContadorVisitas = new LinkedList<>();
        ContadorVisita contadorVisitas;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_VISITAS_REALIZADAS(?,?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setLong(2, empresa.getId());

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                contadorVisitas = new ContadorVisita();
                contadorVisitas.setContador(rs.getLong("CANTIDAD"));

                listaContadorVisitas.add(contadorVisitas);
            }

            return listaContadorVisitas;

        } catch (SQLException ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /* Método del campesino (Más efectivo)
    public int obtenerCantidadVisitasAlternativo()
    {
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_VISITAS_REALIZADAS(?)}");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            
            cst.execute();
            
            ResultSet rs = (ResultSet)cst.getObject(1);
            
            rs.next();
            
            int cantidad = rs.getInt("CANTIDAD");
            
            return cantidad;
            
        } catch (SQLException ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (Exception ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }*/
    public List<ContadorVisita> obtenerCantidadVisitasPendientes(Empresa empresa) {
        List<ContadorVisita> listaContadorVisitas = new LinkedList<>();
        ContadorVisita contadorVisitas;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_VISITAS_PENDIENTES(?,?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setLong(2, empresa.getId());

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                contadorVisitas = new ContadorVisita();
                contadorVisitas.setContador(rs.getLong("CANTIDAD"));

                listaContadorVisitas.add(contadorVisitas);
            }

            return listaContadorVisitas;

        } catch (SQLException ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<ContadorVisita> obtenerCantidadVisitasCanceladas(Empresa empresa) {
        List<ContadorVisita> listaContadorVisitas = new LinkedList<>();
        ContadorVisita contadorVisitas;

        try {

            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_CONTADOR_VISITAS_CANCELADAS(?,?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setLong(2, empresa.getId());

            cst.execute();

            ResultSet rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {

                contadorVisitas = new ContadorVisita();
                contadorVisitas.setContador(rs.getLong("CANTIDAD"));

                listaContadorVisitas.add(contadorVisitas);
            }

            return listaContadorVisitas;

        } catch (SQLException ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
