package com.connectfour.repository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.connectfour.dto.UserDTO;

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
        Transaction tx = session.beginTransaction();
        session.save(newUser);
        tx.commit();
        session.close();
    }
}
