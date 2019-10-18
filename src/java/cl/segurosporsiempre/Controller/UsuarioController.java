/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Data.UsuarioDao;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Perfil;
import cl.segurosporsiempre.Model.Usuario;
import cl.segurosporsiempre.Model.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tonino
 */
public class UsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {

            case "activarUsuario":
                this.activarUsuario(request, response);
                break;
            case "desactivarUsuario":
                this.desactivarUsuario(request, response);
                break;
            case "gModificarUsuario":
                this.gModificarUsuario(request, response);
                break;
            default:
                throw new AssertionError();
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //Añadir codigo POST aquí conchemimare
        String accion = request.getParameter("accion");

        switch (accion) {
            case "agregarCredencial":
                this.agregarCredencial(request, response);
                break;

            case "modificarPersona":
                this.modificarPersona(request, response);
                break;

            default:
                throw new AssertionError();
        }
    }

    private void agregarCredencial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String correo = request.getParameter("correo");
        //String clave = request.getParameter("password");
        String clave = Utils.MD5(request.getParameter("password"));

        //request.getParamemter("empresa")
        String empresa = request.getParameter("empresa");

        Perfil perf = new Perfil();
        Usuario usr = new Usuario();
        Empresa empre = new Empresa();

        Integer tipoUsr = 0;
        //regla de negocio xD

        if (empresa.equals("1")) {
            tipoUsr = 2;
            //perf.setId(2);
        } else {
            tipoUsr = 3;
            //perf.setId(3);
        }

        usr.setCorreo(correo);
        usr.setPassword(clave);
        //usr.setPerfil(perf);
        usr.setPerfil(new Perfil(tipoUsr));
        usr.setEmpresa(new Empresa(Long.parseLong(empresa)));
        //perf.setId(tipoUsr)

        Conexion conn = new Conexion();
        UsuarioDao pDto = new UsuarioDao(conn);

        boolean resultado = pDto.agregarCredencial(usr);
        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "agregarCredencialPos");
            Common.setCredencialesSession(request, response);
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "agregarCredencialNeg");
            Common.setCredencialesSession(request, response);            
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        }
    }

    //processRequest(request, response);
    //ACTIVAR USUARIO
    private void activarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Conexion conn = new Conexion();
        UsuarioDao uDto = new UsuarioDao(conn);
        boolean resultado = uDto.activarUsuario(id);
        conn.cerrarConexion();
        if (resultado) {
            request.setAttribute("mensaje", "activarCredencialPos");
            Common.setCredencialesSession(request, response);            
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "activarCredencialNeg");
            Common.setCredencialesSession(request, response);            
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        }

    }

    //DESACTIVAR USUARIO
    private void desactivarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Conexion conn = new Conexion();
        UsuarioDao uDto = new UsuarioDao(conn);
        boolean resultado = uDto.desactivarUsuario(id);
        conn.cerrarConexion();
        if (resultado) {
            request.setAttribute("mensaje", "desactivarCredencialPos");
            Common.setCredencialesSession(request, response);            
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "desactivarCredencialNeg");
            Common.setCredencialesSession(request, response);            
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        }

    }

    //Gatillar modificación de usuario (Gatillar?? SAPBEEEE!!)    
    private void gModificarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Conexion conn = new Conexion();
        UsuarioDao uDto = new UsuarioDao(conn);
        Usuario u = uDto.buscarUsuarioxId(id);

        if (u != null) {
            request.setAttribute("tCredencial", u);
            request.getRequestDispatcher("adminPersonasMod.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "credNoEncontradaMod");
            Common.setCredencialesSession(request, response);
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        }
    }

    //Modificar usuario
    private void modificarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //sera esto? P.D: Sí!! Faltó pasar la ID xD
        Long id = Long.parseLong(request.getParameter("id"));
        String correo = request.getParameter("correo");
        //request.getParamemter("empresa")
        String empresa = request.getParameter("empresa");

        Usuario usr = new Usuario();
        Integer tipoUsr = 0;

        if (empresa.equals("1")) {
            tipoUsr = 2;
        } else {
            tipoUsr = 3;
        }

        //Será esto?... SÍ!! Obviamente hay que pasar la ID.... SAPBEEE
        usr.setId(id);
        usr.setCorreo(correo);
        usr.setPerfil(new Perfil(tipoUsr));
        usr.setEmpresa(new Empresa(Long.parseLong(empresa)));
        Conexion conn = new Conexion();
        UsuarioDao uDto = new UsuarioDao(conn);

        boolean resultado = uDto.modificarUsuario(usr);
        if (resultado) {
            request.setAttribute("mensaje", "modificarCredencialPos");
            Common.setCredencialesSession(request, response);            
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "modificarCredencialFracaso");
            Common.setCredencialesSession(request, response);            
            request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
        }
    }
}
