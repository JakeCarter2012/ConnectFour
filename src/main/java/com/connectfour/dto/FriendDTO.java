package com.connectfour.dto;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(FriendPK.class)
public class FriendDTO {
    @Id
    private int FriendOne;
    @Id
    private int FriendTwo;
    private boolean Accepted;
    
    public FriendDTO()
    {
        super();
    }
    
    public FriendDTO(int friendOne, int friendTwo, boolean accepted)
    {
        super();
        this.FriendOne = friendOne;
        this.FriendTwo = friendTwo;
        this.Accepted = accepted;
    }
    
    @Override
    public String toString()
    {
        return "Friend [FriendOne=" + this.FriendOne + ", FriendTwo=" + this.FriendTwo
                + ", Accepted=" + this.Accepted + "]";
    }
}
