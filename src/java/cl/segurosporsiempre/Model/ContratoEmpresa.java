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
public class ContratoEmpresa extends Contrato {
    
    private Empresa empresa;

    public ContratoEmpresa() {
    }

    public ContratoEmpresa(Empresa empresa, Long id) {
        super(id);
        this.empresa = empresa;
    }

    public ContratoEmpresa(Empresa empresa, Long id, String fechaIngreso, String fechaTermino, String fechaContrato, Boolean estado) {
        super(id, fechaIngreso, fechaTermino, fechaContrato, estado);
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return super.toString() + "ContratoEmpresa{" + "empresa=" + empresa + '}';
    }
}