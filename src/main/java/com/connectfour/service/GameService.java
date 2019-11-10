package com.connectfour.service;

import com.connectfour.gameData.PersonalGame;
import java.util.List;

public interface GameService {
    public int createGame(int playerIdOne, int playerIdTwo);
    
    public void endGame(int gameId);
    
    public List<PersonalGame> getPersonalGames(int playerId);
    
    public boolean forfeitGame(int gameID, int userId);
    
    public int getTurn(int gameId);
    
    public String getTurnName(int gameId);
}
