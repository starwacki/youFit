package dao;

import model.DateController;
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
    private static final int SQL_BREAKFAST_INDEX = 1;
    private static final int SQL_BRUNCH_INDEX = 2;
    private static final int SQL_LUNCH_INDEX = 3;
    private static final int SQL_SUPPER_INDEX = 4;
    private static final int SQL_PRODUCT_NAME_COLUMN_INDEX = 3;
    private static final int SQL_PRODUCER_COLUMN_INDEX = 4;
    private static final int SQL_KCAL_PER_100G_COLUMN_INDEX = 5;
    private static final int SQL_PROTEINS_PER_100G_COLUMN_INDEX = 6;
    private static final int SQL_CARBOHYDRATES_PER_100G_COLUMN_INDEX = 7;
    private static final int SQL_FAT_PER_100G_COLUMN_INDEX = 8;
    private static final int NO_WEIGHT_VALUE = 0;
    private static final int SQL_EMAIL_COLUMN_INDEX = 1;
    private static final int SQL_PASSWORD_COLUMN_INDEX = 1;
    private static final int SQL_USERNAME_COLUMN_INDEX = 1;
    private static final int SQL_USER_ID_COLUMN_INDEX = 1;
    private static final int SQL_DATE_OF_BIRTH_COLUMN_INDEX = 1;
    private static final int SQL_WEIGHT_COLUMN_INDEX = 2;
    private static final int NULL_VALUE = -1;
    public static ResultSet executeSelect(String selectQuery) {
        try {
            Connection connection = DataBaseConnector.connect();
            Statement statement = connection.createStatement();
            return statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void updateQuery(String query) {
        try {
            Connection connection = DataBaseConnector.connect();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static char[] getUserPassword(String username) {
        ResultSet resultSet = executeSelect("SELECT password FROM users WHERE users.username = " + "'" + username + "';");
        try {
            if (resultSet.next()) return resultSet.getString(SQL_PASSWORD_COLUMN_INDEX).toCharArray();
            else return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public static boolean isUsernameInBase(String username) {
        ResultSet resultSet = executeSelect("SELECT username FROM users WHERE users.username = " + "'" + username + "';");
        try {
            if (resultSet.next()) {
                return resultSet.getString(SQL_USERNAME_COLUMN_INDEX).equals(username);
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
                return resultSet.getString(SQL_EMAIL_COLUMN_INDEX).equals(email);
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

    public static List<ProductFromBase> productBase()  {
        List<ProductFromBase> productsBase = new ArrayList<>();
        ResultSet resultSet = QueryExecutor.executeSelect("SELECT * FROM youfit.products");
        try {
            int i =0;
            while (resultSet.next()) {
                ProductFromBase product = new ProductFromBase(resultSet.getString(SQL_PRODUCT_NAME_COLUMN_INDEX),
                        resultSet.getString(SQL_PRODUCER_COLUMN_INDEX),
                        resultSet.getDouble(SQL_KCAL_PER_100G_COLUMN_INDEX),
                        resultSet.getDouble(SQL_PROTEINS_PER_100G_COLUMN_INDEX),
                        resultSet.getDouble(SQL_CARBOHYDRATES_PER_100G_COLUMN_INDEX),
                        resultSet.getDouble(SQL_FAT_PER_100G_COLUMN_INDEX),
                        NO_WEIGHT_VALUE,i++);
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
                Product product = ProductBase.productBase.get(getProductIdInProductBaseList(resultSet));
                product.setWeight(resultSet.getDouble(SQL_WEIGHT_COLUMN_INDEX));
                mealProducts.add(product);
             }
        } catch (SQLException sqlException) {
            return null;
        }
        return mealProducts;
    }

    public static List<List<Product>> allUserDayMeals(int userID,LocalDate localDate) {
        List<List<Product>> listOfDayMeals = new ArrayList<>();
        listOfDayMeals.add(getMealProducts(userID,localDate,SQL_BREAKFAST_INDEX));
        listOfDayMeals.add(getMealProducts(userID,localDate,SQL_BRUNCH_INDEX));
        listOfDayMeals.add(getMealProducts(userID,localDate,SQL_LUNCH_INDEX));
        listOfDayMeals.add(getMealProducts(userID,localDate,SQL_SUPPER_INDEX));
        return listOfDayMeals;
    }

    public static int getUserID(String username) {
        ResultSet resultSet = executeSelect("SELECT user_id FROM users WHERE users.username = " + "'" + username + "';");
        try {
            if (resultSet.next()) {
                return resultSet.getInt(SQL_USER_ID_COLUMN_INDEX);
            } else return NULL_VALUE;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUserEmail(String username) {
        ResultSet resultSet = executeSelect("SELECT email FROM users WHERE users.username = " + "'" + username + "';");
        try {
            if (resultSet.next()) {
                return resultSet.getString(SQL_EMAIL_COLUMN_INDEX);
            } else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static LocalDate getUserDateOfBirth(String username) {
        ResultSet resultSet = executeSelect("SELECT date_of_birth FROM users WHERE users.username = " + "'" + username + "';");
        try {
            if (resultSet.next()) {
                return resultSet.getDate(SQL_DATE_OF_BIRTH_COLUMN_INDEX).toLocalDate();
            } else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addProductToBase(int mealID,int productID, double productWeight, int product_index_in_meal) {
         updateQuery("INSERT INTO youfitbase VALUES("+ User.getUserID() +"," + mealID +","+productID+","
                     + "'"+DateController.getActualClickedDate()+"',"+productWeight+","+product_index_in_meal+","
                     + "null)");
        }
    public static void deleteProductFromBase(int mealID, int product_index_in_meal) {
        updateQuery("DELETE FROM youfitbase WHERE user_id = " + User.getUserID() + " AND meal_id = " + mealID +
                    " AND date = '"+DateController.getActualClickedDate() +"' AND product_index_in_meal = " + product_index_in_meal + ";");
    }


    /* Removing product from sql base is based on USER ID, DATE, MEAL and product index in meal -
     method sets the correct values for product index in meal > removed product index in meal.
     */
    public static void updateProductIndexInMealFromBase(int mealID,int removedIndex ) {
        updateQuery("""
                       UPDATE youfitbase
                       SET product_index_in_meal = product_index_in_meal - 1
                       WHERE user_id =""" +" " + User.getUserID() + " AND meal_id = " + mealID + " AND date = '" + DateController.getActualClickedDate() + "' AND product_index_in_meal > " + removedIndex);
    }

    private static int getProductIdInProductBaseList (ResultSet resultSet) throws SQLException {
      return   resultSet.getInt(1)-1;
    }


    }

