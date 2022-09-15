package io;

import model.product.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class YourProductBaseIO {
    private static final String PRODUCT_SEPARATOR = ";";
    private static final int PRODUCT_NAME_INDEX = 0;
    private static final int PRODUCT_PRODUCER_NAME_INDEX = 1;
    private static final int PRODUCT_CALORIES_PER_100G_INDEX = 2;
    private static final int PRODUCT_PROTEINS_PER_100G_INDEX = 3;
    private static final int PRODUCT_CARBOHYDRATES_PER_100G_INDEX = 4;
    private static final int PRODUCT_FAT_PER_100G_INDEX = 5;
      private static final File file = new File("src/main/resources/yourProductBase.txt");

        public static void safeProductToYourBase(Product product) {
        try (
                var fileWriter = new BufferedWriter(new FileWriter(file,true))
                ) {
            fileWriter.newLine();
            fileWriter.write(product.getNameOfProduct() + ";" + product.getProducer() + ";" +
                                 product.getCaloriesPer100Grams() + ";" + product.getProteinsPer100Grams() + ";" +
                                 product.getCarbohydratesPer100Grams() +";" + product.getFatPer100Grams());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        }

    public static List<String> readProductBase() {
        List<String> list = new ArrayList<>();
        try(
                var fileReader = new BufferedReader(new FileReader(file))
        ) {

            String read = fileReader.readLine();

            while (read!=null) {
                read = fileReader.readLine();
                if (read!=null) addProductToObservableList(list,read);
            }
            return list;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static Product getProductFromBase(int index,double weight) {
        Product product;
        try (
                var fileReader = new BufferedReader(new FileReader(file))
        ) {

            String read = fileReader.readLine();
            for (int i = -1; i < index; i++) {
                read = fileReader.readLine();
            }

            product = createNewProduct(read,weight);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
    private static void addProductToObservableList(List<String> list,String read) {
        String[] line =  read.split( PRODUCT_SEPARATOR);
        list.add(line[PRODUCT_NAME_INDEX] + " - " + line[PRODUCT_PRODUCER_NAME_INDEX] + " " +
                line[PRODUCT_CALORIES_PER_100G_INDEX] + "kcal  " + line[PRODUCT_PROTEINS_PER_100G_INDEX] + "p " +
                line[PRODUCT_CARBOHYDRATES_PER_100G_INDEX] + "c " + line[PRODUCT_FAT_PER_100G_INDEX] + "f");
    }
    private static Product createNewProduct(String read,double weight) {
        String[] productString = read.split(";");
        return new Product(productString[PRODUCT_NAME_INDEX],productString[PRODUCT_PRODUCER_NAME_INDEX],
                Double.parseDouble(productString[PRODUCT_CALORIES_PER_100G_INDEX]),
                Double.parseDouble(productString[PRODUCT_PROTEINS_PER_100G_INDEX]),
                Double.parseDouble(productString[PRODUCT_CARBOHYDRATES_PER_100G_INDEX]),
                Double.parseDouble(productString[PRODUCT_FAT_PER_100G_INDEX]),weight);
    }
    }


