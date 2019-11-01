package com.connectfour.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connectfour.repository.GameRepository;

@Service
public class GameService {
    @Autowired
    GameRepository GameRepo;
}
