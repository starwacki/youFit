package model.product;
import model.calories.CaloriesCalculator;

public class Product {
    private String nameOfProduct;
    private String producer;
    private double caloriesPer100Grams;
    private double proteinsPer100Grams;
    private double carbohydratesPer100Grams;
    private double fatPer100Grams;
    private double weight;
    private int kcal;
    private int proteins;
    private int carbohydrates;
    private int fat;


    public Product(String nameOfProduct, String producer, double caloriesPer100Grams, double proteinsPer100Grams, double carbohydratesPer100Grams, double fatPer100Grams, double weight) {
        this.nameOfProduct = nameOfProduct;
        this.producer = producer;
        this.caloriesPer100Grams = caloriesPer100Grams;
        this.proteinsPer100Grams = proteinsPer100Grams;
        this.fatPer100Grams = fatPer100Grams;
        this.weight = weight;
        this.carbohydratesPer100Grams = carbohydratesPer100Grams;
        this.kcal = (int) CaloriesCalculator.caloriesInProduct(this);
        this.proteins = (int) CaloriesCalculator.proteinsInProduct(this);
        this.carbohydrates = (int) CaloriesCalculator.carbohydratesInProduct(this);
        this.fat = (int) CaloriesCalculator.fatInProduct(this);
    }

    public double getKcal() {
        return kcal;
    }

    public double getProteins() {
        return proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFat() {
        return fat;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public String getProducer() {
        return producer;
    }

    public double getCaloriesPer100Grams() {
        return caloriesPer100Grams;
    }

    public double getProteinsPer100Grams() {
        return proteinsPer100Grams;
    }

    public double getCarbohydratesPer100Grams() {
        return carbohydratesPer100Grams;
    }

    public double getFatPer100Grams() {
        return fatPer100Grams;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameOfProduct='" + nameOfProduct + '\'' +
                ", producer='" + producer + '\'' +
                ", caloriesPer100Grams=" + caloriesPer100Grams +
                ", proteinsPer100Grams=" + proteinsPer100Grams +
                ", carbohydratesPer100Grams=" + carbohydratesPer100Grams +
                ", fatPer100Grams=" + fatPer100Grams +
                ", weight=" + weight +
                ", kcal=" + kcal +
                ", proteins=" + proteins +
                ", carbohydrates=" + carbohydrates +
                ", fat=" + fat +
                '}';
    }
}
