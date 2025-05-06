package com.juarcoding.pcmspringboot3.repo;

import com.juarcoding.pcmspringboot3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
