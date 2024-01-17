package tests;

import TestData.TestDataForRestApiExample;
import baseUrl.BaseUrlRestApiExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C13_GetRequestWithTestData extends BaseUrlRestApiExample{
@Test
    public void getTest(){
              /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine
        bir GET request gonderdigimizde
        donen response’un status code’unun 200,
        content Type’inin application/json
        ve body’sinin asagidaki gibi oldugunu test edin.

          Expected Response Body
            {
                "status":"success",
                "data":{
                        "id":3,
                        "employee_name":"Ashton Cox",
                        "employee_salary":86000,
                        "employee_age":66,
                        "profile_image":""
                        },
                "message":"Successfully! Record has been fetched."
            }
         */
        // 1- endpoint ve request body olustu
        specRestApiExample.pathParams("pp1","employee","pp2","3");


        // 2- Preparing Expected Data
        JSONObject expectedData = TestDataForRestApiExample.restApiExampleSendData("success",
                                                                                    3,
                                                                                    "Ashton Cox",
                                                                                    86000,
                                                                                    66,
                                                                                    "",
                                                                                    "Successfully! Record has been fetched."
                );

        // 3- Send Request and Save Response
        Response response = given()
                            .when().spec(specRestApiExample)
                            .get("{pp1}/{pp2}");
        //response.prettyPrint();
        //4- Assertion
        JsonPath responseJP = response.jsonPath();
        assertEquals(expectedData.getString("status"),responseJP.getString("status"));
        assertEquals(expectedData.getJSONObject("data").getInt("id"), responseJP.getInt("data.id"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_age"), responseJP.getInt("data.employee_age"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_salary"), responseJP.getInt("data.employee_salary"));
        assertEquals(expectedData.getString("message"), responseJP.getString("message"));



}


}
