package com.connectfour.dto;
import java.io.Serializable;
        
public class FriendPK implements Serializable{
    protected int FriendOne;
    protected int FriendTwo;
    
    
    public FriendPK() {}
    
    public FriendPK(int friendOne, int friendTwo)
    {
        this.FriendOne = friendOne;
        this.FriendTwo = friendTwo;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null || obj.getClass() != this.getClass())
        {
            return false;
        }
        
        if(this.FriendOne == ((FriendPK)obj).FriendOne && 
                this.FriendTwo == ((FriendPK)obj).FriendTwo)
        {
            return true;
        }
        else if(this.FriendOne == ((FriendPK)obj).FriendTwo && 
                this.FriendTwo == ((FriendPK)obj).FriendOne){
            return true;
        }
        return false;
    }
    
    @Override 
    public int hashCode() 
    {
        int hash = 7;
        
        hash = 31 * hash + this.FriendOne;
        hash = 31 * hash + this.FriendTwo;
        
        return hash;
    }
}
