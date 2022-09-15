package io;
import model.product.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductBaseReader {
    private static final String PRODUCT_SEPARATOR = ";";
    private static final int PRODUCT_NAME_INDEX = 0;
    private static final int PRODUCT_CALORIES_INDEX = 1;
    private static final int PRODUCT_PROTEINS_INDEX = 2;
    private static final int PRODUCT_FAT_INDEX = 3;
    private static final int PRODUCT_CARBOHYDRATES_INDEX = 4;

    private  static final File file = new File("src/main/resources/productBase.txt");
    public static List<String> readProductBase() {
        List<String> list = new ArrayList<>();
        try (
                var fileReader = new BufferedReader(new FileReader(file))
        ) {
            String read = fileReader.readLine();

            while (read != null) {
                read = fileReader.readLine();
                if (read != null)  addProductToObservableList(read,list);
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

            String chosenProduct = getChosenProductFromFile(index,fileReader);
            product = createNewProduct(weight,chosenProduct);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    private static void addProductToObservableList(String read,List<String> list) {
        String[] line = read.split(PRODUCT_SEPARATOR);
        list.add(line[PRODUCT_NAME_INDEX] + " " + line[PRODUCT_CALORIES_INDEX] + "kcal  " +
                line[PRODUCT_PROTEINS_INDEX] + "p " + line[PRODUCT_CARBOHYDRATES_INDEX] + "c " +
                line[PRODUCT_FAT_INDEX] + "f");
    }

    private static Product createNewProduct(double weight,String read) {
        String[] productString = read.split(PRODUCT_SEPARATOR);
        return new Product(productString[PRODUCT_NAME_INDEX],"brak",
                Double.parseDouble(productString[PRODUCT_CALORIES_INDEX]),
                Double.parseDouble(productString[PRODUCT_PROTEINS_INDEX]),
                Double.parseDouble(productString[PRODUCT_CARBOHYDRATES_INDEX]),
                Double.parseDouble(productString[PRODUCT_FAT_INDEX]),weight);
    }

    private static String getChosenProductFromFile(int index, BufferedReader fileReader) throws IOException {
        String read = fileReader.readLine();
        for (int i = -1; i < index; i++) {
            read = fileReader.readLine();
        }
        return read;
    }


    }

