package com.trivia.triviaApi.Services;

import com.trivia.triviaApi.Models.CategoriaModel;
import com.trivia.triviaApi.Models.DificultadModel;
import com.trivia.triviaApi.Models.PreguntaModel;
import com.trivia.triviaApi.Repositories.PreguntaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreguntaService {
    @Autowired
    PreguntaRepository preguntaRepository;
    
    public List<PreguntaModel> ListarPregunta(){
        return preguntaRepository.findAll();
    }
    
    public Optional<PreguntaModel> ListarPreguntaId(Long id){
        return preguntaRepository.findById(id);
    }
    
    public List<PreguntaModel> getPre(){
        List<Object[]> resultados = preguntaRepository.BuscarDifyCat();
        List<PreguntaModel> preguntas = new ArrayList<>();

        for(Object[] resultado : resultados){
            PreguntaModel pregunta = (PreguntaModel) resultado[0];
            CategoriaModel categoria = (CategoriaModel) resultado[1];
            DificultadModel dificultad = (DificultadModel) resultado[2];
            pregunta.setCategoriaModel(categoria);
            pregunta.setDificultadModel(dificultad);
            preguntas.add(pregunta);
        }

        return preguntas;
    }
    
    public List<PreguntaModel> getEsp(int cat, int dif){
        List<Object[]> resultados = preguntaRepository.BuscarEsp(cat, dif);
        List<PreguntaModel> preguntasesp = new ArrayList<>();
        
        for(Object[] resultado : resultados){
            PreguntaModel preguntam = (PreguntaModel) resultado[0];
            CategoriaModel categoriam = (CategoriaModel) resultado[1];
            DificultadModel dificultadm = (DificultadModel) resultado[2];
            preguntam.setCategoriaModel(categoriam);
            preguntam.setDificultadModel(dificultadm);
            preguntasesp.add(preguntam);
        }
        
        return preguntasesp;
    }
}
