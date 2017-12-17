

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

        QuizUser user = (QuizUser)manager.getEntityWithId(new QuizUser(), 1);

        Assertions.assertNotNull(manager);
        Assertions.assertEquals(user.getName(), "john");
    }
}
