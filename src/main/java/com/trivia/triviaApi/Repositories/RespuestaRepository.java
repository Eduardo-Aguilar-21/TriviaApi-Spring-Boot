package com.trivia.triviaApi.Repositories;

import com.trivia.triviaApi.Models.RespuestaModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RespuestaRepository extends JpaRepository<RespuestaModel,Long> {
    @Query("SELECT r,p,d,c \n" +
            "FROM  RespuestaModel r \n" +
            "INNER JOIN PreguntaModel p \n" +
            "ON r.preguntaModel.id_pre = p.id_pre\n" +
            "INNER JOIN DificultadModel d \n" +
            "ON p.dificultadModel.id_dif = d.id_dif\n" +
            "INNER Join CategoriaModel c \n" +
            "ON p.categoriaModel.id_cat = c.id_cat\n" +
            "WHERE p.id_pre = 1")
    List<Object[]> BuscarRespEsp();
}
