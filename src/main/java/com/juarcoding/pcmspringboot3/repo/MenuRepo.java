package com.juarcoding.pcmspringboot3.repo;


import com.juarcoding.pcmspringboot3.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepo extends JpaRepository<Menu, Long> {
}
