package com.connectfour.forms;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserNameForm{
    @JsonProperty("UserName")
    private String UserName;
    
    public UserNameForm() {}
    
    public UserNameForm(String name)
    {
        this.UserName = name;
    }
    
    public void setUserName(String name)
    {
        this.UserName = name;
    }
    
    public String getUserName()
    {
        return this.UserName;
    }
}