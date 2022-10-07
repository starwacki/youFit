package model.calories;
import model.product.Product;
import model.product.Meals;
import model.weekSummary.WeekSummary;

import java.util.List;

public class CaloriesCalculator {
    // static variables  define kcal per gram of macronutrient
    public static final double ONE_GRAM_OF_PROTEIN_CALORIES = 4;
    public static final double ONE_GRAM_OF_CARBOHYDRATES_CALORIES = 4;
    public static final double ONE_GRAM_OF_FAT_CALORIES = 9;
    private static final int MEALS_INDEX = 0;

    public static double proteinsInProduct(Product product) {
        return product.getProteinsPer100Grams()* product.getWeight()/100;
    }
    public static double fatInProduct(Product product) {
        return product.getFatPer100Grams()* product.getWeight()/100;
    }
    public static double carbohydratesInProduct(Product product) {
        return product.getCarbohydratesPer100Grams()* product.getWeight()/100;
    }

  public static double getProteinsFromMeal(List<Product> products) {
        double proteins = 0;
      for (Product p: products) {
          proteins += proteinsInProduct(p);
      }
      return proteins;
  }
    public static double getCarbohydratesFromMeal(List<Product> products) {
        double carbohydrates = 0;
        for (Product p: products) {
            carbohydrates += carbohydratesInProduct(p);
        }
        return carbohydrates;
    }
    public static double getFatFromMeal(List<Product> products) {
        double fat = 0;
        for (Product p: products) {
            fat += fatInProduct(p);
        }
        return fat;
    }
    //Methods return micronutrient of all day meals
    public static  double getProteinsFromDay(List<Meals> meals) {

        return getProteinsFromMeal(meals.get(MEALS_INDEX).getBreakfast()) + getProteinsFromMeal(meals.get(MEALS_INDEX).getBrunch())
                + getProteinsFromMeal(meals.get(MEALS_INDEX).getLunch()) + getProteinsFromMeal(meals.get(MEALS_INDEX).getSupper());
    }
    public static  double getFatFromDay(List<Meals> meals) {
        return    getFatFromMeal(meals.get(MEALS_INDEX).getBreakfast()) + getFatFromMeal(meals.get(MEALS_INDEX).getBrunch())
                + getFatFromMeal(meals.get(MEALS_INDEX).getLunch()) + getFatFromMeal(meals.get(MEALS_INDEX).getSupper());
    }
    public static  double getCarbohydratesFromDay(List<Meals> meals) {
        return    getCarbohydratesFromMeal(meals.get(MEALS_INDEX).getBreakfast()) + getCarbohydratesFromMeal(meals.get(MEALS_INDEX).getBrunch())
                + getCarbohydratesFromMeal(meals.get(MEALS_INDEX).getLunch()) + getCarbohydratesFromMeal(meals.get(MEALS_INDEX).getSupper());
    }

    //Methods return calories from one product, one meal and day
    public static double caloriesInProduct (Product product) {
        return product.getCaloriesPer100Grams()* product.getWeight()/100;
    }
    public static double getCaloriesFromMeal (List<Product> products) {
        double calories = 0;
        for (Product p : products) {
            calories += caloriesInProduct(p);
        }
        return calories;
    }
    public static  double getCaloriesFromDay(List<Meals> meals) {

     return     getCaloriesFromMeal(meals.get(MEALS_INDEX).getBreakfast()) + getCaloriesFromMeal(meals.get(MEALS_INDEX).getLunch())
             +  getCaloriesFromMeal(meals.get(MEALS_INDEX).getSupper()) +  getCaloriesFromMeal(meals.get(MEALS_INDEX).getBrunch()) ;
    }

    public static double getWeekProteins(WeekSummary weekSummary) {
        return  getProteinsFromDay(weekSummary.getMondayProducts()) + getProteinsFromDay(weekSummary.getTuesdayProducts()) +
                getProteinsFromDay(weekSummary.getWednesdayProducts()) + getProteinsFromDay(weekSummary.getThursdayProducts()) +
                getProteinsFromDay(weekSummary.getFridayProducts()) + getProteinsFromDay(weekSummary.getSaturdayProducts()) +
                getProteinsFromDay(weekSummary.getSundayProducts());
    }
    public static double getWeekCarbohydrates(WeekSummary weekSummary) {
        return  getCarbohydratesFromDay(weekSummary.getMondayProducts()) + getCarbohydratesFromDay(weekSummary.getTuesdayProducts()) +
                getCarbohydratesFromDay(weekSummary.getWednesdayProducts()) + getCarbohydratesFromDay(weekSummary.getThursdayProducts()) +
                getCarbohydratesFromDay(weekSummary.getFridayProducts()) + getCarbohydratesFromDay(weekSummary.getSaturdayProducts()) +
                getCarbohydratesFromDay(weekSummary.getSundayProducts());
    }
    public static double getWeekFat(WeekSummary weekSummary) {
        return  getFatFromDay(weekSummary.getMondayProducts()) + getFatFromDay(weekSummary.getTuesdayProducts()) +
                getFatFromDay(weekSummary.getWednesdayProducts()) + getFatFromDay(weekSummary.getThursdayProducts()) +
                getFatFromDay(weekSummary.getFridayProducts()) + getFatFromDay(weekSummary.getSaturdayProducts()) +
                getFatFromDay(weekSummary.getSundayProducts());
    }
    public static double getWeekCalories(WeekSummary weekSummary) {
        return  getCaloriesFromDay(weekSummary.getMondayProducts()) + getCaloriesFromDay(weekSummary.getTuesdayProducts()) +
                getCaloriesFromDay(weekSummary.getWednesdayProducts()) + getCaloriesFromDay(weekSummary.getThursdayProducts()) +
                getCaloriesFromDay(weekSummary.getFridayProducts()) + getCaloriesFromDay(weekSummary.getSaturdayProducts()) +
                getCaloriesFromDay(weekSummary.getSundayProducts());
    }









}
