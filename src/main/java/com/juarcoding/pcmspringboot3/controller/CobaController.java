package com.juarcoding.pcmspringboot3.controller;

import com.juarcoding.pcmspringboot3.utils.LoggingFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class CobaController {

    @GetMapping("/lg")
    public String getData(){
        try{
            int i = 1/0;
        }catch (Exception e){
            LoggingFile.logException("Cobaan","main(String[] args)--Line 17",e);
        }
        return "login";
    }
}
