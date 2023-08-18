package retrofit;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import retrofit.steps.ChangeName;
import retrofit.steps.CreateBoard;
import retrofit.steps.DeleteBoard;
import retrofit.steps.GetBoard;

import java.io.IOException;
@Listeners({AllureTestNg.class})
public class TrelloTestsWithRetrofit extends BaseTestRetrofit {
    @Test(priority = 1)
    @Description("Test to verify POST request")
    public void createBoardTest() throws IOException {

        CreateBoard steps = new CreateBoard();
        steps.initializeProperties();
        steps.preparePayload();
        steps.sendRequest();
        steps.assertResponse();
    }

    @Test(priority = 2)
    @Description("Test to verify GET request")
    public void getBoardTest() throws IOException {
        GetBoard steps = new GetBoard();
        steps.initializeProperties();
        steps.preparePayload();
        steps.sendRequest();
        steps.assertResponse();
    }
    @Test (priority = 3)
    @Description("Test to verify PUT request")
    public void changeBoardName () throws IOException {
        ChangeName steps = new ChangeName();
        steps.initializeProperties();
        steps.preparePayload();
        steps.sendRequest();
        steps.assertResponse();
    }
    @Test (priority = 4)
    @Description("Test to verify DELETE request")
    public void deleteBoard () throws IOException{
        DeleteBoard steps = new DeleteBoard();
        steps.initializeProperties();
        steps.preparePayload();
        steps.sendRequest();
        steps.assertResponse();
    }
}
