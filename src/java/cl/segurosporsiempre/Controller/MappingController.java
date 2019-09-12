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
        
    }
}