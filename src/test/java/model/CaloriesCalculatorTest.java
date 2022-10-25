package model;
import model.calories.CaloriesCalculator;
import model.product.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class CaloriesCalculatorTest {

    @Test
    public void shouldReturn50gOfAllProductMicronutrients() {
        String nameOfProduct = "test";
        String producer = "test";
        double caloriesPer100g = 425;
        double proteinsPer100g = 25;
        double carbohydratesPer100g = 25;
        double fatPer100g = 25;
        double weight = 200;
        Product product = new Product(nameOfProduct,producer,caloriesPer100g,proteinsPer100g,carbohydratesPer100g,fatPer100g,weight);
        Assertions.assertEquals(50, CaloriesCalculator.proteinsInProduct(product));
        Assertions.assertEquals(50,CaloriesCalculator.carbohydratesInProduct(product));
        Assertions.assertEquals(50,CaloriesCalculator.fatInProduct(product));
    }

    @Test
    public void shouldReturn100gOfAllMealMicronutrients() {
        String nameOfProduct = "test";
        String producer = "test";
        double caloriesPer100g = 425;
        double proteinsPer100g = 25;
        double carbohydratesPer100g = 25;
        double fatPer100g = 25;
        double weight = 200;
        Product product1 = new Product(nameOfProduct,producer,caloriesPer100g,proteinsPer100g,carbohydratesPer100g,fatPer100g,weight);
        Product product2 = new Product(nameOfProduct,producer,caloriesPer100g,proteinsPer100g,carbohydratesPer100g,fatPer100g,weight);
        List<Product> list = List.of(product1,product2);
        Assertions.assertEquals(100,CaloriesCalculator.getProteinsFromMeal(list));
        Assertions.assertEquals(100,CaloriesCalculator.getCarbohydratesFromMeal(list));
        Assertions.assertEquals(100,CaloriesCalculator.getFatFromMeal(list));
    }

    @Test
    public void shouldReturn400gOfAllDayMicronutrients() {
        String nameOfProduct = "test";
        String producer = "test";
        double caloriesPer100g = 425;
        double proteinsPer100g = 25;
        double carbohydratesPer100g = 25;
        double fatPer100g = 25;
        double weight = 200;
        Product product1 = new Product(nameOfProduct,producer,caloriesPer100g,proteinsPer100g,carbohydratesPer100g,fatPer100g,weight);
        Product product2 = new Product(nameOfProduct,producer,caloriesPer100g,proteinsPer100g,carbohydratesPer100g,fatPer100g,weight);
        List<Product> list1 = List.of(product1,product2);
        List<Product> list2 = List.of(product1,product2);
        List<Product> list3 = List.of(product1,product2);
        List<Product> list4 = List.of(product1,product2);
        List<List<Product>> dayMeals = List.of(list1,list2,list3,list4);
        Assertions.assertEquals(400,CaloriesCalculator.getProteinsFromDay(dayMeals));
        Assertions.assertEquals(400,CaloriesCalculator.getCarbohydratesFromDay(dayMeals));
        Assertions.assertEquals(400,CaloriesCalculator.getFatFromDay(dayMeals));
    }

    @Test
    public void shouldReturn850CaloriesFromProduct() {
        String nameOfProduct = "test";
        String producer = "test";
        double caloriesPer100g = 425;
        double proteinsPer100g = 25;
        double carbohydratesPer100g = 25;
        double fatPer100g = 25;
        double weight = 200;
        Product product = new Product(nameOfProduct,producer,caloriesPer100g,proteinsPer100g,carbohydratesPer100g,fatPer100g,weight);
        Assertions.assertEquals(850,CaloriesCalculator.caloriesInProduct(product));
    }

    @Test
    public void shouldReturn1700CaloriesFromMeal() {
        String nameOfProduct = "test";
        String producer = "test";
        double caloriesPer100g = 425;
        double proteinsPer100g = 25;
        double carbohydratesPer100g = 25;
        double fatPer100g = 25;
        double weight = 200;
        Product product1 = new Product(nameOfProduct,producer,caloriesPer100g,proteinsPer100g,carbohydratesPer100g,fatPer100g,weight);
        Product product2 = new Product(nameOfProduct,producer,caloriesPer100g,proteinsPer100g,carbohydratesPer100g,fatPer100g,weight);
        List<Product> list = List.of(product1,product2);
        Assertions.assertEquals(1700,CaloriesCalculator.getCaloriesFromMeal(list));
    }

    @Test
    public void shouldReturn6800CaloriesFromDay() {
        String nameOfProduct = "test";
        String producer = "test";
        double caloriesPer100g = 425;
        double proteinsPer100g = 25;
        double carbohydratesPer100g = 25;
        double fatPer100g = 25;
        double weight = 200;
        Product product1 = new Product(nameOfProduct,producer,caloriesPer100g,proteinsPer100g,carbohydratesPer100g,fatPer100g,weight);
        Product product2 = new Product(nameOfProduct,producer,caloriesPer100g,proteinsPer100g,carbohydratesPer100g,fatPer100g,weight);
        List<Product> list1 = List.of(product1,product2);
        List<Product> list2 = List.of(product1,product2);
        List<Product> list3 = List.of(product1,product2);
        List<Product> list4 = List.of(product1,product2);
        List<List<Product>> dayMeals = List.of(list1,list2,list3,list4);
        Assertions.assertEquals(6800,CaloriesCalculator.getCaloriesFromDay(dayMeals));
    }

}