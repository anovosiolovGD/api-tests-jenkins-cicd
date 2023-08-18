package restAssured;

import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import restAssured.testStepsLib.ChangeBoardNameStep;
import restAssured.testStepsLib.CreateBoardSteps;
import restAssured.testStepsLib.DeleteBoardStep;
import restAssured.testStepsLib.GetBoardSteps;

@Listeners({AllureTestNg.class})
public class TrelloTestWithRestAssured {
    @Test(priority = 1)
    @Description("Test to verify POST request")
    public void createBoardTest() {
        CreateBoardSteps steps = new CreateBoardSteps();

        steps.initializeProperties();
        steps.restAssuredSpecsSetup();
        steps.preparePayload();
        steps.sendRequest();
        steps.assertResponse();
    }
    @Test(priority = 2)
    @Description("Test to verify GET request")
    public void getBoardTest() {
        GetBoardSteps steps = new GetBoardSteps();

        steps.initializeProperties();
        steps.restAssuredSpecsSetup();
        steps.preparePayload();
        steps.sendRequest();
        steps.assertResponse();
    }
    @Test(priority = 3)
    @Description("Test to verify PUT request")
    public void changeBoardNameTest() {
        ChangeBoardNameStep steps = new ChangeBoardNameStep();

        steps.initializeProperties();
        steps.restAssuredSpecsSetup();
        steps.preparePayload();
        steps.sendRequest();
        steps.assertResponse();
    }
    @Test(priority = 4)
    @Description("Test to verify DELETE request")
    public void deleteBoardTest() {
        DeleteBoardStep steps = new DeleteBoardStep();

        steps.initializeProperties();
        steps.restAssuredSpecsSetup();
        steps.preparePayload();
        steps.sendRequest();
        steps.assertResponse();
    }
}


