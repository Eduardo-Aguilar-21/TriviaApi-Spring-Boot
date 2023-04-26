package com.trivia.triviaApi.Repositories;

import com.trivia.triviaApi.Models.RespuestaModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RespuestaRepository extends JpaRepository<RespuestaModel,Long> {
    @Query("SELECT r,p \n" +
            "FROM  RespuestaModel r \n" +
            "INNER JOIN PreguntaModel p \n" +
            "ON r.preguntaModel.id_pre = p.id_pre\n" +
            "WHERE p.id_pre =:id_pre")
    List<Object[]> BuscarRespEsp(int id_pre);
}
