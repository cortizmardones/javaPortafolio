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
public class UsuarioProfesional extends Usuario {
    
    private Profesional profesional;

    public UsuarioProfesional() {
    }

    public UsuarioProfesional(Long id) {
        super(id);
    }

    public UsuarioProfesional(Profesional profesional, Long id, Perfil perfil, Empresa empresa, String correo, String password, Boolean estado, Boolean primeraVez) {
        super(id, perfil, empresa, correo, password, estado, primeraVez);
        this.profesional = profesional;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    @Override
    public String toString() {
        return super.toString() + "UsuarioProfesional{" + "profesional=" + profesional + '}';
    }  
}