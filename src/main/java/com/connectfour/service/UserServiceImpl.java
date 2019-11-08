package com.connectfour.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connectfour.repository.UserRepositoryImpl;
import java.util.HashMap;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepositoryImpl UserRepo;
    
    public void addUser(int id, String name, String password, short wins,
            String boardColor, String myColor, String opponentColor)
    {
        UserRepo.addUser(id, name, password, wins, boardColor, myColor, opponentColor);
    }
    
    public int getUserId(String name, String password)
    {
        return UserRepo.getUserId(name, password);
    }
    
    public HashMap<String, String> getUserPreferences(int id, String userName)
    {
        return UserRepo.getUserPreferences(id, userName);
    }
    
    public short getUserWins(String userName)
    {
        return UserRepo.getUserWins(userName);
    }
    
    public void changeColors(int id, String userName, String boardColor, String myColor, String opponentColor)
    {
        UserRepo.changeColors(id, userName, boardColor, myColor, opponentColor);
    }
    
    public boolean changePassword(int id, String oldPassword, String newPassword)
    {
        return UserRepo.changePassword(id, oldPassword, newPassword);
    }
    
    public void addWin(int id, String userName)
    {
        UserRepo.addWin(id, userName);
    }
}
