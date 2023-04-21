package com.trivia.triviaApi.Controllers;

import com.trivia.triviaApi.Models.CategoriaModel;
import com.trivia.triviaApi.Services.CategoriaService;
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
@RequestMapping("trivia/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping
    public List<CategoriaModel> ListarC(){
        return categoriaService.ListarCategorias();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> ListarCId(@PathVariable Long id){
        Optional<CategoriaModel> categoria = categoriaService.ListarCategoriasId(id);
        if(categoria.isPresent()){
            return new ResponseEntity<>(categoria.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
