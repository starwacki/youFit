package io;
import model.Days;
import model.product.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductTableViewsReader {
    private static final String DAY_SEPARATOR = "###";
    private static final String MEAL_SEPARATOR = "#";
    private static final String PRODUCT_SEPARATOR = ";";
    private static final String PRODUCT_ELEMENT_SEPARATOR = "@";
    private static final int MONDAY_LINE = 1;
    private static final int TUESDAY_LINE = 2;
    private static final int WEDNESDAY_LINE = 3;
    private static final int THURSDAY_LINE = 4;
    private static final int FRIDAY_LINE = 5;
    private static final int SATURDAY_LINE = 6;
    private static final int SUNDAY_LINE = 7;
    private static final int DAY_INDEX = 1;
    private static final int BREAKFAST_PRODUCTS_INDEX = 1;
    private static final int BRUNCH_PRODUCTS_INDEX = 3;
    private static final int LUNCH_PRODUCTS_INDEX = 5;
    private static final int SUPPER_PRODUCTS_INDEX = 7;
    private static final int PRODUCT_NAME_INDEX = 0;
    private static final int PRODUCT_PRODUCER_NAME_INDEX = 1;
    private static final int PRODUCT_CALORIES_PER_100G_INDEX = 2;
    private static final int PRODUCT_PROTEINS_PER_100G_INDEX = 3;
    private static final int PRODUCT_CARBOHYDRATES_PER_100G_INDEX = 4;
    private static final int PRODUCT_FAT_PER_100G_INDEX = 5;
    private static final int PRODUCT_WEIGHT_INDEX = 6;


    private static final File file = new File("src/main/resources/tableBase.txt");

    public static String readProductBase(int line) {
        try (
                var fileReader = new BufferedReader(new FileReader(file))
        ) {

            return getProductFromFile(line, fileReader);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Product> getProductListFromMeal(Days days, String meal) {
        List<Product> list = new ArrayList<>();
        addProductsToList(list,days,meal);
        return list;

    }

    //Method return DAY: -> BREAKFAST#PRODUCTS#BRUNCH#PRODUCTS#LUNCH#PRODUCTS#SUPPER#PRODUCTS
    private static String getDayProducts(Days days) {
        String allDayMeals = "";
        switch (days) {
            case MONDAY -> allDayMeals = readProductBase(MONDAY_LINE).split(DAY_SEPARATOR)[DAY_INDEX];
            case TUESDAY -> allDayMeals = readProductBase(TUESDAY_LINE).split(DAY_SEPARATOR)[DAY_INDEX];
            case WEDNESDAY -> allDayMeals = readProductBase(WEDNESDAY_LINE).split(DAY_SEPARATOR)[DAY_INDEX];
            case THURSDAY -> allDayMeals = readProductBase(THURSDAY_LINE).split(DAY_SEPARATOR)[DAY_INDEX];
            case FRIDAY -> allDayMeals = readProductBase(FRIDAY_LINE).split(DAY_SEPARATOR)[DAY_INDEX];
            case SATURDAY -> allDayMeals = readProductBase(SATURDAY_LINE).split(DAY_SEPARATOR)[DAY_INDEX];
            case SUNDAY -> allDayMeals = readProductBase(SUNDAY_LINE).split(DAY_SEPARATOR)[DAY_INDEX];
        }
        return allDayMeals;
    }

    //Method return String table of products from chosen day and meal, Monday,"BREAKFAST" - > [product1;product2;....;product]
    private static String[] getMealProducts(Days days, String meal) {
        String[] mealProducts = new String[0];
        switch (meal) {
            case "BREAKFAST" -> mealProducts = getDayProducts(days).split(MEAL_SEPARATOR)[BREAKFAST_PRODUCTS_INDEX].split(PRODUCT_SEPARATOR);
            case "BRUNCH" -> mealProducts = getDayProducts(days).split(MEAL_SEPARATOR)[BRUNCH_PRODUCTS_INDEX].split(PRODUCT_SEPARATOR);
            case "LUNCH" -> mealProducts = getDayProducts(days).split(MEAL_SEPARATOR)[LUNCH_PRODUCTS_INDEX].split(PRODUCT_SEPARATOR);
            case "SUPPER" -> mealProducts = getDayProducts(days).split(MEAL_SEPARATOR)[SUPPER_PRODUCTS_INDEX].split(PRODUCT_SEPARATOR);
        }
        return mealProducts;
    }

    private static Product getProduct(String prod) {
        String[] product = prod.split(PRODUCT_ELEMENT_SEPARATOR);
        return new Product(product[PRODUCT_NAME_INDEX],
                product[PRODUCT_PRODUCER_NAME_INDEX],
                Double.parseDouble(product[PRODUCT_CALORIES_PER_100G_INDEX]),
                Double.parseDouble(product[PRODUCT_PROTEINS_PER_100G_INDEX]),
                Double.parseDouble(product[PRODUCT_CARBOHYDRATES_PER_100G_INDEX]),
                Double.parseDouble(product[PRODUCT_FAT_PER_100G_INDEX]),
                Double.parseDouble(product[PRODUCT_WEIGHT_INDEX]));
    }

    private static String getProductFromFile(int line, BufferedReader fileReader) throws IOException {
        String read = fileReader.readLine();
        for (int i = 0; i < line; i++) {
            read = fileReader.readLine();
        }
        return read;
    }

    private static void addProductsToList(List<Product> list, Days days, String meal) {
        String[] products = getMealProducts(days, meal);
        if (products.length > 0) {
            for (String product : products) {
                list.add(getProduct(product));
            }
        }
    }

}

