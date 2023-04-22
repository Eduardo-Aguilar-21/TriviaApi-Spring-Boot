package com.trivia.triviaApi.Controllers;

import com.trivia.triviaApi.Models.PreguntaModel;
import com.trivia.triviaApi.Repositories.PreguntaRepository;
import com.trivia.triviaApi.Services.PreguntaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("trivia/pregunta")
public class PreguntaController {
    @Autowired
    PreguntaService preguntaService;
    @Autowired
    PreguntaRepository preguntaRepository;
    
    @GetMapping
    private List<PreguntaModel> ListarP(){
        return preguntaService.ListarPregunta();
    }
    
    @GetMapping("/{id}")
    private ResponseEntity<PreguntaModel> ListarPId(@PathVariable Long id){
        Optional<PreguntaModel> pregunta = preguntaService.ListarPreguntaId(id);
        if(pregunta.isPresent()){
            return new ResponseEntity<>(pregunta.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/preguntas")
    public List<PreguntaModel> getPreguntas(){
        return preguntaRepository.BuscarDifyCat();
    }
}
