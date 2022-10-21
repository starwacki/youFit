package controllers;

import controllers.MainPaneComponentsControllers.CaloriesPaneController;
import controllers.MainPaneComponentsControllers.SettingsPaneController;
import controllers.SwitchScenesControllers.EditPaneController;
import controllers.tableViewsControllers.BreakfastTableViewController;
import controllers.tableViewsControllers.BrunchTableViewController;
import controllers.tableViewsControllers.LunchTableViewController;
import controllers.tableViewsControllers.SupperTableViewController;
import dao.QueryExecutor;
import io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import model.DateController;
import model.calories.CaloricDemand;
import model.calories.CaloriesCalculator;
import model.language.Language;
import model.product.Meals;
import model.product.DaysMeals;
import model.product.Product;
import model.user.User;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class MainEditPaneController {

    private static final String BREAKFAST_TABLE_VIEW_ID = "breakfastTableView";
    private static final String BRUNCH_TABLE_VIEW_ID = "brunchTableView";
    private static final String LUNCH_TABLE_VIEW_ID = "lunchTableView";
    private static final String SUPPER_TABLE_VIEW_ID = "supperTableView";
    private static final String DELETE_BUTTON_JPG_FILE_PATH = "/img/deleteButton.png";
    private static final String DELETE_BUTTON_CSS_STYLE_SHEET_ID = "delete-button";
    private static final String BASIC_PROTEINS_PROGRESS_BAR_COLOR = "-fx-accent: #04BDDE";
    private static final String BASIC_CARBOHYDRATES_PROGRESS_BAR_COLOR = "-fx-accent: #32F902";
    private static final String BASIC_FAT_PROGRESS_BAR_COLOR = "-fx-accent: chocolate";
    private static final String BASIC_CALORIES_PROGRESS_BAR_COLOR = "-fx-accent: #9933ff";
    private static final String WARNING_PROGRESS_BAR_COLOR = "-fx-accent: red;";
    private static final String BREAKFAST_NAME = "BREAKFAST";
    private static final String BRUNCH_NAME = "BRUNCH";
    private static final String LUNCH_NAME = "LUNCH";
    private static final String SUPPER_NAME = "SUPPER";
    private static final String EMPTY_FIELD = "";
    private static final String EMPTY_PIE_CHART_COLOR = "-fx-pie-color: white";
    private static final String PROTEINS_PIE_COLOR = "-fx-pie-color: #04BDDE";
    private static final String CARBOHYDRATES_PIE_COLOR = "-fx-pie-color: #32F902";
    private static final String FAT_PIE_COLOR = "-fx-pie-color: chocolate";
    private static final int LIST_OF_ALL_MEALS_INDEX = 0;
    private static final int EXCEEDED_MICRONUTRIENTS_WARNING_PROGRESS_BAR_VALUE = 1;
    private static final int EMPTY_PIE_CHART_DATA_INDEX = 0;
    private static final int PROTEINS_PIE_CHART_DATA_INDEX = 0;
    private static final int CARBOHYDRATES_PIE_CHART_DATA_INDEX = 1;
    private static final int FAT_PIE_CHART_DATA_INDEX = 2;
    private static final int SQL_BREAKFAST_index = 1;
    private static final int SQL_BRUNCH_index = 2;
    private static final int SQL_LUNCH_index = 3;
    private static final int SQL_SUPPER_index = 4;
    private static final int NULL_VALUE = -1;
    private static boolean mainBase = true;
    private DateController dateController;
    @FXML
    private CaloriesPaneController caloriesPaneController;
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
    private EditPaneController editPaneController;

    public void initialize() {
        DaysMeals daysMeals = new DaysMeals();
        this.dateController = new DateController();
        hideSwitchToEditPaneButton();
        setAll(daysMeals);
        addProductToBase();
        addDeleteButtonToActualTableViewMeal();
    }

    public void setAll(DaysMeals daysMeals) {
        daysMeals.createMealsFromAllDays();
        addAllProductToAllTableViews(daysMeals);
        setEditPaneViewByMeal(daysMeals);
        setStartCaloricDemand();
    }

    public static void setNumberOfLastClickedDay(DayOfWeek day) {
        DateController.setLastClickedDay(day);
    }

    public static boolean isMainBase() {
        return mainBase;
    }

    public static void setMainBase(boolean mainBase) {
        MainEditPaneController.mainBase = mainBase;
    }

    private void setEditPaneViewByMeal(DaysMeals daysMeals) {
        switch (getMealId()) {
            case BREAKFAST_TABLE_VIEW_ID -> setBreakfastEditPane(daysMeals, DateController.getLastClickedDay());
            case BRUNCH_TABLE_VIEW_ID -> setBrunchEditPane(daysMeals, DateController.getLastClickedDay());
            case LUNCH_TABLE_VIEW_ID -> setLunchEditPane(daysMeals, DateController.getLastClickedDay());
            case SUPPER_TABLE_VIEW_ID -> setSupperEditPane(daysMeals, DateController.getLastClickedDay());
        }
    }

    private String getMealId() {
        return mainPaneViewVboxController.getChildren().get(LIST_OF_ALL_MEALS_INDEX).getId();
    }

    private void setBreakfastEditPane(DaysMeals daysMeals, DayOfWeek days) {
        addProductsToBreakfastByDay(daysMeals, days);
        setBreakfastMicronutrientsTableViewLabels(daysMeals, days);
        setCaloriesPane();
        setBreakfastPieChar();
    }

    private void setBrunchEditPane(DaysMeals daysMeals, DayOfWeek days) {
        addProductsToBrunchByDay(daysMeals, days);
        setBrunchMicronutrientsTableViewLabels(daysMeals, days);
        setCaloriesPane();
        setBrunchPieChar();
    }

    private void setLunchEditPane(DaysMeals daysMeals, DayOfWeek days) {
        addProductsToLunchByDay(daysMeals, days);
        setLunchMicronutrientsTableViewLabels(daysMeals, days);
        setCaloriesPane();
        setLunchPieChar();
    }

    private void setSupperEditPane(DaysMeals daysMeals, DayOfWeek days) {
        addProductsToSupperByDay(daysMeals, days);
        setSupperMicronutrientsTableViewLabels(daysMeals, days);
        setCaloriesPane();
        setSupperPieChar();
    }

    private void addProductsToBreakfastByDay(DaysMeals daysMeals, DayOfWeek days) {
        breakfastTableViewController.removeAllTableViewProducts();
        breakfastTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getBreakfast());
    }

    private void addProductsToBrunchByDay(DaysMeals daysMeals, DayOfWeek days) {
        brunchTableViewController.removeAllTableViewProducts();
        brunchTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getBrunch());
    }

    private void addProductsToLunchByDay(DaysMeals daysMeals, DayOfWeek days) {
        lunchTableViewController.removeAllTableViewProducts();
        lunchTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getLunch());
    }

    private void addProductsToSupperByDay(DaysMeals daysMeals, DayOfWeek days) {
        supperTableViewController.removeAllTableViewProducts();
        supperTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getSupper());
    }

    private void setBreakfastMicronutrientsTableViewLabels(DaysMeals daysMeals, DayOfWeek days) {
        breakfastTableViewController.setThisMealMicronutrientsLabels(daysMeals, days);
    }

    private void setBrunchMicronutrientsTableViewLabels(DaysMeals daysMeals, DayOfWeek days) {
        brunchTableViewController.setThisMealMicronutrientsLabels(daysMeals, days);
    }

    private void setLunchMicronutrientsTableViewLabels(DaysMeals daysMeals, DayOfWeek days) {
        lunchTableViewController.setThisMealMicronutrientsLabels(daysMeals, days);
    }

    private void setSupperMicronutrientsTableViewLabels(DaysMeals daysMeals, DayOfWeek days) {
        supperTableViewController.setThisMealMicronutrientsLabels(daysMeals, days);
    }

    private void setCaloriesPane() {
        setEatenMicronutrients();
        setProgressBars();
        setCaloriesPaneElementsColors();
    }

    private void setEatenMicronutrients() {
        caloriesPaneController.getEatenProteinsLabelController().setText(Integer.toString((int) CaloriesCalculator.getProteinsFromDay(QueryExecutor.allUserDayMeals(User.getUserID(),DateController.getActualClickedDate()))));
        caloriesPaneController.getEatenCarbohydratesLabelController().setText((Integer.toString((int) CaloriesCalculator.getCarbohydratesFromDay(QueryExecutor.allUserDayMeals(User.getUserID(),DateController.getActualClickedDate())))));
        caloriesPaneController.getEatenFatLabelController().setText(Integer.toString((int) CaloriesCalculator.getFatFromDay(QueryExecutor.allUserDayMeals(User.getUserID(),DateController.getActualClickedDate()))));
        caloriesPaneController.getEatenCaloriesLabelController().setText(Integer.toString((int) CaloriesCalculator.getCaloriesFromDay(QueryExecutor.allUserDayMeals(User.getUserID(),DateController.getActualClickedDate()))));
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
        return Double.parseDouble(caloriesPaneController.getEatenProteinsLabelController().getText()) /
                Double.parseDouble(caloriesPaneController.getNeededProteinsLabelController().getText());
    }

    private double getEatenCarbohydratesPercent() {
        return Double.parseDouble(caloriesPaneController.getEatenCarbohydratesLabelController().getText()) /
                Double.parseDouble(caloriesPaneController.getNeededCarbohydratesLabelController().getText());
    }

    private double getEatenFatPercent() {
        return Double.parseDouble(caloriesPaneController.getEatenFatLabelController().getText()) /
                Double.parseDouble(caloriesPaneController.getNeededFatLabelController().getText());
    }

    private double getEatenCaloriesPercent() {
        return Double.parseDouble(caloriesPaneController.getEatenCaloriesLabelController().getText()) /
                Double.parseDouble(caloriesPaneController.getNeededCaloriesLabelController().getText());
    }

    private void setCaloriesPaneElementsColors() {
        setAllProgressBarsColors();
        setAllCaloriesPaneMicronutrientsLabelColors();
    }

    private void setAllProgressBarsColors() {
        setProgressBarsColors(caloriesPaneController.getCaloriesProgressBarController(), BASIC_CALORIES_PROGRESS_BAR_COLOR);
        setProgressBarsColors(caloriesPaneController.getProteinsProgressBarController(), BASIC_PROTEINS_PROGRESS_BAR_COLOR);
        setProgressBarsColors(caloriesPaneController.getCarbohydratesProgressBarController(), BASIC_CARBOHYDRATES_PROGRESS_BAR_COLOR);
        setProgressBarsColors(caloriesPaneController.getFatProgressBarController(), BASIC_FAT_PROGRESS_BAR_COLOR);
    }

    private void setProgressBarsColors(ProgressBar progressBar, String basicProgressBarColorStyle) {
        progressBar.progressProperty().addListener((progress, number, t1) -> {
            double progressValue = progress.getValue().doubleValue();
            if (progressValue > EXCEEDED_MICRONUTRIENTS_WARNING_PROGRESS_BAR_VALUE) setBarRed(progressBar);
            else setBasicBarColor(progressBar, basicProgressBarColorStyle);
        });
    }

    private void setBarRed(ProgressBar progressBar) {
        progressBar.setStyle(WARNING_PROGRESS_BAR_COLOR);
    }

    private void setBasicBarColor(ProgressBar progressBar, String basicProgressBarColor) {
        progressBar.setStyle(basicProgressBarColor);
    }

    private void setAllCaloriesPaneMicronutrientsLabelColors() {
        setCaloriesPaneMicronutrientsLabelColor(caloriesPaneController.getCaloriesProgressBarController(), caloriesPaneController.getAllCaloriesLabels());
        setCaloriesPaneMicronutrientsLabelColor(caloriesPaneController.getProteinsProgressBarController(), caloriesPaneController.getAllProteinsLabels());
        setCaloriesPaneMicronutrientsLabelColor(caloriesPaneController.getCarbohydratesProgressBarController(), caloriesPaneController.getAllCarbohydratesLabels());
        setCaloriesPaneMicronutrientsLabelColor(caloriesPaneController.getFatProgressBarController(), caloriesPaneController.getAllFatLabels());
    }

    private void setCaloriesPaneMicronutrientsLabelColor(ProgressBar progressBar, List<Label> micronutrientsLabels) {
        if (progressBar.getProgress() > EXCEEDED_MICRONUTRIENTS_WARNING_PROGRESS_BAR_VALUE) setCaloriesPaneLabelsRed(micronutrientsLabels);
        else setCaloriesPaneBasic(micronutrientsLabels);
    }

    private void setCaloriesPaneLabelsRed(List<Label> micronutrientsLabels) {
        micronutrientsLabels.forEach(label -> label.setTextFill(Color.RED));
    }

    private void setCaloriesPaneBasic(List<Label> micronutrientsLabels) {
        micronutrientsLabels.forEach(label -> label.setTextFill(Color.WHITE));
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
        day.get(LIST_OF_ALL_MEALS_INDEX).getBreakfast().addAll(meals.get(0));
        day.get(LIST_OF_ALL_MEALS_INDEX).getBrunch().addAll(meals.get(1));
        day.get(LIST_OF_ALL_MEALS_INDEX).getLunch().addAll(meals.get(2));
        day.get(LIST_OF_ALL_MEALS_INDEX).getSupper().addAll(meals.get(3));
    }

    private void setStartCaloricDemand() {
        setCaloricDemand();
        setProgressBars();
        setCaloriesPaneElementsColors();
    }

    private void setCaloricDemand() {
        CaloricDemand caloricDemand = CaloricDemandIO.getCaloricDemand();
        caloriesPaneController.getNeededProteinsLabelController().setText(String.valueOf((int) caloricDemand.getProteinsInDiet()));
        caloriesPaneController.getNeededCarbohydratesLabelController().setText(String.valueOf((int) caloricDemand.getCarbohydratesInDiet()));
        caloriesPaneController.getNeededFatLabelController().setText(String.valueOf((int) caloricDemand.getFatInDiet()));
        caloriesPaneController.getNeededCaloriesLabelController().setText(String.valueOf((int) caloricDemand.getTotalDailyEnergyExpenditure()));
    }

    private void setBreakfastPieChar() {
        setPieChart(breakfastTableViewController.getBreakfastProteinsPercentInMeal(),
                    breakfastTableViewController.getBreakfastCarbohydratesPercentInMeal(),
                    breakfastTableViewController.getBreakfastFatPercentInMeal(),
                    BREAKFAST_NAME.toLowerCase(Locale.ROOT));
    }

    private void setBrunchPieChar() {
        setPieChart(brunchTableViewController.getBrunchProteinsPercentInMeal(),
                    brunchTableViewController.getBrunchCarbohydratesPercentInMeal(),
                    brunchTableViewController.getBrunchFatPercentInMeal(),
                   BRUNCH_NAME.toLowerCase(Locale.ROOT));
    }

    private void setLunchPieChar() {
        setPieChart(lunchTableViewController.getLunchProteinsPercentInMeal(),
                    lunchTableViewController.getLunchCarbohydratesPercentInMeal(),
                    lunchTableViewController.getLunchFatPercentInMeal(),
                    LUNCH_NAME.toLowerCase(Locale.ROOT));
    }

    private void setSupperPieChar() {
        setPieChart(supperTableViewController.getSupperProteinsPercentInMeal(),
                    supperTableViewController.getSupperCarbohydratesPercentInMeal(),
                    supperTableViewController.getSupperFatPercentInMeal(),
                   SUPPER_NAME.toLowerCase(Locale.ROOT));
    }

    private void setPieChart(double proteinsPercent, double carbohydratesPercent, double fatPercent, String mealName) {
        if (isChartEmpty(proteinsPercent,carbohydratesPercent,fatPercent)) initializePieChart(proteinsPercent,carbohydratesPercent,fatPercent,mealName);
        else initializeEmptyPieChart(mealName);
    }

    private void initializePieChart(double proteinsPercent, double carbohydratesPercent, double fatPercent, String mealName) {
        setPieChartData(proteinsPercent, carbohydratesPercent, fatPercent, mealName);
        setPieChartInfoLabels(proteinsPercent, carbohydratesPercent, fatPercent);
        setPieCharColor();
    }
    private void initializeEmptyPieChart(String mealName) {
        setEmptyPieChart(mealName);
        setEmptyPieChartInfoLabels();
    }

    private void setPieCharColor() {
        editPaneController.getPieChartController().getData().get(PROTEINS_PIE_CHART_DATA_INDEX).getNode().setStyle(PROTEINS_PIE_COLOR);
        editPaneController.getPieChartController().getData().get(CARBOHYDRATES_PIE_CHART_DATA_INDEX).getNode().setStyle(CARBOHYDRATES_PIE_COLOR);
        editPaneController.getPieChartController().getData().get(FAT_PIE_CHART_DATA_INDEX).getNode().setStyle(FAT_PIE_COLOR);

    }

    private void setPieChartData(double proteinsPercent, double carbohydratesPercent, double fatPercent, String mealName) {
        ObservableList<PieChart.Data> pieChart = FXCollections.observableArrayList(
                new PieChart.Data("Proteins", proteinsPercent),
                new PieChart.Data("Carbohydrates", carbohydratesPercent),
                new PieChart.Data("Fat", fatPercent));
        editPaneController.getPieChartController().setTitle(mealName);
        editPaneController.getPieChartController().setData(pieChart);
    }

    private void setPieChartInfoLabels(double proteinsPercent, double carbohydratesPercent, double fatPercent) {
        editPaneController.getProteinsPieCharLabelController().setText(new Language().getEditPaneLanguage().getProteinsPieCharLabelController()+ "         " + formatFloat(proteinsPercent));
        editPaneController.getCarbohydratesPieCharLabelController().setText(new Language().getEditPaneLanguage().getCarbohydratesPieCharLabelController() +" " + formatFloat(carbohydratesPercent));
        editPaneController.getFatPieCharLabelController().setText(new Language().getEditPaneLanguage().getFatPieCharLabelController()  + "      " +formatFloat(fatPercent));

    }

    private String formatFloat(double micronutrientPercent) {
        return String.format("%.1f%%", micronutrientPercent);
    }

    private void setEmptyPieChart(String mealName) {
        ObservableList<PieChart.Data> pieChart = FXCollections.observableArrayList(
                new PieChart.Data("", 100));
        editPaneController.getPieChartController().setTitle(mealName);
        editPaneController.getPieChartController().setData(pieChart);
        pieChart.get(EMPTY_PIE_CHART_DATA_INDEX).getNode().setStyle(EMPTY_PIE_CHART_COLOR);
    }

    private void setEmptyPieChartInfoLabels() {
        editPaneController.getProteinsPieCharLabelController().setText(new Language().getEditPaneLanguage().getProteinsPieCharLabelController()+ "        " + 0 + "%");
        editPaneController.getCarbohydratesPieCharLabelController().setText(new Language().getEditPaneLanguage().getCarbohydratesPieCharLabelController() +" " + 0 + "%");
        editPaneController.getFatPieCharLabelController().setText(new Language().getEditPaneLanguage().getFatPieCharLabelController()  + "      " + 0 + "%");

    }

    private boolean isChartEmpty(double proteinsPercent, double carbohydratesPercent, double fatPercent) {
        return proteinsPercent>0 || carbohydratesPercent>0 || fatPercent>0;
    }

    private void addProductToBase(){
       editPaneController.getAddProductToListViewButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
           if (!isTextFieldEmpty(editPaneController.getWeightTextFieldController())) {
               if (editPaneController.getProductsBaseListView().getSelectionModel().getSelectedItem()!=null) {
                   DaysMeals daysMeals = new DaysMeals();
                   QueryExecutor.addProductToBase(getMealIdInList(),getProductIndexInSQL(),getWeight(),getNewProductIndexInTableView());
                   setAll(daysMeals);
               }
           }
       });
    }

    private int getMealIdInList() {
        int idInList = NULL_VALUE;
        switch (getMealId()) {
            case BREAKFAST_TABLE_VIEW_ID -> idInList = SQL_BREAKFAST_index;
            case BRUNCH_TABLE_VIEW_ID -> idInList = SQL_BRUNCH_index;
            case LUNCH_TABLE_VIEW_ID -> idInList = SQL_LUNCH_index;
            case SUPPER_TABLE_VIEW_ID -> idInList =SQL_SUPPER_index;
        }
        return idInList;
    }

    private int getProductIndexInSQL() {
     return editPaneController.getProductsBaseListView().getSelectionModel().getSelectedItem().getProductIndex()+1;
    }

    private double getWeight() {
      return Double.parseDouble(editPaneController.getWeightTextFieldController().getText());
    }

    private int getNewProductIndexInTableView() {
        int idInList = NULL_VALUE;
        switch (getMealId()) {
            case BREAKFAST_TABLE_VIEW_ID -> idInList = breakfastTableViewController.getBreakfastTableViewController().getItems().size();
            case BRUNCH_TABLE_VIEW_ID -> idInList = brunchTableViewController.getBrunchTableViewController().getItems().size();
            case LUNCH_TABLE_VIEW_ID -> idInList = lunchTableViewController.getLunchTableViewController().getItems().size();
            case SUPPER_TABLE_VIEW_ID -> idInList = supperTableViewController.getSupperTableViewController().getItems().size();
        }
        return idInList;
    }

    private boolean isTextFieldEmpty(TextField textField) {
        if(textField == null) return true;
        else return textField.getText().equals(EMPTY_FIELD);
    }

    private void addDeleteButtonToActualTableViewMeal() {
        switch (getMealId()) {
            case BREAKFAST_TABLE_VIEW_ID -> addButtonToTable(breakfastTableViewController.getBreakfastTableViewController());
            case BRUNCH_TABLE_VIEW_ID -> addButtonToTable(brunchTableViewController.getBrunchTableViewController());
            case LUNCH_TABLE_VIEW_ID -> addButtonToTable(lunchTableViewController.getLunchTableViewController());
            case SUPPER_TABLE_VIEW_ID -> addButtonToTable(supperTableViewController.getSupperTableViewController());
        }
    }

    private void addButtonToTable(TableView<Product> tableView) {
        TableColumn<Product, Void> colBtn = new TableColumn("Delete");
        Callback<TableColumn<Product, Void>, TableCell<Product, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Product, Void> call(final TableColumn<Product, Void> column) {
                final TableCell<Product, Void> cell = new TableCell<>() {
                    private final Button btn = new Button();

                    {
                        setDeleteButton(btn);
                        btn.setOnAction((ActionEvent event) -> {
                            QueryExecutor.deleteProductFromBase(getMealIdInList(),getIndex());
                            QueryExecutor.updateProductIndexInMealFromBase(getMealIdInList(),getIndex());
                            DaysMeals daysMeals = new DaysMeals();
                            setAll(daysMeals);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);
        setAddedTableColumnSetting(colBtn);
        tableView.getColumns().add(colBtn);
    }

    private void setDeleteButton(Button btn) {
        btn.setMinSize(40,20);
        btn.setPrefSize(40,20);
        btn.setMaxSize(40,20);
        btn.setId(DELETE_BUTTON_CSS_STYLE_SHEET_ID);
        ImageView delete = new ImageView(getClass().getResource(DELETE_BUTTON_JPG_FILE_PATH).toExternalForm());
        delete.setPreserveRatio(true);
        btn.setGraphic(delete);
        btn.setContentDisplay(ContentDisplay.CENTER);
    }

    private void setAddedTableColumnSetting(TableColumn tableColumn) {
        tableColumn.setReorderable(false);
        tableColumn.setEditable(false);
    }

    private void hideSwitchToEditPaneButton() {
        switch (getMealId()) {
            case BREAKFAST_TABLE_VIEW_ID -> breakfastTableViewController.getBreakfastEditButtonController().setVisible(false);
            case BRUNCH_TABLE_VIEW_ID -> brunchTableViewController.getBrunchEditButtonController().setVisible(false);
            case LUNCH_TABLE_VIEW_ID -> lunchTableViewController.getLunchEditButtonController().setVisible(false);
            case SUPPER_TABLE_VIEW_ID -> supperTableViewController.getSupperEditButtonController().setVisible(false);
        }
    }


    }








