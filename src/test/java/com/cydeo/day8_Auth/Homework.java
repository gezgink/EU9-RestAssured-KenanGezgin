package com.cydeo.day8_Auth;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


public class Homework extends SpartanTestBase {



    @DisplayName("//Admin Should be able to Create")
    @Test
    public void test1(){
        given().auth().basic("admin", "admin")
                .accept(ContentType.JSON)
                .when()
                ("/api/spartans")







    }



    /*
        As a homework,write a detealied test for Role Base Access Control(RBAC)
            in Spartan Auth app (7000)
            Admin should be able take all CRUD
            Editor should be able to take all CRUD
                other than DELETE
            User should be able to only READ data
                not update,delete,create (POST,PUT,PATCH,DELETE)
       --------------------------------------------------------
        Can guest even read data ? 401 for all

     */


}
