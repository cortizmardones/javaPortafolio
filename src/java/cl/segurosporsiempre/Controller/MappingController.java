/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import java.io.IOException;
import java.util.List;
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
        
        if (nav == null)
        {
            System.out.println((String)request.getAttribute("nave"));
            nav = (String)request.getAttribute("nave");
        }

        switch (nav) {
            case "aPanel":
                request.getRequestDispatcher("pAdmin.jsp").forward(request, response);
                break;
            case "aClientes":
                Common.setRubrosSession(request, response);
                Common.setEmpresasSession2(request, response);
                request.getRequestDispatcher("adminClientes.jsp").forward(request, response);
                break;
            case "aProfesionales":
                Common.setProfesionalesSession(request, response);
                request.getRequestDispatcher("adminProfesionales.jsp").forward(request, response);
                break;
            case "aPagos":
                request.getRequestDispatcher("adminPagos.jsp").forward(request, response);
                break;
            case "aOperaciones":
                request.getRequestDispatcher("adminHistorial.jsp").forward(request, response);
                break;
            case "aCredenciales":
                Common.setCredencialesSession(request, response);
                Common.setEmpresasSession(request, response);                
                request.getRequestDispatcher("adminPersonas.jsp").forward(request, response);
                break;
            case "cPanel":
                request.getRequestDispatcher("pCliente.jsp").forward(request, response);
                break;
            case "cSolicitudes":
                request.getRequestDispatcher("cliSolicitudes.jsp").forward(request, response);
                break;
            case "cPagos":
                request.getRequestDispatcher("cliPagos.jsp").forward(request, response);
                break;
            case "cReportes":
                request.getRequestDispatcher("cliReportes.jsp").forward(request, response);
                break;
            case "pPanel":
                request.getRequestDispatcher("pProfesional.jsp").forward(request, response);
                break;
            case "pAsesorias":
                Common.setAsesoriasSession(request, response);
                Common.setProfesionalesSession(request, response);
                Common.setEmpresasSession(request, response);    
                Common.setTipoAsesoriasRequest(request, response); 
                request.getRequestDispatcher("proAsesorias.jsp").forward(request, response);
                break;
            case "pAccidentes":
                Common.setTiposAccidenteRequest(request, response);
                Common.setEmpresasSession(request, response);
                Common.setAccidentesSession(request, response);
                request.getRequestDispatcher("proAccidentes.jsp").forward(request, response);
                break;                              
            case "pCapacitaciones":
                Common.setCapacitaicionesSession(request, response);                
                request.getRequestDispatcher("proCapacitaciones.jsp").forward(request, response);
                break;
            case "pVisitas":
                Common.setProfesionalesSession(request, response);
                Common.setEmpresasSession(request, response);
                Common.setVisitasSession(request, response);
                Common.setCheckListSession(request, response);
                request.getRequestDispatcher("proVisitas.jsp").forward(request, response);
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