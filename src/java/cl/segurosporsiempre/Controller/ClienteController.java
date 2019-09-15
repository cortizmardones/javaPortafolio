/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Raúl Pardo Zurita
 */
public class ClienteController extends HttpServlet {

    private static final String UPLOAD_DIR = "multimedia";

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

        String accion = request.getParameter("accion");

        switch (accion) {
            case "agregarCliente":
                this.agregarCliente(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void agregarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String razonSocial = request.getParameter("razonSocial");
        String logo = "www.carloschile.cl/ultra.jpg";
        String fechaContrato = request.getParameter("fechaContrato");
        
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String fechaIngreso = sdf.format(fechaActual);
        
        String fechaTermino = "1999-01-01 00:00";
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        String fono = request.getParameter("fono"); 
        String rubro = request.getParameter("rubro");
        boolean estado = true;
        String pass = Utils.MD5(request.getParameter("password_two")); 
         */
    }

    private void subirArchivo(HttpServletRequest request, HttpServletResponse response, Part archivo) throws ServletException, IOException {

        String applicationPath = getServletContext().getInitParameter("file-upload");
        String uploadFilePath = applicationPath + File.separator;
        String nombre = archivo.getSubmittedFileName();
        archivo.write(uploadFilePath + File.separator + nombre);
        
    }
}
