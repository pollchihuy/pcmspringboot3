package com.juarcoding.pcmspringboot3.repo;

import com.juarcoding.pcmspringboot3.model.GroupMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GroupMenuRepo extends JpaRepository<GroupMenu, Long> {

    /** SELECT * FROM MstGroupMenu WHERE toLower('variable_') LIKE toLower('%?%') */
    public Page<GroupMenu> findByNamaContainsIgnoreCase(String nama, Pageable pageable);
    public Page<GroupMenu> findByDeskripsiContainsIgnoreCase(String nama, Pageable pageable);

    public List<GroupMenu> findByNamaContainsIgnoreCase(String nama);
    public List<GroupMenu> findByDeskripsiContainsIgnoreCase(String nama);
}