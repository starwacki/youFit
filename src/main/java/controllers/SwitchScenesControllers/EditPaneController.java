package controllers.SwitchScenesControllers;

import controllers.MainEditPaneController;
import dao.QueryExecutor;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.calories.CaloriesCalculator;
import model.language.EditPaneLanguage;
import model.language.Language;
import model.product.ProductBase;
import model.product.ProductFromBase;
import java.util.List;
import java.util.stream.Collectors;

public class EditPaneController {
    private static final String EMPTY_FIELD = "";
    private static final int MAX_LENGTH = 20;
    private static final int VISIBLE_OPACITY = 1;
    private static final int MAX_MICRONUTRIENT_PER_100G_VALUE = 100;
    private static final double POSSIBLE_VALUE_OF_THE_DISCREPANCY_IN_PERCENT = 0.15;
    private static final String ERROR_STYLE = "-fx-text-fill: red";
    private static final String SUCCESSIVELY_ADDED_STYLE = "-fx-text-fill: green";
    private static final String INCORRECT_MICRONUTRIENT_VALUE_TEXT_STYLE = "-fx-text-fill: red";
    private static final String CORRECT_MICRONUTRIENT_VALUE_TEXT_STYLE = "-fx-text-fill: black";
    private static  String EMPTY_TEXT_FIELD_ERROR = "empty text field error";
    private static  String INCORRECT_SUM_OF_MICRONUTRIENTS_CALORIES_ERROR = "incorrect sum of micronutrients calories ERROR";
    private static  String INCORRECT_SUM_OF_MICRONUTRIENTS_PER_100G_ERROR = "incorrect sum of micronutrients per 100g ERROR";
    private static  String INCORRECT_MICRONUTRIENTS_VALUES_ERROR = "incorrect  micronutrients values ERROR";
    private static  String PRODUCT_SUCCESSIVELY_ADDED_INFO = "product successively added info";


    @FXML
    private AnchorPane editPaneController;
    @FXML
    private Label carbohydratesPieCharLabelController;
    @FXML
    private Button addProductToListViewButtonController;
    @FXML
    private Label fatPieCharLabelController;
    @FXML
    private PieChart pieChartController;
    @FXML
    private Label proteinsPieCharLabelController;
    @FXML
    private TextField weightTextFieldController;
    @FXML
    private ListView<ProductFromBase> productsBaseListView;
    @FXML
    private TextField searchTextFieldController;
    @FXML
    private Button changeListViewButtonController;
    @FXML
    private Button addNewProductToYourBase;
    @FXML
    private Label percentageOfMacronutrientsLabelController;
    @FXML
    private Label selectProductToAddInfoLabelController;
    @FXML
    private Label searchLabelController;
    @FXML
    private Label weightInfoLabelController;
    @FXML
    private Label addNewProductToYourBaseInfoLabelController;
    @FXML
    private Label productNameInfoLabelController;
    @FXML
    private Label producerInfoLabelController;
    @FXML
    private Label proteinsPer100gInfoLabelController;
    @FXML
    private Label caloriesPer100gInfoLabelController;
    @FXML
    private Label carbsPer100gInfoLabelController;
    @FXML
    private Label fatPer100gInfoLabelController;
    @FXML
    private TextField productTextFieldController;
    @FXML
    private TextField producerTextFieldController;
    @FXML
    private TextField caloriesPer100gTextFieldController;
    @FXML
    private TextField proteinsPer100gTextFieldController;
    @FXML
    private TextField carbsPer100gTextFieldController;
    @FXML
    private TextField fatPer100gTextFieldController;
    @FXML
    private Label addNewProductInfoLabel;

    private List<ProductFromBase> listview;


