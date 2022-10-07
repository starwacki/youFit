package controllers.tableViewsControllers;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.calories.CaloriesCalculator;
import model.language.BreakfastTableViewLanguage;
import model.language.Language;
import model.language.TablesLabels;
import model.product.DaysMeals;
import model.product.Product;

import java.time.DayOfWeek;
import java.util.List;
public class BreakfastTableViewController {
    private static boolean isTableHide = false;
    private static final  String SHOW_TABLE_IMAGE_VIEW_PATH = "/img/show-table.png";
    private static final  String HIDE_TABLE_IMAGE_VIEW_PATH = "/img/hide-table.png";
    @FXML
    private AnchorPane breakfastTableView;
    @FXML
    private TableView<Product> breakfastTableViewController;
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
    private Label carbsBreakfastLabelController;
    @FXML
    private Label fatBreakfastLabelController;
    @FXML
    private Label kcalBreakfastLabelController;
    @FXML
    private Label proteinsBreakfastLabelController;
    @FXML
    private Button breakfastEditButtonController;
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
    @FXML
    private ImageView hideTableViewImageViewController;


    public void initialize() {
        setColumnsSettings();
        editButtonListener();
        setLanguage(new Language().getBreakfastTableViewLanguage());
        changeTableViewOpacity();
    }

    public void addProductsToActualTableView(List<Product> productList) {
        int i = 0;
        for (Product product : productList) {
            breakfastTableViewController.getItems().add(i, product);
            i++;
        }
    }

    public void removeAllTableViewProducts() {
        breakfastTableViewController.getItems().removeAll(breakfastTableViewController.getItems());
    }

    public void setThisMealMicronutrientsLabels(DaysMeals daysMeals, DayOfWeek days) {
        proteinsBreakfastLabelController.setText(Double.toString((int) CaloriesCalculator.getProteinsFromMeal(daysMeals.getDaysListMap().get(days).get(0).getBreakfast())));
        carbsBreakfastLabelController.setText(Double.toString((int) CaloriesCalculator.getCarbohydratesFromMeal(daysMeals.getDaysListMap().get(days).get(0).getBreakfast())));
        fatBreakfastLabelController.setText(Double.toString((int) CaloriesCalculator.getFatFromMeal(daysMeals.getDaysListMap().get(days).get(0).getBreakfast())));
        kcalBreakfastLabelController.setText(Double.toString((int) CaloriesCalculator.getCaloriesFromMeal(daysMeals.getDaysListMap().get(days).get(0).getBreakfast())));
    }

    public Button getBreakfastEditButtonController() {
        return breakfastEditButtonController;
    }

    public AnchorPane getBreakfastTableView() {
        return breakfastTableView;
    }

    public TableView<Product> getBreakfastTableViewController() {
        return breakfastTableViewController;
    }

    public double getBreakfastProteinsPercentInMeal() {
        return getLabelValue(proteinsBreakfastLabelController) * CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES
                / getApproximateCaloriesFromLabels() * 100;
    }

    public double getBreakfastCarbohydratesPercentInMeal() {
        return getLabelValue(carbsBreakfastLabelController) * CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES
                / getApproximateCaloriesFromLabels() * 100;
    }

    public double getBreakfastFatPercentInMeal() {
        return getLabelValue(fatBreakfastLabelController) * CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES
                / getApproximateCaloriesFromLabels() * 100;
    }

    private void setLanguage(BreakfastTableViewLanguage language) {
        setLanguageLabels(language);
        setUserLabels();
    }

    private void setLanguageLabels(BreakfastTableViewLanguage language) {
        nameLabelController.setText(language.getMealName());
        proteinsInfoLabelController.setText(language.getProteinsInfoLabelController());
        carbohydratesInfoLabelController.setText(language.getCarbohydratesInfoLabelController());
        fatInfoLabelController.setText(language.getFatInfoLabelController());
        caloriesInfoLabelController.setText(language.getCaloriesInfoLabelController());
    }

    private void setUserLabels() {
        if (TablesLabels.basicBreakfastName != null) nameLabelController.setText(TablesLabels.basicBreakfastName);
        if (TablesLabels.basicBreakfastTime != null) timeLabelController.setText(TablesLabels.basicBreakfastTime);
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
        breakfastEditButtonController.addEventFilter(MouseEvent.MOUSE_ENTERED, actionEvent -> breakfastEditButtonController.getGraphic().setOpacity(0.7));
    }

    private void setOpacityToBasic() {
        breakfastEditButtonController.addEventFilter(MouseEvent.MOUSE_EXITED, actionEvent -> breakfastEditButtonController.getGraphic().setOpacity(1));
    }

    private double getApproximateCaloriesFromLabels() {
        return getLabelValue(proteinsBreakfastLabelController) * CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES +
                getLabelValue(carbsBreakfastLabelController) * CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES +
                getLabelValue(fatBreakfastLabelController) * CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES;
    }

    private double getLabelValue(Label label) {
        return Double.parseDouble(label.getText());
    }

    private void changeTableViewOpacity() {
        hideTableViewImageViewController.addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> {
            if (isTableHide==false)hideTable();
            else showTable();
                }

        );
    }

    private void hideTable() {
        hideTableViewImageViewController.setImage(new Image(getClass().getResource(SHOW_TABLE_IMAGE_VIEW_PATH).toExternalForm()));
        isTableHide = true;
        breakfastTableViewController.setVisible(false);
    }

    private void showTable() {
        hideTableViewImageViewController.setImage(new Image(getClass().getResource(HIDE_TABLE_IMAGE_VIEW_PATH).toExternalForm()));
        isTableHide = false;
        breakfastTableViewController.setVisible(true);
    }
}