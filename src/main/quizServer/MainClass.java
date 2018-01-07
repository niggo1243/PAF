package main.quizServer;

import main.quizServer.rest.QuizService;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


import java.io.IOException;
import java.net.URI;


public class MainClass
{
    public static final String serverRootUri = "https://localhost:8080";
    public static final String defaultIpAdress = "127.0.0.1";

    public static final int defaultPort = 8080;
    public static final int defaultBackLog = 10;

    public static void main(String[] args)
    {
        System.out.println("Starting the Quiz Server");

        try
        {
            ResourceConfig rc = new ResourceConfig();
            rc.register(QuizService.class);

            HttpServer quizServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(serverRootUri), rc);
//
//            //instantiate the socketAdress
//            InetSocketAddress inetSocketAddress = new InetSocketAddress(defaultIpAdress, defaultPort);
//            //create and start the main.quizServer
//            //HttpsServer quizServer = HttpsServer.create(inetSocketAddress, defaultBackLog);
//            HttpServer quizServer = HttpServer.create(inetSocketAddress, defaultBackLog);
//
//
            quizServer.start();

            System.out.println("Hit any key, to close the server: ");
            System.in.read();

            //stop the server
            quizServer.stop();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

}