    public void initialize() {
        setLanguage(new Language().getEditPaneLanguage());
        listview =  ProductBase.productBase;
        addProductToListView(listview);
        setTextFieldOnlyNumeric(weightTextFieldController);
        changeListView();
        searchProduct();
        blockAllTextFieldsIncorrectValues();
        addNewProductToBaseByClickedButton();
    }
    private void setLanguage(EditPaneLanguage language) {
        percentageOfMacronutrientsLabelController.setText(language.getPercentageOfMacronutrientsLabelController());
        proteinsPieCharLabelController.setText(language.getProteinsPieCharLabelController());
        carbohydratesPieCharLabelController.setText(language.getCarbohydratesPieCharLabelController());
        fatPieCharLabelController.setText(language.getFatPieCharLabelController());
        selectProductToAddInfoLabelController.setText(language.getSelectProductToAddInfoLabelController());
        searchLabelController.setText(language.getSearchLabelController());
        changeListViewButtonController.setText(language.getChangeListViewButtonController());
        weightInfoLabelController.setText(language.getWeightInfoLabelController());
        addNewProductToYourBaseInfoLabelController.setText(language.getAddNewProductToYourBaseInfoLabelController());
        productNameInfoLabelController.setText(language.getProductNameInfoLabelController());
        producerInfoLabelController.setText(language.getProducerInfoLabelController());
        caloriesPer100gInfoLabelController.setText(language.getCaloriesPer100gInfoLabelController());
        proteinsPer100gInfoLabelController.setText(language.getProteinsPer100gInfoLabelController());
        carbsPer100gInfoLabelController.setText(language.getCarbsPer100gInfoLabelController());
        fatPer100gInfoLabelController.setText(language.getFatPer100gInfoLabelController());
        addNewProductToYourBase.setText(language.getAddNewProductToYourBase());
        EMPTY_TEXT_FIELD_ERROR = language.getEmptyTextFieldError();
        INCORRECT_SUM_OF_MICRONUTRIENTS_PER_100G_ERROR = language.getIncorrectSumOfMicronutrientsPer100gError();
        INCORRECT_MICRONUTRIENTS_VALUES_ERROR = language.getIncorrectMicronutrientsValuesError();
        INCORRECT_SUM_OF_MICRONUTRIENTS_CALORIES_ERROR = language.getIncorrectSumOfMicronutrientsCaloriesError();
        PRODUCT_SUCCESSIVELY_ADDED_INFO = language.getProductSuccessivelyAddedInfo();
    }

    public PieChart getPieChartController() {
        return pieChartController;
    }

    public Label getProteinsPieCharLabelController() {
        return proteinsPieCharLabelController;
    }

    public Label getCarbohydratesPieCharLabelController() {
        return carbohydratesPieCharLabelController;
    }

    public Label getFatPieCharLabelController() {
        return fatPieCharLabelController;
    }

    public ListView<ProductFromBase> getProductsBaseListView() {
        return productsBaseListView;
    }

    public Button getAddProductToListViewButtonController() {
        return addProductToListViewButtonController;
    }

    public TextField getWeightTextFieldController() {
        return weightTextFieldController;
    }

