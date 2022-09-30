package controllers.SettingsPanesControllers;

import controllers.MainPaneComponentsControllers.CaloriesPaneController;
import controllers.MainPaneComponentsControllers.DaysPaneController;
import controllers.MainPaneComponentsControllers.SettingsPaneController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import model.language.Language;
import model.language.LanguageCode;


public class MainPaneSettingsController {
    @FXML
    private CaloriesPaneController caloriesPaneController;
    @FXML
    private DaysPaneController daysPaneController;
    @FXML
    private SettingsPaneController settingsPaneController;
    @FXML
    private BodyMeasurementsPaneController bodyMeasurementsPaneController;
    @FXML
    private CaloricDemandPaneController caloricDemandPaneController;
    @FXML
    private SettingsSettingsPaneController settingsSettingsPaneController;
    @FXML
    private WeekSummaryPaneController weekSummaryPaneController;
    @FXML
    private ProfilePaneController profilePaneController;

    public void initialize() {
        changeLanguage();
    }
    private void changeLanguage() {
        settingsSettingsPaneController.getPolandLanguageImageView().addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> setPL());
        settingsSettingsPaneController.getEnglishLanguageImageView().addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> setEN());
    }
    private void setPL() {
        Language.language = LanguageCode.PL;
        settingsSettingsPaneController.getPolandLanguageImageView().setOpacity(0.5);
        settingsSettingsPaneController.getEnglishLanguageImageView().setOpacity(1);
        settingsSettingsPaneController.setLanguage(new Language().getSettingsSettingsLanguage());
        settingsPaneController.setLanguage(new Language().getSettingsLanguage());
    }
    private void setEN() {
        Language.language = LanguageCode.EN;
        settingsSettingsPaneController.getEnglishLanguageImageView().setOpacity(0.5);
        settingsSettingsPaneController.getPolandLanguageImageView().setOpacity(1);
        settingsSettingsPaneController.setLanguage(new Language().getSettingsSettingsLanguage());
        settingsPaneController.setLanguage(new Language().getSettingsLanguage());
    }

    }





