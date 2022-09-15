package controllers;
import controllers.tableViewsControllers.BreakfastTableViewController;
import controllers.tableViewsControllers.BrunchTableViewController;
import controllers.tableViewsControllers.LunchTableViewController;
import controllers.tableViewsControllers.SupperTableViewController;
import io.ProductTableViewsReader;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.calories.CaloriesCalculator;
import model.Days;
import model.meals.Meals;
import model.product.DaysMeals;
import java.util.List;

public class MainPaneController {
    @FXML
    private CaloriesPaneController caloriesPaneController;
    @FXML
    private DaysPaneController daysPaneController;
    @FXML
    private BreakfastTableViewController breakfastTableViewController;
    @FXML
    private BrunchTableViewController brunchTableViewController;
    @FXML
    private LunchTableViewController lunchTableViewController;
    @FXML
    private SupperTableViewController supperTableViewController;
    @FXML
    private VBox mainPaneViewVboxController;
    @FXML
    private MainEditPaneController breakfastMainEditPaneController;
    private static final int LIST_OF_ALL_MEALS_INDEX = 0;
    private static final int TABLE_WIDTH = 685;
    private static final int EXCEEDED_MICRONUTRIENTS_WARNING_PROGRESS_BAR_VALUE = 1;
    private static final String LAST_CLICKED_DAY_COLOR_STYLE = "-fx-border-color: red";
    private static final String PREVIOUS_CLICKED_DAY_COLOR_STYLE = "-fx-border-color: white";
    private static final String BASIC_PROTEINS_PROGRESS_BAR_COLOR = "-fx-accent: blue;";
    private static final String BASIC_CARBOHYDRATES_PROGRESS_BAR_COLOR = "-fx-accent: green;";
    private static final String BASIC_FAT_PROGRESS_BAR_COLOR = "-fx-accent: chocolate;";
    private static final String BASIC_CALORIES_PROGRESS_BAR_COLOR = "-fx-accent: black;";
    private static final String WARNING_PROGRESS_BAR_COLOR = "-fx-accent: red;";
    private static final String BREAKFAST_NAME = "BREAKFAST";
    private static final String BRUNCH_NAME = "BRUNCH";
    private static final String LUNCH_NAME = "LUNCH";
    private static final String SUPPER_NAME = "SUPPER";

