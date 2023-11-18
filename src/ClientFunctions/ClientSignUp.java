package ClientFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ClientSignUp {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/y_app", "root", "4vPRBRYJU9.");
            ResultSet resultSet = connection.createStatement().executeQuery("Select * from user");
            while
            (resultSet.next()){
                System.out.println(resultSet.getString("username"));
            }
        }
        catch(Exception e){

            System.out.println("try again");
        }
    }
}
