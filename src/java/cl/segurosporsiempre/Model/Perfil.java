/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Model;

/**
 *
 * @author PFT
 */
public class Perfil {
    
    private Long idPerfil;
    private Login login;
    private String nombre;
    private String descripcion;

    public Perfil() {
    }

    public Perfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Perfil(Long idPerfil, Login login, String nombre, String descripcion) {
        this.idPerfil = idPerfil;
        this.login = login;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }
    

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}