package controllers.SettingsPanesControllers;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

public class WeekSummaryPaneController {
    @FXML
    private ProgressBar caloriesWeekSummaryProgressBarController;
    @FXML
    private ProgressBar carbohydratesWeekSummaryProgressBarController;
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
    private AnchorPane weekSummaryAnchorPaneController;
}
