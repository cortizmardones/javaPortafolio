/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Model;

/**
 *
 * @author raulp
 */
public class Profesional {
    
    private Long id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Integer fono;
    private String rut;
    private String avatar;
    private ContratoProfesional contrato;
    private String fechaNacimiento;
    private String fechaIngreso;
    private String fechaTermino;
    private String fechaContrato;
    private Boolean estado;

    public Profesional() {
    }

    public Profesional(Long id) {
        this.id = id;
    }

    public Profesional(Long id, String nombres, String apellidos, String direccion, Integer fono, String rut, String avatar, ContratoProfesional contrato, String fechaNacimiento, String fechaIngreso, String fechaTermino, String fechaContrato, Boolean estado) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fono = fono;
        this.rut = rut;
        this.avatar = avatar;
        this.contrato = contrato;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.fechaTermino = fechaTermino;
        this.fechaContrato = fechaContrato;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ContratoProfesional getContrato() {
        return contrato;
    }

    public void setContrato(ContratoProfesional contrato) {
        this.contrato = contrato;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Profesional{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", fono=" + fono + ", rut=" + rut + ", avatar=" + avatar + ", contrato=" + contrato + ", fechaNacimiento=" + fechaNacimiento + ", fechaIngreso=" + fechaIngreso + ", fechaTermino=" + fechaTermino + ", fechaContrato=" + fechaContrato + ", estado=" + estado + '}';
    }
}