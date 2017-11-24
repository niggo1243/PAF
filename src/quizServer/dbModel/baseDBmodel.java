package quizServer.dbModel;

import javax.persistence.*;


public class baseDBmodel
{
    @GeneratedValue
    @Id
    public long id;

    @Column(nullable = false)
    public String name;
}
