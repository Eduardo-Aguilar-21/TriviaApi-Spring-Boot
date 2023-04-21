package com.trivia.triviaApi.Repositories;

import com.trivia.triviaApi.Models.DificultadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DificultadRepository extends JpaRepository<DificultadModel, Long> {
    
}
