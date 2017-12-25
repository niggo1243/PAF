package main.quizServer;

import main.quizServer.dbModel.*;

import javax.persistence.EntityManagerFactory;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import java.io.Serializable;

public class DbManager extends SingletonInstance implements IDbManager
{
    private SessionFactory sessionFactory;

    //make a private constructor, so only this class can instantiate this object
    private DbManager()
    {
        System.out.println("instantiating the DbManager");
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SingletonInstance getInstance()
    {
        if (instance == null)
        {
            instance = new DbManager();
        }

        return instance;
    }

    public BaseDBmodel getEntityWithId(BaseDBmodel dbModelType, int id)
    {
            try
            {
                // This step will read hibernate.cfg.xml and prepare hibernate for use
                Session session = this.sessionFactory.openSession();
                session.beginTransaction();

                dbModelType = session.get(QuizUser.class, id);

                session.getTransaction().commit();

                session.close();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


        return dbModelType;
    }

    public boolean updateEntity(BaseDBmodel dbModelType)
    {
        try
        {
            Session session = this.sessionFactory.openSession();

            session.beginTransaction();

            session.update(dbModelType);

            session.getTransaction().commit();

            session.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean createEntity(BaseDBmodel dbModelType)
    {
        try
        {
            Session session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.persist(dbModelType);

            session.getTransaction().commit();
            session.close();
        }
        catch (ConstraintViolationException cve)
        {
            return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
