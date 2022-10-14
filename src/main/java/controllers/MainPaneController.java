package controllers;
import controllers.MainPaneComponentsControllers.CaloriesPaneController;
import controllers.MainPaneComponentsControllers.DaysPaneController;
import controllers.MainPaneComponentsControllers.SettingsPaneController;
import controllers.tableViewsControllers.BreakfastTableViewController;
import controllers.tableViewsControllers.BrunchTableViewController;
import controllers.tableViewsControllers.LunchTableViewController;
import controllers.tableViewsControllers.SupperTableViewController;
import io.CaloricDemandIO;
import io.ProductTableViewsReader;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.DateController;
import model.calories.CaloricDemand;
import model.calories.CaloriesCalculator;
import model.product.Meals;
import model.product.DaysMeals;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
    private SettingsPaneController settingsPaneController;
    @FXML
    private VBox mainPaneViewVboxController;

    @FXML
    private MainEditPaneController breakfastMainEditPaneController;
    private static final int LIST_OF_ALL_MEALS_INDEX = 0;
    private static final int TABLE_WIDTH = 680;
    private static final int EXCEEDED_MICRONUTRIENTS_WARNING_PROGRESS_BAR_VALUE = 1;
    private static final String LAST_CLICKED_DAY_COLOR_STYLE = "-fx-border-color: red";
    private static final String PREVIOUS_CLICKED_DAY_COLOR_STYLE = "-fx-border-color: white";
    private static final String BASIC_PROTEINS_PROGRESS_BAR_COLOR = "-fx-accent: #04BDDE";
    private static final String BASIC_CARBOHYDRATES_PROGRESS_BAR_COLOR = "-fx-accent: #32F902";
    private static final String BASIC_FAT_PROGRESS_BAR_COLOR = "-fx-accent: chocolate;";
    private static final String BASIC_CALORIES_PROGRESS_BAR_COLOR = "-fx-accent: #9933ff;";
    private static final String WARNING_PROGRESS_BAR_COLOR = "-fx-accent: red;";
    private static final String BREAKFAST_NAME = "BREAKFAST";
    private static final String BRUNCH_NAME = "BRUNCH";
    private static final String LUNCH_NAME = "LUNCH";
    private static final String SUPPER_NAME = "SUPPER";
    private DateController dateController;

    public void initialize() {
        this.dateController = new DateController();
        DaysMeals productsAdded = new DaysMeals();
        productsAdded.createMealsFromAllDays();
        addAllProductToAllTableViews(productsAdded);
        setStartView(productsAdded);
        setStartCaloricDemand();
        showMainViewFromClickedDay(productsAdded);
        showEditTableViewPaneByClickedDay();
        setProperTableViewWidth();
        initializeDaysPane();
    }
    private void initializeDaysPane() {
        setDates(dateController);
        changeWeek();
        setDateByDatePicker();
    }
    private void setProperTableViewWidth() {
        breakfastTableViewController.getBreakfastTableViewController().setPrefWidth(TABLE_WIDTH);
        brunchTableViewController.getBrunchTableViewController().setPrefWidth(TABLE_WIDTH);
        lunchTableViewController.getLunchTableViewController().setPrefWidth(TABLE_WIDTH);
        supperTableViewController.getSupperTableViewController().setPrefWidth(TABLE_WIDTH);
    }

    private void setStartView(DaysMeals daysMeals) {
        setTableViewsMealsPane(daysMeals, DateController.getLastClickedDay());
        setCaloriesPane(daysMeals, DateController.getLastClickedDay());
        setDaysPaneBackgroundColors(DateController.getLastClickedDay());

    }
    private void showMainViewFromClickedDay(DaysMeals daysMeals) {
        daysPaneController.getMondayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  {
            setDateController(dateController.getMondayDate(),dateController.getMondayDate().getDayOfWeek());
            showAllPanesByClickedDay(daysMeals,DayOfWeek.MONDAY);
                });
        daysPaneController.getTuesdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  {
            setDateController(dateController.getTuesdayDate(),dateController.getTuesdayDate().getDayOfWeek());
            showAllPanesByClickedDay(daysMeals,DayOfWeek.TUESDAY);
                });
        daysPaneController.getWednesdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  {
            setDateController(dateController.getWednesdayDate(),dateController.getWednesdayDate().getDayOfWeek());
            showAllPanesByClickedDay(daysMeals,DayOfWeek.WEDNESDAY);
                });
        daysPaneController.getThursdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  {
            setDateController(dateController.getThursdayDate(),dateController.getThursdayDate().getDayOfWeek());
            showAllPanesByClickedDay(daysMeals,DayOfWeek.THURSDAY);
                });
        daysPaneController.getFridayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  {
            setDateController(dateController.getFridayDate(),dateController.getFridayDate().getDayOfWeek());
            showAllPanesByClickedDay(daysMeals,DayOfWeek.FRIDAY);
                });
        daysPaneController.getSaturdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  {
            setDateController(dateController.getSaturdayDate(),dateController.getSaturdayDate().getDayOfWeek());
            showAllPanesByClickedDay(daysMeals,DayOfWeek.SATURDAY);
                });
        daysPaneController.getSundayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  {
            setDateController(dateController.getSundayDate(),dateController.getSundayDate().getDayOfWeek());
            showAllPanesByClickedDay(daysMeals,DayOfWeek.SUNDAY);
                });
    }
    private void setDateController(LocalDate localDate, DayOfWeek day) {
        DateController.setActualClickedDate(localDate);
        DateController.setLastClickedDay(day);
    }
    private void showAllPanesByClickedDay(DaysMeals daysMeals,DayOfWeek days) {
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
    private void setTableViewsMealsPane(DaysMeals daysMeals,DayOfWeek days) {
        addProductsToMealsByDay(daysMeals,days);
        setAllMicronutrientsTableViewLabels(daysMeals,days);
    }
    private void  addProductsToMealsByDay(DaysMeals daysMeals, DayOfWeek days) {
        breakfastTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getBreakfast());
        brunchTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getBrunch());
        lunchTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getLunch());
        supperTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getSupper());
    }
   private void  setAllMicronutrientsTableViewLabels(DaysMeals daysMeals, DayOfWeek days) {
        breakfastTableViewController.setThisMealMicronutrientsLabels(daysMeals,days);
        lunchTableViewController.setThisMealMicronutrientsLabels(daysMeals,days);
        brunchTableViewController.setThisMealMicronutrientsLabels(daysMeals,days);
        supperTableViewController.setThisMealMicronutrientsLabels(daysMeals,days);
   }
    private void  setCaloriesPane(DaysMeals daysMeals, DayOfWeek days) {
        setEatenMicronutrients(daysMeals,days);
        setProgressBars();
        setCaloriesPaneElementsColors();
    }
   private void setEatenMicronutrients(DaysMeals daysMeals, DayOfWeek days) {
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
        micronutrientsLabels.forEach(label -> label.setTextFill(Color.WHITE));
    }

    private void setStartCaloricDemand() {
        setCalculatedCaloricDemand();
        setProgressBars();
        setCaloriesPaneElementsColors();
    }
    private void setCalculatedCaloricDemand() {
        CaloricDemand caloricDemand = CaloricDemandIO.getCaloricDemand();
        caloriesPaneController.getNeededProteinsLabelController().setText(String.valueOf((int) caloricDemand.getProteinsInDiet()));
        caloriesPaneController.getNeededCarbohydratesLabelController().setText(String.valueOf((int) caloricDemand.getCarbohydratesInDiet()));
        caloriesPaneController.getNeededFatLabelController().setText(String.valueOf((int) caloricDemand.getFatInDiet()));
        caloriesPaneController.getNeededCaloriesLabelController().setText(String.valueOf((int) caloricDemand.getTotalDailyEnergyExpenditure()));
    }
    public void addAllProductToAllTableViews(DaysMeals products) {
        addAllProductToTableView(products.getMondayMeals(),DayOfWeek.MONDAY);
        addAllProductToTableView(products.getTuesdayMeals(),DayOfWeek.TUESDAY);
        addAllProductToTableView(products.getWednesdayMeals(),DayOfWeek.WEDNESDAY);
        addAllProductToTableView(products.getThursdayMeals(),DayOfWeek.THURSDAY);
        addAllProductToTableView(products.getFridayMeals(),DayOfWeek.FRIDAY);
        addAllProductToTableView(products.getSaturdayMeals(),DayOfWeek.SATURDAY);
        addAllProductToTableView(products.getSundayMeals(),DayOfWeek.SUNDAY);
    }
    private void addAllProductToTableView(List<Meals> day, DayOfWeek days) {
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
    private void setDaysPaneBackgroundColors(DayOfWeek days){
        clearAllDayBorders();
        setLastClickedDayBorderColor(days,LAST_CLICKED_DAY_COLOR_STYLE);
    }
    private void clearAllDayBorders() {
        daysPaneController.getMondayButtonController().setStyle(PREVIOUS_CLICKED_DAY_COLOR_STYLE);
        daysPaneController.getTuesdayButtonController().setStyle(PREVIOUS_CLICKED_DAY_COLOR_STYLE);
        daysPaneController.getWednesdayButtonController().setStyle(PREVIOUS_CLICKED_DAY_COLOR_STYLE);
        daysPaneController.getThursdayButtonController().setStyle(PREVIOUS_CLICKED_DAY_COLOR_STYLE);
        daysPaneController.getFridayButtonController().setStyle(PREVIOUS_CLICKED_DAY_COLOR_STYLE);
        daysPaneController.getSaturdayButtonController().setStyle(PREVIOUS_CLICKED_DAY_COLOR_STYLE);
        daysPaneController.getSundayButtonController().setStyle(PREVIOUS_CLICKED_DAY_COLOR_STYLE);
    }
    private void setLastClickedDayBorderColor(DayOfWeek days, String style) {
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
    private void setDateByDatePicker() {
        daysPaneController.getDaysPaneDatePickerController().valueProperty().addListener((observableValue, localDate, t1) -> {
            DateController.setLastClickedDay(t1.getDayOfWeek());
            DateController.setActualClickedDate(t1);
            this.dateController = new DateController();
            setDates(dateController);
            setDaysPaneBackgroundColors(DateController.getLastClickedDay());
        });
    }
    private void previousWeek() {
        daysPaneController.getPreviousWeekImageViewController().addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
                    dateController.setMondayDate(dateController.getMondayDate().minusDays(7L));
                    dateController.setTuesdayDate(dateController.getTuesdayDate().minusDays(7L));
                    dateController.setWednesdayDate(dateController.getWednesdayDate().minusDays(7L));
                    dateController.setThursdayDate(dateController.getThursdayDate().minusDays(7L));
                    dateController.setFridayDate(dateController.getFridayDate().minusDays(7L));
                    dateController.setSaturdayDate(dateController.getSaturdayDate().minusDays(7L));
                    dateController.setSundayDate(dateController.getSundayDate().minusDays(7L));
                    setDates(dateController);
                    DateController.setActualClickedDate(DateController.getActualClickedDate().minusDays(7L));

                }
        );
    }

    private void nextWeek() {
        daysPaneController.getNextWeekImageViewController().addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
                    dateController.setMondayDate(dateController.getMondayDate().plusDays(7L));
                    dateController.setTuesdayDate(dateController.getTuesdayDate().plusDays(7L));
                    dateController.setWednesdayDate(dateController.getWednesdayDate().plusDays(7L));
                    dateController.setThursdayDate(dateController.getThursdayDate().plusDays(7L));
                    dateController.setFridayDate(dateController.getFridayDate().plusDays(7L));
                    dateController.setSaturdayDate(dateController.getSaturdayDate().plusDays(7L));
                    dateController.setSundayDate(dateController.getSundayDate().plusDays(7L));
                    setDates(dateController);
                    DateController.setActualClickedDate(DateController.getActualClickedDate().plusDays(7L));

                }
        );
    }
    private void changeWeek() {
        this.dateController = new DateController(DateController.getActualClickedDate());
        previousWeek();
        nextWeek();
    }
    private void setDates(DateController timeController){
        setDateLabel(daysPaneController.getMondayLabelController(),timeController.getMondayDate());
        setDateLabel(daysPaneController.getTuesdayLabelController(),timeController.getTuesdayDate());
        setDateLabel(daysPaneController.getWednesdayLabelController(),timeController.getWednesdayDate());
        setDateLabel(daysPaneController.getThursdayLabelController(),timeController.getThursdayDate());
        setDateLabel(daysPaneController.getFridayLabelController(),timeController.getFridayDate());
        setDateLabel(daysPaneController.getSaturdayLabelController(),timeController.getSaturdayDate());
        setDateLabel(daysPaneController.getSundayLabelController(),timeController.getSundayDate());
    }

    private void setDateLabel(Label label,LocalDate localDate) {
        label.setText(getDateString(localDate));
    }
    private String getDateString(LocalDate localDate) {
        return localDate.getDayOfMonth() + "." + localDate.getMonthValue();
    }
}






