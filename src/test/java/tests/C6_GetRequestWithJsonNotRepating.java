package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class C6_GetRequestWithJsonNotRepating {

    @Test
    public void get01(){
        /*
        https://restful-booker.herokuapp.com/booking/11 url’ine bir GET request
        gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application-json, ve response body’sindeki
        "firstname“in, "Susan",
        ve "lastname“in, "Jackson",
        ve "totalprice“in, 612,
        ve "depositpaid“in, false,
        ve "additionalneeds“in, "Breakfast"
        oldugunu test edin
         */

        String url = "https://restful-booker.herokuapp.com/booking/11";

        Response response = given().when().get(url);

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("John"),
                        "lastname",equalTo("Smith"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "additionalneeds",equalTo("Breakfast"));



    }
}
