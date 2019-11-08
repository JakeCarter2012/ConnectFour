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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int GameId;
    private int PlayerOne;
    private int PlayerTwo;
    private boolean Turn;
    
    public GameDTO() {}
    
    public GameDTO(int id, int playerOne, int playerTwo, boolean turn)
    {
        this.GameId = id;
        this.PlayerOne = playerOne;
        this.PlayerTwo = playerTwo;
        this.Turn = turn;
    }
    
    public void setGameId(int id)
    {
        this.GameId = id;
    }
    
    public int getGameId()
    {
        return this.getGameId();
    }
    
    public void setPlayerOne(int player)
    {
        this.PlayerOne = player;
    }
    
    public int getPlayerOne()
    {
        return this.PlayerOne;
    }
    
    public void setPlayerTwo(int player)
    {
        this.PlayerTwo = player;
    }
    
    public int getPlayerTwo()
    {
        return this.PlayerTwo;
    }
    
    public void setTurn(boolean turn)
    {
        this.Turn = turn;
    }
    
    public boolean getTurn()
    {
        return this.Turn;
    }
    
    @Override
    public String toString()
    {
        return "Games [GameId =" + this.GameId + ", PlayerOne=" + this.PlayerOne
                + ", PlayerTwo=" + this.PlayerTwo + ", Turn=" + this.Turn + "]";
    }
}
