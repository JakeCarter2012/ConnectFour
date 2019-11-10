package com.connectfour.forms;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewGameForm {
    @JsonProperty("PlayerOne")
    private int PlayerOne;
    @JsonProperty("PlayerTwo")
    private int PlayerTwo;
    
    public NewGameForm() {}
    
    public NewGameForm(int playerOne, int playerTwo)
    {
        this.PlayerOne = playerOne;
        this.PlayerTwo = playerTwo;
    }
    
    public void setPlayerOne(int playerOne)
    {
        this.PlayerOne = playerOne;
    }
    
    public int getPlayerOne()
    {
        return this.PlayerOne;
    }
    
    public void setPlayerTwo(int playerTwo)
    {
        this.PlayerTwo = playerTwo;
    }
    
    public int getPlayerTwo()
    {
        return this.PlayerTwo;
    }
}
