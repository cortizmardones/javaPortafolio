package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Data.VisitaDAO;
import cl.segurosporsiempre.Model.CheckList;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.GeneraQR;
import cl.segurosporsiempre.Model.Profesional;
import cl.segurosporsiempre.Model.Utils;
import cl.segurosporsiempre.Model.Visita;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

@MultipartConfig(maxFileSize = 16177215)
public class VisitaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {

            case "activar":
                this.activarVisita(request, response);
                break;
            case "desactivar":
                this.desactivarVisita(request, response);
                break;

            case "cancelar":
                this.cancelarVisitaCliente(request, response);
                break;
            case "gModificar":
                this.gatillarModificacion(request, response);
                break;
            case "generarQR": {
                try {
                    this.generarQR(request, response);
                } catch (WriterException ex) {
                    Logger.getLogger(VisitaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            default:
                throw new AssertionError();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {
            case "agregarVisita":
                this.agregarVisita(request, response);
                break;
            case "modificarVisita":
                this.modificarVisita(request, response);
                break;

            case "solicitarVisita":
                this.solicitarVisita(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void agregarVisita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long profesional = Long.parseLong(request.getParameter("profesional"));
        Long empresa = Long.parseLong(request.getParameter("empresa"));
        String fecha = Utils.FECHATRANSFORMADA(request.getParameter("fecha"));
        //String fecha = request.getParameter("fecha");

        //averiguar donde voy a guardar esto
        Long lista = Long.parseLong(request.getParameter("lista"));

        Profesional pro = new Profesional();
        pro.setId(profesional);

        Empresa emp = new Empresa();
        emp.setId(empresa);

        //averiguar donde voy a guardar esto (2)
        CheckList check = new CheckList();
        check.setId(lista);

        Visita visita = new Visita();
        visita.setProfesional(pro);
        visita.setEmpresa(emp);
        visita.setFecha(fecha);

        Conexion conn = new Conexion();
        VisitaDAO eDto = new VisitaDAO(conn);

        boolean resultado = eDto.agregarVisita(visita);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "agregarVisitaExito");
            Common.setVisitasSession(request, response);
            request.getRequestDispatcher("proVisitas.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "agregarVisitaFracaso");
            Common.setVisitasSession(request, response);
            request.getRequestDispatcher("proVisitas.jsp").forward(request, response);
        }
    }

    //SOLICITAR POR CLIENTE
    private void solicitarVisita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long profesional = Long.parseLong(request.getParameter("profesional"));
        //Long profesional = Long.parseLong("1");
        Long empresa = Long.parseLong(request.getParameter("empresa"));
        String fecha = Utils.FECHATRANSFORMADA(request.getParameter("fecha"));
        //String fecha = request.getParameter("fecha");

        //averiguar donde voy a guardar esto
        //Long lista = Long.parseLong(request.getParameter("lista"));
        Profesional pro = new Profesional();
        pro.setId(profesional);

        Empresa emp = new Empresa();
        emp.setId(empresa);

        //averiguar donde voy a guardar esto (2)
        //CheckList check = new CheckList();
        //check.setId(lista);
        Visita visita = new Visita();
        visita.setProfesional(pro);
        visita.setEmpresa(emp);
        visita.setFecha(fecha);

        Conexion conn = new Conexion();
        VisitaDAO eDto = new VisitaDAO(conn);

        boolean resultado = eDto.agregarVisita(visita);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "solicitarVisitaPos");
            Common.setVisitasSession(request, response);
            request.getRequestDispatcher("cliSolicitudes.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "solicitarVisitaExitoNeg");
            Common.setVisitasSession(request, response);
            request.getRequestDispatcher("cliSolicitudes.jsp").forward(request, response);
        }
    }

    private void activarVisita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Conexion conn = new Conexion();
        VisitaDAO eDto = new VisitaDAO(conn);

        boolean resultado = eDto.activarVisita(id);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "activarVisitaExito");
            Common.setVisitasSession(request, response);
            request.getRequestDispatcher("proVisitas.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "activarVisitaFracaso");
            Common.setEmpresasSession(request, response);
            request.getRequestDispatcher("proVisitas.jsp").forward(request, response);
        }
    }

    //POR CLIENTE
    private void desactivarVisita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Conexion conn = new Conexion();
        VisitaDAO eDto = new VisitaDAO(conn);

        boolean resultado = eDto.desactivarVisita(id);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "desactivarVisitaExito");
            Common.setVisitasSession(request, response);
            request.getRequestDispatcher("proVisitas.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "desactivarVisitaFracaso");
            Common.setVisitasSession(request, response);
            request.getRequestDispatcher("proVisitas.jsp").forward(request, response);
        }
    }

    private void cancelarVisitaCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Conexion conn = new Conexion();
        VisitaDAO eDto = new VisitaDAO(conn);

        boolean resultado = eDto.desactivarVisita(id);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "cancelarVisitaPos");
            Common.setVisitasSession(request, response);
            request.getRequestDispatcher("cliSolicitudes.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "cancelarVisitaNeg");
            Common.setVisitasSession(request, response);
            request.getRequestDispatcher("cliSolicitudes.jsp").forward(request, response);
        }
    }

    private void gatillarModificacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Conexion conn = new Conexion();
        VisitaDAO eDto = new VisitaDAO(conn);

        Visita v = eDto.obtenerVisitaPorId(id);

        conn.cerrarConexion();

        if (v != null) {
            request.setAttribute("viActivo", v);
            Common.setVisitasSession(request, response);
            request.getRequestDispatcher("proVisitasMod.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "viFracaso");
            Common.setVisitasSession(request, response);
            request.getRequestDispatcher("proVisitasMod.jsp").forward(request, response);
        }
    }

    private void modificarVisita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String fecha = request.getParameter("fecha");

        String lista = request.getParameter("lista");

        Visita visita = new Visita();
        visita.setId(id);
        visita.setFecha(fecha);

        CheckList checklist = new CheckList();
        checklist.setDescripcion(lista);

        Conexion conn = new Conexion();
        VisitaDAO vDto = new VisitaDAO(conn);

        boolean resultado = vDto.modificarVisita(visita, checklist);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "modificarVisitaExito");
            Common.setVisitasSession(request, response);
            request.getRequestDispatcher("proVisitas.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "modificarVisitasFracaso");
            Common.setVisitasSession(request, response);
            request.getRequestDispatcher("proVisitas.jsp").forward(request, response);
        }
    }

    public void generarQR(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, WriterException {

        GeneraQR generaQR = new GeneraQR();

        String texto = request.getParameter("id");
        BufferedImage imagen = generaQR.crearQR(texto, 300, 300);

        response.setContentType("image/png");

        request.setAttribute("modal", "imagen");        
        request.setAttribute("imagen", ImageIO.write(imagen, "png", response.getOutputStream()));
        Common.setVisitasSession(request, response);
        //request.getRequestDispatcher("index.jsp").forward(request, response);
        request.getRequestDispatcher("cliSolicitudes.jsp").forward(request, response);

    }
    
    
    //

}
