package com.juarcoding.pcmspringboot3.repo;

import com.juarcoding.pcmspringboot3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    //Derivered Query
    // SELECT x.* FROM MstUser x WHERE x.Email = ?
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
