package apiTestWithrestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;

public class FirstTest {

    @Test
    public void getRequest(){
       /* String url = "https://reqres.in/api/users?page=2";
        Response response = RestAssured.get(url);
        Assert.assertEquals("Response code mismatch",200,response.getStatusCode());
        int total_pages = response.jsonPath().get("total_pages");
        Assert.assertEquals("Total pages value mismatch", 2, total_pages);*/

        given()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .log().all() //response from the server in console
                .body("data.id[1]",equalTo(7))
                .body("data.first_name", hasItems("Michael","Lindsay"));

    }

    @Test
    public void postApiRequest(){

        String url = "https://reqres.in/api/users";
                String contentType ="application/json";
        String bodyData="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = given().
                contentType(contentType).
                body(bodyData).
                when().
                post(url).
                then().
                extract().
                response();

        Assert.assertEquals("Response code mismatch",201,response.getStatusCode());
        String name = response.jsonPath().get("name");
        Assert.assertEquals("Response code mismatch","morpheus",name);
    }

    @Test
    public void postApiRequestAlternative(){

        JSONObject req = new JSONObject();

        req.put("name","morpheus");
        req.put("job","leader");

        System.out.println(req.toJSONString());
        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);
    }
    @Test
    public void testPut(){
        JSONObject req = new JSONObject();

        req.put("name","Raghav");
        req.put("job","leader");

        System.out.println(req.toJSONString());
        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testDelete(){
                when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .log().all();
    }
}
