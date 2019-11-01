package com.connectfour.service;

public interface UserService {
    public void addUser(int id, String name, String password, short wins,
            String boardColor, String myColor, String opponentColor);
}
