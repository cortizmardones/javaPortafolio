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
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tonino
 */
public class AccidenteController extends HttpServlet {

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
            out.println("<title>Servlet AccidenteController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccidenteController at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {
            case "activar":
                this.activarAccidente(request, response);
                break;
            case "desactivar":
                this.desactivarAccidente(request, response);
                break;
            case "gModificarAccidente":
                this.gModificarAccidente(request, response);
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

        String accion = request.getParameter("accion");

        switch (accion) {
            case "agregarAccidente":
                this.agregarAccidente(request, response);
                break;

            case "modificarAccidente":
                this.modificarAccidente(request, response);
                break;
            default:
                throw new AssertionError();
        }

    }

    private void agregarAccidente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //GRACIAS TROLO RAUL!! 
        String causa = request.getParameter("causa");
        String detalle = request.getParameter("detalle");
        String fecha = Utils.FECHATRANSFORMADA(request.getParameter("fecha"));
        int idTipo = Integer.parseInt(request.getParameter("tipoAccidente"));
        long idEmpresa = Long.parseLong(request.getParameter("empresa"));
        Accidente acc = new Accidente();
        acc.setCausa(causa);
        acc.setDetalle(detalle);
        acc.setFecha(fecha);
        acc.setTipo(new TipoAccidente(idTipo));
        acc.setEmprea(new Empresa(idEmpresa));

        Conexion conn = new Conexion();
        AccidenteDao aDto = new AccidenteDao(conn);

        boolean resultado = aDto.agregarAccidente(acc);
        //conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "agregarAccidentePos");
            Common.setAccidentesSession(request, response);

            request.getRequestDispatcher("proAccidentes.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "agregarAccidenteNeg");
            Common.setAccidentesSession(request, response);
            request.getRequestDispatcher("proAccidentes.jsp").forward(request, response);
        }
    }

    //Activar accidente
    private void activarAccidente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Conexion conn = new Conexion();
        AccidenteDao aDto = new AccidenteDao(conn);
        boolean resultado = aDto.activarAccidente(id);
        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "activarAccidentePos");
            Common.setAccidentesSession(request, response);
            request.getRequestDispatcher("proAccidentes.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "activarAccidenteNeg");
            Common.setAccidentesSession(request, response);
            request.getRequestDispatcher("proAccidentes.jsp").forward(request, response);
        }

    }

    //Desactivar accidente
    private void desactivarAccidente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Conexion conn = new Conexion();
        AccidenteDao aDto = new AccidenteDao(conn);
        boolean resultado = aDto.desactivarAccidente(id);
        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "desactivarAccidentePos");
            Common.setAccidentesSession(request, response);
            request.getRequestDispatcher("proAccidentes.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "desactivarAccidenteNeg");
            Common.setAccidentesSession(request, response);
            request.getRequestDispatcher("proAccidentes.jsp").forward(request, response);
        }

    }

    //Trigger gModificarAccidente
    private void gModificarAccidente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Conexion conn = new Conexion();
        AccidenteDao aDto = new AccidenteDao(conn);
        Accidente a = aDto.buscarAccidentexId(id);

        if (a != null) {
            request.setAttribute("atrAccidente", a);
            Common.setAccidentesSession(request, response);
            request.getRequestDispatcher("proAccidentesMod.jsp").forward(request, response);

        } else {
            request.setAttribute("mensaje", "asesoriaNoEncontradaMod");
            Common.setAccidentesSession(request, response);
            request.getRequestDispatcher("proAccidentes.jsp").forward(request, response);
        }

    }

    //Modificar accidente Servlet
    private void modificarAccidente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Integer idTipo = Integer.parseInt(request.getParameter("tipoAccidente"));
        Long idEmpresa = Long.parseLong(request.getParameter("empresa"));
        String fecha = Utils.FECHATRANSFORMADA(request.getParameter("fecha"));
        String causa = request.getParameter("causa");
        String detalle = request.getParameter("detalle");

        Accidente acc = new Accidente();
        acc.setId(id);
        acc.setTipo(new TipoAccidente(idTipo));
        acc.setEmprea(new Empresa(idEmpresa));
        acc.setFecha(fecha);
        acc.setCausa(causa);
        acc.setDetalle(detalle);
        Conexion conn = new Conexion();
        AccidenteDao aDto = new AccidenteDao(conn);
        boolean resultado = aDto.modificarAccidente(acc);

        if (resultado) {
            request.setAttribute("mensaje", "modificarAccidentePos");
            Common.setAccidentesSession(request, response);
            request.getRequestDispatcher("proAccidentes.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "modificarAccidenteNeg");
            Common.setAccidentesSession(request, response);
            request.getRequestDispatcher("proAccidentes.jsp").forward(request, response);
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
