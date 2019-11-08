package com.connectfour.forms;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserIdentificationForm {
    @JsonProperty("UserId")
    private int UserId;
    @JsonProperty("UserName")
    private String UserName;
    
    public UserIdentificationForm() {}
    
    public UserIdentificationForm(int id, String name)
    {
        this.UserId = id;
        this.UserName = name;
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
}
