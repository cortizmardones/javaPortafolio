package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Data.EmpresaDAO;
import cl.segurosporsiempre.Model.ContratoEmpresa;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Rubro;
import cl.segurosporsiempre.Model.Utils;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215)
public class EmpresaController extends HttpServlet {

    private static final String UPLOAD_DIR = "fotosEmpr";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {

            case "activar":
                this.activarEmpresa(request, response);
                break;
            case "desactivar":
                this.desactivarEmpresa(request, response);
                break;
            case "gModificar":
                this.gatillarModificacion(request, response);
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
            case "agregarEmpresa":
                this.agregarEmpresa(request, response);
                break;
            case "modificarEmpresa":
                this.modificarEmpresa(request, response);
                break;
            default:
                throw new AssertionError();
        }

    }

    private void agregarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String rut = request.getParameter("rut");
        String razon_social = request.getParameter("razonSocial");
        String logo = this.subirFoto(request.getPart("logo"), request, response);
        String email = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        Integer fono = Integer.parseInt(request.getParameter("fono"));
        Integer num_trabajadores = Integer.parseInt(request.getParameter("cantidad"));

        //String rubro = request.getParameter("rubro");
        Rubro r = new Rubro();
        r.setId(1);

        String fecha_Contrato = Utils.FECHATRANSFORMADA(request.getParameter("fecha_Contrato"));

        ContratoEmpresa c = new ContratoEmpresa();
        c.setFechaContrato(fecha_Contrato);

        Empresa emp = new Empresa();
        emp.setRut(rut);
        emp.setRazonSocial(razon_social);
        emp.setLogo(logo);
        emp.setEmail(email);
        emp.setDireccion(direccion);
        emp.setFono(fono);
        emp.setNumeroTrabajadores(num_trabajadores);
        emp.setContrato(c);
        emp.setRubro(r);

        Conexion conn = new Conexion();
        EmpresaDAO eDto = new EmpresaDAO(conn);

        boolean resultado = eDto.agregarEmpresa(emp);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "agregarEmpresaExito");
            Common.setEmpresasSession2(request, response);
            request.getRequestDispatcher("adminClientes.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "agregarEmpresaFracaso");
            Common.setEmpresasSession2(request, response);
            request.getRequestDispatcher("adminClientes.jsp").forward(request, response);
        }
    }

    private String subirFoto(Part archivo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String applicationPath = request.getServletContext().getRealPath("");

        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

        System.out.println("part.getContentType : " + archivo.getContentType());
        System.out.println("part.getSize : " + archivo.getSize());
        System.out.println("part.getName : " + archivo.getName());
        System.out.println("part.getSubmittedFileName : " + archivo.getSubmittedFileName());

        String nombre = archivo.getSubmittedFileName();

        archivo.write(uploadFilePath + File.separator + nombre);

        return "https://www.segurosporsiempre.cl/Portafolio_de_Titulo_C4/fotosEmpr/" + nombre;
    }

    private void activarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Conexion conn = new Conexion();
        EmpresaDAO eDto = new EmpresaDAO(conn);

        boolean resultado = eDto.activarEmpresa(id);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "activarEmpresaExito");
            Common.setEmpresasSession2(request, response);
            request.getRequestDispatcher("adminClientes.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "activarEmpresaFracaso");
            Common.setEmpresasSession2(request, response);
            request.getRequestDispatcher("adminClientes.jsp").forward(request, response);
        }
    }

    private void desactivarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Conexion conn = new Conexion();
        EmpresaDAO eDto = new EmpresaDAO(conn);

        boolean resultado = eDto.desactivarEmpresa(id);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "desactivarEmpresaExito");
            Common.setEmpresasSession2(request, response);
            request.getRequestDispatcher("adminClientes.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "desactivarEmpresaFracaso");
            Common.setEmpresasSession2(request, response);
            request.getRequestDispatcher("adminClientes.jsp").forward(request, response);
        }
    }

    private void gatillarModificacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Conexion conn = new Conexion();
        EmpresaDAO eDto = new EmpresaDAO(conn);

        Empresa e = eDto.obtenerEmpresaPorId(id);

        conn.cerrarConexion();

        if (e != null) {
            request.setAttribute("proActivo", e);
            request.getRequestDispatcher("adminClientesMod.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "ModFracaso");
            Common.setEmpresasSession2(request, response);
            request.getRequestDispatcher("adminClientesMod.jsp").forward(request, response);
        }
    }

    private void modificarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String rut = request.getParameter("rut");
        String razon = request.getParameter("razon");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        Integer fono = Integer.parseInt(request.getParameter("fono"));
        Integer numTraba = Integer.parseInt(request.getParameter("numTraba"));

        Empresa emp = new Empresa();
        emp.setId(id);
        emp.setRut(rut);
        emp.setRazonSocial(razon);
        emp.setEmail(correo);
        emp.setDireccion(direccion);
        emp.setFono(fono);
        emp.setNumeroTrabajadores(numTraba);

        Conexion conn = new Conexion();
        EmpresaDAO eDto = new EmpresaDAO(conn);

        boolean resultado = eDto.modificarEmpresa(emp);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "modificarEmpresaExito");
            Common.setEmpresasSession2(request, response);
            request.getRequestDispatcher("adminClientes.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "modificarEmpresaFracaso");
            Common.setEmpresasSession2(request, response);
            request.getRequestDispatcher("adminClientes.jsp").forward(request, response);
        }
    }
}
