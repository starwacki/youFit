package controllers;
import controllers.MainPaneComponentsControllers.CaloriesPaneController;
import controllers.MainPaneComponentsControllers.DaysPaneController;
import controllers.MainPaneComponentsControllers.SettingsPaneController;
import controllers.tableViewsControllers.BreakfastTableViewController;
import controllers.tableViewsControllers.BrunchTableViewController;
import controllers.tableViewsControllers.LunchTableViewController;
import controllers.tableViewsControllers.SupperTableViewController;
import dao.QueryExecutor;
import io.CaloricDemandIO;
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
import model.product.Product;
import model.user.User;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class MainPaneController {
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
    private static final int BREAKFAST_INDEX = 0;
    private static final int BRUNCH_INDEX = 1;
    private static final int LUNCH_INDEX = 2;
    private static final int SUPPER_INDEX = 3;
    private static final long ONE_WEEK = 7L;
    private DateController dateController;
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


    public void initialize() {
        initializeMainPane();
        showMainViewFromClickedDay();
        showEditTableViewPaneByClickedDay();
    }
    private void initializeMainPane() {
        this.dateController = new DateController();
        setStartView();
        setStartCaloricDemand();
        initializeDaysPane();
        setProperTableViewWidth();
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

    private void setStartView() {
        setTableViewsMealsPane(DateController.getLastClickedDay());
        setCaloriesPane();
        setDaysPaneBackgroundColors(DateController.getLastClickedDay());
    }
    private void showMainViewFromClickedDay() {
        daysPaneController.getMondayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  {
            setDateController(dateController.getMondayDate(),dateController.getMondayDate().getDayOfWeek());
            showAllPanesByClickedDay(DayOfWeek.MONDAY);
                });
        daysPaneController.getTuesdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  {
            setDateController(dateController.getTuesdayDate(),dateController.getTuesdayDate().getDayOfWeek());
            showAllPanesByClickedDay(DayOfWeek.TUESDAY);
                });
        daysPaneController.getWednesdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  {
            setDateController(dateController.getWednesdayDate(),dateController.getWednesdayDate().getDayOfWeek());
            showAllPanesByClickedDay(DayOfWeek.WEDNESDAY);
                });
        daysPaneController.getThursdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  {
            setDateController(dateController.getThursdayDate(),dateController.getThursdayDate().getDayOfWeek());
            showAllPanesByClickedDay(DayOfWeek.THURSDAY);
                });
        daysPaneController.getFridayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  {
            setDateController(dateController.getFridayDate(),dateController.getFridayDate().getDayOfWeek());
            showAllPanesByClickedDay(DayOfWeek.FRIDAY);
                });
        daysPaneController.getSaturdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  {
            setDateController(dateController.getSaturdayDate(),dateController.getSaturdayDate().getDayOfWeek());
            showAllPanesByClickedDay(DayOfWeek.SATURDAY);
                });
        daysPaneController.getSundayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->  {
            setDateController(dateController.getSundayDate(),dateController.getSundayDate().getDayOfWeek());
            showAllPanesByClickedDay(DayOfWeek.SUNDAY);
                });
    }

    private void setDateController(LocalDate localDate, DayOfWeek day) {
        DateController.setActualClickedDate(localDate);
        DateController.setLastClickedDay(day);
    }

    private void showAllPanesByClickedDay(DayOfWeek days) {
        clearColumnsBeforeSetNewDay();
        addTableViewsToMainVbox();
        setTableViewsMealsPane(days);
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

    private void setTableViewsMealsPane(DayOfWeek days) {
        DaysMeals daysMeals = new DaysMeals();
        daysMeals.createMealsFromAllDays();
        addAllProductToAllTableViews(daysMeals);
        addProductsToMealsByDay(daysMeals,days);
        setCaloriesPane();
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

    private void  setCaloriesPane() {
        setEatenMicronutrients();
        setProgressBars();
        setCaloriesPaneElementsColors();
    }

   private void setEatenMicronutrients() {
        caloriesPaneController.getEatenProteinsLabelController().setText(Integer.toString((int) CaloriesCalculator.getProteinsFromDay(QueryExecutor.allUserDayMeals(User.getUserID(),DateController.getActualClickedDate()))));
        caloriesPaneController.getEatenCarbohydratesLabelController().setText((Integer.toString((int)CaloriesCalculator.getCarbohydratesFromDay(QueryExecutor.allUserDayMeals(User.getUserID(),DateController.getActualClickedDate())))));
        caloriesPaneController.getEatenFatLabelController().setText(Integer.toString((int)CaloriesCalculator.getFatFromDay(QueryExecutor.allUserDayMeals(User.getUserID(),DateController.getActualClickedDate()))));
        caloriesPaneController.getEatenCaloriesLabelController().setText(Integer.toString((int)CaloriesCalculator.getCaloriesFromDay(QueryExecutor.allUserDayMeals(User.getUserID(),DateController.getActualClickedDate()))));
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
        addAllProductToTableView(products.getMondayMeals(),dateController.getMondayDate());
        addAllProductToTableView(products.getTuesdayMeals(),dateController.getTuesdayDate());
        addAllProductToTableView(products.getWednesdayMeals(),dateController.getWednesdayDate());
        addAllProductToTableView(products.getThursdayMeals(),dateController.getThursdayDate());
        addAllProductToTableView(products.getFridayMeals(),dateController.getFridayDate());
        addAllProductToTableView(products.getSaturdayMeals(),dateController.getSaturdayDate());
        addAllProductToTableView(products.getSundayMeals(),dateController.getSundayDate());
    }

    private void addAllProductToTableView(List<Meals> day, LocalDate localDate ) {
        List<List<Product>> meals = (QueryExecutor.allUserDayMeals(User.getUserID(),localDate));
        day.get(LIST_OF_ALL_MEALS_INDEX).getBreakfast().addAll(meals.get(BREAKFAST_INDEX));
        day.get(LIST_OF_ALL_MEALS_INDEX).getBrunch().addAll(meals.get(BRUNCH_INDEX));
        day.get(LIST_OF_ALL_MEALS_INDEX).getLunch().addAll(meals.get(LUNCH_INDEX));
        day.get(LIST_OF_ALL_MEALS_INDEX).getSupper().addAll(meals.get(SUPPER_INDEX));
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
            changeDate(t1);
            initializeTableViewsByNewDate(t1);
        });
    }
    private void changeDate(LocalDate t1) {
        DateController.setLastClickedDay(t1.getDayOfWeek());
        DateController.setActualClickedDate(t1);
        this.dateController = new DateController();
        setDates(dateController);
    }

    private void initializeTableViewsByNewDate(LocalDate t1) {
        setDaysPaneBackgroundColors(DateController.getLastClickedDay());
        DaysMeals daysMeals = new DaysMeals();
        daysMeals.createMealsFromAllDays();
        addAllProductToAllTableViews(daysMeals);
        showAllPanesByClickedDay(t1.getDayOfWeek());
    }

    private void previousWeek() {
        daysPaneController.getPreviousWeekImageViewController().addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
                    setPreviousWeekDaysDates();
                    setPreviousWeekDate();
                }
        );
    }
    private void setPreviousWeekDaysDates() {
        dateController.setMondayDate(dateController.getMondayDate().minusDays(ONE_WEEK));
        dateController.setTuesdayDate(dateController.getTuesdayDate().minusDays(ONE_WEEK));
        dateController.setWednesdayDate(dateController.getWednesdayDate().minusDays(ONE_WEEK));
        dateController.setThursdayDate(dateController.getThursdayDate().minusDays(ONE_WEEK));
        dateController.setFridayDate(dateController.getFridayDate().minusDays(ONE_WEEK));
        dateController.setSaturdayDate(dateController.getSaturdayDate().minusDays(ONE_WEEK));
        dateController.setSundayDate(dateController.getSundayDate().minusDays(ONE_WEEK));
    }

    private void setPreviousWeekDate() {
        setDates(dateController);
        DateController.setActualClickedDate(DateController.getActualClickedDate().minusDays(ONE_WEEK));
        showAllPanesByClickedDay(DateController.getLastClickedDay());
    }

    private void nextWeek() {
        daysPaneController.getNextWeekImageViewController().addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
                    setNextWeekDaysDates();
                    setNextWeekDate();
                }
        );
    }
    private void setNextWeekDaysDates() {
        dateController.setMondayDate(dateController.getMondayDate().plusDays(ONE_WEEK));
        dateController.setTuesdayDate(dateController.getTuesdayDate().plusDays(ONE_WEEK));
        dateController.setWednesdayDate(dateController.getWednesdayDate().plusDays(ONE_WEEK));
        dateController.setThursdayDate(dateController.getThursdayDate().plusDays(ONE_WEEK));
        dateController.setFridayDate(dateController.getFridayDate().plusDays(ONE_WEEK));
        dateController.setSaturdayDate(dateController.getSaturdayDate().plusDays(ONE_WEEK));
        dateController.setSundayDate(dateController.getSundayDate().plusDays(ONE_WEEK));
    }

    private void setNextWeekDate() {
        setDates(dateController);
        DateController.setActualClickedDate(DateController.getActualClickedDate().plusDays(ONE_WEEK));
        showAllPanesByClickedDay(DateController.getLastClickedDay());
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






