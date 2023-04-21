package com.trivia.triviaApi.Services;

import com.trivia.triviaApi.Models.PreguntaModel;
import com.trivia.triviaApi.Repositories.PreguntaRepository;
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
}
