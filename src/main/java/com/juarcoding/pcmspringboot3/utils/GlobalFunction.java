package com.juarcoding.pcmspringboot3.utils;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;


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
}
