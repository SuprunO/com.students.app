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
public class StudentPatchTests {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8084;
        RestAssured.basePath = "/student";
    }

    @Test
            public void patchStudent(){
    ArrayList<String> courses = new ArrayList<String>();
        courses.add("Java");
        courses.add("C#");
        courses.add("Delphi");

    Student student = new Student();
        student.setFirstName("Mark");
        student.setLastName("Bekmambetovich");
        student.setEmail("kovalski@gmail.com");
        student.setProgramme("QA");
        student.setCourses(courses);

    given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .patch("/101")
                .then()
                .statusCode(200);
}
}
