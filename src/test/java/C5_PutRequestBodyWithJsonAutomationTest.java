import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;
public class C5_PutRequestBodyWithJsonAutomationTest {
    @Test
    public void test(){
        // 1- Request body ve end-point preparing
        // 2- Preparing Expected Data
        // 3- Send Request and Save Response
        // 4- Assertion
        /*
         *  https://jsonplaceholder.typicode.com/posts url send a request body which is given below
         * {
         *  'title' : 'API',
         *  'body' : 'API TEST AUTOMATION',
         *  'userId' :10
         * }
         * returned Response
         * status code:201,
         * content type: application/json,
         * Response Body Title equal to API,
         * userId less than 100
         * Response Body body contain 'API'
         *
         */

        // 1- Request body ve end-point preparing
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody = new JSONObject();

        requestBody.put("title", "API");
        requestBody.put("body", "API TEST AUTOMATION");
        requestBody.put("userId", 10);
        // 2- Preparing Expected Data
        // 3- Send Request and Save Response
        Response response = given()
                            .contentType(ContentType.JSON)
                            .when()
                            .body(requestBody.toString())
                            .put(url);

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("Title", Matchers.equalTo("API"))
                .body("body",Matchers.contains("API"))
                .body("userId",Matchers.lessThan(100));




    }
}
