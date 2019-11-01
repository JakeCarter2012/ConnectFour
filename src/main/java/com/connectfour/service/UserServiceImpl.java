package com.connectfour.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connectfour.repository.UserRepositoryImpl;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepositoryImpl UserRepo;
    
    public void addUser(int id, String name, String password, short wins,
            String boardColor, String myColor, String opponentColor)
    {
        UserRepo.addUser(id, name, password, wins, boardColor, myColor, opponentColor);
    }
}
