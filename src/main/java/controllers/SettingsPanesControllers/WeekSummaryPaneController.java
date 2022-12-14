package controllers.SettingsPanesControllers;

import io.CaloricDemandIO;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import model.calories.CaloricDemand;
import model.calories.CaloriesCalculator;
import model.language.Language;
import model.language.WeekSummaryLanguage;
import model.weekSummary.WeekSummary;

public class WeekSummaryPaneController {
    private static final int DAYS_OF_WEEK = 7;
    private static final int EXCEEDED_MICRONUTRIENTS_WARNING_PROGRESS_BAR_VALUE = 1;
    private static final String BASIC_PROTEINS_PROGRESS_BAR_COLOR = "-fx-accent: #04BDDE";
    private static final String BASIC_CARBOHYDRATES_PROGRESS_BAR_COLOR = "-fx-accent: #32F902";
    private static final String BASIC_FAT_PROGRESS_BAR_COLOR = "-fx-accent: chocolate";
    private static final String BASIC_CALORIES_PROGRESS_BAR_COLOR = "-fx-accent: #9933ff";
    private static final String WARNING_PROGRESS_BAR_COLOR = "-fx-accent: red;";
    private static String mondaySeries;
    private static String tuesdaySeries;
    private static String wednesdaySeries;
    private static String thursdaySeries;
    private static String fridaySeries;
    private static String saturdaySeries;
    private static String sundaySeries;
    private static String proteinsSeriesName;
    private static String carbohydratesSeriesName;
    private static String fatSeriesName;

    @FXML
    private ProgressBar caloriesWeekSummaryProgressBarController;
    @FXML
    private ProgressBar carbohydratesWeekSummaryProgressBarController;
    @FXML
    private Label daysWithoutExceededCaloriesInfoLabelController;
    @FXML
    private Label daysWithoutExceededCaloriesLabelController;
    @FXML
    private Label eatenCaloriesWeekSummaryLabelController;
    @FXML
    private Label eatenCarbohydratesWeekSummaryLabelController;
    @FXML
    private Label eatenFatWeekSummaryLabelController;
    @FXML
    private Label eatenProteinsWeekSummaryLabelController;
    @FXML
    private ProgressBar fatWeekSummaryProgressBarController;
    @FXML
    private Label neededCaloriesWeekSummaryLabelController;
    @FXML
    private Label neededCarbohydratesWeekSummaryLabelController;
    @FXML
    private Label neededFatWeekSummaryLabelController;
    @FXML
    private Label neededProteinsWeekSummaryLabelController;
    @FXML
    private ProgressBar proteinsWeekSummaryProgressBarController;
    @FXML
    private Label weekCaloriesLabelController;
    @FXML
    private Label weekCarbohydratesLabelController;
    @FXML
    private Label weekFatLabelController;
    @FXML
    private Label weekProteinsLabelController;
    @FXML
    private AnchorPane weekSummaryAnchorPaneController;
    @FXML
    private BarChart<String, Integer> barChartController;
    @FXML
    private Label weekSummaryTitleLabelController;
    @FXML
    private Label proteinsSlashController;
    @FXML
    private Label carbohydratesSlashController;
    @FXML
    private Label fatSlashController;
    @FXML
    private Label caloriesSlashController;

    public void initialize() {
        setLanguage(new Language().getWeekSummaryLanguage());
        setWeekSummaryComponents(new WeekSummary(), CaloricDemandIO.getCaloricDemand());
    }

    private void setLanguage(WeekSummaryLanguage language) {
        weekProteinsLabelController.setText(language.getWeekProteinsLabelController());
        weekCarbohydratesLabelController.setText(language.getWeekCarbohydratesLabelController());
        weekFatLabelController.setText(language.getWeekFatLabelController());
        weekCaloriesLabelController.setText(language.getWeekCaloriesLabelController());
        daysWithoutExceededCaloriesInfoLabelController.setText(language.getDaysWithoutExceededCaloriesInfoLabelController());
        weekSummaryTitleLabelController.setText(language.getWeekSummaryTitleLabelController());
        barChartController.setTitle(language.getBarChartTitle());
        mondaySeries = language.getMondaySeries();
        tuesdaySeries = language.getTuesdaySeries();
        wednesdaySeries = language.getWednesdaySeries();
        thursdaySeries = language.getThursdaySeries();
        fridaySeries = language.getFridaySeries();
        saturdaySeries = language.getSaturdaySeries();
        sundaySeries = language.getSundaySeries();
        proteinsSeriesName = language.getProteinsSeriesName();
        carbohydratesSeriesName = language.getCarbohydratesSeriesName();
        fatSeriesName = language.getFatSeriesName();
    }

