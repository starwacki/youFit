package controllers.SettingsPanesControllers;
import io.LanguageIO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.language.Language;
import model.language.LanguageCode;
import model.language.SettingsSettingsLanguage;
import model.language.TablesLabels;

import java.util.ArrayList;
import java.util.List;

public class SettingsSettingsPaneController {

    @FXML
    private Label meal4TimeLabelController;
    @FXML
    private Button changeMealNameButtonController;
    @FXML
    private Button changeMealTimeButtonController;
    @FXML
    private ImageView englishLanguageImageView;
    @FXML
    private ChoiceBox<Integer> meal1HoursChoiceBoxController;
    @FXML
    private ChoiceBox<Integer> meal1MinutesChoiceBoxController;
    @FXML
    private Label meal1NameLabelController;
    @FXML
    private TextField meal1NameTextFieldController;
    @FXML
    private Label meal1TimeLabelController;
    @FXML
    private ChoiceBox<Integer> meal2HoursChoiceBoxController;
    @FXML
    private ChoiceBox<Integer> meal2MinutesChoiceBoxController;
    @FXML
    private Label meal2NameLabelController;
    @FXML
    private TextField meal2NameTextFieldController;
    @FXML
    private Label meal2TimeLabelController;
    @FXML
    private ChoiceBox<Integer> meal3HoursChoiceBoxController;
    @FXML
    private ChoiceBox<Integer> meal3MinutesChoiceBoxController;
    @FXML
    private Label meal3NameLabelController;
    @FXML
    private TextField meal3NameTextFieldController;
    @FXML
    private Label meal3TimeLabelController;
    @FXML
    private ChoiceBox<Integer> meal4HoursChoiceBoxController;
    @FXML
    private ChoiceBox<Integer> meal4MinutesChoiceBoxController;
    @FXML
    private Label meal4NameLabelController;
    @FXML
    private TextField meal4NameTextFieldController;
    @FXML
    private ImageView polandLanguageImageView;
    @FXML
    private Label selectLanguageLabelController;
    @FXML
    private AnchorPane settingsSettingsAnchorPaneController;
    @FXML
    private Label settingsTitleLabelController;

    public void initialize() {
        setLanguage(new Language().getSettingsSettingsLanguage());
        setActuallyLanguageOpacity();
        initializeChoiceBox();
        setUserLabels();
        blockAllNameLabels();
    }
    public void setLanguage(SettingsSettingsLanguage language) {
        meal1NameLabelController.setText(language.getMeal1NameLabelController());
        meal2NameLabelController.setText(language.getMeal2NameLabelController());
        meal3NameLabelController.setText(language.getMeal3NameLabelController());
        meal4NameLabelController.setText(language.getMeal4NameLabelController());
        meal1TimeLabelController.setText(language.getMeal1TimeLabelController());
        meal2TimeLabelController.setText(language.getMeal2TimeLabelController());
        meal3TimeLabelController.setText(language.getMeal3TimeLabelController());
        meal4TimeLabelController.setText(language.getMeal4TimeLabelController());
        changeMealNameButtonController.setText(language.getChangeMealNameButtonController());
        changeMealTimeButtonController.setText(language.getChangeMealTimeButtonController());
        selectLanguageLabelController.setText(language.getSelectLanguageLabelController());
        settingsTitleLabelController.setText(language.getSettingsTitleLabelController());
    }


    public ImageView getEnglishLanguageImageView() {
        return englishLanguageImageView;
    }

