package retrofit.steps;

import model.BoardData;
import org.testng.Assert;
import retrofit.BaseTestRetrofit;
import retrofit2.Response;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateBoard extends BaseTestRetrofit {
    private BoardData expectedBoardData;
    private String actualBoardName;
    private Response<BoardData> response;

    public void preparePayload() {
        actualBoardName = "blablabla";
    }

    public void sendRequest() throws IOException {
        response = trelloBoardService
                .createBoard(
                        actualBoardName,
                        key,
                        token)
                .execute();
        expectedBoardData = response.body();

        assert expectedBoardData != null;
        saveBoardDataInProperties(expectedBoardData);
    }

    public void assertResponse() {
        Assert.assertTrue(response.isSuccessful());
        Assert.assertEquals(actualBoardName, expectedBoardData.getName());

        assertThat(actualBoardName)
                .isNotNull()
                .isEqualTo(expectedBoardData.getName());
    }
}
