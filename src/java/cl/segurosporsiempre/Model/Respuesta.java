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
public class Respuesta {
    
    private Long id;
    private Asistente asistente;
    private Pregunta pregunta;
    private String respuesta;
    private Boolean correcta;
    private Integer puntosObtenidos;
    private String fecha;

    public Respuesta() {
    }

    public Respuesta(Long id) {
        this.id = id;
    }

    public Respuesta(Long id, Asistente asistente, Pregunta pregunta, String respuesta, Boolean correcta, Integer puntosObtenidos, String fecha) {
        this.id = id;
        this.asistente = asistente;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.correcta = correcta;
        this.puntosObtenidos = puntosObtenidos;
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Asistente getAsistente() {
        return asistente;
    }

    public void setAsistente(Asistente asistente) {
        this.asistente = asistente;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Boolean correcta) {
        this.correcta = correcta;
    }

    public Integer getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setPuntosObtenidos(Integer puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }

    @Override
    public String toString() {
        return "Resultado{" + "id=" + id + ", asistente=" + asistente + ", pregunta=" + pregunta + ", respuesta=" + respuesta + ", correcta=" + correcta + ", puntosObtenidos=" + puntosObtenidos + ", fecha=" + fecha + '}';
    }
}