package com.connectfour.repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.connectfour.dto.UserDTO;
import java.util.HashMap;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    
    public void addUser(int id, String name, String password, short wins,
            String boardColor, String myColor, String opponentColor)
    {
        UserDTO newUser = new UserDTO(id, name, password, wins,boardColor, 
                myColor, opponentColor);
        
        Session session = sessionFactory.openSession();
        
        try
        {
            Transaction tx = session.beginTransaction();
            session.save(newUser);
            tx.commit();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
    }
    
    public int getUserId(String name, String password)
    {
        int id = -1;
        Session session = sessionFactory.openSession();
        
        try
        {
            Query query = session.createQuery("SELECT user FROM UserDTO user WHERE "
                    + "user.UserName = :name AND user.UserPassword = :password");
            query.setParameter("name", name);
            query.setParameter("password", password);
            UserDTO user = (UserDTO)query.uniqueResult();
            if(user != null)
            {
                id = user.getUserId();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
        return id;
    }
    
    public HashMap<String, String> getUserPreferences(int id, String userName)
    {
        HashMap<String, String> info = new HashMap<String, String>();
        Session session = sessionFactory.openSession();

        try 
        {
            Query query = session.createQuery("SELECT user FROM UserDTO user WHERE "
                    + "user.UserName = :userName AND user.UserId = :id");
            query.setParameter("userName", userName);
            query.setParameter("id", id);
            UserDTO user = (UserDTO)query.uniqueResult();
            if(user != null)
            {
                info.put("BoardColor", user.getBoardColor());
                info.put("MyColor", user.getMyColor());
                info.put("OpponentColor", user.getOpponentColor());
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
        return info;
    }
    
    public short getUserWins(String userName)
    {
        short wins = 0;
        Session session = sessionFactory.openSession();

        try 
        {
            Query query = session.createQuery("SELECT user FROM UserDTO user WHERE "
                    + "user.UserName = :userName AND user.UserId = :id");
            query.setParameter("userName", userName);
            UserDTO user = (UserDTO)query.uniqueResult();
            if(user != null)
            {
                wins = user.getWins();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
        return wins;
    }
    
    public void changeColors(int id, String userName, String boardColor, String myColor, String opponentColor)
    {
        Session session = sessionFactory.openSession();

        try 
        {
            Query query = session.createQuery("SELECT user FROM UserDTO user WHERE "
                    + "user.UserName = :userName AND user.UserId = :id");
            query.setParameter("userName", userName);
            query.setParameter("id", id);
            UserDTO user = (UserDTO)query.uniqueResult();
            if(user != null)
            {
                user.setBoardColor(boardColor);
                user.setMyColor(myColor);
                user.setOpponentColor(opponentColor);
                
                Transaction tx = session.beginTransaction();
                session.update(user);
                tx.commit();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
    }
    
    public boolean changePassword(int id, String oldPassword, String newPassword)
    {
        Session session = sessionFactory.openSession();
        boolean validPassword = false;

        try 
        {
            Query query = session.createQuery("SELECT user FROM UserDTO user WHERE "
                    + "user.UserPassword = :oldPassword AND user.UserId = :id");
            query.setParameter("oldPassword", oldPassword);
            query.setParameter("id", id);
            UserDTO user = (UserDTO)query.uniqueResult();
            if(user != null)
            {
                user.setUserPassword(newPassword);
                
                Transaction tx = session.beginTransaction();
                session.update(user);
                tx.commit();
                validPassword = true;
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
        return validPassword;
    }
    
    public void addWin(int id, String userName)
    {
        Session session = sessionFactory.openSession();

        try 
        {
            Query query = session.createQuery("SELECT user FROM UserDTO user WHERE "
                    + "user.UserName = :userName AND user.UserId = :id");
            query.setParameter("userName", userName);
            query.setParameter("id", id);
            UserDTO user = (UserDTO)query.uniqueResult();
            if(user != null)
            {
                user.setWins((short)(user.getWins() + 1));
                
                Transaction tx = session.beginTransaction();
                session.update(user);
                tx.commit();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        session.close();
    }
}
