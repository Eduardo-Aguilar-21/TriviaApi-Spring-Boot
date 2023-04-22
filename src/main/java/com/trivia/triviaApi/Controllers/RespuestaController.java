package com.trivia.triviaApi.Controllers;

import com.trivia.triviaApi.Models.RespuestaModel;
import com.trivia.triviaApi.Services.RespuestaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("trivia/respuestas")
public class RespuestaController {
    @Autowired
    RespuestaService respuestaService;
    
    @GetMapping
    public List<RespuestaModel> ListarR(){
        return respuestaService.ListarRespuestas();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RespuestaModel> ListarRId(@PathVariable Long id){
        Optional<RespuestaModel> respuesta = respuestaService.ListarRespuestasId(id);
        if(respuesta.isPresent()){
            return new ResponseEntity<>(respuesta.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   
    @GetMapping("/busp")
    @ResponseBody
    public List<RespuestaModel> Busp(){
        return respuestaService.BusqueEspPre();
    }
}
