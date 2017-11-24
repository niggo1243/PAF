package quizServer.dbModel;

import javax.persistence.*;

@Entity
public class Benutzer extends baseDBmodel
{
    @Column(nullable = false)
    public String password;
}
