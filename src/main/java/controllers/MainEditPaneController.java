package controllers;
import controllers.MainPaneComponentsControllers.CaloriesPaneController;
import controllers.MainPaneComponentsControllers.DaysPaneController;
import controllers.MainPaneComponentsControllers.SettingsPaneController;
import controllers.SwitchScenesControllers.EditPaneController;
import controllers.tableViewsControllers.BreakfastTableViewController;
import controllers.tableViewsControllers.BrunchTableViewController;
import controllers.tableViewsControllers.LunchTableViewController;
import controllers.tableViewsControllers.SupperTableViewController;
import io.ProductBaseReader;
import io.ProductTableViewsReader;
import io.ProductTableViewsWriter;
import io.YourProductBaseIO;
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
import javafx.stage.Stage;
import javafx.util.Callback;
import model.calories.CaloriesCalculator;
import model.Days;
import model.meals.Meals;
import model.product.DaysMeals;
import model.product.Product;
import java.util.List;
import java.util.Locale;

public class MainEditPaneController {
    private static Days lastClickedDay = Days.MONDAY;
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
    private EditPaneController editPaneController;
    private static final int LIST_OF_ALL_MEALS_INDEX = 0;
    private static final String BREAKFAST_TABLE_VIEW_ID = "breakfastTableView";
    private static final String BRUNCH_TABLE_VIEW_ID = "brunchTableView";
    private static final String LUNCH_TABLE_VIEW_ID = "lunchTableView";
    private static final String SUPPER_TABLE_VIEW_ID = "supperTableView";
    private static final String DELETE_BUTTON_JPG_FILE_PATH = "/img/deleteButton.png";
    private static final String DELETE_BUTTON_CSS_STYLE_SHEET_ID = "delete-button";
    private static final String LAST_CLICKED_DAY_COLOR_STYLE = "-fx-border-color: red";
    private static final String BASIC_PROTEINS_PROGRESS_BAR_COLOR = "-fx-accent: blue;";
    private static final String BASIC_CARBOHYDRATES_PROGRESS_BAR_COLOR = "-fx-accent: green;";
    private static final String BASIC_FAT_PROGRESS_BAR_COLOR = "-fx-accent: chocolate;";
    private static final String BASIC_CALORIES_PROGRESS_BAR_COLOR = "-fx-accent: black;";
    private static final String WARNING_PROGRESS_BAR_COLOR = "-fx-accent: red;";
    private static final String BREAKFAST_NAME = "BREAKFAST";
    private static final String BRUNCH_NAME = "BRUNCH";
    private static final String LUNCH_NAME = "LUNCH";
    private static final String SUPPER_NAME = "SUPPER";
    private static final String EMPTY_FIELD = "";
    private static final String CHANGE_TO_YOUR_PRODUCTS_BASE_BUTTON_TEXT = "personal products";
    private static final String CHANGE_TO_MAIN_PRODUCT_BASE_BUTTON_TEXT = "product base";
    private static final String EMPTY_PIE_CHART_COLOR = "-fx-pie-color: white";
    private static final String PROTEINS_PIE_COLOR = "-fx-pie-color: blue";
    private static final String CARBOHYDRATES_PIE_COLOR = "-fx-pie-color: green";
    private static final String FAT_PIE_COLOR = "-fx-pie-color: chocolate";
    private static final int EXCEEDED_MICRONUTRIENTS_WARNING_PROGRESS_BAR_VALUE = 1;
    private static final int EMPTY_PIE_CHART_DATA_INDEX = 0;
    private static final int PROTEINS_PIE_CHART_DATA_INDEX = 0;
    private static final int CARBOHYDRATES_PIE_CHART_DATA_INDEX = 1;
    private static final int FAT_PIE_CHART_DATA_INDEX = 2;

