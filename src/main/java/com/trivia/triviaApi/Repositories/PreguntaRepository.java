package com.trivia.triviaApi.Repositories;

import com.trivia.triviaApi.Models.PreguntaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<PreguntaModel, Long> {
    @Query("SELECT pregunta_n, nombre_cat, nom_dif\n" +
            "FROM PreguntaModel p INNER JOIN CategoriaModel c\n" +
            "ON p.categoria_id = c.id_cat INNER JOIN DificultadModel d \n" +
            "ON p.dificultad_id = d.id_dif WHERE c.id_cat = 1 AND d.id_dif = 1")
    List<PreguntaModel> BuscarDifyCat();
}
