package main.quizServer.dbModel;

import javax.persistence.*;

@Entity(name = "user")
public class QuizUser extends BaseDBmodel
{
    @Column(nullable = false)
    public String password;
}
