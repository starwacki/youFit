package controllers.SettingsPanesControllers;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.language.BodyMeasurementsLanguage;
import model.language.Language;

public class BodyMeasurementsPaneController {

    @FXML
    private Button addBodyMeasurementsButtonController;

    @FXML
    private Button addWeightLinearChartButtonController;

    @FXML
    private Label bicepsLabelController;

    @FXML
    private TableColumn<?, ?> bicepsTableColumnController;

    @FXML
    private TextField bicepsTextFieldController;

    @FXML
    private AnchorPane bodyMeasurementsAnchorPaneController;

    @FXML
    private Label bodyMeasurementsInfoLabelController;

    @FXML
    private TableView<?> bodyMeasurementsTableViewController;

    @FXML
    private Label chestLabelController;

    @FXML
    private TableColumn<?, ?> chestTableColumnController;

    @FXML
    private TextField chestTextFieldController;

    @FXML
    private TableColumn<?, ?> dateBodyMeasurementsTableViewTableColumnController;

    @FXML
    private TableColumn<?, ?> dateLinearChartTableViewTableColumnController;

    @FXML
    private TableColumn<?, ?> deleteBodyMeasurementsTableViewTableColumnController;

    @FXML
    private TableColumn<?, ?> deleteLinearChartTableViewTableColumnController;

    @FXML
    private Label hipLabelController;

    @FXML
    private TableColumn<?, ?> hipTableColumnController;

    @FXML
    private TextField hipTextFieldController;

    @FXML
    private LineChart<?, ?> lineChartController;

    @FXML
    private TableView<?> linearChartTableViewController;

    @FXML
    private Label thighLabelController;

    @FXML
    private TableColumn<?, ?> thighTableColumnController;

    @FXML
    private TextField thighTextFieldController;

    @FXML
    private Label tricepsLabelController;

    @FXML
    private TableColumn<?, ?> tricepsTableColumnController;

    @FXML
    private TextField tricepsTextFieldController;

    @FXML
    private Label waistLabelController;

    @FXML
    private TableColumn<?, ?> waistTableColumnController;

    @FXML
    private TextField waistTextFieldController;

    @FXML
    private Label weightControlInfoLabelController;

    @FXML
    private Label weightInfoLabelController;

    @FXML
    private Label weightMeasurementsInfoLabelController;

    @FXML
    private TableColumn<?, ?> weightTableColumnController;

    @FXML
    private TextField weightTextFieldController;
    @FXML
    private Label bodyMeasurementsTitleLabelController;

    public void initialize() {
    setLanguage(new Language().getBodyMeasurementsLanguage());
    }
    private void setLanguage(BodyMeasurementsLanguage language) {
        weightControlInfoLabelController.setText(language.getWeightControlInfoLabelController());
        weightMeasurementsInfoLabelController.setText(language.getWeightMeasurementsInfoLabelController());
        dateLinearChartTableViewTableColumnController.setText(language.getDateLinearChartTableViewTableColumnController());
        weightTableColumnController.setText(language.getWeightTableColumnController());
        weightInfoLabelController.setText(language.getWeightInfoLabelController());
        addWeightLinearChartButtonController.setText(language.getAddWeightLinearChartButtonController());
        bodyMeasurementsInfoLabelController.setText(language.getBodyMeasurementsInfoLabelController());
        dateBodyMeasurementsTableViewTableColumnController.setText(language.getDateBodyMeasurementsTableViewTableColumnController());
        hipTableColumnController.setText(language.getHipTableColumnController());
        chestTableColumnController.setText(language.getChestTableColumnController());
        thighTableColumnController.setText(language.getThighTableColumnController());
        bicepsTableColumnController.setText(language.getBicepsTableColumnController());
        tricepsTableColumnController.setText(language.getTricepsTableColumnController());
        waistTableColumnController.setText(language.getWaistTableColumnController());
        chestLabelController.setText(language.getChestLabelController());
        hipLabelController.setText(language.getHipLabelController());
        thighLabelController.setText(language.getThighLabelController());
        bicepsLabelController.setText(language.getBicepsLabelController());
        tricepsLabelController.setText(language.getTricepsLabelController());
        waistLabelController.setText(language.getWaistLabelController());
        addBodyMeasurementsButtonController.setText(language.getAddBodyMeasurementsButtonController());
        bodyMeasurementsTitleLabelController.setText(language.getBodyMeasurementsTitleLabelController());
    }

}