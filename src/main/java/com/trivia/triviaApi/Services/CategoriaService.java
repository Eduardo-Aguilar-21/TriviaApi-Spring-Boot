package com.trivia.triviaApi.Services;

import com.trivia.triviaApi.Models.CategoriaModel;
import com.trivia.triviaApi.Repositories.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;
    
    public List<CategoriaModel> ListarCategorias(){
        return categoriaRepository.findAll();
    }
    
    public Optional<CategoriaModel> ListarCategoriasId(Long id){
        return categoriaRepository.findById(id);
    }
}
