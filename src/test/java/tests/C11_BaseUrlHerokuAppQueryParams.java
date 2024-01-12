package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_BaseUrlHerokuAppQueryParams extends BaseUrlHerokuapp {

    @Test
    public void test01(){
         /*

            https://restful-booker.herokuapp.com/booking endpointine
            gerekli Query parametrelerini yazarak
                “firstname” degeri “Susan”
                ve “lastname” degeri “Ericson” olan
            rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
            donen response’un
                status code’unun 200 oldugunu
                ve “Eric Jones” ismine sahip en az bir booking oldugunu test edin
         */
        // 1- Request body ve end-point preparing

        specHerokuapp.pathParam("pp1","booking").queryParam("firstname","Susan");

        // 2- Preparing Expected Data
        // 3- Send Request and Save Response

        Response response = given()
                                .when().spec(specHerokuapp)
                                .get("/{pp1}");
        response.prettyPrint();
        // 4- Assertion

        response.then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(2));

    }
}
