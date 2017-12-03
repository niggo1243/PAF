package main.quizServer;

public class SingletonInstance
{
    protected static SingletonInstance instance;

    protected SingletonInstance()
    {
    }

    public static SingletonInstance getInstance()
    {
        if (instance == null)
        {
            instance = new SingletonInstance();
        }

        return instance;
    }
}
