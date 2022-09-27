package controllers.MainPaneComponentsControllers;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import java.util.List;
public class CaloriesPaneController {
    @FXML
    private ProgressBar caloriesProgressBarController;
    @FXML
    private ProgressBar carbohydratesProgressBarController;
    @FXML
    private Label eatenCaloriesLabelController;
    @FXML
    private Label eatenCarbohydratesLabelController;
    @FXML
    private Label eatenFatLabelController;
    @FXML
    private Label eatenProteinsLabelController;
    @FXML
    private ProgressBar fatProgressBar;
    @FXML
    private Label neededCaloriesLabelController;
    @FXML
    private Label neededCarbohydratesLabelController;
    @FXML
    private Label neededFatLabelController;
    @FXML
    private Label neededProteinsLabelController;
    @FXML
    private ProgressBar proteinsProgressBarController;
    @FXML
    private Label proteinsStringLabelController;
    @FXML
    private Label proteinsSlashLabelController;
    @FXML
    private Label carbohydratesStringLabelController;
    @FXML
    private Label carbohydratesSlashLabelController;
    @FXML
    private Label fatStringLabelController;
    @FXML
    private Label fatSlashLabelController;
    @FXML
    private Label caloriesStringLabelController;
    @FXML
    private Label caloriesSlashLabelController;
    public Label getEatenCaloriesLabelController() {
        return eatenCaloriesLabelController;
    }
    public Label getEatenCarbohydratesLabelController() {
        return eatenCarbohydratesLabelController;
    }
    public Label getEatenFatLabelController() {
        return eatenFatLabelController;
    }
    public Label getEatenProteinsLabelController() {
        return eatenProteinsLabelController;
    }
    public Label getNeededCaloriesLabelController() {
        return neededCaloriesLabelController;
    }
    public Label getNeededCarbohydratesLabelController() {
        return neededCarbohydratesLabelController;
    }
    public Label getNeededFatLabelController() {
        return neededFatLabelController;
    }
    public Label getNeededProteinsLabelController() {
        return neededProteinsLabelController;
    }
    public ProgressBar getCaloriesProgressBarController() {
        return caloriesProgressBarController;
    }
    public ProgressBar getCarbohydratesProgressBarController() {
        return carbohydratesProgressBarController;
    }
    public ProgressBar getFatProgressBarController() {
        return fatProgressBar;
    }
    public ProgressBar getProteinsProgressBarController() {
        return proteinsProgressBarController;
    }
    public List<Label> getAllProteinsLabels () {
        return List.of(proteinsStringLabelController,eatenProteinsLabelController,
                       proteinsSlashLabelController,neededProteinsLabelController);
    }
    public List<Label> getAllCarbohydratesLabels () {
        return List.of(carbohydratesStringLabelController,eatenCarbohydratesLabelController,
                       carbohydratesSlashLabelController,neededCarbohydratesLabelController);
    }
    public List<Label> getAllFatLabels () {
        return List.of(fatStringLabelController,eatenFatLabelController,
                       fatSlashLabelController,neededFatLabelController);
    }
    public List<Label> getAllCaloriesLabels () {
        return List.of(caloriesStringLabelController,eatenCaloriesLabelController,
                       caloriesSlashLabelController,neededCaloriesLabelController);
    }
}
