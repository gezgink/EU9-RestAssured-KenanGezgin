package com.cydeo.day3_QueryParam_PathParam_Path;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiTestsWithParameters_02 {

    @BeforeAll
    public static void init(){

        baseURI = "http://54.84.11.4:1000/ords/hr";

    }



    @DisplayName("Get request to /countries with Query Param")
    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q", "{\"region_id\":2}")
                .log().all()
                .when()
                .get("/countries");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.header("Content-Type"));
        assertTrue(response.body().asString().contains("United States of America"));

        response.prettyPrint();
    }

    @DisplayName("Get request to /employees with Query Param")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q", "{\"job_id\":\"IT_PROG\"}")
                .log().all()
                .when()
                .get("/employees");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.header("Content-Type"));
        assertTrue(response.body().asString().contains("IT_PROG"));

        response.prettyPrint();
    }

}
