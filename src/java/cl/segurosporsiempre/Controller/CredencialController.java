/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Data.CredencialDao;
import cl.segurosporsiempre.Model.Cliente;
import cl.segurosporsiempre.Model.Login;
import cl.segurosporsiempre.Model.Perfil;
import cl.segurosporsiempre.Model.Representante;
import cl.segurosporsiempre.Model.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PFT
 */
public class CredencialController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request petición
     * @param response respuesta
     * @throws ServletException si ocurre un error en el controlador
     * @throws IOException si ocurre un error de entrada y salida
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "desactivarPersona":
                this.eliminarCredencial(request, response);
                break;
            case "activarPersona":
                this.activarCredencial(request, response);
                break;
            case "gModificarPersona":
                this.gatillarModificaiconCredencial(request, response);
                break;
            case "gModificarPass":
                this.gatillarModificacionPass(request, response);
                break;
            default:
                throw new AssertionError();
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request petición
     * @param response respuesta
     * @throws ServletException si ocurre un error en el controlador
     * @throws IOException si ocurre un error de entrada y salida
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {
            case "agregarCredencial":
                this.agregarCredencial(request, response);
                break;
            case "modificarPersona":
                this.modificarPersona(request, response);
                break;
            case "modificarPass":
                this.modificarPass(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void agregarCredencial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String correo = request.getParameter("correo");
        String password = Utils.MD5(request.getParameter("password"));
        Long idEmpresa = Long.parseLong(request.getParameter("empresa"));

        Conexion conn = new Conexion();
        CredencialDao cDto = new CredencialDao(conn);

        Representante rep = new Representante();
        rep.setNombre(nombre);
        rep.setRut(rut);

        Cliente cli = new Cliente();
        cli.setIdCliete(idEmpresa);

        Perfil perf = new Perfil();
        if (idEmpresa == 25) {
            perf.setIdPerfil(2L);
        } else {
            perf.setIdPerfil(3L);
        }

        Login login = new Login();
        login.setActivado(true);
        login.setCorreo(correo);
        login.setPass(password);
        login.setRespresentante(rep);
        login.setCliente(cli);
        login.setPerfil(perf);

        boolean resultado = cDto.agregarCredencial(login);

        System.out.println(resultado);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "agregarCredencialPos");
            Common.setClientesRequest(request, response);
            Common.setCredencialesRequest(request, response);
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "agregarCredencialNeg");
            Common.setClientesRequest(request, response);
            Common.setCredencialesRequest(request, response);
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        }
    }

    private void eliminarCredencial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Conexion conn = new Conexion();
        CredencialDao cDto = new CredencialDao(conn);

        boolean resultado = cDto.desactivarCredencial(id);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "desactivarCredencialPos");
            Common.setClientesRequest(request, response);
            Common.setCredencialesRequest(request, response);
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "desactivarCredencialNeg");
            Common.setClientesRequest(request, response);
            Common.setCredencialesRequest(request, response);
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        }
    }

    private void gatillarModificaiconCredencial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Conexion conn = new Conexion();
        CredencialDao cDto = new CredencialDao(conn);

        Login l = new Login();
        l.setCorreo("nulo");

        l = cDto.obtenerCredencial(id);

        if (!l.getCorreo().equals("nulo")) {
            request.setAttribute("tCredencial", l);
            request.getRequestDispatcher("adminPersonasMod.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "credNoEncontradaMod");
            request.getRequestDispatcher("adminPersonasMod.jsp").forward(request, response);
        }
    }

    private void gatillarModificacionPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Conexion conn = new Conexion();
        CredencialDao cDto = new CredencialDao(conn);

        Login l = new Login();
        l.setCorreo("nulo");

        l = cDto.obtenerCredencial(id);

        conn.cerrarConexion();

        if (!l.getCorreo().equals("nulo")) {
            request.setAttribute("tCredencial", l);
            request.setAttribute("modal", "modPass");
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "credNoEncontradaMod");
            request.getRequestDispatcher("adminPersonasMod.jsp").forward(request, response);
        }
    }

    private void activarCredencial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Conexion conn = new Conexion();
        CredencialDao cDto = new CredencialDao(conn);

        boolean resultado = cDto.activarCredencial(id);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "activarCredencialPos");
            Common.setClientesRequest(request, response);
            Common.setCredencialesRequest(request, response);
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "activarCredencialNeg");
            Common.setClientesRequest(request, response);
            Common.setCredencialesRequest(request, response);
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        }
    }

    private void modificarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String correo = request.getParameter("correo");
        Long idEmpresa = Long.parseLong(request.getParameter("empresa"));

        Representante rep = new Representante();
        rep.setNombre(nombre);
        rep.setRut(rut);

        Cliente cli = new Cliente();
        cli.setIdCliete(idEmpresa);

        Perfil perf = new Perfil();
        if (idEmpresa == 25) {
            perf.setIdPerfil(2L);
        } else {
            perf.setIdPerfil(3L);
        }

        Login login = new Login();
        login.setCorreo(correo);
        login.setRespresentante(rep);
        login.setCliente(cli);
        login.setPerfil(perf);
        login.setIdLogin(id);

        Conexion conn = new Conexion();
        CredencialDao cDto = new CredencialDao(conn);

        boolean resultado = cDto.modificarPersona(login);

        if (resultado) {
            request.setAttribute("mensaje", "modificarCredencialPos");
            Common.setClientesRequest(request, response);
            Common.setCredencialesRequest(request, response);
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "modificarCredencialNeg");
            Common.setClientesRequest(request, response);
            Common.setCredencialesRequest(request, response);
            request.getRequestDispatcher("adminPersonasMod.jsp").forward(request, response);
        }
    }

    private void modificarPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("idl"));
        String pass = Utils.MD5(request.getParameter("password"));

        Conexion conn = new Conexion();
        CredencialDao cDto = new CredencialDao(conn);

        boolean resultado = cDto.modificarClave(id, pass);

        if (resultado) {
            conn.cerrarConexion();
            request.setAttribute("mensaje", "modificarPassPos");
            Common.setClientesRequest(request, response);
            Common.setCredencialesRequest(request, response);
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        } else {
           
            Login l = new Login();
            l.setCorreo("nulo");

            l = cDto.obtenerCredencial(id);

            conn.cerrarConexion();

            if (!l.getCorreo().equals("nulo")) {
                
                request.setAttribute("tCredencial", l);
                request.setAttribute("men", "modificarPassNeg");
                request.setAttribute("modal", "modPass");
                request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
                
            } else {
                request.setAttribute("mensaje", "credNoEncontradaMod");
                request.getRequestDispatcher("adminPersonasMod.jsp").forward(request, response);
            }
        }
    }
}