    public void initialize() {
        DaysMeals daysMeals = new DaysMeals();
        setAll(daysMeals);
        showMainViewFromClickedDay();
        addProductToBase();
        addDeleteButtonToActualTableViewMeal();
    }
    public void setAll(DaysMeals daysMeals) {
        daysMeals.createMealsFromAllDays();
        addAllProductToAllTableViews(daysMeals);
        setEditPaneViewByMeal(daysMeals);
        setStartCaloricDemand();
        setLastClickedDayBackgroundColor();
    }
    public static void setNumberOfLastClickedDay(Days day) {
        lastClickedDay = day;
    }
    public static Days getLastClickedDay() {
        return lastClickedDay;
    }
    private void showMainViewFromClickedDay() {
        daysPaneController.getMondayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> showTableViewsByClickedDay(Days.MONDAY));
        daysPaneController.getTuesdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> showTableViewsByClickedDay(Days.TUESDAY));
        daysPaneController.getWednesdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> showTableViewsByClickedDay(Days.WEDNESDAY));
        daysPaneController.getThursdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> showTableViewsByClickedDay(Days.THURSDAY));
        daysPaneController.getFridayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> showTableViewsByClickedDay(Days.FRIDAY));
        daysPaneController.getSaturdayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> showTableViewsByClickedDay(Days.SATURDAY));
        daysPaneController.getSundayButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> showTableViewsByClickedDay(Days.SUNDAY));
    }
    private void showTableViewsByClickedDay(Days days) {
        SceneSwitcherController sceneSwitcherController = new SceneSwitcherController();
        lastClickedDay = days;
        sceneSwitcherController.switchToMainPane(thisStage());
    }
    private Stage thisStage() {
        return (Stage) daysPaneController.getMondayButtonController().getScene().getWindow();
    }
    private void setEditPaneViewByMeal(DaysMeals daysMeals) {
        switch (getMealId()) {
            case BREAKFAST_TABLE_VIEW_ID -> setBreakfastEditPane(daysMeals, lastClickedDay);
            case BRUNCH_TABLE_VIEW_ID -> setBrunchEditPane(daysMeals, lastClickedDay);
            case LUNCH_TABLE_VIEW_ID -> setLunchEditPane(daysMeals, lastClickedDay);
            case SUPPER_TABLE_VIEW_ID -> setSupperEditPane(daysMeals, lastClickedDay);
        }
    }
    private String getMealId() {
        return mainPaneViewVboxController.getChildren().get(LIST_OF_ALL_MEALS_INDEX).getId();
    }
    private void setBreakfastEditPane(DaysMeals daysMeals, Days days) {
        addProductsToBreakfastByDay(daysMeals, days);
        setBreakfastMicronutrientsTableViewLabels(daysMeals, days);
        setCaloriesPane(daysMeals, days);
        setBreakfastPieChar();
    }
    private void setBrunchEditPane(DaysMeals daysMeals, Days days) {
        addProductsToBrunchByDay(daysMeals, days);
        setBrunchMicronutrientsTableViewLabels(daysMeals, days);
        setCaloriesPane(daysMeals, days);
        setBrunchPieChar();
    }
    private void setLunchEditPane(DaysMeals daysMeals, Days days) {
        addProductsToLunchByDay(daysMeals, days);
        setLunchMicronutrientsTableViewLabels(daysMeals, days);
        setCaloriesPane(daysMeals, days);
        setLunchPieChar();
    }
    private void setSupperEditPane(DaysMeals daysMeals, Days days) {
        addProductsToSupperByDay(daysMeals, days);
        setSupperMicronutrientsTableViewLabels(daysMeals, days);
        setCaloriesPane(daysMeals, days);
        setSupperPieChar();
    }
    private void addProductsToBreakfastByDay(DaysMeals daysMeals, Days days) {
        breakfastTableViewController.removeAllTableViewProducts();
        breakfastTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getBreakfast());
    }
    private void addProductsToBrunchByDay(DaysMeals daysMeals, Days days) {
        brunchTableViewController.removeAllTableViewProducts();
        brunchTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getBrunch());
    }
    private void addProductsToLunchByDay(DaysMeals daysMeals, Days days) {
        lunchTableViewController.removeAllTableViewProducts();
        lunchTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getLunch());
    }
    private void addProductsToSupperByDay(DaysMeals daysMeals, Days days) {
        supperTableViewController.removeAllTableViewProducts();
        supperTableViewController.addProductsToActualTableView(daysMeals.getDaysListMap().get(days).get(LIST_OF_ALL_MEALS_INDEX).getSupper());
    }
    private void setBreakfastMicronutrientsTableViewLabels(DaysMeals daysMeals, Days days) {
        breakfastTableViewController.setThisMealMicronutrientsLabels(daysMeals, days);
    }
    private void setBrunchMicronutrientsTableViewLabels(DaysMeals daysMeals, Days days) {
        brunchTableViewController.setThisMealMicronutrientsLabels(daysMeals, days);
    }
    private void setLunchMicronutrientsTableViewLabels(DaysMeals daysMeals, Days days) {
        lunchTableViewController.setThisMealMicronutrientsLabels(daysMeals, days);
    }
    private void setSupperMicronutrientsTableViewLabels(DaysMeals daysMeals, Days days) {
        supperTableViewController.setThisMealMicronutrientsLabels(daysMeals, days);
    }
    private void setCaloriesPane(DaysMeals daysMeals, Days days) {
        setEatenMicronutrients(daysMeals, days);
        setProgressBars();
        setCaloriesPaneElementsColors();
    }
    private void setEatenMicronutrients(DaysMeals daysMeals, Days days) {
        caloriesPaneController.getEatenProteinsLabelController().setText(Integer.toString((int) CaloriesCalculator.getProteinsFromDay(daysMeals.getDaysListMap().get(days))));
        caloriesPaneController.getEatenCarbohydratesLabelController().setText((Integer.toString((int) CaloriesCalculator.getCarbohydratesFromDay(daysMeals.getDaysListMap().get(days)))));
        caloriesPaneController.getEatenFatLabelController().setText(Integer.toString((int) CaloriesCalculator.getFatFromDay(daysMeals.getDaysListMap().get(days))));
        caloriesPaneController.getEatenCaloriesLabelController().setText(Integer.toString((int) CaloriesCalculator.getCaloriesFromDay(daysMeals.getDaysListMap().get(days))));
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
        addAllProductToTableView(products.getMondayMeals(),Days.MONDAY);
        addAllProductToTableView(products.getTuesdayMeals(),Days.TUESDAY);
        addAllProductToTableView(products.getWednesdayMeals(),Days.WEDNESDAY);
        addAllProductToTableView(products.getThursdayMeals(),Days.THURSDAY);
        addAllProductToTableView(products.getFridayMeals(),Days.FRIDAY);
        addAllProductToTableView(products.getSaturdayMeals(),Days.SATURDAY);
        addAllProductToTableView(products.getSundayMeals(),Days.SUNDAY);

    }
    public void addAllProductToTableView(List<Meals> day, Days days) {
        day.get(LIST_OF_ALL_MEALS_INDEX).getBreakfast().addAll(ProductTableViewsReader.getProductListFromMeal(days,BREAKFAST_NAME));
        day.get(LIST_OF_ALL_MEALS_INDEX).getBrunch().addAll(ProductTableViewsReader.getProductListFromMeal(days,BRUNCH_NAME));
        day.get(LIST_OF_ALL_MEALS_INDEX).getLunch().addAll(ProductTableViewsReader.getProductListFromMeal(days,LUNCH_NAME));
        day.get(LIST_OF_ALL_MEALS_INDEX).getSupper().addAll(ProductTableViewsReader.getProductListFromMeal(days,SUPPER_NAME));
    }

    private void setStartCaloricDemand() {
        caloriesPaneController.getNeededProteinsLabelController().setText("120");
        caloriesPaneController.getNeededCarbohydratesLabelController().setText("300");
        caloriesPaneController.getNeededFatLabelController().setText("60");
        caloriesPaneController.getNeededCaloriesLabelController().setText("2220");
        setProgressBars();
        setCaloriesPaneElementsColors();
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
        if (isChartEmpty(proteinsPercent,carbohydratesPercent,fatPercent)) {
            setPieChartData(proteinsPercent, carbohydratesPercent, fatPercent, mealName);
            setPieChartInfoLabels(proteinsPercent, carbohydratesPercent, fatPercent);
            setPieCharColor();
        } else {
            setEmptyPieChart(mealName);
            setEmptyPieChartInfoLabels();
        }
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
        editPaneController.getProteinsPieCharLabelController().setText("Proteins:          " + formatFloat(proteinsPercent));
        editPaneController.getCarbohydratesPieCharLabelController().setText("Carbohydrates:   " + formatFloat(carbohydratesPercent));
        editPaneController.getFatPieCharLabelController().setText("Fat:               " + formatFloat(fatPercent));

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
        editPaneController.getProteinsPieCharLabelController().setText("Proteins:          " + 0 + "%");
        editPaneController.getCarbohydratesPieCharLabelController().setText("Carbohydrates:   " + 0 + "%");
        editPaneController.getFatPieCharLabelController().setText("Fat:               " + 0 + "%");

    }
    private boolean isChartEmpty(double proteinsPercent, double carbohydratesPercent, double fatPercent) {
        return proteinsPercent>0 || carbohydratesPercent>0 || fatPercent>0;
    }
    private void setLastClickedDayBackgroundColor() {
        switch (lastClickedDay) {
            case MONDAY ->    daysPaneController.getMondayButtonController().setStyle(LAST_CLICKED_DAY_COLOR_STYLE);
            case TUESDAY ->   daysPaneController.getTuesdayButtonController().setStyle(LAST_CLICKED_DAY_COLOR_STYLE);
            case WEDNESDAY -> daysPaneController.getWednesdayButtonController().setStyle(LAST_CLICKED_DAY_COLOR_STYLE);
            case THURSDAY ->  daysPaneController.getThursdayButtonController().setStyle(LAST_CLICKED_DAY_COLOR_STYLE);
            case FRIDAY ->    daysPaneController.getFridayButtonController().setStyle(LAST_CLICKED_DAY_COLOR_STYLE);
            case SATURDAY ->  daysPaneController.getSaturdayButtonController().setStyle(LAST_CLICKED_DAY_COLOR_STYLE);
            case SUNDAY ->    daysPaneController.getSundayButtonController().setStyle(LAST_CLICKED_DAY_COLOR_STYLE);

        }
    }
    private void addProductToBase(){
       editPaneController.getAddProductToListViewButtonController().addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
           if (!isTextFieldEmpty(editPaneController.getWeightTextFieldController())) {
               if (editPaneController.getProductsBaseListView().getSelectionModel().getSelectedItem()!=null) {
                   DaysMeals daysMeals = new DaysMeals();
                   safeTableViewState(getChosenProductFromListView());
                   setAll(daysMeals);
               }
           }
       });
    }
    private Product getChosenProductFromListView() {
        Product product;
        if(editPaneController.getChangeListViewButtonController().getText().equals(CHANGE_TO_YOUR_PRODUCTS_BASE_BUTTON_TEXT)) {
           product = ProductBaseReader.getProductFromBase(editPaneController.getProductsBaseListView().getSelectionModel().getSelectedIndex(),
                    Double.parseDouble(editPaneController.getWeightTextFieldController().getText()));
        } else if (editPaneController.getChangeListViewButtonController().getText().equals(CHANGE_TO_MAIN_PRODUCT_BASE_BUTTON_TEXT)) {
            product = YourProductBaseIO.getProductFromBase(editPaneController.getProductsBaseListView().getSelectionModel().getSelectedIndex(),
                    Double.parseDouble(editPaneController.getWeightTextFieldController().getText()));
        } else throw new NullPointerException();
        return product;
    }
    private void safeTableViewState(Product product) {
        ProductTableViewsWriter.addProductToTableBase(lastClickedDay,meal(),modifyProductToStringToSaveForm(product));
    }
    private String modifyProductToStringToSaveForm(Product product){
        return  product.getNameOfProduct() + "@" + product.getProducer() + "@" + product.getKcal() + "@" +
                product.getProteins() + "@" + product.getCarbohydrates() + "@" + product.getFat() + "@" +
                product.getWeight();
    }
    private String meal() {
        String meal = "";
        switch (getMealId()) {
            case BREAKFAST_TABLE_VIEW_ID -> meal = BREAKFAST_NAME;
            case BRUNCH_TABLE_VIEW_ID -> meal = BRUNCH_NAME;
            case LUNCH_TABLE_VIEW_ID -> meal = LUNCH_NAME;
            case SUPPER_TABLE_VIEW_ID -> meal = SUPPER_NAME;
        }
        return meal;
    }
    private boolean isTextFieldEmpty(TextField textField) {
        if(textField == null) return true;
        else return textField.getText().equals(EMPTY_FIELD);
    }
    private void addDeleteButtonToActualTableViewMeal() {
        switch (getMealId()) {
            case BREAKFAST_TABLE_VIEW_ID -> addButtonToTable(breakfastTableViewController.getBreakfastTableViewController(),BREAKFAST_NAME);
            case BRUNCH_TABLE_VIEW_ID -> addButtonToTable(brunchTableViewController.getBrunchTableViewController(),BRUNCH_NAME);
            case LUNCH_TABLE_VIEW_ID -> addButtonToTable(lunchTableViewController.getLunchTableViewController(),LUNCH_NAME);
            case SUPPER_TABLE_VIEW_ID -> addButtonToTable(supperTableViewController.getSupperTableViewController(),SUPPER_NAME);
        }
    }
    private void addButtonToTable(TableView<Product> tableView,String mealName) {
        TableColumn<Product, Void> colBtn = new TableColumn("Delete");
        Callback<TableColumn<Product, Void>, TableCell<Product, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Product, Void> call(final TableColumn<Product, Void> column) {
                final TableCell<Product, Void> cell = new TableCell<>() {
                    private final Button btn = new Button();

                    {
                        setDeleteButton(btn);
                        btn.setOnAction((ActionEvent event) -> {
                            ProductTableViewsWriter.removeProductFromTableBase(MainEditPaneController.getLastClickedDay(), mealName, getIndex());
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
    }








