package com.juarcoding.pcmspringboot3.repo;


import com.juarcoding.pcmspringboot3.model.GroupMenu;
import com.juarcoding.pcmspringboot3.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepo extends JpaRepository<Menu, Long> {

    public Page<Menu> findByNamaContainsIgnoreCase(String nama, Pageable pageable);
    public Page<Menu> findByPathContainsIgnoreCase(String nama, Pageable pageable);
    public Page<Menu> findByDeskripsiContainsIgnoreCase(String nama, Pageable pageable);

    public List<Menu> findByNamaContainsIgnoreCase(String nama);
    public List<Menu> findByPathContainsIgnoreCase(String nama);
    public List<Menu> findByDeskripsiContainsIgnoreCase(String nama);

    public Optional<Menu> findTop1ByOrderByIdDesc();
}
