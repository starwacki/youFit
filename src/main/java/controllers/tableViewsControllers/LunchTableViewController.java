package controllers.tableViewsControllers;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.calories.CaloriesCalculator;
import model.language.*;
import model.product.DaysMeals;
import model.product.Product;

import java.time.DayOfWeek;
import java.util.List;
public class LunchTableViewController {
    @FXML
    private AnchorPane lunchTableView;
    @FXML
    private TableView<Product> lunchTableViewController;
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
    private Label carbsLunchLabelController;
    @FXML
    private Label fatLunchLabelController;
    @FXML
    private Label kcalLunchLabelController;
    @FXML
    private Label proteinsLunchLabelController;
    @FXML
    private Button lunchEditButtonController;
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
    @FXML
    private Label timeLabelController;
    public void initialize(){
        setColumnsSettings();
        editButtonListener();
        setLanguage(new Language().getLunchTableViewLanguage());

    }
    public void addProductsToActualTableView(List<Product> productList) {
        int i = 0;
        for (Product product: productList) {
            lunchTableViewController.getItems().add(i,product);
            i++;
        }
    }
    public void removeAllTableViewProducts() {
         lunchTableViewController.getItems().removeAll(lunchTableViewController.getItems());
    }
    public void setThisMealMicronutrientsLabels(DaysMeals daysMeals, DayOfWeek days) {
        proteinsLunchLabelController.setText(Double.toString((int) CaloriesCalculator.getProteinsFromMeal(daysMeals.getDaysListMap().get(days).get(0).getLunch())));
        carbsLunchLabelController.setText(Double.toString((int) CaloriesCalculator.getCarbohydratesFromMeal(daysMeals.getDaysListMap().get(days).get(0).getLunch())));
        fatLunchLabelController.setText(Double.toString((int) CaloriesCalculator.getFatFromMeal(daysMeals.getDaysListMap().get(days).get(0).getLunch())));
        kcalLunchLabelController.setText(Double.toString((int) CaloriesCalculator.getCaloriesFromMeal(daysMeals.getDaysListMap().get(days).get(0).getLunch())));
    }
    public Button getLunchEditButtonController() {
        return lunchEditButtonController;
    }
    public AnchorPane getLunchTableView() {
        return lunchTableView;
    }
    public TableView<Product> getLunchTableViewController() {
        return lunchTableViewController;
    }
    public double getLunchProteinsPercentInMeal() {
        return  getLabelValue(proteinsLunchLabelController)*CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES
                /getApproximateCaloriesFromLabels()*100;
    }
    public double getLunchCarbohydratesPercentInMeal() {
        return  getLabelValue(carbsLunchLabelController)*CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES
                /getApproximateCaloriesFromLabels()*100;
    }
    public double getLunchFatPercentInMeal() {
        return  getLabelValue(fatLunchLabelController)*CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES
                /getApproximateCaloriesFromLabels()*100;
    }

    private void setLanguage(LunchTableViewLanguage language){
        setLanguageLabels(language);
        setUserLabels();
    }
    private void setLanguageLabels(LunchTableViewLanguage language) {
        nameLabelController.setText(language.getMealName());
        proteinsInfoLabelController.setText(language.getProteinsInfoLabelController());
        carbohydratesInfoLabelController.setText(language.getCarbohydratesInfoLabelController());
        fatInfoLabelController.setText(language.getFatInfoLabelController());
        caloriesInfoLabelController.setText(language.getCaloriesInfoLabelController());
    }
    private void setUserLabels() {
        if (TablesLabels.basicLunchName!=null) nameLabelController.setText(TablesLabels.basicLunchName);
        if (TablesLabels.basicLunchTime!=null) timeLabelController.setText(TablesLabels.basicLunchTime);
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
        lunchEditButtonController.addEventFilter(MouseEvent.MOUSE_ENTERED, actionEvent -> lunchEditButtonController.getGraphic().setOpacity(0.7));
    }
    private void setOpacityToBasic () {
        lunchEditButtonController.addEventFilter(MouseEvent.MOUSE_EXITED, actionEvent -> lunchEditButtonController.getGraphic().setOpacity(1));
    }
    private double getApproximateCaloriesFromLabels () {
        return  getLabelValue(proteinsLunchLabelController)*CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES +
                getLabelValue(carbsLunchLabelController)*CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES +
                getLabelValue(fatLunchLabelController)*CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES;
    }
    private double getLabelValue(Label label) {
        return  Double.parseDouble(label.getText());
    }
}