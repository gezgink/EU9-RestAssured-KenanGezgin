package com.cydeo.day3_QueryParam_PathParam_Path;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTestsWithParameters_01 {

    @BeforeAll
    public static void init(){

        baseURI = "http://54.84.11.4:8000";

    }

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .and().pathParams("id", 5)
                .when().get("/api/spartans/{id}");

        assertEquals(200,response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Blythe"));




    }

    @DisplayName("Get request /api/spartans/{id} Negative Test")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .pathParams("id", 500)
                .when().get("/api/spartans/{id}");

        assertEquals(404,response.statusCode());
        assertEquals("application/json",response.contentType());
        assertTrue(response.body().asString().contains("Not Found"));


    }

    @DisplayName("Get request to /api/spartans/search with Query Params")
    @Test
    public void test3(){
        Response response = given().log().all()
                .accept(ContentType.JSON)
                .and().queryParam("nameContains", "e")
                .and().queryParam("gender", "Female")
                .when()
                .get("/api/spartans/search");
        assertEquals(200,response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Female"));
        assertTrue(response.body().asString().contains("Janette"));

    }

    @DisplayName("GET request to /api/spartans/search with Query Params (MAP)")
    @Test
    public void test4(){
        Map<String,Object> querryMap= new HashMap<>();
        querryMap.put("nameContains","e");
        querryMap.put("gender","Female");

        Response response = given().
                log().all()
                .accept(ContentType.JSON)
                .and().queryParams(querryMap)
                .when()
                .get("/api/spartans/search");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());

        assertTrue(response.body().asString().contains("Female"));
        assertTrue(response.body().asString().contains("Janette"));



    }





}
