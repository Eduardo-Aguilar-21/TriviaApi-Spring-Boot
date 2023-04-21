package com.trivia.triviaApi.Repositories;

import com.trivia.triviaApi.Models.RespuestaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RespuestaRepository extends JpaRepository<RespuestaModel,Long> {
    
}
