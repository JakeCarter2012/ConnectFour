package com.connectfour.forms;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ColorChangeForm {
    @JsonProperty("UserId")
    private int UserId;
    @JsonProperty("UserName")
    private String UserName;
    @JsonProperty("BoardColor")
    private String BoardColor;
    @JsonProperty("MyColor")
    private  String MyColor;
    @JsonProperty("OpponentColor")
    private String OpponentColor;
    
    public ColorChangeForm() {}
    
    public ColorChangeForm(int id, String name, String boardColor, String myColor, 
            String opponentColor)
    {
        this.UserId = id;
        this.UserName = name;
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
}