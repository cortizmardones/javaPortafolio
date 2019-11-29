/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Data.CapacitacionDao;
import cl.segurosporsiempre.Model.Capacitacion;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Profesional;
import cl.segurosporsiempre.Model.Prueba;
import cl.segurosporsiempre.Model.Utils;
import cl.segurosporsiempre.Reporting.GeneradorReporte;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author raulp
 */
public class CapacitacionController extends HttpServlet {


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
        
        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "explorar":
                this.explorarCapacitacion(request, response);
                break;
            case "generarReporte":
                this.generarReporte(request, response);
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

        
    }

    private void explorarCapacitacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Long id = Long.parseLong(request.getParameter("id"));
        Common.setPruebaCapActivaSession(id, request, response);
    }

    private void generarReporte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            
            JasperPrint reporteLeno = GeneradorReporte.generarReporteCapacitaciones(Long.parseLong(request.getParameter("idCapActiva")));        
            JasperExportManager.exportReportToPdfFile(reporteLeno, "/opt/apache-tomcat-8.5.45/webapps/ROOT/reports/ReporteMaestroCapacitaciones"+ request.getParameter("idCapActiva") + ".pdf");
            request.setAttribute("senDescargar", "bajarReporte");
            request.getRequestDispatcher("proCapacitacionesDetalles.jsp").forward(request, response);
        } catch (JRException ex) {
            Logger.getLogger(CapacitacionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