    public void initialize() {
        DaysMeals productsAdded = new DaysMeals();
        productsAdded.createMealsFromAllDays();
        addAllProductToAllTableViews(productsAdded);
        setStartView(productsAdded);
        setStartCaloricDemand();
        showMainViewFromClickedDay(productsAdded);
        showEditTableViewPaneByClickedDay();
        breakfastTableViewController.getBreakfastTableViewController().setPrefWidth(TABLE_WIDTH);
        brunchTableViewController.getBrunchTableViewController().setPrefWidth(TABLE_WIDTH);
        lunchTableViewController.getLunchTableViewController().setPrefWidth(TABLE_WIDTH);
        supperTableViewController.getSupperTableViewController().setPrefWidth(TABLE_WIDTH);
    }
    private void setStartView(DaysMeals daysMeals) {
        setTableViewsMealsPane(daysMeals,MainEditPaneController.getLastClickedDay());
        setCaloriesPane(daysMeals,MainEditPaneController.getLastClickedDay());
        setDaysPaneBackgroundColors(MainEditPaneController.getLastClickedDay());

    }
    private void showMainViewFromClickedDay(DaysMeals daysMeals) {
        daysPaneController.getMondayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  showAllPanesByClickedDay(daysMeals,Days.MONDAY));
        daysPaneController.getTuesdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> showAllPanesByClickedDay(daysMeals,Days.TUESDAY));
        daysPaneController.getWednesdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> showAllPanesByClickedDay(daysMeals,Days.WEDNESDAY));
        daysPaneController.getThursdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> showAllPanesByClickedDay(daysMeals,Days.THURSDAY));
        daysPaneController.getFridayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> showAllPanesByClickedDay(daysMeals,Days.FRIDAY));
        daysPaneController.getSaturdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> showAllPanesByClickedDay(daysMeals,Days.SATURDAY));
        daysPaneController.getSundayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> showAllPanesByClickedDay(daysMeals,Days.SUNDAY));
    }
    private void showAllPanesByClickedDay(DaysMeals daysMeals,Days days) {
        clearColumnsBeforeSetNewDay();
        addTableViewsToMainVbox();
        setTableViewsMealsPane(daysMeals, days);
        setCaloriesPane(daysMeals,days);
        setDaysPaneBackgroundColors(days);
        MainEditPaneController.setNumberOfLastClickedDay(days);
    }
    private void clearColumnsBeforeSetNewDay() {
        breakfastTableViewController.removeAllTableViewProducts();
        brunchTableViewController.removeAllTableViewProducts();
        lunchTableViewController.removeAllTableViewProducts();
        supperTableViewController.removeAllTableViewProducts();
    }
    private void addTableViewsToMainVbox() {
        mainPaneViewVboxController.getChildren().removeAll();
        setAllTableViews();

    }
    private void setAllTableViews() {
        mainPaneViewVboxController.getChildren().setAll(
                breakfastTableViewController.getBreakfastTableView(),
                brunchTableViewController.getBrunchTableView(),
                lunchTableViewController.getLunchTableView(),
                supperTableViewController.getSupperTableView()
        );
    }
    private void setTableViewsMealsPane(DaysMeals daysMeals,Days days) {
        addProductsToMealsByDay(daysMeals,days);
        setAllMicronutrientsTableViewLabels(daysMeals,days);
    }
    private void  addProductsToMealsByDay(DaysMeals daysMeals, Days days) {
        breakfastTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getBreakfast());
        brunchTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getBrunch());
        lunchTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getLunch());
        supperTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getSupper());
    }
   private void  setAllMicronutrientsTableViewLabels(DaysMeals daysMeals, Days days) {
        breakfastTableViewController.setThisMealMicronutrientsLabels(daysMeals,days);
        lunchTableViewController.setThisMealMicronutrientsLabels(daysMeals,days);
        brunchTableViewController.setThisMealMicronutrientsLabels(daysMeals,days);
        supperTableViewController.setThisMealMicronutrientsLabels(daysMeals,days);
   }
    private void  setCaloriesPane(DaysMeals daysMeals, Days days) {
        setEatenMicronutrients(daysMeals,days);
        setProgressBars();
        setCaloriesPaneElementsColors();
    }
   private void setEatenMicronutrients(DaysMeals daysMeals, Days days) {
        caloriesPaneController.getEatenProteinsLabelController().setText(Integer.toString((int) CaloriesCalculator.getProteinsFromDay(daysMeals.getDaysListMap().get(days))));
        caloriesPaneController.getEatenCarbohydratesLabelController().setText((Integer.toString((int)CaloriesCalculator.getCarbohydratesFromDay(daysMeals.getDaysListMap().get(days)))));
        caloriesPaneController.getEatenFatLabelController().setText(Integer.toString((int)CaloriesCalculator.getFatFromDay(daysMeals.getDaysListMap().get(days))));
        caloriesPaneController.getEatenCaloriesLabelController().setText(Integer.toString((int)CaloriesCalculator.getCaloriesFromDay(daysMeals.getDaysListMap().get(days))));
    }
    private void setProgressBars() {
        setProgressInProgressBars();
    }
    private void setProgressInProgressBars() {
        caloriesPaneController.getProteinsProgressBarController().setProgress(getEatenProteinsPercent());
        caloriesPaneController.getCarbohydratesProgressBarController().setProgress(getEatenCarbohydratesPercent());
        caloriesPaneController.getFatProgressBarController().setProgress(getEatenFatPercent());
        caloriesPaneController.getCaloriesProgressBarController().setProgress(getEatenCaloriesPercent());
    }
    private double getEatenProteinsPercent() {
        return  Double.parseDouble(caloriesPaneController.getEatenProteinsLabelController().getText())/
                Double.parseDouble(caloriesPaneController.getNeededProteinsLabelController().getText());
    }
    private double getEatenCarbohydratesPercent() {
        return  Double.parseDouble(caloriesPaneController.getEatenCarbohydratesLabelController().getText())/
                Double.parseDouble(caloriesPaneController.getNeededCarbohydratesLabelController().getText());
    }
    private double getEatenFatPercent() {
        return  Double.parseDouble(caloriesPaneController.getEatenFatLabelController().getText())/
                Double.parseDouble(caloriesPaneController.getNeededFatLabelController().getText());
    }
    private double getEatenCaloriesPercent() {
        return  Double.parseDouble(caloriesPaneController.getEatenCaloriesLabelController().getText())/
                Double.parseDouble(caloriesPaneController.getNeededCaloriesLabelController().getText());
    }
    private void setCaloriesPaneElementsColors() {
        setAllProgressBarsColors();
        setAllCaloriesPaneMicronutrientsLabelColors();
    }
    private void setAllProgressBarsColors() {
        setProgressBarsColors(caloriesPaneController.getCaloriesProgressBarController(),BASIC_CALORIES_PROGRESS_BAR_COLOR);
        setProgressBarsColors(caloriesPaneController.getProteinsProgressBarController(),BASIC_PROTEINS_PROGRESS_BAR_COLOR);
        setProgressBarsColors(caloriesPaneController.getCarbohydratesProgressBarController(),BASIC_CARBOHYDRATES_PROGRESS_BAR_COLOR);
        setProgressBarsColors(caloriesPaneController.getFatProgressBarController(),BASIC_FAT_PROGRESS_BAR_COLOR);
    }
    private void  setProgressBarsColors(ProgressBar progressBar,String basicProgressBarColorStyle) {
        progressBar.progressProperty().addListener((progress, number, t1) -> {
            double progressValue = progress.getValue().doubleValue();
            if (progressValue>EXCEEDED_MICRONUTRIENTS_WARNING_PROGRESS_BAR_VALUE) setBarRed(progressBar);
            else setBasicBarColor(progressBar,basicProgressBarColorStyle);
        });
    }
    private void setBarRed(ProgressBar progressBar) {
        progressBar.setStyle(WARNING_PROGRESS_BAR_COLOR);
    }
    private void setBasicBarColor(ProgressBar progressBar,String basicProgressBarColor) {
        progressBar.setStyle(basicProgressBarColor);
    }
    private void setAllCaloriesPaneMicronutrientsLabelColors() {
        setCaloriesPaneMicronutrientsLabelColor(caloriesPaneController.getCaloriesProgressBarController(),caloriesPaneController.getAllCaloriesLabels());
        setCaloriesPaneMicronutrientsLabelColor(caloriesPaneController.getProteinsProgressBarController(),caloriesPaneController.getAllProteinsLabels());
        setCaloriesPaneMicronutrientsLabelColor(caloriesPaneController.getCarbohydratesProgressBarController(),caloriesPaneController.getAllCarbohydratesLabels());
        setCaloriesPaneMicronutrientsLabelColor(caloriesPaneController.getFatProgressBarController(),caloriesPaneController.getAllFatLabels());
    }
    private void setCaloriesPaneMicronutrientsLabelColor(ProgressBar progressBar,List<Label> micronutrientsLabels) {
        if(progressBar.getProgress()>EXCEEDED_MICRONUTRIENTS_WARNING_PROGRESS_BAR_VALUE) setCaloriesPaneLabelsRed(micronutrientsLabels);
        else setCaloriesPaneBasic(micronutrientsLabels);
    }
    private void setCaloriesPaneLabelsRed(List<Label> micronutrientsLabels) {
        micronutrientsLabels.forEach(label -> label.setTextFill(Color.RED));
    }
    private void setCaloriesPaneBasic(List<Label> micronutrientsLabels) {
        micronutrientsLabels.forEach(label -> label.setTextFill(Color.BLACK));
    }

    //method to delete in future -> set start calories demand;
    private void setStartCaloricDemand() {
        caloriesPaneController.getNeededProteinsLabelController().setText("120");
        caloriesPaneController.getNeededCarbohydratesLabelController().setText("300");
        caloriesPaneController.getNeededFatLabelController().setText("60");
        caloriesPaneController.getNeededCaloriesLabelController().setText("2220");
        setProgressBars();
        setCaloriesPaneElementsColors();
    }
    public void addAllProductToAllTableViews(DaysMeals products) {
        addAllProductToTableView(products.getMondayMeals(),Days.MONDAY);
        addAllProductToTableView(products.getTuesdayMeals(),Days.TUESDAY);
        addAllProductToTableView(products.getWednesdayMeals(),Days.WEDNESDAY);
        addAllProductToTableView(products.getThursdayMeals(),Days.THURSDAY);
        addAllProductToTableView(products.getFridayMeals(),Days.FRIDAY);
        addAllProductToTableView(products.getSaturdayMeals(),Days.SATURDAY);
        addAllProductToTableView(products.getSundayMeals(),Days.SUNDAY);
    }
    private void addAllProductToTableView(List<Meals> day,Days days) {
        day.get(LIST_OF_ALL_MEALS_INDEX).getBreakfast().addAll(ProductTableViewsReader.getProductListFromMeal(days,BREAKFAST_NAME));
        day.get(LIST_OF_ALL_MEALS_INDEX).getBrunch().addAll(ProductTableViewsReader.getProductListFromMeal(days,BRUNCH_NAME));
        day.get(LIST_OF_ALL_MEALS_INDEX).getLunch().addAll(ProductTableViewsReader.getProductListFromMeal(days,LUNCH_NAME));
        day.get(LIST_OF_ALL_MEALS_INDEX).getSupper().addAll(ProductTableViewsReader.getProductListFromMeal(days,SUPPER_NAME));
    }
    private void showEditTableViewPaneByClickedDay() {
    SceneSwitcherController sceneSwitcherController = new SceneSwitcherController();
    breakfastTableViewController.getBreakfastEditButtonController().setOnAction(
            event -> sceneSwitcherController.switchToBreakfastEditPane(thisStage()));
    brunchTableViewController.getBrunchEditButtonController().setOnAction(
            event -> sceneSwitcherController.switchToBrunchEditPane(thisStage()));
    lunchTableViewController.getLunchEditButtonController().setOnAction(
            event -> sceneSwitcherController.switchToLunchEditPane(thisStage()));
    supperTableViewController.getSupperEditButtonController().setOnAction(
            event -> sceneSwitcherController.switchToSupperEditPane(thisStage()));
    }
    private Stage thisStage() {
       return  (Stage) breakfastTableViewController.getBreakfastEditButtonController().getScene().getWindow();
    }
    private void setDaysPaneBackgroundColors(Days days){
        setLastClickedDayBorderColor(MainEditPaneController.getLastClickedDay(),PREVIOUS_CLICKED_DAY_COLOR_STYLE);
        setLastClickedDayBorderColor(days,LAST_CLICKED_DAY_COLOR_STYLE);
    }
    private void setLastClickedDayBorderColor(Days days, String style) {
        switch (days) {
            case MONDAY -> daysPaneController.getMondayButtonController().setStyle(style);
            case TUESDAY -> daysPaneController.getTuesdayButtonController().setStyle(style);
            case WEDNESDAY -> daysPaneController.getWednesdayButtonController().setStyle(style);
            case THURSDAY -> daysPaneController.getThursdayButtonController().setStyle(style);
            case FRIDAY -> daysPaneController.getFridayButtonController().setStyle(style);
            case SATURDAY -> daysPaneController.getSaturdayButtonController().setStyle(style);
            case SUNDAY -> daysPaneController.getSundayButtonController().setStyle(style);
        }
    }
}






