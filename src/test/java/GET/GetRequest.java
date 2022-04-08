package GET;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class GetRequest {

    private String url;

    public GetRequest(String url) {
        this.url = url;
    }

    public Response send() {
        Response response = given().when().get(this.url);
        return response;
    }
}
