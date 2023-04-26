package com.trivia.triviaApi.Services;

import com.trivia.triviaApi.Models.CategoriaModel;
import com.trivia.triviaApi.Models.DificultadModel;
import com.trivia.triviaApi.Models.PreguntaModel;
import com.trivia.triviaApi.Models.RespuestaModel;
import com.trivia.triviaApi.Repositories.RespuestaRepository;
import java.util.ArrayList;
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
    
    public List<RespuestaModel> BusqueEspPre(int id){
        List<Object[]> resultados = respuestaRepository.BuscarRespEsp(id);
        List<RespuestaModel> respuestap = new ArrayList<>();
        
        for(Object[] resultado : resultados){
            RespuestaModel respuestam = (RespuestaModel) resultado[0];
            PreguntaModel preguntam = (PreguntaModel) resultado[1];
            respuestam.setPreguntaModel(preguntam);
            respuestap.add(respuestam);
        }
        return respuestap;
    }
}
