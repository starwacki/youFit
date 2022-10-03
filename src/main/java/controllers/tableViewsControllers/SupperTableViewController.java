package controllers.tableViewsControllers;
import io.LanguageIO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.calories.CaloriesCalculator;
import model.Days;
import model.language.BreakfastTableViewLanguage;
import model.language.Language;
import model.language.SupperTableViewLanguage;
import model.product.DaysMeals;
import model.product.Product;
import java.util.List;
public class SupperTableViewController {
    @FXML
    private AnchorPane supperTableView;
    @FXML
    private TableView<Product> supperTableViewController;
    @FXML
    private TableColumn<Product, String> carbsTableColumnController;
    @FXML
    private TableColumn<Product, String> fatTableColumnController;
    @FXML
    private TableColumn<Product, String> kcalTableColumnController;
    @FXML
    private TableColumn<Product, String> nameTableColumnController;
    @FXML
    private TableColumn<Product, String> producerTableColumnController;
    @FXML
    private TableColumn<Product, String> proteinsTableColumnController;
    @FXML
    private TableColumn<Product, String> weightTableColumnController;
    @FXML
    private Label carbsSupperLabelController;
    @FXML
    private Label fatSupperLabelController;
    @FXML
    private Label kcalSupperLabelController;
    @FXML
    private Label proteinsSupperLabelController;
    @FXML
    private Button supperEditButtonController;
    @FXML
    private Label proteinsInfoLabelController;
    @FXML
    private Label carbohydratesInfoLabelController;
    @FXML
    private Label fatInfoLabelController;
    @FXML
    private Label caloriesInfoLabelController;
    @FXML
    private Label nameLabelController;
    public void initialize() {
        setColumnsSettings();
        editButtonListener();
        setLanguage(new Language().getSupperTableViewLanguage());
    }
    public void addProductsToActualTableView(List<Product> productList) {
        int i = 0;
        for (Product product: productList) {
           supperTableViewController.getItems().add(i,product);
            i++;
        }
    }
    public void removeAllTableViewProducts() {
       supperTableViewController.getItems().removeAll(supperTableViewController.getItems());
    }
    public void setThisMealMicronutrientsLabels(DaysMeals daysMeals, Days days) {
        proteinsSupperLabelController.setText(Double.toString((int) CaloriesCalculator.getProteinsFromMeal(daysMeals.getDaysListMap().get(days).get(0).getSupper())));
        carbsSupperLabelController.setText(Double.toString((int) CaloriesCalculator.getCarbohydratesFromMeal(daysMeals.getDaysListMap().get(days).get(0).getSupper())));
        fatSupperLabelController.setText(Double.toString((int) CaloriesCalculator.getFatFromMeal(daysMeals.getDaysListMap().get(days).get(0).getSupper())));
        kcalSupperLabelController.setText(Double.toString((int) CaloriesCalculator.getCaloriesFromMeal(daysMeals.getDaysListMap().get(days).get(0).getSupper())));
    }
    public Button getSupperEditButtonController() {
        return supperEditButtonController;
    }
    public AnchorPane getSupperTableView() {
        return supperTableView;
    }
    public TableView<Product> getSupperTableViewController() {
        return supperTableViewController;
    }
    public double getSupperProteinsPercentInMeal() {
        return  getLabelValue(proteinsSupperLabelController)*CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES
                /getApproximateCaloriesFromLabels()*100;
    }
    public double getSupperCarbohydratesPercentInMeal() {
        return  getLabelValue(carbsSupperLabelController)*CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES
                /getApproximateCaloriesFromLabels()*100;
    }
    public double getSupperFatPercentInMeal() {
        return  getLabelValue(fatSupperLabelController)*CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES
                /getApproximateCaloriesFromLabels()*100;
    }
    private void setLanguage(SupperTableViewLanguage language){
        nameLabelController.setText(language.getMealName());
        proteinsInfoLabelController.setText(language.getProteinsInfoLabelController());
        carbohydratesInfoLabelController.setText(language.getCarbohydratesInfoLabelController());
        fatInfoLabelController.setText(language.getFatInfoLabelController());
        caloriesInfoLabelController.setText(language.getCaloriesInfoLabelController());
    }
    private void setColumnsSettings() {
        setCellValueFactory();
        setReorderable();
    }
    private void setReorderable() {
        nameTableColumnController.setReorderable(false);
        producerTableColumnController.setReorderable(false);
        weightTableColumnController.setReorderable(false);
        kcalTableColumnController.setReorderable(false);
        fatTableColumnController.setReorderable(false);
        proteinsTableColumnController.setReorderable(false);
        carbsTableColumnController.setReorderable(false);
    }
    private void setCellValueFactory() {
        nameTableColumnController.setCellValueFactory(new PropertyValueFactory<>("nameOfProduct"));
        producerTableColumnController.setCellValueFactory(new PropertyValueFactory<>("producer"));
        weightTableColumnController.setCellValueFactory(new PropertyValueFactory<>("weight"));
        kcalTableColumnController.setCellValueFactory(new PropertyValueFactory<>("kcal"));
        fatTableColumnController.setCellValueFactory(new PropertyValueFactory<>("fat"));
        proteinsTableColumnController.setCellValueFactory(new PropertyValueFactory<>("proteins"));
        carbsTableColumnController.setCellValueFactory(new PropertyValueFactory<>("carbohydrates"));
    }
    private void editButtonListener() {
        setOpacityLower();
        setOpacityToBasic();
    }
    private void setOpacityLower() {
        supperEditButtonController.addEventFilter(MouseEvent.MOUSE_ENTERED, actionEvent -> supperEditButtonController.getGraphic().setOpacity(0.7));
    }
    private void setOpacityToBasic () {
        supperEditButtonController.addEventFilter(MouseEvent.MOUSE_EXITED, actionEvent -> supperEditButtonController.getGraphic().setOpacity(1));
    }
    private double getApproximateCaloriesFromLabels () {
        return  getLabelValue(proteinsSupperLabelController)*CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES +
                getLabelValue(carbsSupperLabelController)*CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES +
                getLabelValue(fatSupperLabelController)*CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES;
    }
    private double getLabelValue(Label label) {
        return  Double.parseDouble(label.getText());
    }
}