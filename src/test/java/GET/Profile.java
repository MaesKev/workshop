package GET;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Profile {

    final static String url = "http://localhost:3000/profile";
    GetRequest request;

    @Test
    @DisplayName("GET /profile should return statusCode 200")
    void getResponse() {
        request = new GetRequest(url);
        Response res = request.send();
        Assertions.assertEquals(200, res.getStatusCode());
    }
}
