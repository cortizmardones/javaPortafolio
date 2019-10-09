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
public class Usuario {
    
    private Long id;
    private Perfil perfil;
    private Empresa empresa;
    private String correo;
    private String password;
    private Boolean estado;
    private Boolean primeraVez;

    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(Long id, Perfil perfil, Empresa empresa, String correo, String password, Boolean estado, Boolean primeraVez) {
        this.id = id;
        this.perfil = perfil;
        this.empresa = empresa;
        this.correo = correo;
        this.password = password;
        this.estado = estado;
        this.primeraVez = primeraVez;
    }

    public Boolean getPrimeraVez() {
        return primeraVez;
    }

    public void setPrimeraVez(Boolean primeraVez) {
        this.primeraVez = primeraVez;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", perfil=" + perfil + ", empresa=" + empresa + ", correo=" + correo + ", password=" + password + ", estado=" + estado + ", primeraVez=" + primeraVez + '}';
    }
}