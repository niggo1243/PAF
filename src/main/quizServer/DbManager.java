package main.quizServer;

import main.quizServer.dbModel.*;

import javax.persistence.EntityManagerFactory;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class DbManager extends SingletonInstance implements IDbManager
{
    //make a private constructor, so only this class can instantiate this object
    private DbManager()
    {
        System.out.println("instantiating the DbManager");

    }

    private EntityManagerFactory entityManagerFactory;

    public static SingletonInstance getInstance()
    {
        if (instance == null)
        {
            instance = new DbManager();
        }

        return instance;
    }

    public BaseDBmodel getEntityWithId(BaseDBmodel dbModelType, long id)
    {
        //EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        //dbModelType = entityManager.find(dbModelType.getClass(), id);

        Configuration config = new Configuration();
            try
            {
                // This step will read hibernate.cfg.xml and prepare hibernate for use
                SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                Session session = sessionFactory.openSession();
                Transaction tx = session.beginTransaction();

                //Create new instance of Contact and set values in it by reading them from form object
                System.out.println("Inserting Record");

                dbModelType = session.get(QuizUser.class, 1);


                // Actual contact insertion will happen at this step

                session.flush();
                session.close();

            }
            catch (InvalidMappingException e)
            {
                e.printStackTrace();
            }


        return dbModelType;
    }
}
