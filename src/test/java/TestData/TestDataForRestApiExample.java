package TestData;

import org.json.JSONObject;

public class TestDataForRestApiExample {
    public int  status_code = 200;
    public String content_type = "application/json";
/*    Expected Response Body
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
    }*/
    public static JSONObject restApiExampleSendData(String status,
                                                 int id,
                                                 String employee_name,
                                                 int employee_salary,
                                                 int employee_age,
                                                 String profile_image,
                                                 String message){
        JSONObject sendData = new JSONObject();
        JSONObject data = new JSONObject();
        data.put("id",id);
        data.put("employee_name",employee_name);
        data.put("employee_salary", employee_salary);
        data.put("employee_age",employee_age);
        data.put("profile_image",profile_image);
        sendData.put("status",status);
        sendData.put("data",data);
        sendData.put("message",message);


        return sendData;

    }
}
