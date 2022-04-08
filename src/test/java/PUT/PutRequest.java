package PUT;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class PutRequest {
    private String url;

    public PutRequest(String url) {
        this.url = url;
    }

    public Response send(JSONObject body) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(body);
        Response response = request.put(url);

        return response;
    }
}
