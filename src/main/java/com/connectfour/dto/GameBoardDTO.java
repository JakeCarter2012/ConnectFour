package com.connectfour.dto;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "GameBoards")
@IdClass(GameBoardPK.class)
public class GameBoardDTO {
    @Id
    private int GameId;
    @Id
    private short TokenX;
    @Id
    private short TokenY;
    
    public GameBoardDTO() {}
    
    public GameBoardDTO(int id, short x, short y)
    {
        this.GameId = id;
        this.TokenX = x;
        this.TokenY = y;
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
    
    @Override
    public String toString()
    {
        return "GameBoard [GameId=" + this.GameId + ", TokenX=" + this.TokenX
                + ", TokenY" + this.TokenY + "]";
    }
}
