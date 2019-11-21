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
public class Pregunta {
    
    private Long id;
    private Tema tema;
    private Prueba prueba;
    private String descripcion;
    private String respuestaCorrecta;
    private Integer puntos;

    public Pregunta() {
    }

    public Pregunta(Long id) {
        this.id = id;
    }

    public Pregunta(Long id, Tema tema, Prueba prueba, String descripcion, String respuestaCorrecta, Integer puntos) {
        this.id = id;
        this.tema = tema;
        this.prueba = prueba;
        this.descripcion = descripcion;
        this.respuestaCorrecta = respuestaCorrecta;
        this.puntos = puntos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Prueba getPrueba() {
        return prueba;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "id=" + id + ", tema=" + tema + ", prueba=" + prueba + ", descripcion=" + descripcion + ", respuestaCorrecta=" + respuestaCorrecta + ", puntos=" + puntos + '}';
    }
    
}