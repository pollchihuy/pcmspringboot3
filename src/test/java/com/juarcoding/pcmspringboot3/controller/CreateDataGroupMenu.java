package com.juarcoding.pcmspringboot3.controller;

import com.juarcoding.pcmspringboot3.config.OtherConfig;
import com.juarcoding.pcmspringboot3.model.GroupMenu;
import com.juarcoding.pcmspringboot3.repo.GroupMenuRepo;
import com.juarcoding.pcmspringboot3.utils.DataGenerator;
import com.juarcoding.pcmspringboot3.utils.TokenGenerator;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CreateDataGroupMenu extends AbstractTestNGSpringContextTests {

    @Autowired
    private GroupMenuRepo groupMenuRepo;

    private JSONObject req;
    private GroupMenu groupMenu;
    private Random rand ;
    private String token;
    private DataGenerator dataGenerator;

    @BeforeClass
    private void init(){
        token = new TokenGenerator(AuthControllerTest.authorization).getToken();
        rand  = new Random();
        req = new JSONObject();
        groupMenu = new GroupMenu();
        dataGenerator = new DataGenerator();
        Optional<GroupMenu> op = groupMenuRepo.findTop1ByOrderByIdDesc();
        groupMenu = op.get();
    }

    @BeforeTest
    private void setup(){
        /** sifatnya optional */
    }

    @Test(priority = 0)
    void save(){
        Response response ;
        try{
            req.put("nama", dataGenerator.dataNamaTim());
            req.put("deskripsi", genDataDescription());

            response = given().
                    header("Content-Type","application/json").
                    header("accept","*/*").
                    header(AuthControllerTest.AUTH_HEADER,token).
                    body(req).
                    request(Method.POST,"group-menu");

            int intResponse = response.getStatusCode();
            JsonPath jsonPath = response.jsonPath();
            Assert.assertEquals(intResponse,201);
            Assert.assertEquals(jsonPath.getString("message"),"SAVE SUCCESS !!");
            Assert.assertNotNull(jsonPath.getString("data"));
            Assert.assertTrue(Boolean.parseBoolean(jsonPath.getString("success")));
            Assert.assertNotNull(jsonPath.getString("timestamp"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    private String genDataDescription(){
        String strArr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        int intLength =  rand.nextInt(20,200);
        for (int i = 0; i < intLength; i++) {
            sb.append(strArr.charAt(rand.nextInt(strArr.length())));
        }

        return sb.toString();
    }
}