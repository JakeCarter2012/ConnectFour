package com.connectfour.forms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForfeitForm {
    @JsonProperty("GameId")
    private int GameId;
    @JsonProperty("UserId")
    private int UserId;
    
    public ForfeitForm() {}
    
    public ForfeitForm(int gameId, int userId)
    {
        this.GameId = gameId;
        this.UserId = userId;
    }
    
    public void setUserId(int id)
    {
        this.UserId = id;
    }
    
    public int getUserId()
    {
        return this.UserId;
    }
    
    public void setGameId(int id)
    {
        this.GameId = id;
    }
    
    public int getGameId()
    {
        return this.GameId;
    }
}
