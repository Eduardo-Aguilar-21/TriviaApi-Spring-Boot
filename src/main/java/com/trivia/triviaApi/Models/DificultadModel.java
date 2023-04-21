package com.trivia.triviaApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "Dificultad")
public class DificultadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Long id_dif;
    private String nom_dif;
    @JsonIgnore
    @OneToMany(mappedBy = "dificultadModel")
    private List<PreguntaModel> preguntas;

    public DificultadModel() {
    }

    public DificultadModel(String nom_dif) {
        this.nom_dif = nom_dif;
    }

    public Long getId_dif() {
        return id_dif;
    }

    public void setId_dif(Long id_dif) {
        this.id_dif = id_dif;
    }

    public String getNom_dif() {
        return nom_dif;
    }

    public void setNom_dif(String nom_dif) {
        this.nom_dif = nom_dif;
    }

    public List<PreguntaModel> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaModel> preguntas) {
        this.preguntas = preguntas;
    }
            
}
