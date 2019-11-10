package com.connectfour.forms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayPieceForm {
    @JsonProperty("GameId")
    private int GameId;
    @JsonProperty("TokenX")
    private short TokenX;
    @JsonProperty("TokenY")
    private short TokenY;
    @JsonProperty("PlayedBy")
    private int PlayedBy;
    
    public PlayPieceForm() {}
    
    public PlayPieceForm(int id, short x, short y, int playedBy)
    {
        this.GameId = id;
        this.TokenX = x;
        this.TokenY = y;
        this.PlayedBy = playedBy;
    }
    
    public void setGameId(int id)
    {
        this.GameId = id;
    }
    
    public int getGameId()
    {
        return this.GameId;
    }
    
    public void setTokenX(short x)
    {
        this.TokenX = x;
    }
    
    public short getTokenX()
    {
        return this.TokenX;
    }
    
    public void setTokenY(short y)
    {
        this.TokenX = y;
    }
    
    public short getTokenY()
    {
        return this.TokenY;
    }
    
    public void setPlayedBy(int playedBy)
    {
        this.PlayedBy = playedBy;
    }
    
    public int getPlayedBy()
    {
        return this.PlayedBy;
    }
}
