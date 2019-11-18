/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Data.AccidenteDao;
import cl.segurosporsiempre.Data.AsesoriaDao;
import cl.segurosporsiempre.Data.CapacitacionDao;
import cl.segurosporsiempre.Data.CheckListDAO;
import cl.segurosporsiempre.Data.EmpresaDAO;
import cl.segurosporsiempre.Data.LoginDao;
import cl.segurosporsiempre.Data.ProfesionalDao;
import cl.segurosporsiempre.Data.RubroDAO;
import cl.segurosporsiempre.Data.UsuarioDao;
import cl.segurosporsiempre.Data.VisitaDAO;
import cl.segurosporsiempre.Model.Accidente;
import cl.segurosporsiempre.Model.Asesoria;
import cl.segurosporsiempre.Model.Capacitacion;
import cl.segurosporsiempre.Model.CheckList;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Profesional;
import cl.segurosporsiempre.Model.Rubro;
import cl.segurosporsiempre.Model.TipoAccidente;
import cl.segurosporsiempre.Model.TipoAsesoria;
import cl.segurosporsiempre.Model.Usuario;
import cl.segurosporsiempre.Model.UsuarioProfesional;
import cl.segurosporsiempre.Model.Visita;
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

    public static void setProfesionalesSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Conexion conn = new Conexion();
        ProfesionalDao pDto = new ProfesionalDao(conn);

        List<Profesional> profesionales = pDto.obtenerProfesionales();

        conn.cerrarConexion();

        if (profesionales != null && profesionales.size() > 0) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("profesionales", profesionales);
        } else {
            HttpSession sesion = request.getSession();
            List<Profesional> pros = new LinkedList<>();
            sesion.setAttribute("profesionales", pros);
        }
    }

    public static void setUsuarioActivoSession(Usuario usu, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuarioActivo", usu);
    }
    
    public static void setUsuarioActivoRecPassSession(String correo, String perfil, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        
        Conexion conn = new Conexion();
        LoginDao lDto = new LoginDao(conn);
        
        if (perfil.equals("profesional"))
        {
            UsuarioProfesional usu = lDto.obtenerUsuarioProfesional(correo);
            conn.cerrarConexion();
            sesion.setAttribute("usuRec", usu);
        }
        else
        {
            Usuario usu = lDto.obtenerUsuario(correo);
            conn.cerrarConexion();
            sesion.setAttribute("usuRec", usu);            
        }
    }    

    public static void setTiposAccidenteRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conexion conn = new Conexion();
        AccidenteDao aDto = new AccidenteDao(conn);

        List<TipoAccidente> tas = aDto.obtenerTiposAccidente();

        conn.cerrarConexion();

        if (tas != null && tas.size() > 0) {
            request.setAttribute("tiposAccidente", tas);
        } else {
            List<TipoAccidente> tasDos = new LinkedList<>();
            request.setAttribute("tiposAccidente", tasDos);
        }
    }

    public static void setEmpresasSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            HttpSession sesion = request.getSession();
            //crear conexion
            Conexion conn = new Conexion();
            UsuarioDao pDto = new UsuarioDao(conn);
            List<Empresa> empresas = pDto.obtenerEmpresas();

            if (empresas != null && empresas.size() > 0) {
                sesion.setAttribute("emp", empresas);
            } else {
                List<Empresa> lstEmpresa = new LinkedList<>();
                sesion.setAttribute("emp", lstEmpresa);
            }
        }
    }

    public static void setCredencialesSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Conexion conn = new Conexion();
        UsuarioDao lsp = new UsuarioDao(conn);

        List<Usuario> usuarios = lsp.obtenerPersonas();

        if (usuarios != null && usuarios.size() > 0) {
            //HttpSession sesion = request.getSession();
            sesion.setAttribute("credenciales", usuarios);
        } else {

            //HttpSession sesion = request.getSession();
            List<Usuario> pros = new LinkedList<>();
            sesion.setAttribute("credenciales", pros);
        }
    }

    public static void setRubrosSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conexion conn = new Conexion();
        RubroDAO rDto = new RubroDAO(conn);

        List<Rubro> rubros = rDto.obtenerRubros();

        if (rubros != null && rubros.size() > 0) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rRubros", rubros);
        } else {
            HttpSession sesion = request.getSession();
            List<Rubro> rubrosList = new LinkedList<>();
            sesion.setAttribute("rRubros", rubrosList);
        }

    }

    public static void setEmpresasSession2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conexion conn = new Conexion();
        EmpresaDAO eDto = new EmpresaDAO(conn);

        List<Empresa> empresas = eDto.obtenerEmpresas();

        if (empresas != null && empresas.size() > 0) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("empresas", empresas);
        } else {
            HttpSession sesion = request.getSession();
            List<Empresa> empresas2 = new LinkedList<>();
            sesion.setAttribute("empresas", empresas2);
        }

    }

    public static void setVisitasSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conexion conn = new Conexion();
        VisitaDAO vDto = new VisitaDAO(conn);

        List<Visita> visitas = vDto.obtenerVisitas();

        if (visitas != null && visitas.size() > 0) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("visitas", visitas);
        } else {
            HttpSession sesion = request.getSession();
            List<Visita> visitas2 = new LinkedList<>();
            sesion.setAttribute("visitas", visitas2);
        }

    }

    public static void setCheckListSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conexion conn = new Conexion();
        CheckListDAO cDto = new CheckListDAO(conn);

        List<CheckList> checklists = cDto.obtenerCheckList();

        if (checklists != null && checklists.size() > 0) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("checklists", checklists);
        } else {
            HttpSession sesion = request.getSession();
            List<CheckList> checklists2 = new LinkedList<>();
            sesion.setAttribute("checklists", checklists2);
        }
    }
    
    public static void setCapacitaicionesSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        Conexion conn = new Conexion();
        CapacitacionDao cDto = new CapacitacionDao(conn);
        
        List<Capacitacion> capacitaciones = cDto.obtenerCapacitaciones();
        
        conn.cerrarConexion();
        
        if (capacitaciones != null && capacitaciones.size() > 0)
        {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("capacitaciones", capacitaciones);
        }
        else
        {
            List<Capacitacion> caps = new LinkedList<>();
            HttpSession sesion = request.getSession();
            sesion.setAttribute("capacitaciones", caps);            
        }
    }
    
    public static void setAsesoriasSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            //HttpSession sesion = request.getSession();
            //crear conexion
            Conexion conn = new Conexion();
            AsesoriaDao pDto = new AsesoriaDao(conn);
            List<Asesoria> asesorias = pDto.obtenerAsesorias();

            if (asesorias != null && asesorias.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("asesorias", asesorias);
            } else {
                List<Asesoria> lstAsesorias = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("asesorias", lstAsesorias);
            }
        }
    }
    
    public static void setTipoAsesoriasRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {            
            Conexion conn = new Conexion();
            AsesoriaDao taDto = new AsesoriaDao(conn);
            List<TipoAsesoria> tase = taDto.obtenerTiposAsesoria();
            conn.cerrarConexion();

            if (tase != null && tase.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("tiposAsesorias", tase);
                
            } else {
                List<TipoAsesoria> lstase = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("tiposAsesorias", lstase);                
            }
        }
    }

    public static void setAccidentesSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesion = request.getSession();

        //crear conexion
        Conexion conn = new Conexion();
        AccidenteDao aDto = new AccidenteDao(conn);
        List<Accidente> accidentes = aDto.obtenerAccidentes();

        if (accidentes != null && accidentes.size() > 0) {
            //HttpSession sesion = request.getSession();
            sesion.setAttribute("accidentes", accidentes);
        } else {
            List<Accidente> lstAccidente = new LinkedList<>();
            //HttpSession sesion = request.getSession();
            sesion.setAttribute("accidentes", lstAccidente);
        }

    }
     
}
