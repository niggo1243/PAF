package main.quizServer.dbModel;

import javax.persistence.*;


public class BaseDBmodel
{
    @GeneratedValue
    @Id
    public long id;

    @Column(nullable = false)
    public String name;
}
