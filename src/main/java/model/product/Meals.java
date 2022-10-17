package model.product;

import java.util.List;

public class Meals  {
    private List<Product> breakfast;
    private List<Product> brunch;
    private List<Product> lunch;
    private List<Product> supper;

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
