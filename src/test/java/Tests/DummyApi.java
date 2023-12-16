package Tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DummyApi {

    @Test
    public void get(){

        baseURI = "http://localhost:3000/";

                given().get("/users").then().statusCode(200).log().all();
    }

    //@Test
    public void post(){

        JSONObject request = new JSONObject();

        request.put("first_name", "mallu");
        request.put("last_name", "l");
        request.put("subjectId", 2);


        baseURI = "http://localhost:3000";

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();
    }

    @Test
    public void put(){

        JSONObject request = new JSONObject();

        request.put("first_name", "rahul");
        request.put("last_name", "m");
        request.put("subjectId", 1);


        baseURI = "http://localhost:3000";

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/4").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void patch(){

        JSONObject request = new JSONObject();

        request.put("last_name", "sd");

        baseURI = "http://localhost:3000";

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/users/4").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void delete(){

        baseURI = "http://localhost:3000";

        given().
                when().
                delete("/users/5").
                then().
                statusCode(200).
                log().all();
    }

}