    private void setWeekSummaryComponents(WeekSummary weekSummary, CaloricDemand caloricDemand) {
        setWeekSummaryLabels(weekSummary, caloricDemand);
        setProgressBars(weekSummary, caloricDemand);
        initializeDaysWithoutExceededCalories(weekSummary, caloricDemand);
        initializeBarChart(weekSummary);

    }

    private void setWeekSummaryLabels(WeekSummary weekSummary, CaloricDemand caloricDemand) {
        setEatenMicronutrientsLabels(weekSummary);
        setNeededMicronutrientsLabels(caloricDemand);
    }

    private void setEatenMicronutrientsLabels(WeekSummary weekSummary) {
        eatenProteinsWeekSummaryLabelController.setText(String.valueOf((int) CaloriesCalculator.getWeekProteins(weekSummary)));
        eatenCarbohydratesWeekSummaryLabelController.setText(String.valueOf((int) CaloriesCalculator.getWeekCarbohydrates(weekSummary)));
        eatenFatWeekSummaryLabelController.setText(String.valueOf((int) CaloriesCalculator.getWeekFat(weekSummary)));
        eatenCaloriesWeekSummaryLabelController.setText(String.valueOf((int) CaloriesCalculator.getWeekCalories(weekSummary)));
    }

    private void setNeededMicronutrientsLabels(CaloricDemand caloricDemand) {
        neededProteinsWeekSummaryLabelController.setText(String.valueOf(DAYS_OF_WEEK * caloricDemand.getProteinsInDiet()));
        neededCarbohydratesWeekSummaryLabelController.setText(String.valueOf(DAYS_OF_WEEK * caloricDemand.getCarbohydratesInDiet()));
        neededFatWeekSummaryLabelController.setText(String.valueOf(DAYS_OF_WEEK * caloricDemand.getFatInDiet()));
        neededCaloriesWeekSummaryLabelController.setText(String.valueOf(DAYS_OF_WEEK * caloricDemand.getTotalDailyEnergyExpenditure()));
    }

    private void setProgressBars(WeekSummary weekSummary, CaloricDemand caloricDemand) {
        setProgressInProgressBars(weekSummary, caloricDemand);
        setAllProgressBarsColors();
    }

    private void setProgressInProgressBars(WeekSummary weekSummary, CaloricDemand caloricDemand) {
        proteinsWeekSummaryProgressBarController.setProgress(getProteinsProgressBarProgress(weekSummary, caloricDemand));
        carbohydratesWeekSummaryProgressBarController.setProgress(getCarbohydratesProgressBarProgress(weekSummary, caloricDemand));
        fatWeekSummaryProgressBarController.setProgress(getFatProgressBarProgress(weekSummary, caloricDemand));
        caloriesWeekSummaryProgressBarController.setProgress(getCaloriesProgressBarProgress(weekSummary, caloricDemand));
    }

    private double getProteinsProgressBarProgress(WeekSummary weekSummary, CaloricDemand caloricDemand) {
        return getProgress(CaloriesCalculator.getWeekProteins(weekSummary), DAYS_OF_WEEK * caloricDemand.getProteinsInDiet());
    }

    private double getCarbohydratesProgressBarProgress(WeekSummary weekSummary, CaloricDemand caloricDemand) {
        return getProgress(CaloriesCalculator.getWeekCarbohydrates(weekSummary), DAYS_OF_WEEK * caloricDemand.getCarbohydratesInDiet());
    }

