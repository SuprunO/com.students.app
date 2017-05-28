package com.students.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by alex on 28.05.2017.
 */


public class StudentGetTests {
    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8084;
        RestAssured.basePath = "/student";
    }

    @Test

    public void getAllStudentInformation() {
// given,
// set cookies, add auth, add parameters, set header info
// when,
// GET, POST,PUT, DELETE
// then
// Validate status code,extract response, extract headers, extract the response body
        Response response = given()
                .when()
                .get("/list");
        System.out.println(response.body().prettyPrint());
        //validate the status code
        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @Test
    public void getStudentInfo() {
        Response response = given()
                .when()
                .get("/1");
            System.out.println(response.body().prettyPrint());
        given()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void getStudentsFromFA() {
        Response response2 = given()
                .when()
                .get("/list?programme=Financial Analysis&limit=2");
            System.out.println(response2.body().prettyPeek());
        given()
                .param("programme", "Financial Analysis")
                .param("limit", 2)
                .when()
                .get("/list");
        System.out.println(response2.body().prettyPeek());
    }
}
