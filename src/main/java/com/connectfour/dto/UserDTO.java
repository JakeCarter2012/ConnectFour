package com.connectfour.dto;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserId;
    private String UserName;
    private String UserPassword;
    private short Wins;
    private String BoardColor;
    private String MyColor;
    private String OpponentColor;
    
    public UserDTO() {}
    
    public UserDTO(int id, String name, String password, short wins,
            String boardColor, String myColor, String opponentColor)
    {
        this.UserId = id;
        this.UserName = name;
        this.UserPassword = password;
        this.Wins = wins;
        this.BoardColor = boardColor;
        this.MyColor = myColor;
        this.OpponentColor = opponentColor;
    }
    
    public void setUserId(int id)
    {
        this.UserId = id;
    }
    
    public int getUserId()
    {
        return this.UserId;
    }
    
    public void setUserName(String name)
    {
        this.UserName = name;
    }
    
    public String getUserName()
    {
        return this.UserName;
    }
    
    public void setUserPassword(String password)
    {
        this.UserPassword = password;
    }
    
    public String getUserPassword()
    {
        return this.UserPassword;
    }
    
    public void setWins(short wins)
    {
        this.Wins = wins;
    }
    
    public short getWins()
    {
        return this.Wins;
    }
    
    public void setBoardColor(String color)
    {
        this.BoardColor = color;
    }
    
    public String getBoardColor()
    {
        return this.BoardColor;
    }
    
    public void setMyColor(String color)
    {
        this.MyColor = color;
    }
    
    public String getMyColor()
    {
        return this.MyColor;
    }
    
    public void setOpponentColor(String color)
    {
        this.OpponentColor = color;
    }
    
    public String getOpponentColor()
    {
        return this.OpponentColor;
    }
    
    @Override
    public String toString()
    {
        return "UserDTO [UserId=" + this.UserId + ", UserName=" + this.UserName
                + ", UserPassword=" + this.UserPassword + ", Wins=" + this.Wins
                + ", BoardColor=" + this.BoardColor + ", MyColor="
                +this.MyColor + ", OpponentColor=" + this.OpponentColor + "]";
    }
}
