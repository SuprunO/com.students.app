package com.students.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.student.model.Student;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by alex on 05.06.2017.
 */
public class StudentPostTests {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8084;
        RestAssured.basePath = "/student";
    }

    @Test
    public void createNewStudent() {
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Java");
        courses.add("C#");
        courses.add("Python");

        Student student = new Student();
        student.setFirstName("Serhey");
        student.setLastName("Zapadlovich");
        student.setEmail("vasya@gmail.com");
        student.setProgramme("QA");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
        .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
    }
}
