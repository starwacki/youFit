package dao;
import java.sql.*;
import java.util.Optional;
public class DataBaseConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection connect() {
        Connection connection = null;
        try {
         connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("polaczomo");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }


}

