package com.connectfour.dto;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class GameDTO {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int GameId;
    private int PlayerOne;
    private int PlayerTwo;
    private boolean Turn;
    
    public GameDTO()
    {
        super();
    }
    
    public GameDTO(int id, int playerOne, int playerTwo, boolean turn)
    {
        super();
        this.GameId = id;
        this.PlayerOne = playerOne;
        this.PlayerTwo = playerTwo;
        this.Turn = turn;
    }
    
    @Override
    public String toString()
    {
        return "Games [GameId =" + this.GameId + ", PlayerOne=" + this.PlayerOne
                + ", PlayerTwo=" + this.PlayerTwo + ", Turn=" + this.Turn + "]";
    }
}
