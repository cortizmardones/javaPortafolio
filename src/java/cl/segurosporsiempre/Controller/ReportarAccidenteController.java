/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author raulp
 */
public class ReportarAccidenteController extends HttpServlet {


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
            case "reportarAccidente":
                this.reportarAccidente(request, response);
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
        
        
        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "consolidarReporte":
                this.consolidarReporte(request, response);
                break;
            default:
                throw new AssertionError();
        }        

    }
    
    

    private void reportarAccidente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setAttribute("modal", "reporteAccidente");
        request.getRequestDispatcher("pCliente.jsp").forward(request, response);
        
    }

    private void consolidarReporte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}