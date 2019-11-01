package com.connectfour.repository;
import com.connectfour.dto.UserDTO;

public interface UserRepository {
    public void addUser(int id, String name, String password, short wins,
            String boardColor, String myColor, String opponentColor);
}
