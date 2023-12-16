package Tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XMLSchemaValidator {

    @Test
    public void XMLSchema() throws IOException {

        File file = new File("./SoapRequest/Add.xml.txt");

        if(file.exists()){
            System.out.println("File exists");
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

        baseURI = "http://www.dneonline.com";

        given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).
                when().post("/calculator.asmx?op=Add").
                then().
                statusCode(200).
                log().all().
                and().
                body("//*:AddResult.text()", equalTo("8")).
        and().
        assertThat().body(matchesXsdInClasspath("Calculator.xsd"));
    }
}
