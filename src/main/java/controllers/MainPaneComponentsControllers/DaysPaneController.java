package controllers.MainPaneComponentsControllers;
import io.LanguageIO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Days;
import model.language.DaysPaneLanguage;
import model.language.Language;

public class DaysPaneController {
    @FXML
    private Button fridayButtonController;
    @FXML
    private Button mondayButtonController;
    @FXML
    private Button saturdayButtonController;
    @FXML
    private Button sundayButtonController;
    @FXML
    private Button thursdayButtonController;
    @FXML
    private Button tuesdayButtonController;
    @FXML
    private Button wednesdayButtonController;
    public void initialize() {
        setLanguage(new Language().getDaysPaneLanguage());
    }
    private void setLanguage(DaysPaneLanguage language) {
        mondayButtonController.setText(language.getMondayButtonController());
        tuesdayButtonController.setText(language.getTuesdayButtonController());
        wednesdayButtonController.setText(language.getWednesdayButtonController());
        thursdayButtonController.setText(language.getThursdayButtonController());
        fridayButtonController.setText(language.getFridayButtonController());
        saturdayButtonController.setText(language.getSaturdayButtonController());
        sundayButtonController.setText(language.getSundayButtonController());
    }
    public Button getFridayButtonController() {
        return fridayButtonController;
    }
    public Button getMondayButtonController() {
        return mondayButtonController;
    }
    public Button getSaturdayButtonController() {
        return saturdayButtonController;
    }
    public Button getSundayButtonController() {
        return sundayButtonController;
    }
    public Button getThursdayButtonController() {
        return thursdayButtonController;
    }
    public Button getTuesdayButtonController() {
        return tuesdayButtonController;
    }
    public Button getWednesdayButtonController() {
        return wednesdayButtonController;
    }
}