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
import cl.segurosporsiempre.Model.UbicacionProfesional;
import cl.segurosporsiempre.Model.Usuario;
import cl.segurosporsiempre.Model.UsuarioProfesional;
import cl.segurosporsiempre.Model.Utils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        String accion = request.getParameter("accion");

        switch (accion) {

            case "activar":
                this.activarProfesional(request, response);
                break;
            case "desactivar":
                this.desactivarProfesional(request, response);
                break;
            case "gModificar":
                this.gatillarModificacion(request, response);
                break;
            case "gatillarModPass":
                this.modificarContrasenaProf(request, response);
                break;
            case "consultarUbicacion":
                this.traerUbicacion(request, response);
                break;
            default:
                throw new AssertionError();
        }
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
            case "modificarProfesional":
                this.modificarProfesional(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void agregarProfesional(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String rut = request.getParameter("rut");
        String avatar = this.subirFoto(request.getPart("foto"), request, response);
        String fechaContrato = Utils.FECHATRANSFORMADA(request.getParameter("fechaContrato"));
        String fechaNacimiento = Utils.FECHATRANSFORMADA(request.getParameter("fechaNacimiento"));
        String direccion = request.getParameter("direccion");
        int fono = Integer.parseInt(request.getParameter("fono"));
        String correo = request.getParameter("correo");
        String password = Utils.MD5(request.getParameter("password"));

        System.out.println(fechaContrato);
        System.out.println(fechaNacimiento);

        ContratoProfesional c = new ContratoProfesional();
        c.setFechaContrato(fechaContrato);

        UsuarioProfesional u = new UsuarioProfesional();
        u.setCorreo(correo);
        u.setPassword(password);

        Profesional pro = new Profesional();
        pro.setNombres(nombres);
        pro.setApellidos(apellidos);
        pro.setRut(rut);
        pro.setDireccion(direccion);
        pro.setFono(fono);
        pro.setFechaNacimiento(fechaNacimiento);
        pro.setAvatar(avatar);

        pro.setContrato(c);
        pro.setUsuario(u);

        Conexion conn = new Conexion();
        ProfesionalDao pDto = new ProfesionalDao(conn);

        boolean resultado = pDto.agregarProfesional(pro);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "agregarProfesionalExito");
            Common.setProfesionalesSession(request, response);
            request.getRequestDispatcher("adminProfesionales.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "agregarProfesionalFracaso");
            Common.setProfesionalesSession(request, response);
            request.getRequestDispatcher("adminProfesionales.jsp").forward(request, response);
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

        return "https://www.segurosporsiempre.cl/fotosPro/" + nombre;
    }

    private void activarProfesional(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Conexion conn = new Conexion();
        ProfesionalDao pDto = new ProfesionalDao(conn);

        boolean resultado = pDto.activarProfesional(id);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "activarProfesionalExito");
            Common.setProfesionalesSession(request, response);
            request.getRequestDispatcher("adminProfesionales.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "activarProfesionalFracaso");
            Common.setProfesionalesSession(request, response);
            request.getRequestDispatcher("adminProfesionales.jsp").forward(request, response);
        }
    }

    private void desactivarProfesional(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Conexion conn = new Conexion();
        ProfesionalDao pDto = new ProfesionalDao(conn);

        boolean resultado = pDto.desactivarProfesional(id);

        conn.cerrarConexion();

        if (resultado) {
            request.setAttribute("mensaje", "desactivarProfesionalExito");
            Common.setProfesionalesSession(request, response);
            request.getRequestDispatcher("adminProfesionales.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "desactivarProfesionalFracaso");
            Common.setProfesionalesSession(request, response);
            request.getRequestDispatcher("adminProfesionales.jsp").forward(request, response);
        }
    }

    private void gatillarModificacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Conexion conn = new Conexion();
        ProfesionalDao pDto = new ProfesionalDao(conn);

        Profesional p = pDto.obtenerProfesionalPorId(id);

        if (p != null) {
            request.setAttribute("proActivo", p);
            request.getRequestDispatcher("adminProfesionalesMod.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "gatillarModFracaso");
            Common.setProfesionalesSession(request, response);
            request.getRequestDispatcher("adminProfesionales.jsp").forward(request, response);
        }
    }

    private void modificarContrasenaProf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("modal", "cambiarPassProfesional");
        request.getRequestDispatcher("pProfesional.jsp").forward(request, response);

    }

    private void modificarProfesional(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tipoDeTransaccion = request.getParameter("status");

        switch (tipoDeTransaccion) {
            case "part":

                String direccion = request.getParameter("direccion");
                String correo = request.getParameter("correo");
                String nombres = request.getParameter("nombres");
                String apellidos = request.getParameter("apellidos");
                String foto = this.subirFoto(request.getPart("foto"), request, response);
                String fechaNacimiento = Utils.FECHATRANSFORMADA(request.getParameter("fechaNacimiento"));
                String fechaContratoS = Utils.FECHATRANSFORMADA(request.getParameter("fechaContrato"));
                int fono = Integer.parseInt(request.getParameter("fono"));
                String formularioFechaTermino = request.getParameter("fechaTermino");
                Long id = Long.parseLong(request.getParameter("id"));
                String fechaTermino;

                if (formularioFechaTermino.equals("INDEFINIDO")) {
                    fechaTermino = null;
                } else {
                    fechaTermino = Utils.FECHATRANSFORMADA(formularioFechaTermino);
                }

                Profesional p = new Profesional();
                ContratoProfesional c = new ContratoProfesional();
                UsuarioProfesional up = new UsuarioProfesional();

                c.setFechaTermino(fechaTermino);
                c.setFechaContrato(fechaContratoS);

                up.setCorreo(correo);

                p.setApellidos(apellidos);
                p.setAvatar(foto);
                p.setFechaNacimiento(fechaNacimiento);
                p.setFono(fono);
                p.setDireccion(direccion);
                p.setNombres(nombres);
                p.setContrato(c);
                p.setUsuario(up);
                p.setId(id);

                Conexion conn = new Conexion();
                ProfesionalDao pDto = new ProfesionalDao(conn);

                boolean resultado = pDto.modificarProfesional(p);

                conn.cerrarConexion();

                if (resultado) {
                    request.setAttribute("mensaje", "modificarProfesionalExito");
                    Common.setProfesionalesSession(request, response);
                    request.getRequestDispatcher("adminProfesionales.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensaje", "modificarProfesionalFracaso");
                    Common.setProfesionalesSession(request, response);
                    request.getRequestDispatcher("adminProfesionalesMod.jsp").forward(request, response);
                }

                break;
            case "non-part":

                String direccionDos = request.getParameter("direccion");
                String correoDos = request.getParameter("correo");
                String nombresDos = request.getParameter("nombres");
                String apellidosDos = request.getParameter("apellidos");
                String fotoDos = request.getParameter("urlFoto");
                String fechaNacimientoDos = Utils.FECHATRANSFORMADA(request.getParameter("fechaNacimiento"));
                String fechaContrato = Utils.FECHATRANSFORMADA(request.getParameter("fechaContrato"));
                int fonoDos = Integer.parseInt(request.getParameter("fono"));
                String formularioFechaTerminoDos = request.getParameter("fechaTermino");
                Long idDos = Long.parseLong(request.getParameter("id"));
                String fechaTerminoDos;

                if (formularioFechaTerminoDos.equals("INDEFINIDO")) {
                    fechaTerminoDos = null;
                } else {
                    fechaTerminoDos = Utils.FECHATRANSFORMADA(formularioFechaTerminoDos);
                }

                Profesional pDos = new Profesional();
                ContratoProfesional cDos = new ContratoProfesional();
                UsuarioProfesional upo = new UsuarioProfesional();

                cDos.setFechaTermino(fechaTerminoDos);
                cDos.setFechaContrato(fechaContrato);

                upo.setCorreo(correoDos);

                pDos.setApellidos(apellidosDos);
                pDos.setAvatar(fotoDos);
                pDos.setFechaNacimiento(fechaNacimientoDos);
                pDos.setFono(fonoDos);
                pDos.setDireccion(direccionDos);
                pDos.setNombres(nombresDos);
                pDos.setContrato(cDos);
                pDos.setUsuario(upo);
                pDos.setId(idDos);

                Conexion connDos = new Conexion();
                ProfesionalDao pDtoDos = new ProfesionalDao(connDos);

                boolean resultadoDos = pDtoDos.modificarProfesional(pDos);

                connDos.cerrarConexion();

                if (resultadoDos) {
                    request.setAttribute("mensaje", "modificarProfesionalExito");
                    Common.setProfesionalesSession(request, response);
                    request.getRequestDispatcher("adminProfesionales.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensaje", "modificarProfesionalFracaso");
                    Common.setProfesionalesSession(request, response);
                    request.getRequestDispatcher("adminProfesionalesMod.jsp").forward(request, response);
                }

                break;
            default:
                throw new AssertionError();
        }
    }

    private void traerUbicacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("idPro"));

        Conexion conn = new Conexion();
        ProfesionalDao pDto = new ProfesionalDao(conn);
        
        Profesional profesional = new Profesional();
        profesional.setId(id);
        
        List<UbicacionProfesional> resultado = pDto.obtenerUbicacion(profesional);

        conn.cerrarConexion();

        if (resultado != null && resultado.size()>0) {
            request.setAttribute("ubicacion", resultado);
            System.out.println("LLENA");
            request.getRequestDispatcher("ubicacionProfesional.jsp").forward(request, response);
        } else {
            request.setAttribute("ubicacion", resultado);
            System.out.println("VACÍA");
            request.getRequestDispatcher("ubicacionProfesional.jsp").forward(request, response);
        }

    }

}
