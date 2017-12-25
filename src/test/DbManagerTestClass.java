

import main.quizServer.DbManager;
import main.quizServer.dbModel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DbManagerTestClass
{
    @Test
    public void getDbModels()
    {
        DbManager manager = (DbManager)DbManager.getInstance();

        QuizUser newUser = new QuizUser();
        newUser.setName("john");
        newUser.setId(1);

        manager.updateEntity(newUser);

        QuizUser user = (QuizUser)manager.getEntityWithId(new QuizUser(), 1);

        Assertions.assertNotNull(manager);
        Assertions.assertEquals(user.getName(), "john");

        newUser = new QuizUser();
        newUser.setName("marry");
        newUser.setId(1);

        manager.updateEntity(newUser);

        QuizUser user2 = (QuizUser)manager.getEntityWithId(new QuizUser(), 1);
        Assertions.assertEquals(user2.getName(), "marry");

    }

    @Test
    public void createTables()
    {
        DbManager manager = (DbManager)DbManager.getInstance();

        QuizUser user = new QuizUser();
        user.setId(2);
        user.setName("Ocelot");

        manager.createEntity(user);

        QuizUser user2 = (QuizUser)manager.getEntityWithId(new QuizUser(), 2);
        Assertions.assertEquals(user2.getName(), "Ocelot");
    }
}
