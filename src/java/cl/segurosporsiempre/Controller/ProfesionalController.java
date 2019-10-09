/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Data.ProfesionalDao;
import cl.segurosporsiempre.Model.ContratoProfesional;
import cl.segurosporsiempre.Model.Profesional;
import cl.segurosporsiempre.Model.Utils;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 *
 * @author raulp
 */
@MultipartConfig(maxFileSize = 16177215)
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
        String avatar = this.subirFoto(request.getPart("foto"), request, response);
        String fechaContrato = Utils.FECHATRANSFORMADA(request.getParameter("fechaContrato"));
        String fechaNacimiento = Utils.FECHATRANSFORMADA(request.getParameter("fechaNacimiento"));
        String direccion = request.getParameter("direccion");
        int fono = Integer.parseInt(request.getParameter("fono"));
        
        System.out.println(fechaContrato);
        System.out.println(fechaNacimiento);
        
        
        ContratoProfesional c = new ContratoProfesional();
        c.setFechaContrato(fechaContrato);
        
        
        Profesional pro = new Profesional();
        pro.setNombres(nombres);
        pro.setApellidos(apellidos);
        pro.setRut(rut);
        pro.setDireccion(direccion);
        pro.setFono(fono);
        pro.setFechaNacimiento(fechaNacimiento);
        pro.setAvatar(avatar);
        
        pro.setContrato(c);
        
        Conexion conn = new Conexion();        
        ProfesionalDao pDto = new ProfesionalDao(conn);
        
        boolean resultado = pDto.agregarProfesional(pro);
        
        conn.cerrarConexion();
        
        if (resultado)
        {
            request.setAttribute("mensaje", "agregarProfesionalExito");
            request.getRequestDispatcher("adminProfesionales.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("mensaje", "agregarProfesionalFracaso");
            request.getRequestDispatcher("adminProfesionales.jsp").forward(request, response);            
        }
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
