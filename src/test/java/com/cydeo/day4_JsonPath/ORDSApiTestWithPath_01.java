package com.cydeo.day4_JsonPath;

import com.cydeo.utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiTestWithPath_01 extends HRTestBase {

    @DisplayName("GET request to countries with Path method")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q", "{\"region_id\":2}")
                .when()
                .get("/countries");

        assertEquals(200,response.statusCode());

        //print limit result
        System.out.println("response.path(\"limit\") = " + response.path("limit"));

        //print hasmore result
        System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));

        //print first CountryId
        System.out.println("response.path(\"items[0].country_id\") = " + response.path("items[0].country_id"));

        //print second country name
        System.out.println("response.path(\"items[1].country_name\") = " + response.path("items[1].country_name"));

//        print "http://54.84.11.4:1000/ords/hr/countries/CA"

        String thirdHref = response.path("items[2].links[0].href");
        System.out.println("thirdHref = " + thirdHref);

        List<String> countryNames = response.path("items.country_name");
        System.out.println("countryNames = " + countryNames);

        //assert that all regions ids are equal to 2

        List<Integer> allRegionsIds = response.path("items.region_id");

        for (Integer regionsId : allRegionsIds) {

            System.out.println("regionsId = " + regionsId);
            assertEquals(2,regionsId);

        }



    }


    @DisplayName("Get request to /employees with Query Param")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q", "{\"job_id\":\"IT_PROG\"}")
                .when()
                .get("/employees");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.header("Content-Type"));
        assertTrue(response.body().asString().contains("IT_PROG"));

        List<String> allJobIDs = response.path("items.job_id");

        for (String jobID : allJobIDs) {
            System.out.println("jobID = " + jobID);
            assertEquals("IT_PROG",jobID);
        }

    }


}
