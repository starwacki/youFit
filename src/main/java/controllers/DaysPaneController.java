package controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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