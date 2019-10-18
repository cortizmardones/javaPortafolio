/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Model;

import java.util.List;

/**
 *
 * @author raulp
 */
public class Empresa {
    
    private Long id;
    private Rubro rubro;
    private ContratoEmpresa contrato;
    private List<Usuario> usuarios;
    private String razonSocial;
    private String rut;
    private String logo;
    private String email;
    private String direccion;
    private Integer fono;
    private Integer numeroTrabajadores;
    private Boolean estado;


    public Empresa() {
    }

    public Empresa(Long id) {
        this.id = id;
    }

    public Empresa(Long id, Rubro rubro, ContratoEmpresa contrato, List<Usuario> usuarios, String razonSocial, String rut, String logo, String email, String direccion, Integer fono, Integer numeroTrabajadores, Boolean estado) {
        this.id = id;
        this.rubro = rubro;
        this.contrato = contrato;
        this.usuarios = usuarios;
        this.razonSocial = razonSocial;
        this.rut = rut;
        this.logo = logo;
        this.email = email;
        this.direccion = direccion;
        this.fono = fono;
        this.numeroTrabajadores = numeroTrabajadores;
        this.estado = estado;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getFono() {
        return fono;
    }

    public void setFono(Integer fono) {
        this.fono = fono;
    }

    public Integer getNumeroTrabajadores() {
        return numeroTrabajadores;
    }

    public void setNumeroTrabajadores(Integer numeroTrabajadores) {
        this.numeroTrabajadores = numeroTrabajadores;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public ContratoEmpresa getContrato() {
        return contrato;
    }

    public void setContrato(ContratoEmpresa contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", rubro=" + rubro + ", contrato=" + contrato + ", usuarios=" + usuarios + ", razonSocial=" + razonSocial + ", rut=" + rut + ", logo=" + logo + ", email=" + email + ", direccion=" + direccion + ", fono=" + fono + ", numeroTrabajadores=" + numeroTrabajadores + ", estado=" + estado + '}';
    }
}