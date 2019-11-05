package com.connectfour.dto;
import java.io.Serializable;
        
public class GameBoardPK implements Serializable{
    protected int GameId;
    protected short TokenX;
    protected short TokenY;
    
    public GameBoardPK() {}
    
    public GameBoardPK(int gameId, short x, short y)
    {
        this.GameId = gameId;
        this.TokenX = x;
        this.TokenY = y;
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
