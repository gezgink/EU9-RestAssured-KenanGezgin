package com.cydeo.day10;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.get;

public class govXmlTest {



    @Test
    public void test1(){
        //send a get request to
        //https://data.ct.gov/api/views/qm34-pq7e/rows.xml
        //get all the years
        //get all unknowns
        //get 2005 other
        //get 2007 _address
        Response response = get("https://data.ct.gov/resource/y6p2-px98.xml")
                            .then().statusCode(200).extract().response();

        XmlPath xmlPath = response.xmlPath();

        //get all the category
        List<String> category = xmlPath.getList("response.rows.row.category");
        System.out.println("category = " + category);
        //get all unknowns
        List<String> item = xmlPath.getList("response.rows.row.item");
        System.out.println("item = " + item);

        String url = xmlPath.getString("response.rows.row[0].@_address");
        System.out.println("url = " + url);


//        //get 2005 other
//        int locationZip = xmlPath.getInt("response.rows.row.location_1_zip");
//        System.out.println("locationZip = " + locationZip);
//        //get 2007 _address
//        String adress = xmlPath.getString("response.rows.row.location_1_address");
//        System.out.println("adress = " + adress);




        //Not: Jamal'ın linki çalışmıyordu. Yeni paylaşılan link üzerinden verileri değiştirirerek yaptım.


    }
}
