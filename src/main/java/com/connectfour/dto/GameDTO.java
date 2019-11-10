package com.connectfour.dto;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
@Entity
@Table(name = "Games")
public class GameDTO {
    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int GameId;
    private int Turn;
    
    public GameDTO() {}
    
    public GameDTO(int id, int turn)
    {
        this.GameId = id;
        this.Turn = turn;
    }
    
    public void setGameId(int id)
    {
        this.GameId = id;
    }
    
    public int getGameId()
    {
        return this.GameId;
    }  
    
    public void setTurn(int turn)
    {
        this.Turn = turn;
    }
    
    public int getTurn()
    {
        return this.Turn;
    }
    
    @Override
    public String toString()
    {
        return "Games [GameId =" + this.GameId + ", Turn=" + this.Turn + "]";
    }
}
