package com.connectfour.service;
import com.connectfour.gameData.BoardPiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connectfour.repository.GameBoardRepositoryImpl;
import java.util.List;

@Service("gameBoardService")
public class GameBoardServiceImpl implements GameBoardService{
    @Autowired
    GameBoardRepositoryImpl GameBoardRepo;
    
    public List<BoardPiece> getGameBoard(int gameId)
    {
        return GameBoardRepo.getGameBoard(gameId);
    }
    
    public void playPiece(int gameId, int playerId, short x, short y)
    {
        GameBoardRepo.playPiece(gameId, playerId, x, y);
    }
    
    public short getGameState(int gameId, int playerId, short x, short y)
    {
        return GameBoardRepo.getGameState(gameId, playerId, x, y);
    }
}
