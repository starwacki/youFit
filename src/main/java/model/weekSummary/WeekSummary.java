package model.weekSummary;

import dao.QueryExecutor;
import model.DateController;
import model.product.Product;
import model.user.User;
import java.time.LocalDate;
import java.util.List;

public class WeekSummary {
private List<List<Product>> mondayProducts;
private List<List<Product>> tuesdayProducts;
private List<List<Product>> wednesdayProducts;
private List<List<Product>> thursdayProducts;
private List<List<Product>> fridayProducts;
private List<List<Product>> saturdayProducts;
private List<List<Product>> sundayProducts;

    public WeekSummary() {
        DateController dateController = new DateController();
       mondayProducts = addDayMeals(dateController.getMondayDate());
       tuesdayProducts = addDayMeals(dateController.getTuesdayDate());
       wednesdayProducts = addDayMeals(dateController.getWednesdayDate());
       thursdayProducts = addDayMeals(dateController.getThursdayDate());
       fridayProducts = addDayMeals(dateController.getFridayDate());
       saturdayProducts = addDayMeals(dateController.getSaturdayDate());
       sundayProducts = addDayMeals(dateController.getSundayDate());

    }
    private List<List<Product>> addDayMeals(LocalDate localDate) {
        List<List<Product>> dayProducts = QueryExecutor.allUserDayMeals(User.getUserID(),localDate);
        return dayProducts;
    }

    public List<List<Product>> getMondayProducts() {
        return mondayProducts;
    }

    public List<List<Product>> getTuesdayProducts() {
        return tuesdayProducts;
    }

    public List<List<Product>> getWednesdayProducts() {
        return wednesdayProducts;
    }

    public List<List<Product>> getThursdayProducts() {
        return thursdayProducts;
    }

    public List<List<Product>> getFridayProducts() {
        return fridayProducts;
    }

    public List<List<Product>> getSaturdayProducts() {
        return saturdayProducts;
    }

    public List<List<Product>> getSundayProducts() {
        return sundayProducts;
    }
}