    public ImageView getPolandLanguageImageView() {
        return polandLanguageImageView;
    }
    private void setActuallyLanguageOpacity() {
        if (Language.language==LanguageCode.PL) polandLanguageImageView.setOpacity(0.5);
        else englishLanguageImageView.setOpacity(0.5);
    }
    private void initializeChoiceBox() {
        addHoursToChoiceToChoiceBox();
        addMinutesToChoiceToChoiceBox();
    }
    private void addHoursToChoiceToChoiceBox() {
        meal1HoursChoiceBoxController.getItems().addAll(generateDailyHours());
        meal2HoursChoiceBoxController.getItems().addAll(generateDailyHours());
        meal3HoursChoiceBoxController.getItems().addAll(generateDailyHours());
        meal4HoursChoiceBoxController.getItems().addAll(generateDailyHours());
    }
    private void addMinutesToChoiceToChoiceBox () {
        meal1MinutesChoiceBoxController.getItems().addAll(generateHourMinutes());
        meal2MinutesChoiceBoxController.getItems().addAll(generateHourMinutes());
        meal3MinutesChoiceBoxController.getItems().addAll(generateHourMinutes());
        meal4MinutesChoiceBoxController.getItems().addAll(generateHourMinutes());
    }
    private List<Integer> generateDailyHours() {
        List<Integer> hours = new ArrayList<>();
        for (int i = 0; i <24 ; i++) {
            hours.add(i);
        }
        return hours;
    }
    private List<Integer> generateHourMinutes() {
        List<Integer> minutes = new ArrayList<>();
        for (int i = 0; i <60 ; i++) {
            minutes.add(i);
        }
        return minutes;
    }
    private void setUserLabels() {
        setMealsName();
        setMealsTime();
    }


    private void setMealsName() {
      changeMealNameButtonController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
         if (isTextFieldEmpty(meal1NameTextFieldController)) TablesLabels.basicBreakfastName = meal1NameTextFieldController.getText();
         if (isTextFieldEmpty(meal2NameTextFieldController)) TablesLabels.basicBrunchName= meal2NameTextFieldController.getText();
         if (isTextFieldEmpty(meal3NameTextFieldController)) TablesLabels.basicLunchName = meal3NameTextFieldController.getText();
         if (isTextFieldEmpty(meal4NameTextFieldController)) TablesLabels.basicSupperName = meal4NameTextFieldController.getText();
          });
    }
    private void setMealsTime() {
        changeMealTimeButtonController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            if (!isChoiceBoxEmpty(meal1HoursChoiceBoxController,meal1MinutesChoiceBoxController))
                TablesLabels.basicBreakfastTime = getLabelTime(meal1HoursChoiceBoxController,meal1MinutesChoiceBoxController);
            if (!isChoiceBoxEmpty(meal2HoursChoiceBoxController,meal2MinutesChoiceBoxController))
                TablesLabels.basicBrunchTime = getLabelTime(meal2HoursChoiceBoxController,meal2MinutesChoiceBoxController);
            if (!isChoiceBoxEmpty(meal3HoursChoiceBoxController,meal3MinutesChoiceBoxController))
                TablesLabels.basicLunchTime = getLabelTime(meal3HoursChoiceBoxController,meal3MinutesChoiceBoxController);
            if (!isChoiceBoxEmpty(meal4HoursChoiceBoxController,meal4MinutesChoiceBoxController))
                TablesLabels.basicSupperTime = getLabelTime(meal4HoursChoiceBoxController,meal4MinutesChoiceBoxController);
       });
    }
    private boolean isTextFieldEmpty(TextField textField) {
       return textField.getText()==null || !textField.getText().equals("");
    }
    private boolean isChoiceBoxEmpty(ChoiceBox hoursChoiceBox,ChoiceBox minutesChoiceBox) {
        return hoursChoiceBox.getSelectionModel().getSelectedItem() == null ||
                minutesChoiceBox.getSelectionModel().getSelectedItem() ==null;
    }
    private String getLabelTime(ChoiceBox hoursChoiceBox,ChoiceBox minutesChoiceBox) {
        if ((int) minutesChoiceBox.getSelectionModel().getSelectedItem()<10) {
            return hoursChoiceBox.getSelectionModel().getSelectedItem() + ":" + "0" +
                    minutesChoiceBox.getSelectionModel().getSelectedItem();
        } else
            return hoursChoiceBox.getSelectionModel().getSelectedItem() + ":" +
                    minutesChoiceBox.getSelectionModel().getSelectedItem();
    }
    private void blockAllNameLabels() {
        blockTooLongMealName(meal1NameTextFieldController);
        blockTooLongMealName(meal2NameTextFieldController);
        blockTooLongMealName(meal3NameTextFieldController);
        blockTooLongMealName(meal4NameTextFieldController);
    }
    private void blockTooLongMealName(TextField textField) {
        textField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.length()>12) textField.setText(oldValue);
        });
    }
}

