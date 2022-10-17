package controllers.MainPaneComponentsControllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
    @FXML
    private Label mondayLabelController;
    @FXML
    private Label tuesdayLabelController;
    @FXML
    private Label wednesdayLabelController;
    @FXML
    private Label thursdayLabelController;
    @FXML
    private Label fridayLabelController;
    @FXML
    private Label saturdayLabelController;
    @FXML
    private Label sundayLabelController;
    @FXML
    private ImageView nextWeekImageViewController;
    @FXML
    private ImageView previousWeekImageViewController;
    @FXML
    private DatePicker daysPaneDatePickerController;

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

    public ImageView getNextWeekImageViewController() {
        return nextWeekImageViewController;
    }

    public ImageView getPreviousWeekImageViewController() {
        return previousWeekImageViewController;
    }

    public DatePicker getDaysPaneDatePickerController() {
        return daysPaneDatePickerController;
    }

    public Label getMondayLabelController() {
        return mondayLabelController;
    }

    public Label getTuesdayLabelController() {
        return tuesdayLabelController;
    }

    public Label getWednesdayLabelController() {
        return wednesdayLabelController;
    }

    public Label getThursdayLabelController() {
        return thursdayLabelController;
    }

    public Label getFridayLabelController() {
        return fridayLabelController;
    }

    public Label getSaturdayLabelController() {
        return saturdayLabelController;
    }

    public Label getSundayLabelController() {
        return sundayLabelController;
    }

}



