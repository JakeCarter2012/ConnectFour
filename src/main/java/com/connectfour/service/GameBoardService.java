package com.connectfour.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connectfour.repository.GameBoardRepository;

@Service
public class GameBoardService {
    @Autowired
    GameBoardRepository GameBoardRepo;
}