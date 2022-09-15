package io;
import model.Days;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductTableViewsWriter {
    private static final String DAY_SEPARATOR = "###";
    private static final String MEAL_SEPARATOR = "#";
    private static final String PRODUCT_SEPARATOR = ";";
    private static final int DAY_NAME_INDEX = 0;
    private static final int DAY_MEALS_INDEX = 1;
    private static final int MONDAY_INDEX = 1;
    private static final int TUESDAY_INDEX = 2;
    private static final int WEDNESDAY_INDEX = 3;
    private static final int THURSDAY_INDEX = 4;
    private static final int FRIDAY_INDEX = 5;
    private static final int SATURDAY_INDEX = 6;
    private static final int SUNDAY_INDEX = 7;
    private static final int BREAKFAST_PRODUCTS_INDEX = 1;
    private static final int BRUNCH_PRODUCTS_INDEX = 3;
    private static final int LUNCH_PRODUCTS_INDEX = 5;
    private static final int SUPPER_PRODUCTS_INDEX = 7;
    private static final int MEAL_NAME_BREAKFAST_INDEX = 0;
    private static final int MEAL_NAME_BRUNCH_INDEX = 2;
    private static final int MEAL_NAME_LUNCH_INDEX = 4;
    private static final int MEAL_NAME_SUPPER_INDEX = 6;
    private static final File file = new File("src/main/resources/tableBase.txt");
    public static void addProductToTableBase(Days days, String meal, String product) {
        List<String> fileText = new ArrayList<>(getFileText());
        changedChosenDay(meal,fileText,days,product);
        try(
                var fileWriter = new BufferedWriter(new FileWriter(file))
        ) {
            writeFile(fileWriter,fileText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeProductFromTableBase(Days days, String mealName, int productIndex) {
        List<String> fileText = new ArrayList<>(getFileText());
        changedChosenDay(mealName,fileText,days,productIndex);
        try(
                var fileWriter = new BufferedWriter(new FileWriter(file))
        ) {
            writeFile(fileWriter,fileText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void changedChosenDay(String mealName,List<String> fileText,Days days, String productInStringForm) {
        String changedDay = modifyDay(mealName, getDayToString(fileText,days),productInStringForm);
        switch (days) {
            case MONDAY -> addProductToChosenDay(fileText,changedDay,MONDAY_INDEX);
            case TUESDAY -> addProductToChosenDay(fileText,changedDay,TUESDAY_INDEX);
            case WEDNESDAY -> addProductToChosenDay(fileText,changedDay,WEDNESDAY_INDEX);
            case THURSDAY -> addProductToChosenDay(fileText,changedDay,THURSDAY_INDEX);
            case FRIDAY -> addProductToChosenDay(fileText,changedDay,FRIDAY_INDEX);
            case SATURDAY -> addProductToChosenDay(fileText,changedDay,SATURDAY_INDEX);
            case SUNDAY -> addProductToChosenDay(fileText,changedDay,SUNDAY_INDEX);
        }
    }
    private static void addProductToChosenDay(List<String> fileText,String changedDay,int dayIndex) {
        fileText.remove(dayIndex);
        fileText.add(dayIndex,changedDay);
    }
    private static List<String> getFileText() {
        List<String> fileText = new ArrayList<>();
        for (int i = 0; i <=7 ; i++) {
            fileText.add(ProductTableViewsReader.readProductBase(i));
        }
        return fileText;
    }
    private static String getDayToString(List<String> fileTtext, Days days) {
        String day = "";
        switch (days) {
            case MONDAY -> day = fileTtext.get(MONDAY_INDEX);
            case TUESDAY -> day = fileTtext.get(TUESDAY_INDEX);
            case WEDNESDAY -> day = fileTtext.get(WEDNESDAY_INDEX);
            case THURSDAY -> day = fileTtext.get(THURSDAY_INDEX);
            case FRIDAY -> day = fileTtext.get(FRIDAY_INDEX);
            case SATURDAY -> day = fileTtext.get(SATURDAY_INDEX);
            case SUNDAY -> day = fileTtext.get(SUNDAY_INDEX);
        }
        return day;
    }
    private static String modifyDay(String meal,String fullDay,String product) {
        String dayName = fullDay.split(DAY_SEPARATOR)[DAY_NAME_INDEX];
        List<String> dayMeals = new ArrayList<>(Arrays.stream(fullDay.split(DAY_SEPARATOR)[DAY_MEALS_INDEX].split(MEAL_SEPARATOR)).toList());
        switch (meal) {
            case "BREAKFAST" -> addProductToChosenMeal(fullDay,dayMeals,BREAKFAST_PRODUCTS_INDEX,product);
            case "BRUNCH" -> addProductToChosenMeal(fullDay,dayMeals,BRUNCH_PRODUCTS_INDEX,product);
            case "LUNCH" ->  addProductToChosenMeal(fullDay,dayMeals,LUNCH_PRODUCTS_INDEX,product);
            case "SUPPER" ->  addProductToChosenMeal(fullDay,dayMeals,SUPPER_PRODUCTS_INDEX,product);
        }
        return returnChangedFullDayString(dayName,dayMeals);
    }

    //Method remove old (String) products and add new (String) products with given product from all meals list
    private static void addProductToChosenMeal(String fullDay,List<String> dayMeals,int mealIndex,String product) {
         dayMeals.remove(mealIndex);
        dayMeals.add(mealIndex, mealProducts(fullDay,mealIndex,product));
    }

    /*Method return fullDay String which is saved in the file, for example:
    TUESDAY###BREAKFAST#Passata z Bazylią@Pudliszki@40@1.6@6.7@0.5@300;Mięso z łopatki wieprzowej@Kaufland@128@19.5@0.6@5.4@400;Makaron Spaggeti@Kaufland@368@15@68@3.3@150#BRUNCH#Twaróg chudy@Delikate@90@17@2.9@0.5@500;Cebula@Brak@33@1.4@6.9@0.4@150#Lunch#Jajo Kurze@Brak@140@12.5@0.6@9.7@400;Chleb zwykly@Biedronka@255@6.5@56.3@1.3@100#Supper#Jogurt Naturalny@Bakoma@60@4.3@6.2@2@400
    */
    private static String returnChangedFullDayString(String dayName, List<String> dayMeals) {
        return  dayName + DAY_SEPARATOR +
                dayMeals.get(MEAL_NAME_BREAKFAST_INDEX)+ MEAL_SEPARATOR + dayMeals.get(BREAKFAST_PRODUCTS_INDEX) +  MEAL_SEPARATOR +
                dayMeals.get(MEAL_NAME_BRUNCH_INDEX)+ MEAL_SEPARATOR + dayMeals.get(BRUNCH_PRODUCTS_INDEX) + MEAL_SEPARATOR +
                dayMeals.get(MEAL_NAME_LUNCH_INDEX)+ MEAL_SEPARATOR + dayMeals.get(LUNCH_PRODUCTS_INDEX) + MEAL_SEPARATOR +
                dayMeals.get(MEAL_NAME_SUPPER_INDEX)+ MEAL_SEPARATOR + dayMeals.get(SUPPER_PRODUCTS_INDEX);
    }

    /*method check day products - if day is empty(day products is only ";") method add only (String) product if string
    isn't empty method stick (String) product to (String) meal products. This is necessary to avoid ProductTableReader
    throw exception, for example:
    BREAKFAST#; return: product1
    BREAKFAST#(STRING) product1  return: (String) product1;(String) product2
    */
    public static String mealProducts(String day, int mealIndex, String product) {
     if (day.split(DAY_SEPARATOR)[DAY_MEALS_INDEX].split(MEAL_SEPARATOR)[mealIndex].equals(";")) return product;
     else return day.split(DAY_SEPARATOR)[DAY_MEALS_INDEX].split(MEAL_SEPARATOR)[mealIndex]+ ";" + product;
    }
    private static String modifyDay(String meal,String fullDay,int productIndex) {
        String dayName = fullDay.split(DAY_SEPARATOR)[DAY_NAME_INDEX];
        List<String> dayMeals = new ArrayList<>(Arrays.stream(fullDay.split(DAY_SEPARATOR)[DAY_MEALS_INDEX].split(MEAL_SEPARATOR)).toList());

        switch (meal) {
            case "BREAKFAST" -> deleteProductFromChosenMeal(dayMeals,BREAKFAST_PRODUCTS_INDEX,productIndex);
            case "BRUNCH" -> deleteProductFromChosenMeal(dayMeals,BRUNCH_PRODUCTS_INDEX,productIndex);
            case "LUNCH" -> deleteProductFromChosenMeal(dayMeals,LUNCH_PRODUCTS_INDEX,productIndex);
            case "SUPPER" -> deleteProductFromChosenMeal(dayMeals,SUPPER_PRODUCTS_INDEX,productIndex);
        }

        return returnChangedFullDayString(dayName,dayMeals);
    }
    private static void changedChosenDay(String meal,List<String> fileText,Days days, int productIndex) {
        String changedDay = modifyDay(meal, getDayToString(fileText,days),productIndex);
        switch (days) {
            case MONDAY -> addProductToChosenDay(fileText,changedDay,MONDAY_INDEX);
            case TUESDAY -> addProductToChosenDay(fileText,changedDay,TUESDAY_INDEX);
            case WEDNESDAY -> addProductToChosenDay(fileText,changedDay,WEDNESDAY_INDEX);
            case THURSDAY -> addProductToChosenDay(fileText,changedDay,THURSDAY_INDEX);
            case FRIDAY -> addProductToChosenDay(fileText,changedDay,FRIDAY_INDEX);
            case SATURDAY -> addProductToChosenDay(fileText,changedDay,SATURDAY_INDEX);
            case SUNDAY -> addProductToChosenDay(fileText,changedDay,SUNDAY_INDEX);
        }
    }
    private static void deleteProductFromChosenMeal(List<String> dayMeals,int mealProductsIndex,int productIndex) {
        String mealProducts = deleteProduct(dayMeals.get(mealProductsIndex),productIndex);
        dayMeals.remove(mealProductsIndex);
        dayMeals.add(mealProductsIndex,mealProducts);
    }

    /*Method delete product from chosen day from chosen meal and return others products in string form
    if meal has only one product method remove product and return ;
    to maintain the continuity of the addProductToTableBase algorithm
     */
    private static String deleteProduct(String mealProducts,int productIndex) {
       List<String> products = new ArrayList<>( Arrays.stream(mealProducts.split(PRODUCT_SEPARATOR)).toList());
       if(products.size()==1) return ";";

       else {
           products.remove(productIndex);
           return mealProducts(products);
       }
     }

     //Method return full products of meal in String form
     private static String mealProducts(List<String> fullMealProducts) {
        StringBuilder stringBuilder = new StringBuilder();
         for (int i = 0; i < fullMealProducts.size()-1; i++) {
             stringBuilder.append(fullMealProducts.get(i)).append(";");
         }
         stringBuilder.append(fullMealProducts.get(fullMealProducts.size()-1));
         return stringBuilder.toString();
     }

     //method overwrites file by changed Day ( add or delete)
     private static void writeFile(BufferedWriter fileWriter, List<String> file) throws IOException {
         for (int i = 0; i <=7; i++) {
             fileWriter.write(file.get(i));
             fileWriter.newLine();
         }
     }
    }

