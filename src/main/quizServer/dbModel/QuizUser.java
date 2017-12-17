package main.quizServer.dbModel;

public class QuizUser extends BaseDBmodel
{
    private String password;

    public QuizUser()
    {

    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
