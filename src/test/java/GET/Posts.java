package GET;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Posts {

    final static String url = "http://localhost:3000/posts";
    GetRequest request;

    @Test
    @DisplayName("GET /posts should return statusCode 200")
    void getResponseWithoutId() {
        request = new GetRequest(url);
        Response res = request.send();
        Assertions.assertEquals(200, res.getStatusCode());
    }

    @Test
    @DisplayName("GET /posts/{id} should return statusCode 200")
    void getResponseWithId() {
        request = new GetRequest(String.format("%s/1", url));
        Response res = request.send();
        Assertions.assertEquals(200, res.getStatusCode());
    }

}
