package com.connectfour.forms;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginForm {
    @JsonProperty("UserName")
    private String UserName;
    @JsonProperty("UserPassword")
    private String UserPassword;
    
    public LoginForm() {}
    
    public LoginForm (String name, String password)
    {
        this.UserName = name;
        this.UserPassword = password;
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
}
