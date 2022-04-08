package DELETE;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
    private String url;

    public DeleteRequest(String url) {
        this.url = url;
    }

    public Response send(String id) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        Response response = request.delete(String.format("%s/%s", url, id));

        return response;
    }
}
