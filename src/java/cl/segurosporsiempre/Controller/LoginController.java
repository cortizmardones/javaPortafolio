/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Controller;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Data.LoginDao;
import cl.segurosporsiempre.Model.Usuario;
import cl.segurosporsiempre.Model.UsuarioProfesional;
import cl.segurosporsiempre.Model.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raulp
 */
public class LoginController extends HttpServlet {


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
        
        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "recuperarPass":
                this.recuperarPass(request, response);
                break;
            default:
                throw new AssertionError();
        }
        

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
            case "login":
                this.loguear(request, response);
                break;
            case "ingresarPrimeraVez":
                this.primerIngreso(request, response);
                break;           
            case "pasarSegundaEtapa":
                this.recuperarPassP1(request, response);
                break; 
            case "pasarEtapaMod":
                this.recuperarPassP2(request, response);
                break;                               
            default:
                throw new AssertionError();
        }
    }

    private void loguear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String login = request.getParameter("correo");
        String password = Utils.MD5(request.getParameter("contrasenia"));
        String categoria = request.getParameter("categoria");
              
        Conexion conn = new Conexion();
        LoginDao lDto = new LoginDao(conn);
        
        Usuario usu;
        
        if (categoria.equals("profesional"))
        {          
            usu = lDto.obtenerUsuarioProfesional(login); 
        }
        else
        {
            usu = lDto.obtenerUsuario(login);
        }
        
        conn.cerrarConexion();
        
        if (usu != null)
        {
            if (login.equals(usu.getCorreo()) && password.equals(usu.getPassword()) && usu.getEstado())
            {
                if (usu.getPrimeraVez())
                {
                    request.setAttribute("modal", "cambiarPass");
                    request.setAttribute("idTemporal", usu.getId());
                    request.setAttribute("loginTemporal", usu.getCorreo()); 
                    request.setAttribute("categoria", categoria);                     
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                else
                {
                    this.redirigirSegunPerfil(usu, request, response);
                }
            }
            else
            {
                if (!usu.getEstado())
                {
                    request.setAttribute("mensaje", "El usuario se encuentra desactivado, contacte con un administrador");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("mensaje", "Credenciales incorrectas");
                    request.getRequestDispatcher("index.jsp").forward(request, response);                    
                }
            }
        }
        else
        {
            request.setAttribute("mensaje", "Credenciales incorrectas");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
    }

    private void primerIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String password = Utils.MD5(request.getParameter("password"));
        Long id = Long.parseLong(request.getParameter("id"));
        String login = request.getParameter("loginTemporal");
        String categoria = request.getParameter("categoria");
        
        Conexion conn = new Conexion();
        LoginDao lDto = new LoginDao(conn);
        
        boolean resultado;
        
        if (categoria.equals("profesional"))
        {
            UsuarioProfesional usu = new UsuarioProfesional();
            usu.setId(id);
            usu.setPassword(password);
            
            resultado = lDto.modificarPassLogin(usu);
        }
        else
        {
            Usuario usu = new Usuario();
            usu.setId(id);
            usu.setPassword(password);
            
            resultado = lDto.modificarPassLogin(usu);            
        }      
        
        conn.cerrarConexion();
        
        if (resultado)
        {
           request.setAttribute("mensaje", "Contraseña cambiada exitosamente. Puede iniciar nuevamente");
           request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else
        {
            conn.cerrarConexion();
            request.setAttribute("mensaje", "No se pudo cambiar su contraseña, contáctese con un administrador");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    
    private void redirigirSegunPerfil(Usuario usu, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException         
    {
        
        if (usu.getPerfil().getId() == 1)
        {
            Common.setUsuarioActivoSession(usu, request, response);
            request.getRequestDispatcher("pAdmin.jsp").forward(request, response);
        }
        if (usu.getPerfil().getId() == 2)
        {
            Common.setUsuarioActivoSession(usu, request, response);
            request.getRequestDispatcher("pProfesional.jsp").forward(request, response);            
        }        
        if (usu.getPerfil().getId() == 3)
        {
            Common.setUsuarioActivoSession(usu, request, response); 
            request.getRequestDispatcher("pCliente.jsp").forward(request, response);            
        }        
    }

    private void recuperarPass(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
        
        request.setAttribute("modal", "pasoUno");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    private void recuperarPassP1(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
        
        String correo = request.getParameter("correo");
        String codigo = Utils.rGen();
        
        Conexion conn = new Conexion();
        LoginDao lDto = new LoginDao(conn);
        
        boolean resultado = lDto.registrarCodigo(correo, codigo);
        
        conn.cerrarConexion();
        
        if (resultado)
        {
            String mensaje = "El código para reestablecer su contraseña es: " + codigo;
            Utils.enviarCorreo("info.segurita@gmail.com", "bahamut77", correo, mensaje, "Recuperación de contraseña");
            request.setAttribute("modal", "pasoDos");
            request.setAttribute("activeCorreo", correo);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("mensaje", "El correo señalado no existe en el sistema");
            request.getRequestDispatcher("index.jsp").forward(request, response);        
        }
    }   
    
    private void recuperarPassP2(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
        
        //TODO: Revisar codigo, que coincida y que además de eso sea el último, si coincide, llevar a modificar, si no coincide llevar a index con mensaje
        
    }      
}