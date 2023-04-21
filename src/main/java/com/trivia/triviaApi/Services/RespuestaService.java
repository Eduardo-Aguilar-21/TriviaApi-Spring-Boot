package com.trivia.triviaApi.Services;

import com.trivia.triviaApi.Models.RespuestaModel;
import com.trivia.triviaApi.Repositories.RespuestaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {
    @Autowired
    RespuestaRepository respuestaRepository;
    
    public List<RespuestaModel> ListarRespuestas(){
        return respuestaRepository.findAll();
    }
    
    public Optional<RespuestaModel> ListarRespuestasId(Long id){
        return respuestaRepository.findById(id);
    }
}