    private double getFatProgressBarProgress(WeekSummary weekSummary, CaloricDemand caloricDemand) {
        return getProgress(CaloriesCalculator.getWeekFat(weekSummary), DAYS_OF_WEEK * caloricDemand.getFatInDiet());
    }

    private double getCaloriesProgressBarProgress(WeekSummary weekSummary, CaloricDemand caloricDemand) {
        return getProgress(CaloriesCalculator.getWeekCalories(weekSummary), DAYS_OF_WEEK * caloricDemand.getTotalDailyEnergyExpenditure());
    }

    private double getProgress(double caloriesEaten, double caloriesNeeded) {
        return caloriesEaten / caloriesNeeded;
    }

    private void setAllProgressBarsColors() {
        setProgressBarsColors(caloriesWeekSummaryProgressBarController, BASIC_CALORIES_PROGRESS_BAR_COLOR);
        setProgressBarsColors(proteinsWeekSummaryProgressBarController, BASIC_PROTEINS_PROGRESS_BAR_COLOR);
        setProgressBarsColors(carbohydratesWeekSummaryProgressBarController, BASIC_CARBOHYDRATES_PROGRESS_BAR_COLOR);
        setProgressBarsColors(fatWeekSummaryProgressBarController, BASIC_FAT_PROGRESS_BAR_COLOR);
    }

    private void setProgressBarsColors(ProgressBar progressBar, String basicProgressBarColorStyle) {
        if (progressBar.getProgress() > EXCEEDED_MICRONUTRIENTS_WARNING_PROGRESS_BAR_VALUE) setBarRed(progressBar);
        else setBasicBarColor(progressBar, basicProgressBarColorStyle);

    }

    private void setBarRed(ProgressBar progressBar) {
        progressBar.setStyle(WARNING_PROGRESS_BAR_COLOR);
    }

    private void setBasicBarColor(ProgressBar progressBar, String basicProgressBarColor) {
        progressBar.setStyle(basicProgressBarColor);
    }

    private void initializeDaysWithoutExceededCalories(WeekSummary weekSummary, CaloricDemand caloricDemand) {
        daysWithoutExceededCaloriesLabelController.setText(Integer.toString(getDaysWithoutExceededCalories(weekSummary, caloricDemand)));
    }

    private int getDaysWithoutExceededCalories(WeekSummary weekSummary, CaloricDemand caloricDemand) {
        int days = 0;
        if (CaloriesCalculator.getCaloriesFromDay(weekSummary.getMondayProducts()) < caloricDemand.getTotalDailyEnergyExpenditure())
            days++;
        if (CaloriesCalculator.getCaloriesFromDay(weekSummary.getTuesdayProducts()) < caloricDemand.getTotalDailyEnergyExpenditure())
            days++;
        if (CaloriesCalculator.getCaloriesFromDay(weekSummary.getWednesdayProducts()) < caloricDemand.getTotalDailyEnergyExpenditure())
            days++;
        if (CaloriesCalculator.getCaloriesFromDay(weekSummary.getThursdayProducts()) < caloricDemand.getTotalDailyEnergyExpenditure())
            days++;
        if (CaloriesCalculator.getCaloriesFromDay(weekSummary.getFridayProducts()) < caloricDemand.getTotalDailyEnergyExpenditure())
            days++;
        if (CaloriesCalculator.getCaloriesFromDay(weekSummary.getSaturdayProducts()) < caloricDemand.getTotalDailyEnergyExpenditure())
            days++;
        if (CaloriesCalculator.getCaloriesFromDay(weekSummary.getSundayProducts()) < caloricDemand.getTotalDailyEnergyExpenditure())
            days++;
        return days;
    }

    private void initializeBarChart(WeekSummary weekSummary) {
        barChartController.getData().addAll(createProteinsSeries(weekSummary),
                                                   createCarbohydratesSeries(weekSummary),
                                                   createFatSeries(weekSummary));
    }

