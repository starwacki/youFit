package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class QueryExecutor {
    public static ResultSet executeSelect(String selectQuery) {
        try {
            Connection connection = DataBaseConnector.connect();
            Statement statement = connection.createStatement();
            return statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void executeQuery(String query) {
        try {
            Connection connection = DataBaseConnector.connect();
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static char[] getUserPassword(String username) {
        ResultSet resultSet = executeSelect("SELECT password FROM users WHERE users.username = " + "'" + username + "';");
        try {
            if (resultSet.next()) return resultSet.getString(1).toCharArray();
            else return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public static boolean isUsernameInBase(String username) {
        ResultSet resultSet = executeSelect("SELECT username FROM users WHERE users.username = " + "'" + username + "';");
        try {
            if (resultSet.next()) {
                return resultSet.getString(1).equals(username);
            }
            else return false;
        } catch (SQLException e) {
            return false;
        }
    }
    public static boolean isEmailInBase(String email) {
        ResultSet resultSet = executeSelect("SELECT email FROM users WHERE users.email = " + "'" + email + "';");
        try {
            if (resultSet.next()) {
                return resultSet.getString(1).equals(email);
            }
            else return false;
        } catch (SQLException e) {
            return false;
        }
    }
    public static void registerNewUser(String username, String password, String email, LocalDate date) {
        try {
            Connection connection = DataBaseConnector.connect();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO users VALUES (null,'" + username +"','" +password +"','"+email+"','"+date+"');");
        } catch (SQLException e) {
            System.out.println("fdsfs");
            throw new RuntimeException(e.getMessage());
        }
    }
    public static String getEmail(String username) {
        ResultSet resultSet = executeSelect("SELECT email FROM users WHERE users.username = " + "'" + username+ "';");
        try {
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
            else return null;
        } catch (SQLException e) {
            return null;
        }
    }
}