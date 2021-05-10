package basic;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.jfr.ContentType;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static jdk.jfr.ContentType.*;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;

public class openWeather {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://api.openweathermap.org";
        RestAssured.basePath = "/data/2.5";
    }

    @Test
    public void statusCodeVerification() {
        given()
                .param("q", "london")
                .param("appid", "dbd3b02d8958d62185d02e944cd5f522")
                .when()
                .get("/weather")

                .then()
                .statusCode(200)
                .body("sys.id", equalTo(1414))
                .body("name", equalTo("London"))
                .body("coord.lat", equalTo(new Float(51.5085)))
                .contentType(io.restassured.http.ContentType.JSON);

    }


}
