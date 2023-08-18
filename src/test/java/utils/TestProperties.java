package utils;

import org.aeonbits.owner.ConfigFactory;

public class TestProperties {
    private final ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    private final String url = configProperties.url();
    private final String key = configProperties.key();
    private final String token = configProperties.token();
    private final String boardId = ConfigFactory.getProperty("boardId");
    private final String boardName = ConfigFactory.getProperty("name");

    public String getBoardName() {
        return boardName;
    }

    public String getBoardId() {
        return boardId;
    }

    public String getUrl() {
        return url;
    }

    public String getKey() {
        return key;
    }

    public String getToken() {
        return token;
    }

    public static TestProperties getProperties() {
        return new TestProperties();
    }
}
