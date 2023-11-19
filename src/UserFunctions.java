import java.sql.*;
import java.util.Scanner;

public class UserFunctions {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/y_app";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "4vPRBRYJU9.";

    public static void loginUser(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            if (loginUser(username, password)) {
                System.out.println("Login successful!");
                break;
            } else {
                //todo: login failed
                System.out.println("Login failed. Invalid username or password.");
            }
        }

    }

    private static boolean loginUser(String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/y_app", "root", "4vPRBRYJU9.");
            String query = "SELECT * FROM USER WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void signupUser(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.println(username + " " + password + " " + name + " " + email);
            if (signupUser(username, password, name, email)) {
                System.out.println("Signup successful!");
                break;
            } else {
                //todo: signup failed
                System.out.println("Signup failed. Invalid Entries.");
            }
        }
    }

    private static boolean signupUser(String username, String password, String name, String email){

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
            String query = "INSERT INTO USER (username, email, name, password) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, password);
            preparedStatement.execute();
            return true;
           // ResultSet resultSet = preparedStatement.executeQuery();
           // return resultSet.next();
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
