package com.connectfour.gameData;

import com.fasterxml.jackson.annotation.JsonProperty;


public class BoardPiece {
    @JsonProperty("UserName")
    private String UserName;
    @JsonProperty("TokenX")
    private short TokenX;
    @JsonProperty("TokenY")
    private short TokenY;
    
    public BoardPiece() {}
    
    public BoardPiece(String name, short x, short y)
    {
        this.UserName = name;
        this.TokenX = x;
        this.TokenY = y;
    }
    
    public void setUserName(String name)
    {
        this.UserName = name;
    }
    
    public String getUserName()
    {
        return this.UserName;
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
}
