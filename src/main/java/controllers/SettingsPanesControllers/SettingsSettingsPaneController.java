package controllers.SettingsPanesControllers;

import io.LanguageIO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.language.Language;
import model.language.LanguageCode;
import model.language.SettingsSettingsLanguage;

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
    private ChoiceBox<?> meal1HoursChoiceBoxController;
    @FXML
    private ChoiceBox<?> meal1MinutesChoiceBoxController;
    @FXML
    private Label meal1NameLabelController;
    @FXML
    private TextField meal1NameTextFieldController;
    @FXML
    private Label meal1TimeLabelController;
    @FXML
    private ChoiceBox<?> meal2HoursChoiceBoxController;
    @FXML
    private ChoiceBox<?> meal2MinutesChoiceBoxController;
    @FXML
    private Label meal2NameLabelController;
    @FXML
    private TextField meal2NameTextFieldController;
    @FXML
    private Label meal2TimeLabelController;
    @FXML
    private ChoiceBox<?> meal3HoursChoiceBoxController;
    @FXML
    private ChoiceBox<?> meal3MinutesChoiceBoxController;
    @FXML
    private Label meal3NameLabelController;
    @FXML
    private TextField meal3NameTextFieldController;
    @FXML
    private Label meal3TimeLabelController;
    @FXML
    private ChoiceBox<?> meal4HoursChoiceBoxController;
    @FXML
    private ChoiceBox<?> meal4MinutesChoiceBoxController;
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
}

