package com.juarcoding.pcmspringboot3.service;


import com.juarcoding.pcmspringboot3.model.CobaRest;
import com.juarcoding.pcmspringboot3.model.User;
import com.juarcoding.pcmspringboot3.repo.CobaRestRepo;
import com.juarcoding.pcmspringboot3.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CobaRestService {

    @Autowired
    CobaRestRepo cobaRestRepo;

    @Autowired
    UserRepo userRepo;


    public void save(CobaRest cobaRest){
        cobaRestRepo.save(cobaRest);
        cobaRestRepo.deleteById(1);
        userRepo.deleteAll();
        userRepo.save(new User());
    }

    public void save(){
        System.out.println("OK");
    }
}