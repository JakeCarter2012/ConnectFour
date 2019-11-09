package com.connectfour.service;

import com.connectfour.dto.GameBoardDTO;
import java.util.List;

public interface GameBoardService {
    public List<GameBoardDTO> getGameBoard(int gameId);
    
    public void playPiece(int gameId, int playerId, short x, short y);
    
    public short getGameState(int gameId, int playerId, short x, short y);
}
