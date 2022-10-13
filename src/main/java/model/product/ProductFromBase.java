package model.product;

public class ProductFromBase extends Product{

    private int productIndex;

    public ProductFromBase(String nameOfProduct, String producer, double caloriesPer100Grams, double proteinsPer100Grams, double carbohydratesPer100Grams, double fatPer100Grams, double weight,int productIndex) {
        super(nameOfProduct, producer, caloriesPer100Grams, proteinsPer100Grams, carbohydratesPer100Grams, fatPer100Grams, weight);
        this.productIndex = productIndex;
    }

    public int getProductIndex() {
        return productIndex;
    }

    @Override
    public String toString() {
       return super.toString();
    }
}
