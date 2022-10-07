package controllers.tableViewsControllers;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.calories.CaloriesCalculator;
import model.language.BrunchTableViewLanguage;
import model.language.Language;
import model.language.TablesLabels;
import model.product.DaysMeals;
import model.product.Product;

import java.time.DayOfWeek;
import java.util.List;
public class BrunchTableViewController {
    @FXML
    private AnchorPane brunchTableView;
    @FXML
    private TableView<Product> brunchTableViewController;
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
    private Label carbsBrunchLabelController;
    @FXML
    private Label fatBrunchLabelController;
    @FXML
    private Label kcalBrunchLabelController;
    @FXML
    private Label proteinsBrunchLabelController;
    @FXML
    private Button brunchEditButtonController;
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
        setLanguage(new Language().getBrunchTableViewLanguage());

    }
    public void addProductsToActualTableView(List<Product> productList) {
        int i = 0;
        for (Product product: productList) {
            brunchTableViewController.getItems().add(i,product);
            i++;
        }
    }
    public void removeAllTableViewProducts() {
        brunchTableViewController.getItems().removeAll(brunchTableViewController.getItems());
    }
    public void setThisMealMicronutrientsLabels(DaysMeals daysMeals, DayOfWeek days) {
        proteinsBrunchLabelController.setText(Double.toString((int)CaloriesCalculator.getProteinsFromMeal(daysMeals.getDaysListMap().get(days).get(0).getBrunch())));
        carbsBrunchLabelController.setText(Double.toString((int)CaloriesCalculator.getCarbohydratesFromMeal(daysMeals.getDaysListMap().get(days).get(0).getBrunch())));
        fatBrunchLabelController.setText(Double.toString((int)CaloriesCalculator.getFatFromMeal(daysMeals.getDaysListMap().get(days).get(0).getBrunch())));
        kcalBrunchLabelController.setText(Double.toString((int)CaloriesCalculator.getCaloriesFromMeal(daysMeals.getDaysListMap().get(days).get(0).getBrunch())));
    }
    public TableView<Product> getBrunchTableViewController() {
        return brunchTableViewController;
    }
    public Button getBrunchEditButtonController() {
        return brunchEditButtonController;
    }
    public AnchorPane getBrunchTableView() {
        return brunchTableView;
    }
    public double getBrunchProteinsPercentInMeal() {
        return  getLabelValue(proteinsBrunchLabelController)*CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES
                /getApproximateCaloriesFromLabels()*100;
    }
    public double getBrunchCarbohydratesPercentInMeal() {
        return  getLabelValue(carbsBrunchLabelController)*CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES
                /getApproximateCaloriesFromLabels()*100;
    }
    public double getBrunchFatPercentInMeal() {
        return  getLabelValue(fatBrunchLabelController)*CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES
                /getApproximateCaloriesFromLabels()*100;
    }
    private void setLanguage(BrunchTableViewLanguage language){
        setLanguageLabels(language);
        setUserLabels();
    }
    private void setLanguageLabels(BrunchTableViewLanguage language) {
        nameLabelController.setText(language.getMealName());
        proteinsInfoLabelController.setText(language.getProteinsInfoLabelController());
        carbohydratesInfoLabelController.setText(language.getCarbohydratesInfoLabelController());
        fatInfoLabelController.setText(language.getFatInfoLabelController());
        caloriesInfoLabelController.setText(language.getCaloriesInfoLabelController());
    }
    private void setUserLabels() {
        if (TablesLabels.basicBrunchName !=null) nameLabelController.setText(TablesLabels.basicBrunchName);
        if (TablesLabels.basicBrunchTime!=null) timeLabelController.setText(TablesLabels.basicBrunchTime);
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
        brunchEditButtonController.addEventFilter(MouseEvent.MOUSE_ENTERED, actionEvent -> brunchEditButtonController.getGraphic().setOpacity(0.7));
    }
    private void setOpacityToBasic () {
        brunchEditButtonController.addEventFilter(MouseEvent.MOUSE_EXITED, actionEvent -> brunchEditButtonController.getGraphic().setOpacity(1));
    }
    private double getApproximateCaloriesFromLabels () {
        return  getLabelValue(proteinsBrunchLabelController)*CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES +
                getLabelValue(carbsBrunchLabelController)*CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES +
                getLabelValue(fatBrunchLabelController)*CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES;
    }
    private double getLabelValue(Label label) {
        return  Double.parseDouble(label.getText());
    }
}