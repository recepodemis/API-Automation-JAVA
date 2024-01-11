package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C7_PutRequestWithJsonAutomationTest {
    @Test
    public void putTest(){
         /*
            http://dummy.restapiexample.com/api/v1/employees sent get request
                and check return Response
                    status code : 200,
                    content type : Application.JSON,
                    In response body
                    employees count : 24
                    one of employee's is "Ashton Cox"
                    include these employees ages 61,21 ve 35

                     HERE IS RESULT OF GET REQUEST
                    {
                        "status": "success",
                        "data": [
                            {
                                "id": 1,
                                "employee_name": "Tiger Nixon",
                                "employee_salary": 320800,
                                "employee_age": 61,
                                "profile_image": ""
                            },
                          .......
                        ],
                     }
         */

        String url = "http://dummy.restapiexample.com/api/v1/employees";

        Response response = given().when().get(url);

        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON )
                .body("data.id", hasSize(24),
                        "data.employee_name", hasItem("Ashton Cox"),
                        "data.employee_age", hasItems(61,21,35));


    }
}
