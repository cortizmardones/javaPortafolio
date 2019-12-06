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
import cl.segurosporsiempre.Data.ItemsDAO;
import cl.segurosporsiempre.Data.LoginDao;
import cl.segurosporsiempre.Data.ProfesionalDao;
import cl.segurosporsiempre.Data.RubroDAO;
import cl.segurosporsiempre.Data.UsuarioDao;
import cl.segurosporsiempre.Data.VisitaDAO;
import cl.segurosporsiempre.Model.Accidente;
import cl.segurosporsiempre.Model.Asesoria;
import cl.segurosporsiempre.Model.Capacitacion;
import cl.segurosporsiempre.Model.CheckList;
import cl.segurosporsiempre.Model.ContadorAccidente;
import cl.segurosporsiempre.Model.ContadorAsesoria;
import cl.segurosporsiempre.Model.ContadorCapacitacion;
import cl.segurosporsiempre.Model.ContadorTotalAccidente;
import cl.segurosporsiempre.Model.ContadorVisita;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Estado;
import cl.segurosporsiempre.Model.Item;
import cl.segurosporsiempre.Model.Profesional;
import cl.segurosporsiempre.Model.Prueba;
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

        if (perfil.equals("profesional")) {
            UsuarioProfesional usu = lDto.obtenerUsuarioProfesional(correo);
            conn.cerrarConexion();
            sesion.setAttribute("usuRec", usu);
        } else {
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

    public static void setCapacitaicionesSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conexion conn = new Conexion();
        CapacitacionDao cDto = new CapacitacionDao(conn);

        List<Capacitacion> capacitaciones = cDto.obtenerCapacitaciones();

        conn.cerrarConexion();

        if (capacitaciones != null && capacitaciones.size() > 0) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("capacitaciones", capacitaciones);
        } else {
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

    public static void setPruebaCapActivaSession(Long idCapacitacion, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Conexion conn = new Conexion();
        CapacitacionDao cDto = new CapacitacionDao(conn);

        Prueba p = cDto.obtenerPruebaPorCapacitacion(idCapacitacion);

        conn.cerrarConexion();

        if (p != null) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("pruebaActiva", p);
            sesion.setAttribute("idCapActiva", idCapacitacion);
            request.getRequestDispatcher("proCapacitacionesDetalles.jsp").forward(request, response);

        } else {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("pruebaActiva", new Prueba());
            request.getRequestDispatcher("proCapacitaciones.jsp").forward(request, response);
        }
    }

    public static void setCheckListV2Session(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conexion conn = new Conexion();
        CheckListDAO cDto = new CheckListDAO(conn);

        List<CheckList> checklists = cDto.listarCheckList();

        if (checklists != null && checklists.size() > 0) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("checklists", checklists);
        } else {
            HttpSession sesion = request.getSession();
            List<CheckList> checklists2 = new LinkedList<>();
            sesion.setAttribute("checklists", checklists2);
        }
    }

    public static void setEstadoRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conexion conn = new Conexion();
        ItemsDAO iDto = new ItemsDAO(conn);

        List<Estado> edos = iDto.obtenerEstados();
        conn.cerrarConexion();

        if (edos != null && edos.size() > 0) {
            request.setAttribute("estadosItem", edos);
        } else {
            List<Estado> edos2 = new LinkedList<>();
            request.setAttribute("estadosItem", edos2);
        }
    }

    public static void setItemSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conexion conn = new Conexion();
        ItemsDAO iDto = new ItemsDAO(conn);

        List<Item> items = iDto.obtenerItem();

        if (items != null && items.size() > 0) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("items", items);
        } else {
            HttpSession sesion = request.getSession();
            List<Item> item2 = new LinkedList<>();
            sesion.setAttribute("items", item2);
        }

    }

    public static void setContadorVisitasRealizadas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Conexion conn = new Conexion();
            VisitaDAO vDto = new VisitaDAO(conn);
            List<ContadorVisita> contadorVisitas = vDto.obtenerCantidadVisitasRealizadas();

            if (contadorVisitas != null && contadorVisitas.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("vRealizadas", contadorVisitas);
            } else {
                List<ContadorVisita> contadorVisitas2 = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("vRealizadas", contadorVisitas2);
            }
        }
    }

    public static void setContadorVisitasPendientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Conexion conn = new Conexion();
            VisitaDAO vDto = new VisitaDAO(conn);
            List<ContadorVisita> contadorVisitas = vDto.obtenerCantidadVisitasPendientes();

            if (contadorVisitas != null && contadorVisitas.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("vPendientes", contadorVisitas);
            } else {
                List<ContadorVisita> contadorVisitas2 = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("vPendientes", contadorVisitas2);
            }
        }
    }

    public static void setContadorVisitasCanceladas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Conexion conn = new Conexion();
            VisitaDAO vDto = new VisitaDAO(conn);
            List<ContadorVisita> contadorVisitas = vDto.obtenerCantidadVisitasCanceladas();

            if (contadorVisitas != null && contadorVisitas.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("vCanceladas", contadorVisitas);
            } else {
                List<ContadorVisita> contadorVisitas2 = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("vCanceladas", contadorVisitas2);
            }
        }
    }

    public static void setContadorAccidentesLeves(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Conexion conn = new Conexion();
            AccidenteDao vDto = new AccidenteDao(conn);
            List<ContadorAccidente> contadorAccidente = vDto.obtenerCantidadAccidentesLeves();

            if (contadorAccidente != null && contadorAccidente.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("aLeves", contadorAccidente);
            } else {
                List<ContadorVisita> contadorAccidente2 = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("aLeves", contadorAccidente2);
            }
        }
    }

    public static void setContadorAccidentesMedios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Conexion conn = new Conexion();
            AccidenteDao vDto = new AccidenteDao(conn);
            List<ContadorAccidente> contadorAccidente = vDto.obtenerCantidadAccidentesMedios();

            if (contadorAccidente != null && contadorAccidente.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("aMedios", contadorAccidente);
            } else {
                List<ContadorVisita> contadorAccidente2 = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("aMedios", contadorAccidente2);
            }
        }
    }

    public static void setContadorAccidentesGraves(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Conexion conn = new Conexion();
            AccidenteDao vDto = new AccidenteDao(conn);
            List<ContadorAccidente> contadorAccidente = vDto.obtenerCantidadAccidentesGraves();

            if (contadorAccidente != null && contadorAccidente.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("aGraves", contadorAccidente);
            } else {
                List<ContadorVisita> contadorAccidente2 = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("aGraves", contadorAccidente2);
            }
        }
    }

    public static void setContadorCapacitacionesRealizadas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Conexion conn = new Conexion();
            CapacitacionDao vDto = new CapacitacionDao(conn);
            List<ContadorCapacitacion> contadorCapacitacion = vDto.obtenerCantidadCapacitacionesRealizadas();

            if (contadorCapacitacion != null && contadorCapacitacion.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("cRealizadas", contadorCapacitacion);
            } else {
                List<ContadorVisita> contadorCapacitacion2 = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("cRealizadas", contadorCapacitacion2);
            }
        }
    }

    public static void setContadorCapacitacionesPendientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Conexion conn = new Conexion();
            CapacitacionDao vDto = new CapacitacionDao(conn);
            List<ContadorCapacitacion> contadorCapacitacion = vDto.obtenerCantidadCapacitacionesPendientes();

            if (contadorCapacitacion != null && contadorCapacitacion.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("cPendientes", contadorCapacitacion);
            } else {
                List<ContadorVisita> contadorCapacitacion2 = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("cPendientes", contadorCapacitacion2);
            }
        }
    }

    public static void setContadorCapacitacionesCanceladas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Conexion conn = new Conexion();
            CapacitacionDao vDto = new CapacitacionDao(conn);
            List<ContadorCapacitacion> contadorCapacitacion = vDto.obtenerCantidadCapacitacionesCanceladas();

            if (contadorCapacitacion != null && contadorCapacitacion.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("cCanceladas", contadorCapacitacion);
            } else {
                List<ContadorVisita> contadorCapacitacion2 = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("cCanceladas", contadorCapacitacion2);
            }
        }
    }

    public static void setContadorAsesoriasRealizadas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Conexion conn = new Conexion();
            AsesoriaDao vDto = new AsesoriaDao(conn);
            List<ContadorAsesoria> contadorAsesoria = vDto.obtenerCantidadAsesoriasRealizadas();

            if (contadorAsesoria != null && contadorAsesoria.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("aRealizadas", contadorAsesoria);
            } else {
                List<ContadorVisita> contadorAsesoria2 = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("aRealizadas", contadorAsesoria2);
            }
        }
    }

    public static void setContadorAsesoriasPendientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Conexion conn = new Conexion();
            AsesoriaDao vDto = new AsesoriaDao(conn);
            List<ContadorAsesoria> contadorAsesoria = vDto.obtenerCantidadAsesoriasPendientes();

            if (contadorAsesoria != null && contadorAsesoria.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("aPendientes", contadorAsesoria);
            } else {
                List<ContadorVisita> contadorAsesoria2 = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("aPendientes", contadorAsesoria2);
            }
        }
    }

    public static void setContadorAsesoriasCanceladas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Conexion conn = new Conexion();
            AsesoriaDao vDto = new AsesoriaDao(conn);
            List<ContadorAsesoria> contadorAsesoria = vDto.obtenerCantidadAsesoriasCanceladas();

            if (contadorAsesoria != null && contadorAsesoria.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("aCanceladas", contadorAsesoria);
            } else {
                List<ContadorVisita> contadorAsesoria2 = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("aCanceladas", contadorAsesoria2);
            }
        }
    }
    
   
    public static void setGraficosAccidentes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Conexion conn = new Conexion();
            AccidenteDao vDto = new AccidenteDao(conn);
            List<ContadorTotalAccidente> contadorTotalAccidente = vDto.obtenerGraficoAccidente();

            if (contadorTotalAccidente != null && contadorTotalAccidente.size() > 0) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("graficos", contadorTotalAccidente);
            } else {
                List<ContadorVisita> contadorTotalAccidente2 = new LinkedList<>();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("graficos", contadorTotalAccidente2);
            }
        }
    }
    
}
