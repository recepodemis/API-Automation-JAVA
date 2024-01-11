package tests;

import org.json.JSONObject;
import org.junit.Test;

public class C8_PostRequestWithJsonPathAutomationTest {
    @Test
    public void post01(){
        /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un id haric asagidaki gibi oldugunu test edin.

        Request body
        {
        "firstname" : "Hasan",
        "lastname" : "Yagmur",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
            },
        "additionalneeds" : "wi-fi"
        }

        Expected Response Body
        {
        "bookingid":24,
        "booking":{
            "firstname":"Hasan",
            "lastname":"Yagmur",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                "checkin":"2021-06-01",
                "checkout":"2021-06-10"
                },
        "additionalneeds":"wi-fi"
        }
        }
         */

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject expectedData = new JSONObject();
        JSONObject bookingData  = new JSONObject();

        expectedData.put("firstname","Hasan");
        expectedData.put("lastname", "Bulut");
        expectedData.put("totalprice",500);
        expectedData.put("additionalneeds","wi-fi");

        System.out.println(expectedData.toString());
    }
}
