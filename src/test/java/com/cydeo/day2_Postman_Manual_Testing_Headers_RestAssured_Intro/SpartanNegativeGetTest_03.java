package com.cydeo.day2_Postman_Manual_Testing_Headers_RestAssured_Intro;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanNegativeGetTest_03 {


    @BeforeAll
    public static void init(){

        RestAssured.baseURI = "http://54.84.11.4:8000";;

    }

    @DisplayName("Get request to /api/spartans/10")
    @Test
    public void test1(){

        Response response = given()
                .accept(ContentType.XML)
                .when()
                .get("api/spartans/10");

        assertEquals(406,response.statusCode());
        assertEquals("application/xml;charset=UTF-8",response.contentType());

    }







}
