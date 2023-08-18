package restAssured.testStepsLib;

import api.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class DeleteBoardStep extends BaseTest {
    private String boardId;
    private Response response;

    public void preparePayload() {
        boardId = properties.getBoardId();
    }

    public void sendRequest() {
        response = given()
                .when()
                .delete(url + boardId + "?key=" + key + "&token=" + token)
                .then().log().all().extract().response();
    }

    public void assertResponse() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
