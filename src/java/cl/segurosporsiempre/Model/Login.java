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
public class Login {
    
    private Long idLogin;
    private String correo;
    private String pass;
    private Perfil perfil;
    private Representante respresentante;
    private Integer intentos;
    private Boolean nuevo;
    private Cliente cliente;
    private Boolean activado;

    public Login() {
    }

    public Login(Long idLogin) {
        this.idLogin = idLogin;
    }

    public Long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Long idLogin) {
        this.idLogin = idLogin;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Representante getRespresentante() {
        return respresentante;
    }

    public void setRespresentante(Representante respresentante) {
        this.respresentante = respresentante;
    }

    public Integer getIntentos() {
        return intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

    public Boolean getNuevo() {
        return nuevo;
    }

    public void setNuevo(Boolean nuevo) {
        this.nuevo = nuevo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getActivado() {
        return activado;
    }

    public void setActivado(Boolean activado) {
        this.activado = activado;
    }

    @Override
    public String toString() {
        return "Login{" + "idLogin=" + idLogin + ", correo=" + correo + ", pass=" + pass + ", perfil=" + perfil + ", respresentante=" + respresentante + ", intentos=" + intentos + ", nuevo=" + nuevo + ", cliente=" + cliente + ", activado=" + activado + '}';
    }
    
    
}