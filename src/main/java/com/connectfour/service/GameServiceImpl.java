package com.connectfour.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connectfour.repository.GameRepositoryImpl;

@Service("gameService")
public class GameServiceImpl implements GameService{
    @Autowired
    GameRepositoryImpl GameRepo;
}
