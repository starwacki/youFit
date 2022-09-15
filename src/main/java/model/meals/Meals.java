package model.meals;

import model.product.Product;

import java.util.List;

public class Meals {
    private List<Product> breakfast; //basic list
    private List<Product> brunch; //basic list
    private List<Product> lunch; //basic list
    private List<Product> supper; //basic list
  public Meals(List<Product> breakfast,List<Product> brunch,List<Product> lunch,
               List<Product> supper) {
      this.breakfast = breakfast;
      this.brunch=brunch;
      this.lunch = lunch;
      this.supper = supper;

  }
    public List<Product> getBreakfast() {
        return breakfast;
    }

    public List<Product> getBrunch() {
        return brunch;
    }

    public List<Product> getLunch() {
        return lunch;
    }

    public List<Product> getSupper() {
        return supper;
    }
}
