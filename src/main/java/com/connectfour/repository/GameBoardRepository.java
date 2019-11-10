package com.connectfour.repository;
import com.connectfour.gameData.BoardPiece;
import java.util.List;

public interface GameBoardRepository {
    public List<BoardPiece> getGameBoard(int gameId);
    
    public void playPiece(int gameId, int playerId, short x, short y);
    
    public short getGameState(int gameId, int playerId, short x, short y);
}
