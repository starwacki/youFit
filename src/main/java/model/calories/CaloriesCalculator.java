package model.calories;
import model.product.Product;
import model.meals.Meals;

import java.util.List;

public class CaloriesCalculator {
    // static variables  define kcal per gram of macronutrient
    public static final double ONE_GRAM_OF_PROTEIN_CALORIES = 4;
    public static final double ONE_GRAM_OF_CARBOHYDRATES_CALORIES = 4;
    public static final double ONE_GRAM_OF_FAT_CALORIES = 9;


    //methods return weight of  particular micronutrients
    public static double proteinsInProduct(Product product) {
        return product.getProteinsPer100Grams()* product.getWeight()/100;
    }
    public static double fatInProduct(Product product) {
        return product.getFatPer100Grams()* product.getWeight()/100;
    }
    public static double carbohydratesInProduct(Product product) {
        return product.getCarbohydratesPer100Grams()* product.getWeight()/100;
    }

  //Methods return all micronutrients per meal
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

        return getProteinsFromMeal(meals.get(0).getBreakfast()) + getProteinsFromMeal(meals.get(0).getBrunch())
                + getProteinsFromMeal(meals.get(0).getLunch()) + getProteinsFromMeal(meals.get(0).getSupper());
    }
    public static  double getFatFromDay(List<Meals> meals) {
        return    getFatFromMeal(meals.get(0).getBreakfast()) + getFatFromMeal(meals.get(0).getBrunch())
                + getFatFromMeal(meals.get(0).getLunch()) + getFatFromMeal(meals.get(0).getSupper());
    }
    public static  double getCarbohydratesFromDay(List<Meals> meals) {
        return    getCarbohydratesFromMeal(meals.get(0).getBreakfast()) + getCarbohydratesFromMeal(meals.get(0).getBrunch())
                + getCarbohydratesFromMeal(meals.get(0).getLunch()) + getCarbohydratesFromMeal(meals.get(0).getSupper());
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

     return     getCaloriesFromMeal(meals.get(0).getBreakfast()) + getCaloriesFromMeal(meals.get(0).getLunch())
             +  getCaloriesFromMeal(meals.get(0).getSupper()) +  getCaloriesFromMeal(meals.get(0).getBrunch()) ;
    }









}
