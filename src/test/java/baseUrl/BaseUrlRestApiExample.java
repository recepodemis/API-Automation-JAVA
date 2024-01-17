package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlRestApiExample {
    protected RequestSpecification specRestApiExample;
    @Before
    public void setUp(){
        specRestApiExample = new RequestSpecBuilder()
                .setBaseUri("http://dummy.restapiexample.com/api/v1")
                .build();
    }
}
