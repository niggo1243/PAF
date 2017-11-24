package quizServer;

import com.sun.net.httpserver.HttpsServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public final class MainClass
{
    public static final String serverRootUri = "https://localhost:8080/";
    public static final String defaultIpAdress = "127.0.0.1";

    public static final int defaultPort = 8080;
    public static final int defaultBackLog = 10;

    public static void main(String[] args)
    {
        System.out.println("Starting the Quiz Server");

        try
        {
            //instantiate the socketAdress
            InetSocketAddress inetSocketAddress = new InetSocketAddress(defaultIpAdress, defaultPort);
            //create and start the quizServer
            HttpsServer quizServer = HttpsServer.create(inetSocketAddress, defaultBackLog);
            quizServer.start();

            System.out.println("Hit any key, to close the server: ");
            System.in.read();

            //stop the server
            quizServer.stop(1);
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

}
