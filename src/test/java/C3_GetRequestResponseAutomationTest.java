import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C3_GetRequestResponseAutomationTest {

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

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","Cowboy").
                statusLine("HTTP/1.1 200 OK");

    }
}
