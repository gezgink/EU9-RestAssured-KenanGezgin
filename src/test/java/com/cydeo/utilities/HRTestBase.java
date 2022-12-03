package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public abstract class HRTestBase {

    @BeforeAll
    public static void init(){

        baseURI = "http://54.84.11.4:1000/ords/hr";

    }




}
