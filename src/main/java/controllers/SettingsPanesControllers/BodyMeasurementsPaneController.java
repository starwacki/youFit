package controllers.SettingsPanesControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import model.bodyMeasurements.BodyMeasurement;
import model.bodyMeasurements.BodyMeasurements;
import model.bodyMeasurements.LinearChartMeasurement;
import model.language.BodyMeasurementsLanguage;
import model.language.Language;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class BodyMeasurementsPaneController {
    private static final String EMPTY_FIELD = "";
    private static final String DELETE_BUTTON_JPG_FILE_PATH = "/img/deleteButton.png";
    private static final String DELETE_BUTTON_CSS_STYLE_SHEET_ID = "delete-button";
    private static final int WEIGHT_CONTROL_SERIES_ID = 0;
    @FXML
    private Button addBodyMeasurementsButtonController;

    @FXML
    private Button addWeightLinearChartButtonController;

    @FXML
    private Label bicepsLabelController;

    @FXML
    private TableColumn<BodyMeasurement, String> bicepsTableColumnController;

    @FXML
    private TextField bicepsTextFieldController;

    @FXML
    private AnchorPane bodyMeasurementsAnchorPaneController;

    @FXML
    private Label bodyMeasurementsInfoLabelController;

    @FXML
    private TableView<BodyMeasurement> bodyMeasurementsTableViewController;

    @FXML
    private Label chestLabelController;

    @FXML
    private TableColumn<BodyMeasurement, String> chestTableColumnController;

    @FXML
    private TextField chestTextFieldController;

    @FXML
    private TableColumn<BodyMeasurement, LocalDate> dateBodyMeasurementsTableViewTableColumnController;

    @FXML
    private TableColumn<BodyMeasurement, LocalDate>  dateLinearChartTableViewTableColumnController;

    @FXML
    private Label hipLabelController;

    @FXML
    private TableColumn<BodyMeasurement, String> hipTableColumnController;

    @FXML
    private TextField hipTextFieldController;

    @FXML
    private LineChart<String, Integer> lineChartController;

    @FXML
    private TableView<LinearChartMeasurement> linearChartTableViewController;

    @FXML
    private Label thighLabelController;

    @FXML
    private TableColumn<BodyMeasurement, String> thighTableColumnController;

    @FXML
    private TextField thighTextFieldController;

    @FXML
    private Label tricepsLabelController;

    @FXML
    private TableColumn<BodyMeasurement, String> tricepsTableColumnController;

    @FXML
    private TextField tricepsTextFieldController;

    @FXML
    private Label waistLabelController;

    @FXML
    private TableColumn<BodyMeasurement, String> waistTableColumnController;

    @FXML
    private TextField waistTextFieldController;

    @FXML
    private Label weightControlInfoLabelController;

    @FXML
    private Label weightInfoLabelController;

    @FXML
    private Label weightMeasurementsInfoLabelController;

    @FXML
    private TableColumn<LinearChartMeasurement, String> weightTableColumnController;

    @FXML
    private TextField weightTextFieldController;

    @FXML
    private Label bodyMeasurementsTitleLabelController;

    @FXML
    private DatePicker linearChartDatePickerController;

    @FXML
    private DatePicker bodyMeasurementsDatePickerController;

    public void initialize() {
    setLanguage(new Language().getBodyMeasurementsLanguage());
    setColumnsSettings();
    initializeLinearChartTableView();
    initializeBodyMeasurementsTableView();
    initializeLinearChart();
    blockIncorrectTextFieldsValues();
    addRecordToLinearChartTableView();
    addRecordToBodyMeasurementsTableView();
    initializeTablesDeleteButtons();

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
    private void setColumnsSettings() {
        setCellValueFactory();
        setReorderable();
    }
    private void setReorderable() {
        setReorderableLinearChartTableView();
        setReorderableBodyMeasurementsTableView();
    }
    private void setCellValueFactory() {
        setCellValueFactoryLinearChartTableView();
        setCellValueFactoryBodyMeasurementsTableView();
    }
    private void setReorderableLinearChartTableView() {
        dateLinearChartTableViewTableColumnController.setReorderable(false);
        weightTableColumnController.setReorderable(false);
    }
    private void setReorderableBodyMeasurementsTableView() {
        dateBodyMeasurementsTableViewTableColumnController.setReorderable(false);
        hipTableColumnController.setReorderable(false);
        chestTableColumnController.setReorderable(false);
        thighTableColumnController.setReorderable(false);
        bicepsTableColumnController.setReorderable(false);
        tricepsTableColumnController.setReorderable(false);
        waistTableColumnController.setReorderable(false);
    }
    private void setCellValueFactoryLinearChartTableView() {
        dateLinearChartTableViewTableColumnController.setCellValueFactory(new PropertyValueFactory<>("date"));
        weightTableColumnController.setCellValueFactory(new PropertyValueFactory<>("weight"));
    }

    private void setCellValueFactoryBodyMeasurementsTableView() {
        dateBodyMeasurementsTableViewTableColumnController.setCellValueFactory(new PropertyValueFactory<>("date"));
        hipTableColumnController.setCellValueFactory(new PropertyValueFactory<>("hip"));
        chestTableColumnController.setCellValueFactory(new PropertyValueFactory<>("chest"));
        thighTableColumnController.setCellValueFactory(new PropertyValueFactory<>("thigh"));
        bicepsTableColumnController.setCellValueFactory(new PropertyValueFactory<>("biceps"));
        tricepsTableColumnController.setCellValueFactory(new PropertyValueFactory<>("triceps"));
        waistTableColumnController.setCellValueFactory(new PropertyValueFactory<>("waist"));
    }
    private void blockIncorrectTextFieldsValues() {
        blockNumberTextFieldsIncorrectValues();
        blockDatePickerIncorrectValues();
    }
    private void blockNumberTextFieldsIncorrectValues() {
        setTextFieldOnlyNumeric(weightTextFieldController);
        setTextFieldOnlyNumeric(hipTextFieldController);
        setTextFieldOnlyNumeric(chestTextFieldController);
        setTextFieldOnlyNumeric(thighTextFieldController);
        setTextFieldOnlyNumeric(bicepsTextFieldController);
        setTextFieldOnlyNumeric(tricepsTextFieldController);
        setTextFieldOnlyNumeric(waistTextFieldController);
    }
    private void blockDatePickerIncorrectValues() {
        linearChartDatePickerController.setEditable(false);
        bodyMeasurementsDatePickerController.setEditable(false);
    }
    private void setTextFieldOnlyNumeric(TextField textField) {
        textField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(oldValue);
            }
            if (newValue.equals("0")) textField.setText(oldValue);

        });
    }
    private void addRecordToLinearChartTableView() {
        addWeightLinearChartButtonController.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (!areAddRecordToLinearChartTableViewTextFieldsEmpty()) {
                safeLinearChartTableViewRecord();
                initializeLinearChart();
            }
                });
    }
    private void safeLinearChartTableViewRecord() {
        LinearChartMeasurement linearChartMeasurement = createLinearChartMeasurement();
        addRecordToSafeLinearChartTableView(linearChartMeasurement);
        addRecordToObservableLinearChartTableView(linearChartMeasurement);
    }
    private void addRecordToObservableLinearChartTableView(LinearChartMeasurement linearChartMeasurement) {
        linearChartTableViewController.getItems().add(linearChartMeasurement);
        Collections.sort(linearChartTableViewController.getItems());
    }
    private void addRecordToSafeLinearChartTableView(LinearChartMeasurement linearChartMeasurement) {
        BodyMeasurements.linearChartMeasurementsToSafe.add(linearChartMeasurement);
        Collections.sort(BodyMeasurements.linearChartMeasurementsToSafe);
    }
    private boolean isTextFieldEmpty(TextField textField) {
        if(textField == null) return true;
        else return textField.getText().equals(EMPTY_FIELD);
    }
    private boolean areAddRecordToLinearChartTableViewTextFieldsEmpty() {
        return isTextFieldEmpty(weightTextFieldController) || isTextFieldEmpty(linearChartDatePickerController.getEditor());
    }
    private LinearChartMeasurement createLinearChartMeasurement() {
        return new LinearChartMeasurement(( linearChartDatePickerController.getValue()),weightTextFieldController.getText());
    }
    private void initializeLinearChartTableView() {
        linearChartTableViewController.getItems().addAll(BodyMeasurements.linearChartMeasurementsToSafe);
    }
    private void addRecordToBodyMeasurementsTableView() {
        addBodyMeasurementsButtonController.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (!areAddRecordToBodyMeasurementsTableViewTextFieldsEmpty()) safeBodyMeasurementsTableViewRecord();
        });
    }
    private void safeBodyMeasurementsTableViewRecord() {
        BodyMeasurement bodyMeasurement = createBodyMeasurement();
        addRecordToSafeBodyMeasurementsTableView(bodyMeasurement);
        addRecordToObservableBodyMeasurementsTableView(bodyMeasurement);
    }
    private void addRecordToObservableBodyMeasurementsTableView(BodyMeasurement bodyMeasurement) {
        bodyMeasurementsTableViewController.getItems().add(bodyMeasurement);
        Collections.sort(bodyMeasurementsTableViewController.getItems());
    }
    private void addRecordToSafeBodyMeasurementsTableView(BodyMeasurement bodyMeasurement) {
        BodyMeasurements.bodyMeasurementsToSafe.add(bodyMeasurement);
        Collections.sort(BodyMeasurements.bodyMeasurementsToSafe);
    }

    private boolean areAddRecordToBodyMeasurementsTableViewTextFieldsEmpty() {
        return  isTextFieldEmpty(hipTextFieldController) || isTextFieldEmpty(chestTextFieldController)
                || isTextFieldEmpty(thighTextFieldController) || isTextFieldEmpty(bicepsTextFieldController)
                || isTextFieldEmpty(tricepsTextFieldController) || isTextFieldEmpty(waistTextFieldController) ||
                isTextFieldEmpty(bodyMeasurementsDatePickerController.getEditor());
    }
    private BodyMeasurement createBodyMeasurement() {
        return new BodyMeasurement(bodyMeasurementsDatePickerController.getValue(),
                                   hipTextFieldController.getText(),
                                   chestTextFieldController.getText(),
                                   thighTextFieldController.getText(),
                                   bicepsTextFieldController.getText(),
                                   tricepsTextFieldController.getText(),
                                   waistTextFieldController.getText()
        );
    }
    private void initializeBodyMeasurementsTableView() {
        bodyMeasurementsTableViewController.getItems().addAll(BodyMeasurements.bodyMeasurementsToSafe);
    }
    private void initializeTablesDeleteButtons() {
        addDeleteButtonToBodyMeasurementsTableView(bodyMeasurementsTableViewController);
        addDeleteButtonToLinearTableView(linearChartTableViewController);
    }

    private void addDeleteButtonToLinearTableView(TableView<LinearChartMeasurement> tableView) {
        TableColumn<LinearChartMeasurement, Void> colBtn = new TableColumn("X");
        Callback<TableColumn<LinearChartMeasurement, Void>, TableCell<LinearChartMeasurement, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<LinearChartMeasurement, Void> call(final TableColumn<LinearChartMeasurement, Void> column) {
                final TableCell<LinearChartMeasurement, Void> cell = new TableCell<>() {
                    private final Button btn = new Button();

                    {
                        setDeleteButton(btn);
                        btn.setOnAction((ActionEvent event) -> {
                            deleteRecordFromTableView(linearChartTableViewController,
                                    BodyMeasurements.linearChartMeasurementsToSafe,
                                    getIndex());
                            lineChartController.getData().get(WEIGHT_CONTROL_SERIES_ID).getData().remove(getIndex());
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);
        setAddedTableColumnSetting(colBtn);
        tableView.getColumns().add(colBtn);

    }
    private void addDeleteButtonToBodyMeasurementsTableView(TableView<BodyMeasurement> tableView) {
        TableColumn<BodyMeasurement, Void> colBtn = new TableColumn("X");
        Callback<TableColumn<BodyMeasurement, Void>, TableCell<BodyMeasurement, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<BodyMeasurement, Void> call(final TableColumn<BodyMeasurement, Void> column) {
                final TableCell<BodyMeasurement, Void> cell = new TableCell<>() {
                    private final Button btn = new Button();

                    {
                        setDeleteButton(btn);
                        btn.setOnAction((ActionEvent event) -> {
                         deleteRecordFromTableView(bodyMeasurementsTableViewController,
                                                   BodyMeasurements.bodyMeasurementsToSafe,
                                                   getIndex());

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);
        setAddedTableColumnSetting(colBtn);
        tableView.getColumns().add(colBtn);
    }
    private void setAddedTableColumnSetting(TableColumn tableColumn) {
        tableColumn.setMinWidth(30);
        tableColumn.setPrefWidth(30);
        tableColumn.setMaxWidth(30);
        tableColumn.setReorderable(false);
        tableColumn.setEditable(false);
    }
    private void setDeleteButton(Button btn) {
        btn.setMinSize(15,15);
        btn.setPrefSize(15,15);
        btn.setMaxSize(15,15);
        btn.setId(DELETE_BUTTON_CSS_STYLE_SHEET_ID);
        ImageView delete = new ImageView(getClass().getResource(DELETE_BUTTON_JPG_FILE_PATH).toExternalForm());
        delete.setPreserveRatio(true);
        btn.setGraphic(delete);
        btn.setContentDisplay(ContentDisplay.CENTER);
    }
    private void deleteRecordFromTableView(TableView tableView, List list, int index) {
        tableView.getItems().remove(index);
        list.remove(index);
    }
    private void initializeLinearChart() {
        lineChartController.getData().clear();
        lineChartController.getData().add(createLinearChartSeries());

    }
    private XYChart.Series<String,Integer> createLinearChartSeries() {
        XYChart.Series<String,Integer> series = new XYChart.Series<>();
        for (int i = 0; i < BodyMeasurements.linearChartMeasurementsToSafe.size(); i++) {
            series.getData().add(new XYChart.Data<>(BodyMeasurements.linearChartMeasurementsToSafe.get(i).getDate().toString(),
                                                    Integer.parseInt(BodyMeasurements.linearChartMeasurementsToSafe.get(i).getWeight())));
        }
        return series;
    }






}