package retrofit.steps;

import io.qameta.allure.Step;
import model.BoardData;
import org.testng.Assert;
import retrofit.BaseTestRetrofit;
import retrofit2.Response;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class GetBoard extends BaseTestRetrofit {
    private BoardData expectedBoardData;
    private String actualBoardName;
    private String actualBoardId;
    private Response<BoardData> response;
    @Step("Preparing data")
    public void preparePayload() {
        actualBoardName = properties.getBoardName();
        actualBoardId = properties.getBoardId();
    }
    @Step("Sending GET request")
    public void sendRequest() throws IOException {
        response = trelloBoardService
                .getBoard(
                        properties.getBoardId(),
                        key,
                        token)
                .execute();
        expectedBoardData = response.body();
    }
    @Step("Assert result")
    public void assertResponse() {
        Assert.assertTrue(response.isSuccessful());
        Assert.assertEquals(actualBoardName, expectedBoardData.getName());
        Assert.assertEquals(actualBoardId, expectedBoardData.getBoardId());

        assertThat(actualBoardName).isNotNull().isEqualTo(expectedBoardData.getName());
        assertThat(actualBoardId).isNotNull().isEqualTo(expectedBoardData.getBoardId());
    }
}
