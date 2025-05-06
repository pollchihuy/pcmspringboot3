package com.juarcoding.pcmspringboot3.repo;

import com.juarcoding.pcmspringboot3.model.CobaRest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CobaRestRepo extends JpaRepository<CobaRest, Integer> {
    //derived Query
    //JPQL
}