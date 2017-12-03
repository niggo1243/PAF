import org.testng.annotations.Test;
import org.testng.Assert;

import main.quizServer.DbManager;
import main.quizServer.dbModel.*;

public class DbManagerTestClass
{
    @Test
    public void getDbModels()
    {
        DbManager manager = (DbManager)DbManager.getInstance();

        QuizUser user = (QuizUser)manager.getEntityWithId(new QuizUser(), 1);

        Assert.assertEquals(user.name, "john");
    }
}
