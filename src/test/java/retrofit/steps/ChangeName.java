package retrofit.steps;

import model.BoardData;
import org.testng.Assert;
import retrofit.BaseTestRetrofit;
import retrofit2.Response;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ChangeName extends BaseTestRetrofit {
    private BoardData expectedBoardData;
    private String newBoardName;
    private String actualBoardId;
    private Response<BoardData> response;

    public void preparePayload() {
        newBoardName = "goodName";
        actualBoardId = properties.getBoardId();
    }

    public void sendRequest() throws IOException {
        response = trelloBoardService
                .changeBoardName(
                        properties.getBoardId(),
                        key,
                        token,
                        newBoardName)
                .execute();
        expectedBoardData = response.body();
        saveBoardDataInProperties(expectedBoardData);
    }

    public void assertResponse() {
        Assert.assertTrue(response.isSuccessful());
        Assert.assertEquals(newBoardName, expectedBoardData.getName());
        Assert.assertEquals(actualBoardId, expectedBoardData.getBoardId());

        assertThat(newBoardName).isNotNull().isEqualTo(expectedBoardData.getName());
        assertThat(actualBoardId).isNotNull().isEqualTo(expectedBoardData.getBoardId());
    }
}
