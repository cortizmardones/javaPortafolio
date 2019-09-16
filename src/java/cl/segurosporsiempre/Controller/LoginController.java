/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Data.CredencialDao;
import cl.segurosporsiempre.Model.Login;
import cl.segurosporsiempre.Model.Utils;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raúl Pardo Zurita
 */
public class LoginController extends HttpServlet {

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
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
               
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
        
        String login = request.getParameter("correo");
        String password = Utils.MD5(request.getParameter("contrasenia"));
        
        Conexion conn = new Conexion();
        CredencialDao lDto = new CredencialDao(conn);
        
        List<Login> usuarios = lDto.obtenerCredenciales();
        
        Login logind = new Login();
        logind.setCorreo("nulo");
        logind.setActivado(false);
        
        for (Login i: usuarios)
        {
            if (i.getCorreo().equals(login) && i.getPass().equals(password))
            {
                logind = i;
                break;
            }
        }
        
        conn.cerrarConexion();       
        
        if (logind.getCorreo().equals("nulo") || !logind.getActivado())
        {
            String mensaje = null;
            
            if (logind.getCorreo().equals("nulo"))
            {
                mensaje = "Credenciales erróneas";
                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("index.jsp").forward(request, response);            
            }
            
            if (!logind.getActivado())
            {
                mensaje = "No tiene permiso para ingresar al sistema, consulte con un administrador";
                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("index.jsp").forward(request, response);            
            }        
        }
        else
        {
            if (logind.getPerfil().getNombre().equals("Administrador")) {
                request.setAttribute("user", logind);
                request.getRequestDispatcher("pAdmin.jsp").forward(request, response);

            }
            if (logind.getPerfil().getNombre().equals("Profesional")) {

                request.setAttribute("user", logind);
                request.getRequestDispatcher("pProfesional.jsp").forward(request, response);

            }
            if (logind.getPerfil().getNombre().equals("Cliente")) {
                request.setAttribute("user", logind);
                request.getRequestDispatcher("pCliente.jsp").forward(request, response);
            }
        }      
    }
}
