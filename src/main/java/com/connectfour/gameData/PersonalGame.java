package com.connectfour.gameData;

public class PersonalGame {
    private int GameId;
    private String UserName;
    
    public PersonalGame() {}
    
    public PersonalGame(int id, String name)
    {
        this.GameId = id;
        this.UserName = name;
    }
    
    public void setGameId(int id)
    {
        this.GameId = id;
    }
    
    public int getGameId()
    {
        return this.GameId;
    }
    
    public void setOpponentName(String name)
    {
        this.UserName = name;
    }
    
    public String getOpponentName()
    {
        return this.UserName;
    }
}
