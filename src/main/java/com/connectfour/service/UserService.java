package com.connectfour.service;
import java.util.HashMap;

public interface UserService {
    public void addUser(int id, String name, String password, short wins,
            String boardColor, String myColor, String opponentColor);
    
    public int getUserId(String name, String password);
    
    public HashMap<String, String> getUserPreferences(int id, String userName);
    
    public short getUserWins(String userName);
    
    public void changeColors(int id, String userName, String boardColor, String myColor, String opponentColor);
    
    public boolean changePassword(int id, String oldPassword, String newPassword);
    
    public void addWin(int id, String userName);
}
