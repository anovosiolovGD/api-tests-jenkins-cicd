package api;

import model.BoardData;
import org.aeonbits.owner.ConfigFactory;
import utils.RestAssuredSpecifications;
import utils.TestProperties;

public class BaseTest {
    protected TestProperties properties;
    protected String url;
    protected String key;
    protected String token;

    public void initializeProperties() {
        properties = TestProperties.getProperties();
        url = properties.getUrl();
        key = properties.getKey();
        token = properties.getToken();
    }

    protected void saveBoardDataInProperties(BoardData expectedBoardData) {
        ConfigFactory.setProperty("name", expectedBoardData.getName());
        ConfigFactory.setProperty("boardId", expectedBoardData.getBoardId());
    }

    public void restAssuredSpecsSetup(){
        RestAssuredSpecifications.setSpecs(url);
    }
}
