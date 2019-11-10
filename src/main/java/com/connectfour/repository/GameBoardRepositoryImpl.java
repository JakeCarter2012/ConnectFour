package com.connectfour.repository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.connectfour.dto.GameBoardDTO;
import com.connectfour.dto.GameDTO;
import com.connectfour.gameData.BoardPiece;
import com.connectfour.gameData.PersonalGame;
import java.util.ArrayList;

@Repository
public class GameBoardRepositoryImpl implements GameBoardRepository{
    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    
    //returns a list of the pieces in play for the game.
    //to be consumed by users. changes the player id's to player names.
    public List<BoardPiece> getGameBoard(int gameId)
    {
        List<BoardPiece> board = new ArrayList<BoardPiece>();
        
        Session session = sessionFactory.openSession();
        
        try
        {
            Query query = session.createQuery("SELECT board.TokenX, board.TokenY, player.UserName "
                    + "FROM GameBoardDTO board "
                    + "INNER JOIN UserDTO player "
                    + "ON board.PlayedBy = player.UserId "
                    + "WHERE board.GameId = " + gameId);
            board = query.list();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
        return board;
    }
    
    //returns a list of the ieces in play for the given game.
    //for internal use
    private List<GameBoardDTO> getGameBoardDTO(int gameId)
    {
        List<GameBoardDTO> board = new ArrayList<GameBoardDTO>();
        
        Session session = sessionFactory.openSession();
        
        try
        {
            Query query = session.createQuery("SELECT board FROM GameBoardDTO board "
                    + "WHERE board.GameId = " + gameId);
            board = query.list();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
        return board;
    }
    
    //Creates a new piece and adds it to GameBoards table,
    //then updates the Game table to the other player's turn
    public void playPiece(int gameId, int playerId, short x, short y)
    {
        GameBoardDTO piece = new GameBoardDTO(gameId, x, y, playerId);
        
        Session session = sessionFactory.openSession();
        
        try
        {
            Transaction tx = session.beginTransaction();
            session.save(piece);
            Query query = session.createQuery("SELECT opponent.UserId "
                    + "FROM GamePlayerDTO opponent "
                    + "WHERE opponent.UserId <> " + playerId
                    + " AND opponent.GameId = " + gameId);
            int id = (int)query.uniqueResult();
            GameDTO game = (GameDTO)session.get(GameDTO.class, gameId);
            game.setTurn(id);
            session.save(game);
            tx.commit();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
    }
    
    //Adds up any connected pieces to check for 4 connected;
    //use -1, 0, or 1 for xShift/yShift to indicate the direction
    private short rowChecker(List<GameBoardDTO> board, int gameId, int playerId, 
            short x, short y, short xShift, short yShift)
    {
        short row = 0;
        
        for(short i = 1; i < 4; i ++)
        {
            GameBoardDTO connectedPiece = new GameBoardDTO(gameId, (short)(x + i * xShift), 
                    (short)(y + i * yShift), playerId);
            if(board.contains(connectedPiece))
            {
                row++;
            }
            else
            {
                break;
            }
        }
        
        return row;
    }
    
    //checks to see if the played piece connects four in a row;
    //returns 1 if four or more are connected,
    //returns -1 if the board is full and there is not 4 in a row,
    //or returns 0, indicating there wasn't 4 in a row and the game can continue.
    public short getGameState(int gameId, int playerId, short x, short y)
    {
        List<GameBoardDTO> board = this.getGameBoardDTO(gameId);
        
        short horizontal = this.rowChecker(board, gameId, playerId, x, y, (short)1, (short)0);
        horizontal +=this.rowChecker(board, gameId, playerId, x, y, (short)-1, (short)0);
        
        if(horizontal > 2)
        {
            return 1;
        }
        
        short vertical = this.rowChecker(board, gameId, playerId, x, y, (short)0, (short)1);
        vertical += this.rowChecker(board, gameId, playerId, x, y, (short)0, (short)-1);
        
        if(vertical > 2)
        {
            return 1;
        }
        
        short rightDiag = this.rowChecker(board, gameId, playerId, x, y, (short)1, (short)1);
        rightDiag += this.rowChecker(board, gameId, playerId, x, y, (short)-1, (short)-1);
        
        if(rightDiag > 2)
        {
            return 1;
        }
        
        short leftDiag = this.rowChecker(board, gameId, playerId, x, y, (short)1, (short)-1);
        leftDiag += this.rowChecker(board, gameId, playerId, x, y, (short)-1, (short)1);
        
        if(leftDiag > 2)
        {
            return 1;
        }
        
        if(board.size() >= 48)
        {
            return -1;
        }
        
        return 0;
    }
}
