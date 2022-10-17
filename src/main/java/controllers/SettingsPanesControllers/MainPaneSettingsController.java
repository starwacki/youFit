package controllers.SettingsPanesControllers;

import controllers.MainPaneComponentsControllers.CaloriesPaneController;
import controllers.MainPaneComponentsControllers.DaysPaneController;
import controllers.MainPaneComponentsControllers.SettingsPaneController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import model.language.Language;
import model.language.LanguageCode;
import model.language.TablesLabels;


public class MainPaneSettingsController {
    private static final double ACTUAL_CLICKED_COUNTRY_OPACITY = 0.5;
    private static final int NOT_CLICKED_COUNTRY_OPACITY = 1;
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
        if (settingsSettingsPaneController!=null) settingsSettingsPaneController.getPolandLanguageImageView().addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> setPL());
        if (settingsSettingsPaneController!=null) settingsSettingsPaneController.getEnglishLanguageImageView().addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> setEN());
    }
    private void setPL() {
        Language.language = LanguageCode.PL;
        resetUserLabels();
        settingsSettingsPaneController.getPolandLanguageImageView().setOpacity(ACTUAL_CLICKED_COUNTRY_OPACITY);
        settingsSettingsPaneController.getEnglishLanguageImageView().setOpacity(NOT_CLICKED_COUNTRY_OPACITY);
        settingsSettingsPaneController.setLanguage(new Language().getSettingsSettingsLanguage());
        settingsPaneController.setLanguage(new Language().getSettingsLanguage());
    }
    private void setEN() {
        Language.language = LanguageCode.EN;
        resetUserLabels();
        settingsSettingsPaneController.getEnglishLanguageImageView().setOpacity(ACTUAL_CLICKED_COUNTRY_OPACITY);
        settingsSettingsPaneController.getPolandLanguageImageView().setOpacity(NOT_CLICKED_COUNTRY_OPACITY);
        settingsSettingsPaneController.setLanguage(new Language().getSettingsSettingsLanguage());
        settingsPaneController.setLanguage(new Language().getSettingsLanguage());
    }
    private void resetUserLabels() {
        TablesLabels.basicBreakfastName = null;
        TablesLabels.basicBrunchName= null;
        TablesLabels.basicLunchName = null;
        TablesLabels.basicSupperName = null;
        TablesLabels.basicBreakfastTime = null;
        TablesLabels.basicBrunchTime = null;
        TablesLabels.basicLunchTime = null;
        TablesLabels.basicSupperTime = null;
    }

    }





