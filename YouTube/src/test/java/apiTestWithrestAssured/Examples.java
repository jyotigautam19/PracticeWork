package apiTestWithrestAssured;

import io.restassured.http.ContentType;
import org.junit.Test;
import org.json.simple.*;

import static io.restassured.RestAssured.*;

public class Examples {

    @Test
    public void test_getUsers(){

        baseURI = "http://localhost:3000";
        given().
                get("/users/").
                then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void test_getSubject(){

        baseURI = "http://localhost:3000";
        given().
                param("name","Automation").
                get("/subjects").
                then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void test_post(){
        JSONObject request = new JSONObject();
        request.put("firstName","Baby");
        request.put("lastName","Beeny");
        request.put("subjectId","1");

        baseURI = "http://localhost:3000";
        given().
               contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
                when().
                post("/users/").
                then()
                 .statusCode(201)
                 .log().all();
    }

    @Test
    public void test_patch(){
        JSONObject request = new JSONObject();

        request.put("lastName","Updated");

        baseURI = "http://localhost:3000";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
                when().
                patch("/users/7").
                then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void test_delete(){

        baseURI = "http://localhost:3000";

                when().
                delete("/users/7").
                then()
                .statusCode(200)
                .log().all();
    }

}
