package com.connectfour.forms;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IdForm{
    @JsonProperty("Id")
    private int Id;
    
    public IdForm() {}
    
    public IdForm(int id)
    {
        this.Id = id;
    }
    
    public void setId(int id)
    {
        this.Id = id;
    }
    
    public int getId()
    {
        return this.Id;
    }
}