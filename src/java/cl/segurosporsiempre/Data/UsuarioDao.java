/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Data;
import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.Empresa;
import cl.segurosporsiempre.Model.Perfil;
import cl.segurosporsiempre.Model.Rubro;
import cl.segurosporsiempre.Model.Usuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.internal.OracleTypes;


/**
 *
 * @author Tonino
 */
public class UsuarioDao {
    
     private Conexion conn;

    public UsuarioDao(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean agregarCredencial(Usuario u){
       
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_AGREGAR_USUARIO(?,?,?,?)}");
            cst.setString(1, u.getCorreo());
            cst.setString(2, u.getPassword());
            //Perfil
            cst.setInt(3, u.getPerfil().getId());
            //Empresa
            cst.setLong(4, u.getEmpresa().getId());
            //EJECUTAR
            cst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public List<Empresa> obtenerEmpresas()
    {
        Empresa p;
        Rubro r;
        //CREAR LISTA ENLAZADA
        List<Empresa> list = new LinkedList<>();
         try {
             CallableStatement cst = conn.getConnection().prepareCall(" { call SP_OBTENER_EMPRESAS(?) }");
             //REGISTRAR PARÁMETROS DE SALIDA
             cst.registerOutParameter(1, OracleTypes.CURSOR);
             cst.execute();
             
             //crear RESULTSET
             ResultSet rs = (ResultSet)cst.getObject(1);
             
             while(rs.next())
             {
                 
                 r = new Rubro();
                 r.setId(rs.getInt("ID_RUBRO"));
                 r.setNombre(rs.getString("NOMBRE"));
                 r.setDescripcion(rs.getString("DESCRIPCION"));
                 r.setEstado(rs.getBoolean("ESTADO_RUBRO"));
                 //r.setEstado(rs.getBoolean("ESTADO"));
                 
                 p = new Empresa();
                 p.setId(rs.getLong("ID_EMPRESA"));
                 p.setRut(rs.getString("RUT_EMPRESA"));
                 p.setRazonSocial(rs.getString("RAZON_SOCIAL"));
                 p.setLogo(rs.getString("LOGO"));
                 p.setEmail(rs.getString("CORREO_ELECTRONICO"));
                 p.setDireccion(rs.getString("DIRECCION"));
                 p.setFono(rs.getInt("FONO"));
                 p.setNumeroTrabajadores(rs.getInt("NUMERO_TRABAJADORES"));
                 p.setEstado(rs.getBoolean("ESTADO"));
                 p.setRubro(r);
                 
                 list.add(p);
             }
             
             return list;
             
         } catch (SQLException ex) {
             Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         } catch (Exception ex) {
             Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
        
        
    }
    
    //para listar todos los usuario 
    public List<Usuario> obtenerPersonas() {
        Usuario lsp;
        Perfil prf;
        Empresa emp;
        List<Usuario> personas = new LinkedList<>();

        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_LISTAR_USUARIO(?) }");
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();

            ResultSet rs = (ResultSet)cst.getObject(1);

            while (rs.next()) {
                
                prf = new Perfil();
                prf.setNombre(rs.getString("tipo_usuario"));
                
                emp = new Empresa();
                emp.setRazonSocial(rs.getString("nombre_empresa"));
                
                lsp = new Usuario();
                lsp.setId(rs.getLong("id_usuario"));
                lsp.setCorreo(rs.getString("correo_electronico"));
                lsp.setEstado(rs.getBoolean("estado_usuario"));
                lsp.setPerfil(prf);
                lsp.setEmpresa(emp);
                
                //lsp.setEstado(rs.getBoolean("estado"));
                               
                personas.add(lsp);
            }

            return personas;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Usuario> obtenerUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Desactivar usuario
    public boolean desactivarUsuario(Long id) {
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_DESACTIVAR_USUARIO(?) }");
            cst.setLong(1, id);
            cst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //Activar Usuario
    public boolean activarUsuario(Long id) {
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_ACTIVAR_USUARIO(?)}");
            cst.setLong(1, id);
            cst.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    
    //Modificar Usuario
    public Boolean modificarUsuario(Usuario u) {
        /**
         * Modifica un usuario
         *
         * @return Retorna un valor booleano si resulta exitoso o no el proceso.
         */

        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_ACTUALIZAR_USUARIO(?,?,?,?) }");
            
            cst.setLong(1, u.getId());
            cst.setString(2, u.getCorreo());            
            cst.setLong(3, u.getPerfil().getId());
            cst.setLong(4, u.getEmpresa().getId());
            
            cst.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    
    //Buscar Usuario por ID (para modificarlo)
    public Usuario buscarUsuarioxId(Long id)
    {
        Usuario usuario;
        Empresa empresa;
        Perfil perfil;
        

        try {
            CallableStatement cst = conn.getConnection().prepareCall("{ call SP_BUSCAR_USUARIO(?,?) }");
            cst.setLong(1, id);
            cst.registerOutParameter(2, OracleTypes.CURSOR);

            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(2);
            rs.next();
            
            usuario = new Usuario();
            usuario.setId(rs.getLong("id_usuario"));
            usuario.setPassword(rs.getString("clave"));
            usuario.setCorreo(rs.getString("correo_electronico"));
            perfil = new Perfil();
            perfil.setId(rs.getInt("id_perfil"));
            usuario.setPerfil(perfil);
            empresa = new Empresa();
            empresa.setId(rs.getLong("id_empresa"));
            usuario.setEmpresa(empresa);
            usuario.setEstado(rs.getBoolean("estado"));
            usuario.setPrimeraVez(rs.getBoolean("primera_vez"));
            
            return usuario;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    
    


//FIN DEL DAO    
}