    private XYChart.Series<String, Integer> createProteinsSeries(WeekSummary weekSummary) {
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(mondaySeries, (int)(CaloriesCalculator.getProteinsFromDay(weekSummary.getMondayProducts())*CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES)));
        series.getData().add(new XYChart.Data<>(tuesdaySeries, (int) (CaloriesCalculator.getProteinsFromDay(weekSummary.getTuesdayProducts())*CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES)));
        series.getData().add(new XYChart.Data<>(wednesdaySeries, (int) (CaloriesCalculator.getProteinsFromDay(weekSummary.getWednesdayProducts())*CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES)));
        series.getData().add(new XYChart.Data<>(thursdaySeries, (int) (CaloriesCalculator.getProteinsFromDay(weekSummary.getThursdayProducts())*CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES)));
        series.getData().add(new XYChart.Data<>(fridaySeries, (int) (CaloriesCalculator.getProteinsFromDay(weekSummary.getFridayProducts())*CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES)));
        series.getData().add(new XYChart.Data<>(saturdaySeries, (int) (CaloriesCalculator.getProteinsFromDay(weekSummary.getSaturdayProducts())*CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES)));
        series.getData().add(new XYChart.Data<>(sundaySeries, (int) (CaloriesCalculator.getProteinsFromDay(weekSummary.getSundayProducts())*CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES)));
        series.setName(proteinsSeriesName);
        return series;
    }

    private XYChart.Series<String, Integer> createCarbohydratesSeries(WeekSummary weekSummary) {
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(mondaySeries, (int) (CaloriesCalculator.getCarbohydratesFromDay(weekSummary.getMondayProducts())*CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES)));
        series.getData().add(new XYChart.Data<>(tuesdaySeries, (int) (CaloriesCalculator.getCarbohydratesFromDay(weekSummary.getTuesdayProducts())*CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES)));
        series.getData().add(new XYChart.Data<>(wednesdaySeries, (int) (CaloriesCalculator.getCarbohydratesFromDay(weekSummary.getWednesdayProducts())*CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES)));
        series.getData().add(new XYChart.Data<>(thursdaySeries, (int) (CaloriesCalculator.getCarbohydratesFromDay(weekSummary.getThursdayProducts())*CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES)));
        series.getData().add(new XYChart.Data<>(fridaySeries, (int) (CaloriesCalculator.getCarbohydratesFromDay(weekSummary.getFridayProducts())*CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES)));
        series.getData().add(new XYChart.Data<>(saturdaySeries, (int) (CaloriesCalculator.getCarbohydratesFromDay(weekSummary.getSaturdayProducts())*CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES)));
        series.getData().add(new XYChart.Data<>(sundaySeries, (int) (CaloriesCalculator.getCarbohydratesFromDay(weekSummary.getSundayProducts())*CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES)));
        series.setName(carbohydratesSeriesName);
        return series;
    }

    private XYChart.Series<String, Integer> createFatSeries(WeekSummary weekSummary) {
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(mondaySeries, (int) (CaloriesCalculator.getFatFromDay(weekSummary.getMondayProducts())*CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES)));
        series.getData().add(new XYChart.Data<>(tuesdaySeries, (int) (CaloriesCalculator.getFatFromDay(weekSummary.getTuesdayProducts())*CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES)));
        series.getData().add(new XYChart.Data<>(wednesdaySeries, (int) (CaloriesCalculator.getFatFromDay(weekSummary.getWednesdayProducts())*CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES)));
        series.getData().add(new XYChart.Data<>(thursdaySeries, (int) (CaloriesCalculator.getFatFromDay(weekSummary.getThursdayProducts())*CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES)));
        series.getData().add(new XYChart.Data<>(fridaySeries, (int) (CaloriesCalculator.getFatFromDay(weekSummary.getFridayProducts())*CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES)));
        series.getData().add(new XYChart.Data<>(saturdaySeries, (int) (CaloriesCalculator.getFatFromDay(weekSummary.getSaturdayProducts())*CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES)));
        series.getData().add(new XYChart.Data<>(sundaySeries, (int) (CaloriesCalculator.getFatFromDay(weekSummary.getSundayProducts())*CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES)));
        series.setName(fatSeriesName);
        return series;
    }

}