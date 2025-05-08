package com.juarcoding.pcmspringboot3.service;


import com.juarcoding.pcmspringboot3.config.OtherConfig;
import com.juarcoding.pcmspringboot3.dto.validation.LoginDTO;
import com.juarcoding.pcmspringboot3.dto.validation.RegisDTO;
import com.juarcoding.pcmspringboot3.dto.validation.VerifyRegisDTO;
import com.juarcoding.pcmspringboot3.model.User;
import com.juarcoding.pcmspringboot3.repo.UserRepo;
import com.juarcoding.pcmspringboot3.security.BcryptImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class AuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    private Random random = new Random();

    public ResponseEntity<Object> regis(User user) {
        int otp = random.nextInt(100000,999999);
        user.setOtp(String.valueOf(otp));
        user.setPassword(BcryptImpl.hash(user.getUsername()+user.getPassword()));
        userRepo.save(user);
        Map<String,Object> m = new HashMap<>();
        if(OtherConfig.getEnableAutomationTesting().equals("y")){
            m.put("otp",otp);// ini untuk automation
        }
        m.put("email",user.getEmail());

        return ResponseEntity.ok(m);
    }

    public ResponseEntity<Object> verifyRegis(User user) {
        int otp = random.nextInt(100000,999999);
        //lakukan Query ->
        // matching OTP yang dikirim dengan yang di table
        Map<String,Object> m = new HashMap<>();
        Optional<User> opUser = userRepo.findByEmail(user.getEmail());
        if(!opUser.isPresent()) {
            m.put("message","Email Tidak Ditemukan !!");
            return ResponseEntity.badRequest().body(m);
        }
        User userNext = opUser.get();//ini dari database
        if(!userNext.getOtp().equals(user.getOtp())) {
            m.put("message","OTP Salah !!");
            return ResponseEntity.badRequest().body(m);
        }
        userNext.setRegistered(true);
        userNext.setModifiedBy(userNext.getId());
        userNext.setOtp(String.valueOf(otp));
//        userNext.setModifiedDate(LocalDateTime.now());

        m.put("message","Registrasi Berhasil");

        return ResponseEntity.ok(m);
    }

    public ResponseEntity<Object> login(User user) {
        // username (username,email,noHp)
        // password
        String username = user.getUsername();
        Optional<User> opUser = userRepo.findByUsernameOrEmailOrNoHp(username,username,username);
        Map<String,Object> m = new HashMap<>();
        if(!opUser.isPresent()) {
            m.put("message","User Tidak Ditemukan");
            return ResponseEntity.badRequest().body(m);
        }
        User userNext = opUser.get();//diambil dari DB

//        if(!userNext.getPassword().equals(user.getPassword())) {
        String pwdDB = userNext.getUsername()+user.getPassword();
//        if(!BcryptImpl.verifyHash(user.getPassword(),userNext.getPassword())) {
        if(!BcryptImpl.verifyHash(pwdDB,userNext.getPassword())) {
            m.put("message","Username atau Password Salah !!");
            return ResponseEntity.badRequest().body(m);
        }

        m.put("token","nanti di security");
        m.put("menu","sama aja nanti di security");
        m.put("message","Login Berhasil");

        return ResponseEntity.ok(m);
    }

//    public User mapToUser(RegisDTO regisDTO) {
//        User user = new User();
//        user.setEmail(regisDTO.getEmail());
//        user.setNoHp(regisDTO.getNoHp());
//        user.setAlamat(regisDTO.getAlamat());
//        user.setNamaLengkap(regisDTO.getNamaLengkap());
//        user.setPassword(regisDTO.getPassword());
//        user.setTanggalLahir(regisDTO.getTanggalLahir());
//        user.setUsername(regisDTO.getUsername());
//
//        return user;
//    }

//    public User mapToUser(VerifyRegisDTO verifyRegisDTO) {
//        User user = new User();
//        user.setEmail(verifyRegisDTO.getEmail());
//        user.setOtp(verifyRegisDTO.getOtp());
//
//        return user;
//    }

//    public User mapToUser(LoginDTO loginDTO) {
//        User user = new User();
//        user.setUsername(loginDTO.getUsername());
//        user.setPassword(loginDTO.getPassword());
//
//        return user;
//    }


    public User mapToUser(VerifyRegisDTO verifyRegisDTO) {
            return  modelMapper.map(verifyRegisDTO, User.class);
    }

    public User mapToUser(RegisDTO regisDTO) {
        return  modelMapper.map(regisDTO, User.class);
    }

    public User mapToUser(LoginDTO loginDTO) {
        return modelMapper.map(loginDTO, User.class);
    }
}
