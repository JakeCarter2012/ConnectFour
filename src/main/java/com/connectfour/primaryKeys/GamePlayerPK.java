package com.connectfour.primaryKeys;

public class GamePlayerPK {
    private int GameId;
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
