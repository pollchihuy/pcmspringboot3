package com.juarcoding.pcmspringboot3.controller;

import com.juarcoding.pcmspringboot3.config.SmtpConfig;
import com.juarcoding.pcmspringboot3.dto.DataDTO;
import com.juarcoding.pcmspringboot3.service.CobaRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("hello")
public class CobaRestController {

    @Autowired
    CobaRestService cobaRestService;

//    public CobaRestService x (CobaRestService crs){
//        if(crs==null){
//            return new CobaRestService();
//        }
//        return crs;
//    }

    @Value("${cumi.cumi}")
    private String cumicumi;


    @GetMapping("/gt")
    public Object getData(){
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("message","Login");
        map.put("timestamp",new Date());
        map.put("status",256);
        map.put("path","hello/gt");
        cobaRestService.save();
        System.out.println("Nilai CumiCumi adalah "+cumicumi);
        System.out.println("Isi Username SMTPConfig "+ SmtpConfig.getEmailUsername());
//        DataDTO dto = new DataDTO();
//        dto.setMessage("login");
//        dto.setTimestamp(new Date());
//        dto.setStatus(256);

        return map;
    }

    @PostMapping("/pst")
    public String postData(){
        return "Hello World Post!!";
    }

    @PutMapping("/pt")
    public String putData(){
        return "Hello World Put!!";
    }

}