    private void setTextFieldOnlyNumeric(TextField textField) {
        textField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (textField.getText()!=null && newValue.length()>0) {
                if (String.valueOf(newValue.charAt(0)).matches("\\D")) {
                    textField.setText("");
                }
                else if (!(String.valueOf(newValue.charAt(newValue.length()-1)).matches("\\D")) || newValue.charAt(newValue.length()-1)=='.') {
                    if (newValue.charAt(newValue.length()-1)=='.' && newValue.charAt(newValue.length()-2)=='.') {
                        textField.setText(oldValue);
                    }
                    else if (newValue.length()>1 && newValue.substring(0,newValue.length()-2).contains(".")) textField.setText(oldValue);
                }
                else {
                    textField.setText(oldValue);
                }
            }
        });
    }

   private void addProductToListView(List<ProductFromBase> list) {
       productsBaseListView.getItems().clear();
       productsBaseListView.getItems().addAll(list);
   }

   private void searchProduct() {
        if (MainEditPaneController.isMainBase()) searchProductInList();
        else  searchProductInList();
   }

   private void searchProductInList() {
       searchTextFieldController.addEventHandler(KeyEvent.ANY, keyEvent -> {
                   if (searchTextFieldController == null) addProductToListView(listview);
                   else if (searchTextFieldController.getText().equals(EMPTY_FIELD)) addProductToListView(listview);
                   else addProductToListView(listview.stream().filter(s -> s.toString().toLowerCase().contains(searchTextFieldController.getText())).collect(Collectors.toList()));
               }
       );}

    private void changeListView() {
        changeListViewButtonController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            if (MainEditPaneController.isMainBase()) setListView(ProductBase.productBase,false);
            else setListView(ProductBase.productBase,true);

        });
    }

    private void setListView(List<ProductFromBase> listView, boolean isMainBase) {
        this.listview = listView;
        addProductToListView(listview);
        MainEditPaneController.setMainBase(isMainBase);
    }

    private void blockAllTextFieldsIncorrectValues() {
        blockIncorrectTextFieldsValues();
        blockTooLongTextFieldsValues();
    }

    private void blockIncorrectTextFieldsValues() {
        setTextFieldOnlyNumeric(caloriesPer100gTextFieldController);
        setTextFieldOnlyNumeric(proteinsPer100gTextFieldController);
        setTextFieldOnlyNumeric(carbsPer100gTextFieldController);
        setTextFieldOnlyNumeric(fatPer100gTextFieldController);
    }

    private void blockTooLongTextFieldsValues() {
        setTextFieldTextAppropriateLength(productTextFieldController);
        setTextFieldTextAppropriateLength(producerTextFieldController);
    }

    private void setTextFieldTextAppropriateLength(TextField textField) {
        textField.textProperty().addListener((observableValue, s, t1) -> {
            if (t1.length()> MAX_LENGTH) textField.setText(s);
        });
    }

    private boolean areTextFieldsPer100gCorrectValues() {
        return     isTextFieldPer100gCorrectValues(proteinsPer100gTextFieldController) && isTextFieldPer100gCorrectValues(carbsPer100gTextFieldController)
                && isTextFieldPer100gCorrectValues(fatPer100gTextFieldController);
    }

    private boolean isTextFieldPer100gCorrectValues(TextField textField) {
       return  Double.parseDouble(textField.getText()) <= MAX_MICRONUTRIENT_PER_100G_VALUE;
    }

    private void addNewProductToBaseByClickedButton() {
        addNewProductToYourBase.addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> addNewProductToBase());
    }

    private void addNewProductToBase() {
        if (!areTextFieldsEmpty()) {
            if (areTextFieldsPer100gCorrectValues()) {
                if (isMicronutrientsPer100gSumCorrect()) {
                    if (isSumOfMicronutrientsCaloriesCorrect()) {
                        addProduct();
                    } else showAddNewProductInfoLabel(INCORRECT_SUM_OF_MICRONUTRIENTS_CALORIES_ERROR,ERROR_STYLE);
                } else showAddNewProductInfoLabel(INCORRECT_SUM_OF_MICRONUTRIENTS_PER_100G_ERROR,ERROR_STYLE);
            } else showAddNewProductInfoLabel(INCORRECT_MICRONUTRIENTS_VALUES_ERROR,ERROR_STYLE);
        } else showAddNewProductInfoLabel(EMPTY_TEXT_FIELD_ERROR,ERROR_STYLE);
    }

    private void addProduct() {
        showAddNewProductInfoLabel(PRODUCT_SUCCESSIVELY_ADDED_INFO,SUCCESSIVELY_ADDED_STYLE);
        addProductToBaseQuery();
        initializeNewProductBaseToActualProductBase();
    }

    private void addProductToBaseQuery() {
        QueryExecutor.putNewProductToBase(productTextFieldController.getText(),producerTextFieldController.getText(),
                Double.parseDouble(caloriesPer100gTextFieldController.getText()),Double.parseDouble(proteinsPer100gTextFieldController.getText()),
                Double.parseDouble(carbsPer100gTextFieldController.getText()),Double.parseDouble(fatPer100gTextFieldController.getText()));
    }


    //Micronutrients are defined per 100 grams of product. It's impossible to receive sum of micronutrients more than 100g!
    private boolean isMicronutrientsPer100gSumCorrect() {
        return    Double.parseDouble(proteinsPer100gTextFieldController.getText()) + Double.parseDouble(carbsPer100gTextFieldController.getText())
                + Double.parseDouble(fatPer100gTextFieldController.getText()) <= MAX_MICRONUTRIENT_PER_100G_VALUE;
    }


    /* Calories per 100g = CALORIES FROM PROTEIN + CALORIES FROM CARBOHYDRATES + CALORIES FROM FAT
       but slight discrepancy is possible (+-15%) .
     */
    private boolean isSumOfMicronutrientsCaloriesCorrect() {
        return     caloriesPer100g() > sumOfMicronutrientsCalories() - sumOfMicronutrientsCalories()*POSSIBLE_VALUE_OF_THE_DISCREPANCY_IN_PERCENT
                && caloriesPer100g() < sumOfMicronutrientsCalories() + sumOfMicronutrientsCalories()*POSSIBLE_VALUE_OF_THE_DISCREPANCY_IN_PERCENT;

    }

    private double sumOfMicronutrientsCalories() {
        return  Double.parseDouble(proteinsPer100gTextFieldController.getText()) * CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES +
                Double.parseDouble(carbsPer100gTextFieldController.getText()) * CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES +
                Double.parseDouble(fatPer100gTextFieldController.getText()) * CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES;
    }

    private double caloriesPer100g() {
        return Double.parseDouble(caloriesPer100gTextFieldController.getText());
    }

    private boolean isTextFieldEmpty(TextField textField) {
        if(textField == null) return true;
        else return textField.getText().equals(EMPTY_FIELD);
    }

    private boolean areTextFieldsEmpty() {
        return     isTextFieldEmpty(productTextFieldController) || isTextFieldEmpty(producerTextFieldController)
                || isTextFieldEmpty(caloriesPer100gTextFieldController) || isTextFieldEmpty(proteinsPer100gTextFieldController)
                || isTextFieldEmpty(carbsPer100gTextFieldController) || isTextFieldEmpty(fatPer100gTextFieldController);
    }

    private void showAddNewProductInfoLabel(String text,String style) {
        addNewProductInfoLabel.setStyle(style);
        addNewProductInfoLabel.setOpacity(VISIBLE_OPACITY);
        addNewProductInfoLabel.setText(text);
    }

    private void initializeNewProductBaseToActualProductBase() {
        ProductBase.initializeProductBase();
        listview =  ProductBase.productBase;
        addProductToListView(listview);

    }



}