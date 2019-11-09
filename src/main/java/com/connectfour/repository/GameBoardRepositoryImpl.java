package com.connectfour.repository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.connectfour.dto.GameBoardDTO;
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
    
    public List<GameBoardDTO> getGameBoard(int gameId)
    {
        List<GameBoardDTO> board = new ArrayList<GameBoardDTO>();
        
        Session session = sessionFactory.openSession();
        
        try
        {
            Query query = session.createQuery("SELECT board FROM GameBoardDTO "
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
    
    public void playPiece(int gameId, int playerId, short x, short y)
    {
        GameBoardDTO piece = new GameBoardDTO(gameId, x, y, playerId);
        
        Session session = sessionFactory.openSession();
        
        try
        {
            Transaction tx = session.beginTransaction();
            session.save(piece);
            tx.commit();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
    }
    
    private short rowChecker(List<GameBoardDTO> board, int gameId, int playerId, 
            short x, short y, short xShift, short yShift)
    {
        short row = 0;
        
        for(short i = 1; i < 4; i ++)
        {
            if(board.contains(new GameBoardDTO(gameId, (short)(x + i * xShift), 
                    (short)(y + i * yShift), playerId)))
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
    
    public short getGameState(int gameId, int playerId, short x, short y)
    {
        List<GameBoardDTO> board = this.getGameBoard(gameId);
        
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
        rightDiag = this.rowChecker(board, gameId, playerId, x, y, (short)-1, (short)-1);
        
        if(rightDiag > 2)
        {
            return 1;
        }
        
        short leftDiag = this.rowChecker(board, gameId, playerId, x, y, (short)1, (short)-1);
        leftDiag = this.rowChecker(board, gameId, playerId, x, y, (short)-1, (short)1);
        
        if(leftDiag > 2)
        {
            return 1;
        }
        
        if(board.size() == 49)
        {
            return -1;
        }
        
        return 0;
    }
}
