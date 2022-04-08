package DELETE;

import POST.PostRequest;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Posts {

    final static String url = "http://localhost:3000/posts";
    DeleteRequest request;

    @Test
    @DisplayName("DELETE /posts should return statusCode 200 when using a valid id")
    void getResponseWithValidId() {
        PostRequest post = new PostRequest(url);
        JSONObject json = new JSONObject();
        json.put("title", "json-server");
        json.put("author", "typicode");
        json.put("id", "55555");
        post.send(json);

        request = new DeleteRequest(url);
        Response res = request.send("55555");
        Assertions.assertEquals(200, res.getStatusCode());
    }

    @Test
    @DisplayName("DELETE /posts should return statusCode 404 when using an invalid")
    void getResponseWithInvalidId() {
        request = new DeleteRequest(url);
        Response res = request.send("0");
        Assertions.assertEquals(404, res.getStatusCode());
    }
}
