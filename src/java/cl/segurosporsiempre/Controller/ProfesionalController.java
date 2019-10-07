/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 *
 * @author raulp
 */
public class ProfesionalController extends HttpServlet {
    
     private static final String UPLOAD_DIR = "fotosPro";

    /**
     * Maneja el método HTTP <code>GET</code>.
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
     * Maneja el método HTTP <code>POST</code>.
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
            case "agregarProfesional":
                this.agregarProfesional(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void agregarProfesional(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String rut = request.getParameter("rut");
        String foto = this.subirFoto(request.getPart("foto"), request, response);
        String fechaContrato = request.getParameter("fechaContrato");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String direccion = request.getParameter("direccion");
        String fono = request.getParameter("fono");
        
        Conexion conn = new Conexion();
        

    }
    
    private String subirFoto(Part archivo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        
        String applicationPath = request.getServletContext().getRealPath("");

        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        
        System.out.println("part.getContentType : " + archivo.getContentType());
        System.out.println("part.getSize : " + archivo.getSize());
        System.out.println("part.getName : " + archivo.getName());
        System.out.println("part.getSubmittedFileName : " + archivo.getSubmittedFileName());

        String nombre = archivo.getSubmittedFileName();

        archivo.write(uploadFilePath + File.separator + nombre); 
        
        return "https://www.segurosporsiempre.cl/fotosPro/"+ nombre;
    }    
}