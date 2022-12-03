package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public abstract class SpartanTestBase {

    @BeforeAll
    public static void init(){

        baseURI = "http://54.84.11.4:8000";

        String dbUrl = "jdbc:oracle:thin:@54.84.11.4:1521:xe";
        String dbUsername = "SP";
        String dbPassword = "SP";

        //DBUtils.createConnection(dbUrl,dbUsername,dbPassword);

    }

    @AfterAll
    public static void teardown(){
        //DBUtils.destroy();
    }
}
