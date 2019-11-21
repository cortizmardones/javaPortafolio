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
        Common.setPruebaActivaSession(id, request, response);
    }
}
