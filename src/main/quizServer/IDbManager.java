package main.quizServer;

import main.quizServer.dbModel.*;

public interface IDbManager
{
    public BaseDBmodel getEntityWithId(BaseDBmodel dbModelType, long id);
}
