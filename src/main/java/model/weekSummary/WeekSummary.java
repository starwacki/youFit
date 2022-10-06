package model.weekSummary;

import io.ProductTableViewsReader;
import model.Days;
import model.meals.Meals;

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
       mondayProducts = addDayMeals(Days.MONDAY);
       tuesdayProducts = addDayMeals(Days.TUESDAY);
       wednesdayProducts = addDayMeals(Days.WEDNESDAY);
       thursdayProducts = addDayMeals(Days.THURSDAY);
       fridayProducts = addDayMeals(Days.FRIDAY);
       saturdayProducts = addDayMeals(Days.SATURDAY);
       sundayProducts = addDayMeals(Days.SUNDAY);

    }
    private List<Meals> addDayMeals( Days days) {
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
