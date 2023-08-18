package retrofit.steps;

import io.qameta.allure.Step;
import model.BoardData;
import org.testng.Assert;
import retrofit.BaseTestRetrofit;
import retrofit2.Response;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteBoard extends BaseTestRetrofit {
    private BoardData expectedBoardData;
    private String actualBoardName;
    private String actualBoardId;
    private Response<BoardData> response;

    @Step("Preparing data")
    public void preparePayload() {
        actualBoardId = properties.getBoardId();
    }

    @Step("Sending DELETE request")
    public void sendRequest() throws IOException {
        response = trelloBoardService
                .deleteBoard(
                        properties.getBoardId(),
                        key,
                        token)
                .execute();
    }

    @Step("Assert result")
    public void assertResponse() {
        Assert.assertTrue(response.isSuccessful());
        Assert.assertEquals(response.code(), 200);

        assertThat(response.code()).isEqualTo(200);

    }
}
