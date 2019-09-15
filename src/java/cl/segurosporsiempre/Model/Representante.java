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
public class Representante {
    
    private Long idRepresentante;
    private Login login;
    private String nombre;
    private String rut;

    public Representante() {
    }

    public Representante(Long idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    public Long getIdRepresentante() {
        return idRepresentante;
    }

    public void setIdRepresentante(Long idRepresentante) {
        this.idRepresentante = idRepresentante;
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

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}