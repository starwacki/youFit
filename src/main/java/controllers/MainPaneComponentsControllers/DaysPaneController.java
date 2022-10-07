package controllers.MainPaneComponentsControllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.DateController;
import model.language.DaysPaneLanguage;
import model.language.Language;

import java.time.LocalDate;

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
    private DateController dateController;
    public void initialize() {
        dateController = new DateController();
        setLanguage(new Language().getDaysPaneLanguage());
        setDates(dateController);
        changeWeek();
        setDateByDatePicker9();
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
    private void setDates(DateController timeController){
       setDateLabel(mondayLabelController,timeController.getMondayDate());
       setDateLabel(tuesdayLabelController,timeController.getTuesdayDate());
       setDateLabel(wednesdayLabelController,timeController.getWednesdayDate());
       setDateLabel(thursdayLabelController,timeController.getThursdayDate());
       setDateLabel(fridayLabelController,timeController.getFridayDate());
       setDateLabel(saturdayLabelController,timeController.getSaturdayDate());
       setDateLabel(sundayLabelController,timeController.getSundayDate());
    }
    private void setDateLabel(Label label,LocalDate localDate) {
       label.setText(getDateString(localDate));
    }
    private String getDateString(LocalDate localDate) {
        return localDate.getDayOfMonth() + "." + localDate.getMonthValue();
    }
    private void changeWeek() {
        this.dateController = new DateController(DateController.getActualClickedDate());
        previousWeek();
        nextWeek();
    }
    private void nextWeek() {
        nextWeekImageViewController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
                    dateController.setMondayDate(dateController.getMondayDate().plusDays(7L));
                    dateController.setTuesdayDate(dateController.getTuesdayDate().plusDays(7L));
                    dateController.setWednesdayDate(dateController.getWednesdayDate().plusDays(7L));
                    dateController.setThursdayDate(dateController.getThursdayDate().plusDays(7L));
                    dateController.setFridayDate(dateController.getFridayDate().plusDays(7L));
                    dateController.setSaturdayDate(dateController.getSaturdayDate().plusDays(7L));
                    dateController.setSundayDate(dateController.getSundayDate().plusDays(7L));
                    setDates(dateController);

                }
                );
    }
    private void previousWeek() {
           previousWeekImageViewController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
                        dateController.setMondayDate(dateController.getMondayDate().minusDays(7L));
                        dateController.setTuesdayDate(dateController.getTuesdayDate().minusDays(7L));
                        dateController.setWednesdayDate(dateController.getWednesdayDate().minusDays(7L));
                        dateController.setThursdayDate(dateController.getThursdayDate().minusDays(7L));
                        dateController.setFridayDate(dateController.getFridayDate().minusDays(7L));
                        dateController.setSaturdayDate(dateController.getSaturdayDate().minusDays(7L));
                        dateController.setSundayDate(dateController.getSundayDate().minusDays(7L));
                        setDates(dateController);
                    }
            );
        }
        private void setDateByDatePicker9() {
        daysPaneDatePickerController.valueProperty().addListener((observableValue, localDate, t1) -> {
            DateController.setLastClickedDay(t1.getDayOfWeek());
            DateController.setActualClickedDate(t1);
            this.dateController = new DateController(t1);
            setDates(dateController);
        });
        }
    }



