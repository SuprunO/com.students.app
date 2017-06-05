package student.base;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

/**
 * Created by alex on 05.06.2017.
 */
public class BaseClass {
    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8084;
        RestAssured.basePath = "/student";
    }


}
