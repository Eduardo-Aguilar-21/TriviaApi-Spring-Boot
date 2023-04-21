package com.trivia.triviaApi.Controllers;

import com.trivia.triviaApi.Models.DificultadModel;
import com.trivia.triviaApi.Services.DificultadService;
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
@RequestMapping("trivia/dificultad")
public class DificultadController {
    @Autowired
    DificultadService dificultadService;
    
    @GetMapping
    public List<DificultadModel> ListarD(){
        return dificultadService.ListarDificultad();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DificultadModel> ListarDId(@PathVariable Long id){
        Optional<DificultadModel> dificultad = dificultadService.ListatDificultadId(id);
        if(dificultad.isPresent()){
            return new ResponseEntity<>(dificultad.get(), HttpStatus.OK);
        } 
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
