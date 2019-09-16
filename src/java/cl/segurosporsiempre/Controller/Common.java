/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Data.ClienteDao;
import cl.segurosporsiempre.Data.CredencialDao;
import cl.segurosporsiempre.Data.RubroDao;
import cl.segurosporsiempre.Model.Cliente;
import cl.segurosporsiempre.Model.Login;
import cl.segurosporsiempre.Model.Rubro;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raúl Pardo Zurita
 */
public class Common extends HttpServlet {

    /*
    public void doBaHaSample(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
    }  
     */

    /**
     * Deja en sesion todos los rubros
     */
    protected static void setRubrosRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Conexion conn = new Conexion();
        RubroDao rDto = new RubroDao(conn);

        List<Rubro> rubros = rDto.obtenerRubros();

        conn.cerrarConexion();

        if (rubros.size() > 0) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rRubros", rubros);
        }
    }

    /**
     * Deja en sesion todos los clientes, id y nombre
     */
    protected static void setClientesRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Conexion conn = new Conexion();
        ClienteDao rDto = new ClienteDao(conn);

        List<Cliente> clientes = rDto.obtenerClientesR();

        conn.cerrarConexion();

        if (clientes.size() > 0) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rClientes", clientes);
        }
    }
    
    /**
     * Deja en sesion todoas las credenciales
     */    
    protected static void setCredencialesRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Conexion conn = new Conexion();
        CredencialDao rDto = new CredencialDao(conn);

        List<Login> credenciales = rDto.obtenerCredenciales();

        conn.cerrarConexion();

        if (credenciales.size() > 0) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rCredenciales", credenciales);
        }
    }
}
