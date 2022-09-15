package controllers.tableViewsControllers;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.calories.CaloriesCalculator;
import model.Days;
import model.product.DaysMeals;
import model.product.Product;
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
    private Label kcaLunchLabelController;
    @FXML
    private Label proteinsLunchLabelController;
    @FXML
    private Button lunchEditButtonController;
    private static final String EDIT_BUTTON_JPG_FILE_PATH = "/img/edit-button.jpg";

    public void initialize(){
        setColumnsSettings();
        setImage();
        editButtonListener();
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
    public void setThisMealMicronutrientsLabels(DaysMeals daysMeals, Days days) {
        proteinsLunchLabelController.setText(Double.toString((int) CaloriesCalculator.getProteinsFromMeal(daysMeals.getDaysListMap().get(days).get(0).getLunch())));
        carbsLunchLabelController.setText(Double.toString((int) CaloriesCalculator.getCarbohydratesFromMeal(daysMeals.getDaysListMap().get(days).get(0).getLunch())));
        fatLunchLabelController.setText(Double.toString((int) CaloriesCalculator.getFatFromMeal(daysMeals.getDaysListMap().get(days).get(0).getLunch())));
        kcaLunchLabelController.setText(Double.toString((int) CaloriesCalculator.getCaloriesFromMeal(daysMeals.getDaysListMap().get(days).get(0).getLunch())));
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
    private void setImage() {
        ImageView imageView = new ImageView(getClass().getResource(EDIT_BUTTON_JPG_FILE_PATH).toExternalForm());
        lunchEditButtonController.setGraphic(imageView);
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