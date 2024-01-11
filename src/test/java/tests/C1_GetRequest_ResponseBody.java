package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C1_GetRequest_ResponseBody {
    // 1- Request body ve end-point preparing
    // 2- Preparing Expected Data
    // 3- Send Request and Save Response
    // 4- Assertion
    @Test
    public void get01(){
        String url = "https://restful-booker.herokuapp.com/booking/10";
        Response response = given().when().get(url);
        response.prettyPrint();

    }
}
