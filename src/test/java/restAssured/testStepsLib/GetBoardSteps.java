package restAssured.testStepsLib;

import api.BaseTest;
import model.BoardData;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GetBoardSteps extends BaseTest {

    private BoardData expectedBoardData;
    private String actualBoardId;

    public void preparePayload() {
        actualBoardId = properties.getBoardId();
    }

    public void sendRequest() {
        expectedBoardData = given()
                .when()
                .get(url + actualBoardId + "?key=" + key + "&token=" + token)
                .then().log().all()
                .extract().as(BoardData.class);
    }

    public void assertResponse() {
        Assert.assertNotNull(expectedBoardData);
        Assert.assertEquals(actualBoardId, expectedBoardData.getBoardId());
    }


}
