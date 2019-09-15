/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Data.RubroDao;
import cl.segurosporsiempre.Model.Rubro;
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
public class MappingController extends HttpServlet {

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

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String nav = request.getParameter("nav");

        switch (nav) {
            case "aPanel":
                request.getRequestDispatcher("pAdmin.jsp").forward(request, response);
                break;
            case "aClientes":
                this.setRubrosRequest(request, response);
                request.getRequestDispatcher("adminClientes.jsp").forward(request, response);
                break;
            case "aProfesionales":
                request.getRequestDispatcher("adminProfesionales.jsp").forward(request, response);
                break;
            case "aPagos":
                request.getRequestDispatcher("adminPagos.jsp").forward(request, response);
                break;
            case "aOperaciones":
                request.getRequestDispatcher("adminHistorial.jsp").forward(request, response);
                break;
            case "aCredenciales":
                request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
                break;
            case "cPanel":
                request.getRequestDispatcher("pCliente.jsp").forward(request, response);
                break;
            case "cSolicitudes":
                request.getRequestDispatcher("cliSolicitudes.jsp").forward(request, response);
                break;
            case "cPagos":
                request.getRequestDispatcher("cliPagos.jsp").forward(request, response);
                break;
            case "cReportes":
                request.getRequestDispatcher("cliReportes.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
    Deja en request todos los rubros
    */
    protected void setRubrosRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Conexion conn = new Conexion();
        RubroDao rDto = new RubroDao(conn);

        List<Rubro> rubros = rDto.obtenerRubros();
        
        conn.cerrarConexion();

        if (rubros.size() > 0) {
            request.setAttribute("rRubros", rubros);
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

    }
}
