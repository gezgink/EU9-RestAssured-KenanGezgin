package com.cydeo.Day1_API_Introduction;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SimpleDayRequest {



    String url = "http://54.84.11.4:8000/api/spartans";

    @Test
    public void test(){


        Response response = RestAssured.get(url);

        System .out.println(response.statusCode());

        response.prettyPrint();


    }

}
