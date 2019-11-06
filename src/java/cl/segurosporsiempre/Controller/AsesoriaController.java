/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cl.segurosporsiempre.Model.Utils;
import cl.segurosporsiempre.Data.AsesoriaDao;
import cl.segurosporsiempre.Model.Asesoria;
import cl.segurosporsiempre.Model.TipoAsesoria;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Profesional;


/**
 *
 * @author Tonino
 */
public class AsesoriaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AsesoriaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AsesoriaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        //processRequest(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //Gatilladores y D+
        String accion = request.getParameter("accion");

        switch (accion) {

            case "dejarPendiente":
                this.dejarPendiente(request, response);
                break;
            case "dejarHecha":
                this.dejarHecha(request, response);
                break;
            case "gModificarAsesoria":
                this.gModificarAsesoria(request, response);
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
        //processRequest(request, response);

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");
        switch (accion) {
            case "agregarAsesoria":
                this.agregarAsesoria(request, response);
                break;

            case "modificarAsesoria":
                this.modificarAsesoria(request, response);
                break;

            default:
                throw new AssertionError();
        }

    }
    
    private void agregarAsesoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idEmpresa = request.getParameter("empresa");
        String idTipoAsesoria = request.getParameter("tipoAsesoria");
        String idProfesional = request.getParameter("profesional");        
        String fechaIngreso = Utils.FECHATRANSFORMADA(request.getParameter("fechaIngreso"));
        String fechaRealizada = Utils.FECHATRANSFORMADA(request.getParameter("fechaRealizada"));
        Asesoria aso = new Asesoria();
        aso.setEmpresa(new Empresa(Long.parseLong(idEmpresa)));
        aso.setTipoAsesoria(new TipoAsesoria(Integer.parseInt(idTipoAsesoria)));
        aso.setProfesional(new Profesional(Long.parseLong(idProfesional)));
        aso.setFechaIngreso(fechaIngreso);
        aso.setFechaEstimadaRealizada(fechaRealizada);

        Conexion conn = new Conexion();
        AsesoriaDao asoDto = new AsesoriaDao(conn);
        
        boolean resultado = asoDto.agregarAsesoria(aso);
        
        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "agregarAsesoriaPos");
            Common.setAsesoriasSession(request, response);
            request.getRequestDispatcher("proAsesorias.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "agregarAsesoriaNeg");
            Common.setAsesoriasSession(request, response);
            request.getRequestDispatcher("proAsesorias.jsp").forward(request, response);
        }
    }
    
    
    
    //Dejar asesoría hecha
    private void dejarHecha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Conexion conn = new Conexion();
        AsesoriaDao aDto = new AsesoriaDao(conn);
        boolean resultado = aDto.activarAsesoria(id);
        conn.cerrarConexion();
        
        if (resultado) {
            request.setAttribute("mensaje", "activarAsesoriaPos");
            Common.setAsesoriasSession(request, response);
            request.getRequestDispatcher("proAsesorias.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "activarAsesoriaNeg");
            Common.setAsesoriasSession(request, response);
            request.getRequestDispatcher("proAsesorias.jsp").forward(request, response);
        }
    }
    
    
    //Dejar asesoría pendiente
    private void dejarPendiente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Conexion conn = new Conexion();
        AsesoriaDao aDto = new AsesoriaDao(conn);
        boolean resultado = aDto.desactivarAsesoria(id);
        conn.cerrarConexion();
        
        if (resultado) {
            request.setAttribute("mensaje", "desactivarAsesoriaPos");
            Common.setAsesoriasSession(request, response);
            request.getRequestDispatcher("proAsesorias.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "desactivarAsesoriaNeg");
            Common.setAsesoriasSession(request, response);
            request.getRequestDispatcher("proAsesorias.jsp").forward(request, response);
        }
    }
    
    //Trigger gModificarAsesoria
    private void gModificarAsesoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        Long id = Long.parseLong(request.getParameter("id"));
        Conexion conn = new Conexion();
        AsesoriaDao aDto = new AsesoriaDao(conn);
        Asesoria a = aDto.buscarAsesoriaxId(id);
        
        if(a!=null)
        {            
            request.setAttribute("atrAsesoria", a);
            Common.setAsesoriasSession(request, response);
            Common.setEmpresasSession(request, response);
            Common.setProfesionalesSession(request, response);
            request.getRequestDispatcher("proAsesoriasMod.jsp").forward(request, response);
            
        }
        else
        {
            request.setAttribute("mensaje", "asesoriaNoEncontradaMod");
            Common.setAsesoriasSession(request, response);
            request.getRequestDispatcher("proAsesorias.jsp").forward(request, response);            
        }
    }
    
    //Modificar asesoria
    private void modificarAsesoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //sera esto? P.D: Sí!! Faltó pasar la ID xD
        Long id = Long.parseLong(request.getParameter("id"));
        //Integer id = Integer.parseInt(request.getParameter("id"));
        String idEmpresa = request.getParameter("empresa");
        String idTipoAsesoria = request.getParameter("tipoAsesoria");
        String idProfesional = request.getParameter("profesional");        
        String fechaIngreso = Utils.FECHATRANSFORMADA(request.getParameter("fechaIngreso"));
        //String fechaIngreso = request.getParameter("fechaIngreso");
        String fechaRealizada = Utils.FECHATRANSFORMADA(request.getParameter("fechaRealizada"));
        //String fechaRealizada = request.getParameter("fechaRealizada");
        
        Asesoria ase = new Asesoria();
        
        ase.setId(id);        
        ase.setEmpresa(new Empresa(Long.parseLong(idEmpresa)));
        ase.setTipoAsesoria(new TipoAsesoria(Integer.parseInt(idTipoAsesoria)));
        ase.setProfesional(new Profesional(Long.parseLong(idProfesional)));
        ase.setFechaIngreso(fechaIngreso);
        ase.setFechaEstimadaRealizada(fechaRealizada);
        
        Conexion conn = new Conexion();
        AsesoriaDao aDto = new AsesoriaDao(conn);
        
        boolean resultado = aDto.modificarAsesoria(ase);
        
        if (resultado) {
            request.setAttribute("mensaje", "modificarAsesoriaPos");
            Common.setAsesoriasSession(request, response);
            request.getRequestDispatcher("proAsesorias.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "modificarAsesoriaNeg");
            Common.setAsesoriasSession(request, response);
            request.getRequestDispatcher("proAsesorias.jsp").forward(request, response);
        }
        
        
    }
    
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
