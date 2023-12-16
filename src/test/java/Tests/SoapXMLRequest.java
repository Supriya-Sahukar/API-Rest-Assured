package Tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SoapXMLRequest {

    @Test
    public void validateSoapXML() throws IOException {

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
                body("//*:AddResult.text()", equalTo("8"));
    }
}
