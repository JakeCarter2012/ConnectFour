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
import com.connectfour.dto.UserDTO;
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
    
    //Creates a new game with the given player id's,
    //Then calls addPlayers to add the two players to the GamePLayers table.
    //playerIdOne has the first turn in the game
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
    
    //Adds the two players to the GamePlayers table
    //For internal use only
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
    
    //Used when a game needs to end. 
    //Also removes the GamePlayers and GameBoards piees from their corresponding tables.
    public void endGame(int gameId)
    {
        Session session = sessionFactory.openSession();
        
        try
        {
            Query deleteBoard = session.createQuery("DELETE FROM GameBoardDTO board "
                    + "WHERE board.GameId = " + gameId);
            Query deletePlayers = session.createQuery("DELETE FROM GamePlayerDTO player "
                    + "WHERE player.GameId = " + gameId);
            
            Transaction tx = session.beginTransaction();
            
            deleteBoard.executeUpdate();
            deletePlayers.executeUpdate();
            
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
    
    //Returns a list of GameId's and the Opponent player for that game for the requesting user
    public List<PersonalGame> getPersonalGames(int playerId)
    {
        List<PersonalGame> personalGames = new ArrayList<PersonalGame>();
        
        Session session = sessionFactory.openSession();
        
        try
        {
            Query query = session.createQuery("SELECT player.GameId, opponent.UserName "
                    + "FROM GamePlayerDTO player "
                    + "INNER JOIN GamePlayerDTO opponentPlayer "
                    + "ON opponentPlayer.UserId <> player.UserId "
                    + "AND opponentPlayer.GameId = player.GameId "
                    + "INNER JOIN UserDTO opponent "
                    + "ON opponentPlayer.UserId = opponent.UserId "
                    + "WHERE player.UserId = " + playerId);
            personalGames = query.list();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
        return personalGames;
    }
    
    //Forfeits the specified game. First checks to see that the UserId is part of the game,
    //then adds a win to the opponent user, and ends the game.
    public boolean forfeitGame(int gameID, int userId)
    {
        boolean accepted = false;
        
         Session session = sessionFactory.openSession();
        
        try
        {
            Query query = session.createQuery("SELECT player FROM GamePlayerDTO player "
                    + "WHERE player.GameId = " + gameID
                    + "AND player.UserId = " + userId);
            GamePlayerDTO player = (GamePlayerDTO) query.uniqueResult();
            if(player != null)
            {
                Query winnerQuery = session.createQuery("SELECT player FROM GamePlayerDTO player "
                        + "WHERE player.GameId = " + gameID 
                        + "AND player.UserId <> " + userId); 
                GamePlayerDTO winner = (GamePlayerDTO) winnerQuery.uniqueResult();
                
                UserDTO user = (UserDTO)session.get(UserDTO.class, winner.getUserId());
                
                if(user != null)
                {
                    user.setWins((short)(user.getWins() + 1));

                    Transaction tx = session.beginTransaction();
                    session.update(user);
                    tx.commit();
                }
                
                this.endGame(gameID);
                accepted = true;
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return accepted;
    }
    
    //Returns the id for the current turn's player
    public int getTurnId(int gameId)
    {
        Session session = sessionFactory.openSession();
        int turn = -1;
        
        try
        {
            Transaction tx = session.beginTransaction();
            GameDTO game = (GameDTO)session.get(GameDTO.class, gameId);
            turn = game.getTurn();
            tx.commit();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
        return turn;
    }
    
    //Returns the name for the current turn's player
    public String getTurnName(int gameId)
    {
        Session session = sessionFactory.openSession();
        String turn = "";
        
        try
        {
            Query query = session.createQuery("SELECT user.UserName FROM UserDTO user "
                    + "INNER JOIN GameDTO game "
                    + "ON user.UserId = game.Turn "
                    + "WHERE game.GameId = " + gameId);
            turn = (String) query.uniqueResult();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
        return turn;
    }
}
