package controllers.SwitchScenesControllers;

import controllers.MainEditPaneController;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.language.EditPaneLanguage;
import model.language.Language;
import model.product.ProductBase;
import model.product.ProductFromBase;
import java.util.List;
import java.util.stream.Collectors;

public class EditPaneController {
    private static final String EMPTY_FIELD = "";

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
    private List<ProductFromBase> listview;


    public void initialize() {
        setLanguage(new Language().getEditPaneLanguage());
        listview =  ProductBase.productBase;
        addProductToListView(listview);
        setTextFieldOnlyNumeric(weightTextFieldController);
        changeListView();
        searchProduct();
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

}