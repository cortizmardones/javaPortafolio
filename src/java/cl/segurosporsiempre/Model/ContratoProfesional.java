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
public class ContratoProfesional extends Contrato {
    
    private Profesional profesional;

    public ContratoProfesional() {
    }

    public ContratoProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public ContratoProfesional(Profesional profesional, Long id, String fechaIngreso, String fechaTermino, String fechaContrato, Boolean estado) {
        super(id, fechaIngreso, fechaTermino, fechaContrato, estado);
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
        return super.toString() + "ContratoProfesional{" + "profesional=" + profesional + '}';
    }
}