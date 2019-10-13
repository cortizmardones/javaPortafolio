/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Data.ProfesionalDao;
import cl.segurosporsiempre.Model.Profesional;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raúl Pardo Zurita
 */
public class Common extends HttpServlet {

    public static void setProfesionalesSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        Conexion conn = new Conexion();
        ProfesionalDao pDto = new ProfesionalDao(conn);
        
        List<Profesional> profesionales = pDto.obtenerProfesionales();
        
        if (profesionales != null && profesionales.size() > 0)
        {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("profesionales", profesionales);
        }
        else
        {
            HttpSession sesion = request.getSession();
            List<Profesional> pros = new LinkedList<>();
            sesion.setAttribute("profesionales", pros);
        }
    }
}
