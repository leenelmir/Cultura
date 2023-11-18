/*
import java.io.*;
import java.net.*;
import java.util.Scanner;


 1- enter domain name and port number
 2- login or signup
    if signup: name, email address, username, password
    if login: username, password
once logged in:
 3- Feed view:
    views a list of client's posted messages
    AND a list of client's followed posted message (must be constantly updated by contacting the server)
 4- post messages




public class Client {
    public static int member = 0;

    public static void main(String[] args) throws IOException {
        try {
            Scanner scan = new Scanner(System.in);

            // Getting local IP Address (127.0.0.1)
            InetAddress ip = InetAddress.getByName("localhost");

            // Establish the connection with Server on port 5056
            Socket socket = new Socket(ip, 5056);
            // This will trigger the accept() function of the Server
            member++;
            // Receiving input and sending output to Server
            DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());

            DataOutputStream outputToServer = new DataOutputStream(socket.getOutputStream());

            while (true) {
                System.out.println(inputFromServer.readUTF());
                String tosend = scan.nextLine();
                outputToServer.writeUTF(tosend);

                // Sending Exit closes the connection and breaks the loop
                if(tosend.equals("Exit"))
                {
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("Closing this connection : " + socket);
                    socket.close();
                    System.out.println("Connection closed");
                    break;
                }
                System.out.println("-----------------------------------------------------------------------------------");
                // Printing message received from Server
                String received = inputFromServer.readUTF();
                System.out.println(received);
            }

            // Closing resources
            scan.close();
            inputFromServer.close();
            outputToServer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                YPlatformClientWindow window = new YPlatformClientWindow();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

class YPlatformClientWindow extends JFrame {
    private JTextField serverField;
    private JTextField portField;
    // Other GUI components...

    public YPlatformClientWindow() {
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new GridLayout(3, 2));

        serverField = new JTextField();
        portField = new JTextField();
        JButton connectButton = new JButton("Connect");
        // Other GUI components...

        getContentPane().add(new JLabel("Server:"));
        getContentPane().add(serverField);
        getContentPane().add(new JLabel("Port:"));
        getContentPane().add(portField);
        getContentPane().add(connectButton);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String serverAddress = serverField.getText();
                int port = Integer.parseInt(portField.getText());

                // Perform actions when the connect button is clicked
                // For example, initiate a connection to the server
                connectToServer(serverAddress, port);

                // You may want to open another window for login/registration, etc.
            }
        });

        // Initialize other GUI components and listeners...
    }

    private void connectToServer(String serverAddress, int port) {
        // Implement logic to connect to the server
        // Create instances of your ClientCommunication class or other classes responsible for communication
        // Handle user interactions and server responses
    }
}


*/
