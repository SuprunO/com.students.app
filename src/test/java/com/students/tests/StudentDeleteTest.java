package com.students.tests;

import org.testng.annotations.Test;
import student.base.BaseClass;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by alex on 05.06.2017.
 */
public class StudentDeleteTest extends BaseClass {

    @Test
    public void studentDelete (){

given()
        .when()
        .delete("/102")
        .then()
        .statusCode(204);
    }
}
