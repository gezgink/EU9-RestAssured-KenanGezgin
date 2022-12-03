package com.cydeo.day6_Pojo_Post_Put_Patch_Delete;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class SundayPractice {


    @BeforeAll
    public static void setUPBase(){
        baseURI="http://54.84.11.4:8000";

    }

    @Test
    public void test3(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/15");

        Map<String,Object> spartan15 = response.as(Map.class);
        System.out.println(spartan15);

    }

    @Test
    public void test4(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

        List<Map<String,Object>> allSpartans = response.as(List.class);
        System.out.println("allSpartans = " + allSpartans);

    }

    @Test
    public void test5(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParams("nameContains", "m")
                .when().get("/api/spartans/search");

        Map<String,Object> allSpartans = response.as(Map.class);
        System.out.println("allSpartans = " + allSpartans);


    }



    @Test
    public void test1(){

        assertThat(5, is(5));
        assertThat(String.valueOf(10),equals(15));
        assertThat("house",equals("house"));

        System.out.println("house".contains("hou"));

    }

    @Test
    public void test2(){

        assertThat(15,equalTo(15));






    }




}
