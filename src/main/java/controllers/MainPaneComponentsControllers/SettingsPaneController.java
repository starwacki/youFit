package controllers.MainPaneComponentsControllers;

import controllers.SceneSwitcherController;
import io.LanguageIO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.language.Language;
import model.language.ProfileLanguage;
import model.language.SettingsLanguage;

public class SettingsPaneController {

    @FXML
    private Label bodyMeasurementsLabelController;

    @FXML
    private Label changeCaloriesDemandLabelController;

    @FXML
    private Label mealsLabelController;

    @FXML
    private Label profileLabelController;

    @FXML
    private Label settingsLabelController;

    @FXML
    private AnchorPane settingsPaneController;

    @FXML
    private Label weekSummaryLabelController;
    public void initialize() {
        setLanguage(new Language().getSettingsLanguage());
        setMainPaneByClickedSetting();

    }

    public void setLanguage(SettingsLanguage language) {
        profileLabelController.setText(language.getProfileLabelController());
        mealsLabelController.setText(language.getMealsLabelController());
        weekSummaryLabelController.setText(language.getWeekSummaryLabelController());
        bodyMeasurementsLabelController.setText(language.getBodyMeasurementsLabelController());
        changeCaloriesDemandLabelController.setText(language.getChangeCaloriesDemandLabelController());
        settingsLabelController.setText(language.getSettingsLabelController());
    }
    private void setMainPaneByClickedSetting() {
        SceneSwitcherController sceneSwitcherController = new SceneSwitcherController();
        profileLabelController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> sceneSwitcherController.switchToProfileMainPain(thisStage()));
        mealsLabelController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> sceneSwitcherController.switchToMainPane(thisStage()));
        bodyMeasurementsLabelController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> sceneSwitcherController.switchToBodyMeasurementsMainPane(thisStage()));
        changeCaloriesDemandLabelController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> sceneSwitcherController.switchToCaloricDemandMainPane(thisStage()));
        weekSummaryLabelController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> sceneSwitcherController.switchToWeekSummaryMainPane(thisStage()));
        settingsLabelController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> sceneSwitcherController.switchToSettingsMainPain(thisStage()));

    }
    private Stage thisStage() {
        return  (Stage) changeCaloriesDemandLabelController.getScene().getWindow();
    }
}
