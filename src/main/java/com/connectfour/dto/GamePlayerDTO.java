package com.connectfour.dto;
import com.connectfour.primaryKeys.GamePlayerPK;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "GamePlayers")
@IdClass(GamePlayerPK.class)
public class GamePlayerDTO {
    @Id
    private int GameId;
    @Id
    private int UserId;
    
    public GamePlayerDTO() {}
    
    public GamePlayerDTO(int gameId, int playerId)
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
    public String toString()
    {
        return "Games [GameId =" + this.GameId + ", UserId=" + this.UserId + "]";
    }
}
