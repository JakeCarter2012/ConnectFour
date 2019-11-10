package com.connectfour.primaryKeys;

import java.io.Serializable;
import javax.persistence.Id;

public class GamePlayerPK implements Serializable{
    @Id
    private int GameId;
    @Id
    private int UserId;
    
    public GamePlayerPK() {}
    
    public GamePlayerPK(int gameId, int playerId)
    {
        this.GameId = gameId;
        this.UserId = playerId;
    }
    
    public void setGameId(int id)
    {
        this.GameId = id;
    }
    
    public int getGameId()
    {
        return this.GameId;
    }    
    
    public void setUserId(int id)
    {
        this.UserId = id;
    }
    
    public int getUserId()
    {
        return this.UserId;
    }  
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null || obj.getClass() != this.getClass())
        {
            return false;
        }
        
        if(this.GameId == ((GamePlayerPK)obj).GameId && 
                this.UserId == ((GamePlayerPK)obj).UserId)
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
        hash = 31 * hash + this.UserId;
        
        return hash;
    }
}
