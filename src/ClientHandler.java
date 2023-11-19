import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            boolean signup = true;
            // todo: add GUI function when pressing sign up or login
            if (signup){
                System.out.println("------------------ SIGNUP ------------------");
                UserFunctions.signupUser();
            }
            System.out.println("------------------ LOGIN ------------------");
            UserFunctions.loginUser();

        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

