/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Data.AccidenteDao;
import cl.segurosporsiempre.Model.Accidente;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.TipoAccidente;
import cl.segurosporsiempre.Model.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
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
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
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
        Common.setTiposAccidenteRequest(request, response);
        request.getRequestDispatcher("pCliente.jsp").forward(request, response);
        
    }

    private void consolidarReporte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String causa = request.getParameter("causa");
        String detalle = request.getParameter("detalle");
        String fecha = Utils.FECHATRANSFORMADA(request.getParameter("fecha"));
        int idTipo = Integer.parseInt(request.getParameter("tipo"));
        long idEmpresa = Long.parseLong(request.getParameter("idEmpresa"));
        long idCliente = Long.parseLong(request.getParameter("idCliente"));
        
        Accidente acc = new Accidente();
        acc.setCausa(causa);
        acc.setDetalle(detalle);
        acc.setFecha(fecha);
        acc.setTipo(new TipoAccidente(idTipo));
        acc.setEmprea(new Empresa(idEmpresa));
        
        Conexion conn = new Conexion();
        AccidenteDao aDto = new AccidenteDao(conn);
        
        boolean resultado = aDto.agregarAccidente(acc);
        
        if (resultado)
        {
            request.setAttribute("mensaje", "accidenteReportarExito");
            request.getRequestDispatcher("pCliente.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("mensaje", "accidenteReportarFracaso");
            request.getRequestDispatcher("pCliente.jsp").forward(request, response);            
        }
    }
}