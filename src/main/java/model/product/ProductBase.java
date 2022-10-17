package model.product;

import dao.QueryExecutor;
import java.util.List;

public class ProductBase {
    public static List<ProductFromBase> productBase;

    public static void initializeProductBase() {
        productBase = QueryExecutor.productBase();
    }
}
