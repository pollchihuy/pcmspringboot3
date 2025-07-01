package com.juarcoding.pcmspringboot3.repo;

import com.juarcoding.pcmspringboot3.model.Akses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface AksesRepo extends JpaRepository<Akses, Long> {

    /** SELECT * FROM MstAkses Where toLower(Nama) LIKE '%toLower(?)%'*/
    public Page<Akses> findByNamaContainsIgnoreCase(String nama, Pageable pageable);
    public Page<Akses> findByDeskripsiContainsIgnoreCase(String nama, Pageable pageable);
//    public Page<Akses> findByDeskripsiContainsIgnoreCaseAndDiv(String nama,String divisi, Pageable pageable);

    public List<Akses> findByNamaContainsIgnoreCase(String nama);
    public List<Akses> findByDeskripsiContainsIgnoreCase(String nama);

    public Optional<Akses> findTop1ByOrderByIdDesc();
}