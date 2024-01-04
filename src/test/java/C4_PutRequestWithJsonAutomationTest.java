import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C4_PutRequestWithJsonAutomationTest {
    @Test
    public void put01(){
        JSONObject object = new JSONObject();
        object.put("title","Recep");
        object.put("body","Hello");
        object.put("userId",10);
        object.put("id",70);

        String url = "https://jsonplaceholder.typicode.com/posts/70";

        Response response = given().
                            contentType(ContentType.JSON).
                            when().put(url);

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","cloudflare").
                statusLine("HTTP/1.1 200 OK");
    }
}
