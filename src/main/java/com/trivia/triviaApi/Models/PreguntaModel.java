package com.trivia.triviaApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pregunta")
public class PreguntaModel {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_pre;
    private String pregunta_n;
    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id_cat", nullable = false )
    private CategoriaModel categoriaModel;
    
    @ManyToOne
    @JoinColumn(name="dificultad_id", referencedColumnName = "id_dif", nullable = false)
    private DificultadModel dificultadModel;
    
    @JsonIgnore
    @OneToMany(mappedBy = "preguntaModel")
    private List<RespuestaModel> respuestas;

    public PreguntaModel() {
    }

    public PreguntaModel(String pregunta_n, CategoriaModel categoriaModel, DificultadModel dificultadModel) {
        this.pregunta_n = pregunta_n;
        this.categoriaModel = categoriaModel;
        this.dificultadModel = dificultadModel;
    }

    public Long getId_pre() {
        return id_pre;
    }

    public void setId_pre(Long id_pre) {
        this.id_pre = id_pre;
    }

    public String getPregunta_n() {
        return pregunta_n;
    }

    public void setPregunta_n(String pregunta_n) {
        this.pregunta_n = pregunta_n;
    }

    public CategoriaModel getCategoriaModel() {
        return categoriaModel;
    }

    public void setCategoriaModel(CategoriaModel categoriaModel) {
        this.categoriaModel = categoriaModel;
    }

    public DificultadModel getDificultadModel() {
        return dificultadModel;
    }

    public void setDificultadModel(DificultadModel dificultadModel) {
        this.dificultadModel = dificultadModel;
    }

    public List<RespuestaModel> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestaModel> respuestas) {
        this.respuestas = respuestas;
    }

    
    
}
