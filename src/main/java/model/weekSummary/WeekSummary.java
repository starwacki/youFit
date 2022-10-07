package model.weekSummary;

import io.ProductTableViewsReader;
import model.product.Meals;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class WeekSummary {
private List<Meals> mondayProducts;
private List<Meals> tuesdayProducts;
private List<Meals> wednesdayProducts;
private List<Meals> thursdayProducts;
private List<Meals> fridayProducts;
private List<Meals> saturdayProducts;
private List<Meals> sundayProducts;

    public WeekSummary() {
       mondayProducts = addDayMeals(DayOfWeek.MONDAY);
       tuesdayProducts = addDayMeals(DayOfWeek.TUESDAY);
       wednesdayProducts = addDayMeals(DayOfWeek.WEDNESDAY);
       thursdayProducts = addDayMeals(DayOfWeek.THURSDAY);
       fridayProducts = addDayMeals(DayOfWeek.FRIDAY);
       saturdayProducts = addDayMeals(DayOfWeek.SATURDAY);
       sundayProducts = addDayMeals(DayOfWeek.SUNDAY);

    }
    private List<Meals> addDayMeals(DayOfWeek days) {
        List<Meals> list = new ArrayList<>();
        Meals meals = new Meals(ProductTableViewsReader.getProductListFromMeal(days,"BREAKFAST"),
                                ProductTableViewsReader.getProductListFromMeal(days,"BRUNCH"),
                                ProductTableViewsReader.getProductListFromMeal(days,"SUPPER"),
                                ProductTableViewsReader.getProductListFromMeal(days,"LUNCH"));
        list.add(meals);
        return list;
    }

    public List<Meals> getMondayProducts() {
        return mondayProducts;
    }

    public List<Meals> getTuesdayProducts() {
        return tuesdayProducts;
    }

    public List<Meals> getWednesdayProducts() {
        return wednesdayProducts;
    }

    public List<Meals> getThursdayProducts() {
        return thursdayProducts;
    }

    public List<Meals> getFridayProducts() {
        return fridayProducts;
    }

    public List<Meals> getSaturdayProducts() {
        return saturdayProducts;
    }

    public List<Meals> getSundayProducts() {
        return sundayProducts;
    }
}
