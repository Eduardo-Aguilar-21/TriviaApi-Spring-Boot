package com.trivia.triviaApi.Services;

import com.trivia.triviaApi.Models.DificultadModel;
import com.trivia.triviaApi.Repositories.DificultadRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DificultadService {
    @Autowired
    DificultadRepository dificultadRepository;
    
    public List<DificultadModel> ListarDificultad(){
        return dificultadRepository.findAll();
    }
    
    public Optional<DificultadModel> ListatDificultadId(Long id){
        return dificultadRepository.findById(id);
    }
}
