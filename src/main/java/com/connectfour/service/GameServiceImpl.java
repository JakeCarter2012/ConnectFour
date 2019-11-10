package com.connectfour.service;
import com.connectfour.gameData.PersonalGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connectfour.repository.GameRepositoryImpl;
import java.util.List;

@Service("gameService")
public class GameServiceImpl implements GameService{
    @Autowired
    GameRepositoryImpl GameRepo;
    
    public int createGame(int playerIdOne, int playerIdTwo)
    {
        return GameRepo.createGame(playerIdOne, playerIdTwo);
    }
    
    public void endGame(int gameId)
    {
        GameRepo.endGame(gameId);
    }
    
    public List<PersonalGame> getPersonalGames(int playerId)
    {
        return GameRepo.getPersonalGames(playerId);
    }
    
    public boolean forfeitGame(int gameID, int userId)
    {
        return GameRepo.forfeitGame(gameID, userId);
    }
    
    public int getTurn(int gameId)
    {
        return GameRepo.getTurnId(gameId);
    }
    
    public String getTurnName(int gameId)
    {
        return GameRepo.getTurnName(gameId);
    }
}
