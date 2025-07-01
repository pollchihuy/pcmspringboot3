package com.juarcoding.pcmspringboot3.utils;

import com.juarcoding.pcmspringboot3.config.JwtConfig;
import com.juarcoding.pcmspringboot3.config.OtherConfig;
import com.juarcoding.pcmspringboot3.security.Crypto;
import com.juarcoding.pcmspringboot3.security.JwtUtility;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;


@Component
public class GlobalFunction {

    public static Map<String,Object> convertClassToMap(Object object){
        Map<String,Object> map = new LinkedHashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();//Reflection
        for(Field field : fields){
            field.setAccessible(true);
            try{
                map.put(field.getName(),field.get(object));
            }catch(Exception e){

            }
        }
        return map;
    }

    public static String camelToStandard(String camel){
        StringBuilder sb = new StringBuilder();
        char c = camel.charAt(0);
        sb.append(Character.toLowerCase(c));
        for (int i = 1; i < camel.length(); i++) {
            char c1 = camel.charAt(i);
            if(Character.isUpperCase(c1)){
                sb.append(' ').append(Character.toLowerCase(c1));
            }
            else {
                sb.append(c1);
            }
        }
        return sb.toString();
    }

    public static void printConsole(Object o){
        if(OtherConfig.getEnablePrintConsole().equals("y")){
            System.out.println(o);
        }
    }

    public static Map<String,Object> extractToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        token = token.substring(7);
        if(JwtConfig.getTokenEncryptEnable().equals("y")){
            token = Crypto.performDecrypt(token);
        }
        return new JwtUtility().mappingBodyToken(token);
    }
    public static Map<String,Object> extractToken(String token){
        token = token.substring(7);
        if(JwtConfig.getTokenEncryptEnable().equals("y")){
            token = Crypto.performDecrypt(token);
        }
        return new JwtUtility().mappingBodyToken(token);
    }


//    @Async
//    public void sendMail(){
//
//    }
}
