package com.connectfour.dto;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GameBoardDTO {
    @Id
    private int GameId;
    @Id
    private short TokenX;
    @Id
    private short TokenY;
    
    public GameBoardDTO()
    {
        super();
    }
    
    public GameBoardDTO(int id, short x, short y)
    {
        this.GameId = id;
        this.TokenX = x;
        this.TokenY = y;
    }
    
    @Override
    public String toString()
    {
        return "GameBoard [GameId=" + this.GameId + ", TokenX=" + this.TokenX
                + ", TokenY" + this.TokenY + "]";
    }
}