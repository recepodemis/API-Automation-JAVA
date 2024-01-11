package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C9_GetRequestWithBaseUrlAutomationTest extends BaseUrlJsonPlaceHolder {

    @Test
    public void getTest01(){
        specJsonPlaceHolder.pathParam("pp1","posts");
        Response response = given()
                            .when().spec(specJsonPlaceHolder)
                            .get("/{pp1}");
        response.then()
                .assertThat()
                .statusCode(200)
                .body("id", Matchers.hasSize(100));

    }

}
