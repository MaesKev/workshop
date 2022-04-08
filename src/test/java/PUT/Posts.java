package PUT;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Posts {

    final static String url = "http://localhost:3000/posts";
    PutRequest request;

    @Test
    @DisplayName("PUT /posts should return statusCode 200 when using a valid id")
    void getResponseWithValidId() {
        request = new PutRequest(String.format("%s/1", url));

        JSONObject json = new JSONObject();
        json.put("title", "json-server");
        json.put("author", "typicode");
        Response response = request.send(json);

        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    @DisplayName("PUT /posts should return statusCode 404 when using an invalid id")
    void getResponseWithInvalidId() {
        request = new PutRequest(String.format("%s/0", url));

        JSONObject json = new JSONObject();
        json.put("title", "json-serverke");
        json.put("author", "typicode");
        Response response = request.send(json);

        Assertions.assertEquals(404, response.getStatusCode());
    }
}

