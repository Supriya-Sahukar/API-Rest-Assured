package Tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PutPatchDelete {

    @Test
    public void test_PUT(){

        JSONObject request = new JSONObject();

        request.put("name", "sanju");
        request.put("job","dj");

        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_PATCH(){

        JSONObject request = new JSONObject();

        request.put("name", "mmanju");
        request.put("job","rj");

        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_DELETE(){

        baseURI = "https://reqres.in/api";

        given().
                when().
                delete("/users/2").
                then().
                statusCode(204).
                log().all();
    }
}
