package com.trivia.triviaApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Respuesta")
public class RespuestaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id_res;
    private String respuesta_n;
    private boolean esValida;
    private Integer puntos;
    
    @ManyToOne
    @JoinColumn(name="pregunta_id", referencedColumnName = "id_pre", nullable = false)
    private PreguntaModel preguntaModel;

    public RespuestaModel() {
    }

    public RespuestaModel(String respuesta_n, boolean esValida, Integer puntos, PreguntaModel preguntaModel) {
        this.respuesta_n = respuesta_n;
        this.esValida = esValida;
        this.puntos = puntos;
        this.preguntaModel = preguntaModel;
    }

    public Long getId_res() {
        return id_res;
    }

    public void setId_res(Long id_res) {
        this.id_res = id_res;
    }

    public String getRespuesta_n() {
        return respuesta_n;
    }

    public void setRespuesta_n(String respuesta_n) {
        this.respuesta_n = respuesta_n;
    }

    public boolean isEsValida() {
        return esValida;
    }

    public void setEsValida(boolean esValida) {
        this.esValida = esValida;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public PreguntaModel getPreguntaModel() {
        return preguntaModel;
    }

    public void setPreguntaModel(PreguntaModel preguntaModel) {
        this.preguntaModel = preguntaModel;
    }
    
    

    
}
