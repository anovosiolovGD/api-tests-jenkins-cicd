package restAssured.testStepsLib;

import api.BaseTest;
import model.BoardData;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class CreateBoardSteps extends BaseTest {
    private BoardData expectedBoardData;
    private String actualBoardName;

    public void preparePayload() {
        actualBoardName = "nvsNoStress";
    }

    public void sendRequest() {
        expectedBoardData = given()
                .when()
                .post(url + "?name=" + actualBoardName + "&key=" + key + "&token=" + token)
                .then().log().all()
                .extract().as(BoardData.class);
        saveBoardDataInProperties(expectedBoardData);
    }


    public void assertResponse() {
        Assert.assertNotNull(expectedBoardData);
        Assert.assertEquals(actualBoardName, expectedBoardData.getName());
    }
}


