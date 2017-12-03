package main.quizServer;

import main.quizServer.dbModel.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

public class DbManager extends SingletonInstance implements IDbManager
{
    //make a private constructor, so only this class can instantiate this object
    private DbManager()
    {
        System.out.println("instantiating the DbManager");

        this.entityManagerFactory = Persistence.createEntityManagerFactory("NikoMySql");

    }

    private EntityManagerFactory entityManagerFactory;

    public static DbManager getInstance()
    {
        if (instance == null)
        {
            instance = new DbManager();
        }

        return (DbManager)instance;
    }

    @Override
    public BaseDBmodel getEntityWithId(BaseDBmodel dbModelType, long id)
    {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        dbModelType = entityManager.find(dbModelType.getClass(), id);

        return dbModelType;
    }
}
