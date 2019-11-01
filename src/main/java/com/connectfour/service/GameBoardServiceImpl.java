package com.connectfour.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connectfour.repository.GameBoardRepositoryImpl;

@Service("gameBoardService")
public class GameBoardServiceImpl implements GameBoardService{
    @Autowired
    GameBoardRepositoryImpl GameBoardRepo;
}
