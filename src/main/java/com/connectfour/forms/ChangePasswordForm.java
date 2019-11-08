package com.connectfour.forms;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangePasswordForm {
    @JsonProperty("UserId")
    private int UserId;
    @JsonProperty("OldPassword")
    private String OldPassword;
    @JsonProperty("NewPassword")
    private String NewPassword;
    
    public ChangePasswordForm() {}
    
    public ChangePasswordForm (int id, String oldPassword, String newPassword)
    {
        this.UserId = id;
        this.OldPassword = oldPassword;
        this.NewPassword = newPassword;
    }
    
    public void SetUserId(int id)
    {
        this.UserId = id;
    }
    
    public int GetUserId()
    {
        return this.UserId;
    }
    
    public void setOldPassword(String password)
    {
        this.OldPassword = password;
    }
    
    public String getOldPassword()
    {
        return this.OldPassword;
    }
    
    public void setNewPassword(String password)
    {
        this.NewPassword = password;
    }
    
    public String getNewPassword()
    {
        return this.NewPassword;
    }
}
