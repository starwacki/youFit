package dao;

import model.DateController;
import model.product.Meals;
import model.product.Product;
import model.product.ProductBase;
import model.product.ProductFromBase;
import model.user.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public static List<ProductFromBase> productBase()  {
        List<ProductFromBase> productsBase = new ArrayList<>();
        ResultSet resultSet = QueryExecutor.executeSelect("SELECT * FROM youfit.products");
        try {
            int i =0;
            while (resultSet.next()) {
                ProductFromBase product = new ProductFromBase(resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDouble(5),
                        resultSet.getDouble(6),
                        resultSet.getDouble(7),
                        resultSet.getDouble(8),
                        0,i++);
                productsBase.add(product);
            }
        } catch (SQLException e) {
            return productsBase;
        }

        return productsBase;
    }
    public static List<Product> getMealProducts(int userID, LocalDate localDate,int mealID) {
        List<Product> mealProducts = new ArrayList<>();
        ResultSet resultSet = QueryExecutor.executeSelect("SELECT product_id, product_weight, product_index_in_meal FROM youfit.youfitbase where user_id = " + userID + " " +
                "&& date = '" + localDate + "' && meal_id = " + mealID +";");
        try {
            while (resultSet.next()) {
                Product product = ProductBase.productBase.get(resultSet.getInt(1)-1);
                product.setWeight(resultSet.getDouble(2));
                mealProducts.add(product);
             }
        } catch (SQLException sqlException) {
            return null;
        }
        return mealProducts;
    }
    public static List<List<Product>> allUserDayMeals(int userID,LocalDate localDate) {
        List<List<Product>> listOfDayMeals = new ArrayList<>();
        listOfDayMeals.add(getMealProducts(userID,localDate,1));
        listOfDayMeals.add(getMealProducts(userID,localDate,2));
        listOfDayMeals.add(getMealProducts(userID,localDate,3));
        listOfDayMeals.add(getMealProducts(userID,localDate,4));
        return listOfDayMeals;
    }
    public static int getUserID(String username) {
        ResultSet resultSet = executeSelect("SELECT user_id FROM users WHERE users.username = " + "'" + username + "';");
        try {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getUserEmail(String username) {
        ResultSet resultSet = executeSelect("SELECT email FROM users WHERE users.username = " + "'" + username + "';");
        try {
            if (resultSet.next()) {
                return resultSet.getString(1);
            } else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static LocalDate getUserDateOfBirth(String username) {
        ResultSet resultSet = executeSelect("SELECT date_of_birth FROM users WHERE users.username = " + "'" + username + "';");
        try {
            if (resultSet.next()) {
                return resultSet.getDate(1).toLocalDate();
            } else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void addProductToBase(int mealID,int productID, double productWeight, int product_index_in_meal) {
        executeQuery("INSERT INTO youfitbase VALUES("+ User.getUserID() +"," + mealID +","+productID+","
                     + "'"+DateController.getActualClickedDate()+"',"+productWeight+","+product_index_in_meal+","
                     + "null)");
        }
    }

