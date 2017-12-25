package main.quizServer.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/quiz")
public class QuizService implements IQuizService
{
    @POST
    public void postUser(String user)
    {

    }

    @Path("/user")
    @Produces("text/plain")
    @GET
    public String getUser ()
    {
        return "Hallo";
    }
}
