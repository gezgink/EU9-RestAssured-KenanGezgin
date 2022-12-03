package com.cydeo.day2_Postman_Manual_Testing_Headers_RestAssured_Intro;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HrGetRequests_02 {


    @BeforeAll
    public static void init(){

        RestAssured.baseURI = "http://54.84.11.4:1000/ords/hr";

    }

    @DisplayName("Get request to /regions")
    @Test
    public void test1(){
        Response response = RestAssured.get("/regions");
        System.out.println(response.statusCode());

    }

    @DisplayName("Get request to /regions/2")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/regions/2");

        assertEquals(200,response.statusCode());

        assertEquals("application/json", response.contentType());

        response.prettyPrint();

        assertTrue(response.body().asString().contains("Americas"));
    }



}
