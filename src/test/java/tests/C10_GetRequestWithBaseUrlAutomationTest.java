package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C10_GetRequestWithBaseUrlAutomationTest extends BaseUrlJsonPlaceHolder {
    @Test
    public void getTest01(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",42);

        Response response = given()
                                .spec(specJsonPlaceHolder)
                                .when()
                                .get("/{pp1}/{pp2}");
        response.then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.equalTo("commodi ullam sint et excepturi error explicabo praesentium voluptas"));
        
    }

}
