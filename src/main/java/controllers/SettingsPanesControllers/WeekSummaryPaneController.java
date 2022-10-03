package controllers.SettingsPanesControllers;

import io.LanguageIO;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import model.language.Language;
import model.language.WeekSummaryLanguage;

public class WeekSummaryPaneController {

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
    private BarChart<?, ?> weekSummaryBarChartController;

    @FXML
    private Label weekSummaryTitleLabelController;

    public void initialize() {
        setLanguage(new Language().getWeekSummaryLanguage());

    }
    private void setLanguage(WeekSummaryLanguage language) {
        weekProteinsLabelController.setText(language.getWeekProteinsLabelController());
        weekCarbohydratesLabelController.setText(language.getWeekCarbohydratesLabelController());
        weekFatLabelController.setText(language.getWeekFatLabelController());
        weekCaloriesLabelController.setText(language.getWeekCaloriesLabelController());
        daysWithoutExceededCaloriesInfoLabelController.setText(language.getDaysWithoutExceededCaloriesInfoLabelController());
        weekSummaryTitleLabelController.setText(language.getWeekSummaryTitleLabelController());
    }

}