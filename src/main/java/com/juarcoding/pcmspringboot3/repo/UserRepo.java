package com.juarcoding.pcmspringboot3.repo;

import com.juarcoding.pcmspringboot3.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    //Derivered Query
    // SELECT x.* FROM MstUser x WHERE x.Email = ?
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndIsRegistered(String username, Boolean valid);
    Optional<User> findByUsernameOrEmailOrNoHp(String username,String email,String noHp);
    Optional<User> findByUsernameOrEmailOrNoHpAndIsRegistered(String username, String email, String noHp, Boolean valid);

    public Page<User> findByNamaLengkapContainsIgnoreCase(String nama, Pageable pageable);
    public Page<User> findByAlamatContainsIgnoreCase(String nama, Pageable pageable);
    public Page<User> findByEmailContainsIgnoreCase(String nama, Pageable pageable);
    public Page<User> findByUsernameContainsIgnoreCase(String nama, Pageable pageable);
    public Page<User> findByNoHpContainsIgnoreCase(String nama, Pageable pageable);
//    public Page<User> findByTanggalLahirContainsIgnoreCase(String nama, Pageable pageable);

    public List<User> findByNamaLengkapContainsIgnoreCase(String nama);
    public List<User> findByAlamatContainsIgnoreCase(String nama);
    public List<User> findByEmailContainsIgnoreCase(String nama);
    public List<User> findByUsernameContainsIgnoreCase(String nama);
    public List<User> findByNoHpContainsIgnoreCase(String nama);
//    public List<User> findByTanggalLahirContainsIgnoreCase(String nama);

}
