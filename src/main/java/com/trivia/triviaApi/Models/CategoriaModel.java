package com.trivia.triviaApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categoria")
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Long id_cat;
    private String nombre_cat;
    @OneToMany(mappedBy = "categoriaModel")
    @JsonIgnore
    private List<PreguntaModel> preguntas;

    public CategoriaModel() {
    }

    public CategoriaModel(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }

    public Long getId_cat() {
        return id_cat;
    }

    public void setId_cat(Long id_cat) {
        this.id_cat = id_cat;
    }

    public String getNombre_cat() {
        return nombre_cat;
    }

    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }

    public List<PreguntaModel> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaModel> preguntas) {
        this.preguntas = preguntas;
    }
    
}
