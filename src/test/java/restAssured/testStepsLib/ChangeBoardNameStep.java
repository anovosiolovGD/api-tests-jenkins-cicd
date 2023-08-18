package restAssured.testStepsLib;

import api.BaseTest;
import model.BoardData;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class ChangeBoardNameStep extends BaseTest {
    private BoardData expectedBoardData;
    private String boardId;
    private String newActualBoardName;

    public void preparePayload() {
        boardId = properties.getBoardId();
        newActualBoardName = "nvsDoSomeStress";
    }

    public void sendRequest() {
        expectedBoardData = given()
                .when()
                .put(url + boardId + "?key=" + key + "&token=" + token + "&name=" + newActualBoardName)
                .then().log().all()
                .extract().as(BoardData.class);
        saveBoardDataInProperties(expectedBoardData);
    }


    public void assertResponse() {
        Assert.assertNotNull(expectedBoardData);
        Assert.assertEquals(newActualBoardName, expectedBoardData.getName());
    }
}
