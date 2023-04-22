    package com.trivia.triviaApi.Repositories;

import com.trivia.triviaApi.Models.PreguntaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<PreguntaModel, Long> {
    @Query("SELECT p,c ,d \n" +
            "FROM PreguntaModel p INNER JOIN CategoriaModel c\n" +
            "ON p.categoriaModel.id_cat = c.id_cat INNER JOIN DificultadModel d \n" +
            "ON p.dificultadModel.id_dif = d.id_dif WHERE c.id_cat = 1 AND d.id_dif = 1")
    List<Object[]> BuscarDifyCat();
    
    @Query("SELECT p,c ,d \n" +
            "FROM PreguntaModel p INNER JOIN CategoriaModel c\n" +
            "ON p.categoriaModel.id_cat = c.id_cat INNER JOIN DificultadModel d \n" +
            "ON p.dificultadModel.id_dif = d.id_dif WHERE c.id_cat =:id_cate  AND d.id_dif =:id_dife ")
    List<Object[]> BuscarEsp(int id_cate, int id_dife);
}
