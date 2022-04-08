package POST;

import GET.GetRequest;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Posts {

    final static String url = "http://localhost:3000/posts";
    PostRequest request;

    @Test
    @DisplayName("POST /posts should return statusCode 201 and add an entry")
    void getResponseWithJsonBody() {
        request = new PostRequest(url);
        GetRequest get = new GetRequest(url);

        Response start = get.send();

        JSONObject json = new JSONObject();
        json.put("title", "json-server");
        json.put("author", "typicode");
        Response response = request.send(json);

        Response end = get.send();

        Assertions.assertEquals(201, response.getStatusCode());
        Assertions.assertNotEquals(start.asPrettyString(), end.asPrettyString());
    }


}

