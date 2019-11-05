package com.connectfour.dto;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class UserDTO {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int UserId;
    private String UserName;
    private String UserPassword;
    private short Wins;
    private String BoardColor;
    private String MyColor;
    private String OpponentColor;
    
    public UserDTO()
    {
        super();
    }
    
    public UserDTO(int id, String name, String password, short wins,
            String boardColor, String myColor, String opponentColor)
    {
        super();
        this.UserId = id;
        this.UserName = name;
        this.UserPassword = password;
        this.Wins = wins;
        this.BoardColor = boardColor;
        this.MyColor = myColor;
        this.OpponentColor = opponentColor;
    }
    
    @Override
    public String toString()
    {
        return "Users [UserId=" + this.UserId + ", UserName=" + this.UserName
                + ", UserPassword=" + this.UserPassword + ", Wins=" + this.Wins
                + ", BoardColor=" + this.BoardColor + ", MyColor="
                +this.MyColor + ", OpponentColor=" + this.OpponentColor + "]";
    }
}
