package basic;

import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class GetRequestDemo {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://maps.googleapis.com";
        RestAssured.basePath = "/maps/api";
    }

    @Test
    public void statusCodeVerification() {
                given()
                    .param("units", "imperial")
                    .param("origins", "Washington,DC")
                    .param("destinations", "New+York+City,NY")
                    .param("key", "AIzaSyDza2ToBtcmJybpsi_MovjThzc_Il4zJ18")
                .when()
                    .get("/distancematrix/json")
                .then()
                    .statusCode(200);
    }

    @Test
    public void getResponseBody() {
        Response resp =
                given()
                        .param("units", "imperial")
                        .param("origins", "Washington,DC")
                    .param("destinations", "Lexington,MA|Concord,MA")
                    .param("key", "AIzaSyBxHK8lJ5q34zQ_K2vapbaiLMsC-t5U1FU")
                .when()
                        .get("/distancematrix/json");
        /* .then() */
                        System.out.println(resp.body().prettyPrint());

    }
}
