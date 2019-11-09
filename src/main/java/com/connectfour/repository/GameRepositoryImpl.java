package com.connectfour.repository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.connectfour.dto.GameDTO;
import com.connectfour.dto.GamePlayerDTO;
import com.connectfour.gameData.PersonalGame;
import java.util.ArrayList;

@Repository
public class GameRepositoryImpl implements GameRepository{
    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    
    public int createGame(int playerIdOne, int playerIdTwo)
    {
        GameDTO newGame = new GameDTO(0, playerIdOne);
        
        Session session = sessionFactory.openSession();
        
        try
        {
            Transaction tx = session.beginTransaction();
            session.save(newGame);
            tx.commit();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
        
        this.addPlayers(newGame.getGameId(), playerIdOne, playerIdTwo);
        
        return newGame.getGameId();
    }
    
    private void addPlayers(int gameId, int playerOneId, int playerTwoId)
    {
        GamePlayerDTO playerOne = new GamePlayerDTO(gameId, playerOneId);
        GamePlayerDTO playerTwo = new GamePlayerDTO(gameId, playerTwoId);
        
        Session session = sessionFactory.openSession();
        
        try
        {
            Transaction tx = session.beginTransaction();
            session.save(playerOne);
            session.save(playerTwo);
            tx.commit();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
    }
    
    public void endGame(int gameId)
    {
        Session session = sessionFactory.openSession();
        
        try
        {
            Transaction tx = session.beginTransaction();
            GameDTO game = (GameDTO)session.get(GameDTO.class, gameId);
            session.delete(game);
            tx.commit();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
    }
    
    public List<PersonalGame> getPersonalGames(int playerId)
    {
        List<PersonalGame> personalGames = new ArrayList<PersonalGame>();
        
        Session session = sessionFactory.openSession();
        
        try
        {
            Query query = session.createQuery("SELECT player.GameId, opponent.UserName "
                    + "FROM GamePlayerDTO player "
                    + "INNER JOIN GamePlayerDTO opponentPlayer "
                    + "INNER JOIN UserDTO opponent "
                    + "WHERE opponentPlayer.UserId <> player.UserId "
                    + "AND opponentPlayer.GameId = player.GameId "
                    + "AND opponentPlayer.UserId = opponent.UserId "
                    + "AND player.UserId = " + playerId);
            personalGames = query.list();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
        return personalGames;
    }
}
