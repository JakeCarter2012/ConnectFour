package com.connectfour.primaryKeys;
import java.io.Serializable;
import javax.persistence.Id;
        
public class GameBoardPK implements Serializable{
    @Id
    protected int GameId;
    @Id
    protected short TokenX;
    @Id
    protected short TokenY;
    
    public GameBoardPK() {}
    
    public GameBoardPK(int gameId, short x, short y)
    {
        this.GameId = gameId;
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
    public boolean equals(Object obj)
    {
        if(obj == null || obj.getClass() != this.getClass())
        {
            return false;
        }
        
        if(this.GameId == ((GameBoardPK)obj).GameId && 
                this.TokenX == ((GameBoardPK)obj).TokenX &&
                this.TokenY == ((GameBoardPK)obj).TokenY)
        {
            return true;
        }
        return false;
    }
    
    @Override 
    public int hashCode() 
    {
        int hash = 7;
        
        hash = 31 * hash + this.GameId;
        hash = 31 * hash + this.TokenX;
        hash = 31 * hash + this.TokenY;
        
        return hash;
    }
}
