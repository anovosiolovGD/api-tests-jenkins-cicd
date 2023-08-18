package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardData {
    @JsonProperty("id")
    private String boardId;
    @JsonProperty("name")
    private String name;

    public BoardData(String id, String name) {
        this.boardId = id;
        this.name = name;
    }

    public BoardData() {
    }

    public String getBoardId() {
        return boardId;
    }

    public String getName() {
        return name;
    }
}
