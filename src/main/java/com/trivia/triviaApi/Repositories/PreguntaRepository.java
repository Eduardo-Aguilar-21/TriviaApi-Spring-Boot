package com.trivia.triviaApi.Repositories;

import com.trivia.triviaApi.Models.PreguntaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepository extends JpaRepository<PreguntaModel, Long> {
    
}
