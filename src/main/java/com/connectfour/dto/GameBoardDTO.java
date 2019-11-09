package com.connectfour.dto;
import com.connectfour.primaryKeys.GameBoardPK;
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
    private int PlayedBy;
    
    public GameBoardDTO() {}
    
    public GameBoardDTO(int id, short x, short y, int playedBy)
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
    
    public void setPlayeddBy(int playedBy)
    {
        this.PlayedBy = playedBy;
    }
    
    public int getPlayeddBy()
    {
        return this.PlayedBy;
    }
    
    @Override
    public String toString()
    {
        return "GameBoard [GameId=" + this.GameId + ", TokenX=" + this.TokenX
                + ", TokenY" + this.TokenY + ", PlayedBy=" + this.PlayedBy + "]";
    }
}
