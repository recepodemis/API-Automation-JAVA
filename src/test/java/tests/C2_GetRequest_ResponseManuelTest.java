package tests;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;


import static io.restassured.RestAssured.given;

public class C2_GetRequest_ResponseManuelTest {

    // 1- Request body ve end-point preparing
    // 2- Preparing Expected Data
    // 3- Send Request and Save Response
    // 4- Assertion
    /*
    * https://restful-booker.herokuapp.com/booking/10 when send a get request
    * response returns status code should be 200.
    * content type : application/json; utf-8
    * Server name Header value : Cowboy
    * Status Line : HTTP/1.1 200 OK
    * Response time under the 5 seconds
    * Check this information manually
    * */
    @Test
    public void get01(){
        String url = "https://restful-booker.herokuapp.com/booking/10";
        Response response = given().when().get(url);
        System.out.println("status code: " + response.getStatusCode() +
                            "\ncontent type: "+response.getContentType()+
                            "\nServer name: "+ response.getHeader("Server")+
                            "\nStatus Line: "+response.getStatusLine()+
                            "\nResponse Time: "+response.getTime());

    }
}
