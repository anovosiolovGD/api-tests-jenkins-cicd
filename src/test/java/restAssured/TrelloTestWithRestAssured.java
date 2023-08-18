package restAssured;

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
    public void createBoardTest() {
        CreateBoardSteps steps = new CreateBoardSteps();

        steps.initializeProperties();
        steps.restAssuredSpecsSetup();
        steps.preparePayload();
        steps.sendRequest();
        steps.assertResponse();
    }
    @Test(priority = 2)
    public void getBoardTest() {
        GetBoardSteps steps = new GetBoardSteps();

        steps.initializeProperties();
        steps.restAssuredSpecsSetup();
        steps.preparePayload();
        steps.sendRequest();
        steps.assertResponse();
    }
    @Test(priority = 3)
    public void changeBoardNameTest() {
        ChangeBoardNameStep steps = new ChangeBoardNameStep();

        steps.initializeProperties();
        steps.restAssuredSpecsSetup();
        steps.preparePayload();
        steps.sendRequest();
        steps.assertResponse();
    }
    @Test(priority = 4)
    public void deleteBoardTest() {
        DeleteBoardStep steps = new DeleteBoardStep();

        steps.initializeProperties();
        steps.restAssuredSpecsSetup();
        steps.preparePayload();
        steps.sendRequest();
        steps.assertResponse();
    }
}


