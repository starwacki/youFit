package controllers.SettingsPanesControllers;
import io.CaloricDemandIO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.calories.CaloricDemand;
import model.calories.CaloricDemandPhysicalActivity;
import model.calories.CaloriesCalculator;
import model.calories.Purpose;
import model.language.CaloricDemandLanguage;
import model.language.Language;

public class CaloricDemandPaneController {
    private static final String  EMPTY_FIELD = "";
    private static final int  MINIMUM_AGE_VALUE = 18;
    private static final int  MAXIMUM_AGE_VALUE = 80;
    private static final int MINIMUM_HEIGHT_VALUE = 130;
    private static final int MAXIMUM_HEIGHT_VALUE = 210;
    private static final int MINIMUM_WEIGHT_VALUE = 40;
    private static final int MAXIMUM_WEIGHT_VALUE = 180;
    private static final int VERY_LOW_CALORIC_DEMAND_PHYSICAL_ACTIVITY_INDEX = 0;
    private static final int LOW_CALORIC_DEMAND_PHYSICAL_ACTIVITY_INDEX = 1;
    private static final int AVERAGE_CALORIC_DEMAND_PHYSICAL_ACTIVITY_INDEX = 2;
    private static final int BIG_CALORIC_DEMAND_PHYSICAL_ACTIVITY_INDEX = 3;
    private static final int VER_BIG_CALORIC_DEMAND_PHYSICAL_ACTIVITY_INDEX = 4;
    private static final int LOSS_WEIGHT_PURPOSE = 0;
    private static final int STAY_ON_WEIGHT_PURPOSE = 1;
    private static final int PUT_ON_WEIGHT_PURPOSE = 2;
    private static final int MALE_INDEX = 0;
    private static final int FEMALE_INDEX = 1;
    private static final int OPACITY_VISIBLE = 1;
    private static final int OPACITY_INVISIBLE = 0;
    private static final int CALORIC_DEMAND_RANGE_OF_CORRECTNESS = 200;



    @FXML
    private ChoiceBox<String> trainingTargetChoiceBoxController;

    @FXML
    private Label activityLabelController;

    @FXML
    private Label ageInfoLabelController;

    @FXML
    private Label ageLabelController;

    @FXML
    private TextField ageTextFieldController;

    @FXML
    private Button calculateCaloricDemandButtonController;

    @FXML
    private AnchorPane caloricDemandAnchorPane;

    @FXML
    private Label caloricDemandCalculatorLabelController;

    @FXML
    private TextField caloriesCaloricDemandTextFieldController;

    @FXML
    private Label caloriesLabelController;

    @FXML
    private Label caloriesNumberLabelController;

    @FXML
    private TextField carbohydratesCaloricDemandTextFieldController;

    @FXML
    private Label carbohydratesLabelController;

    @FXML
    private Label carbohydratesNumberLabelController;

    @FXML
    private TextField fatCaloricDemandTextFieldController;

    @FXML
    private Label fatLabelController;

    @FXML
    private Label fatNumberLabelController;

    @FXML
    private CheckBox femaleCheckBoxController;

    @FXML
    private Label femaleHarrisBenedictFormulaLabelController;

    @FXML
    private Label genderLabelController;

    @FXML
    private Label harrisBenedictInfoLabelController;

    @FXML
    private Label heightInfoLabelController;

    @FXML
    private TextField heightTextFieldController;

    @FXML
    private CheckBox maleCheckBoxController;

    @FXML
    private Label maleHarrisBenedictFormulaLabelController;

    @FXML
    private TextField proteinsCaloricDemandTextFieldController;

    @FXML
    private Label proteinsLabelController;

    @FXML
    private Label proteinsNumberLabelController;

    @FXML
    private Label recommendedCaloriesLabelController;

    @FXML
    private Button setCalculatedCaloricDemandController;

    @FXML
    private Button setCaloricDemandButtonController;

    @FXML
    private Label setCaloricDemandCaloriesLabelController;

    @FXML
    private Label setCaloricDemandCarbohydratesLabelController;

    @FXML
    private Label setCaloricDemandFatLabelController;

    @FXML
    private Label setCaloricDemandLabelController;

    @FXML
    private Label setCaloricDemandProteinsLabelController;

    @FXML
    private ChoiceBox<String> activityChoiceBoxController;

    @FXML
    private Label trainingTargetLabelController;

    @FXML
    private Label weightInfoLabelController;

    @FXML
    private TextField weightTextFieldController;

    @FXML
    private Label caloricDemandPaneTitleLabelController;

    @FXML
    private ImageView ageImageViewController;
    @FXML
    private ImageView heightImageViewController;
    @FXML
    private ImageView weightImageViewController;
    @FXML
    private ImageView setCaloricDemandWarningImageViewController1;
    @FXML
    private ImageView setCaloricDemandWarningImageViewController2;
    @FXML
    private ImageView setCaloricDemandWarningImageViewController3;
    @FXML
    private ImageView setCaloricDemandWarningImageViewController4;

    public void initialize() {
        setLanguage(new Language().getCaloricDemandLanguage());
        blockIncorrectTextFieldsValues();
        calculateCaloriesDemand();
        setCalculatedCaloricDemand();
        setCaloricDemandByUser();

    }
    private void setLanguage(CaloricDemandLanguage language) {
        setLabels(language);
        initializeActivityBox(language);
        initializeTrainingTargetBox(language);
    }
    private void blockIncorrectTextFieldsValues() {
        setTextFieldOnlyNumeric(ageTextFieldController);
        setTextFieldOnlyNumeric(heightTextFieldController);
        setTextFieldOnlyNumeric(weightTextFieldController);
        setTextFieldOnlyNumeric(proteinsCaloricDemandTextFieldController);
        setTextFieldOnlyNumeric(carbohydratesCaloricDemandTextFieldController);
        setTextFieldOnlyNumeric(fatCaloricDemandTextFieldController);
        setTextFieldOnlyNumeric(caloriesCaloricDemandTextFieldController);
        blockedGenderCheckBox();
    }
    private void setTextFieldOnlyNumeric(TextField textField) {
       textField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(oldValue);
            }
            if (newValue.equals("0")) textField.setText(oldValue);

        });
    }

    private void blockedGenderCheckBox() {
        maleCheckBoxController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent ->
                femaleCheckBoxController.setSelected(false));
        femaleCheckBoxController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent ->
          maleCheckBoxController.setSelected(false));
    }
    private void setLabels(CaloricDemandLanguage language) {
        caloricDemandCalculatorLabelController.setText(language.getCaloricDemandCalculatorLabelController());
        ageLabelController.setText(language.getAgeLabelController());
        ageInfoLabelController.setText(language.getAgeInfoLabelController());
        genderLabelController.setText(language.getGenderLabelController());
        maleCheckBoxController.setText(language.getMaleCheckBoxController());
        femaleCheckBoxController.setText(language.getFemaleCheckBoxController());
        heightInfoLabelController.setText(language.getHeightInfoLabelController());
        weightInfoLabelController.setText(language.getWeightInfoLabelController());
        activityLabelController.setText(language.getActivityLabelController());
        trainingTargetLabelController.setText(language.getTrainingTargetLabelController());
        calculateCaloricDemandButtonController.setText(language.getCalculateCaloricDemandButtonController());
        recommendedCaloriesLabelController.setText(language.getRecommendedCaloriesLabelController());
        caloriesLabelController.setText(language.getCaloriesLabelController());
        proteinsLabelController.setText(language.getProteinsLabelController());
        carbohydratesLabelController.setText(language.getCarbohydratesLabelController());
        fatLabelController.setText(language.getFatLabelController());
        setCalculatedCaloricDemandController.setText(language.getSetCalculatedCaloricDemandController());
        setCaloricDemandLabelController.setText(language.getSetCaloricDemandLabelController());
        setCaloricDemandProteinsLabelController.setText(language.getSetCaloricDemandProteinsLabelController());
        setCaloricDemandCarbohydratesLabelController.setText(language.getSetCaloricDemandCarbohydratesLabelController());
        setCaloricDemandFatLabelController.setText(language.getSetCaloricDemandFatLabelController());
        setCaloricDemandCaloriesLabelController.setText(language.getSetCaloricDemandCaloriesLabelController());
        setCaloricDemandButtonController.setText(language.getSetCaloricDemandButtonController());
        harrisBenedictInfoLabelController.setText(language.getHarrisBenedictInfoLabelController());
        maleHarrisBenedictFormulaLabelController.setText(language.getMaleHarrisBenedictFormulaLabelController());
        femaleHarrisBenedictFormulaLabelController.setText(language.getFemaleHarrisBenedictFormulaLabelController());
        caloricDemandPaneTitleLabelController.setText(language.getCaloricDemandPaneTitleLabelController());
    }
    private void initializeActivityBox(CaloricDemandLanguage language) {
        activityChoiceBoxController.getItems().addAll(language.getActivityChoiceBoxCaloricDemandPhysicalActivityVeryLow(),
                                                      language.getActivityChoiceBoxCaloricDemandPhysicalActivityLow(),
                                                      language.getActivityChoiceBoxCaloricDemandPhysicalActivityAverage(),
                                                      language.getActivityChoiceBoxCaloricDemandPhysicalActivityBig(),
                                                      language.getActivityChoiceBoxCaloricDemandPhysicalActivityVeryBig());
    }
    private void initializeTrainingTargetBox(CaloricDemandLanguage language) {
        trainingTargetChoiceBoxController.getItems().addAll(language.getTrainingTargetChoiceBoxPurposeLossWeight(),
                                                            language.getTrainingTargetChoiceBoxPurposeStayAtWeight(),
                                                            language.getTrainingTargetChoiceBoxPurposePutOnWeight());
    }
    private boolean isTextFieldEmpty(TextField textField) {
        if(textField == null) return true;
        else return textField.getText().equals(EMPTY_FIELD);
    }
    private boolean isChoicesBoxSelected() {
        return activityChoiceBoxController.getSelectionModel().getSelectedItem()!=null && trainingTargetChoiceBoxController.getSelectionModel().getSelectedItem()!=null;
    }
    private boolean isCheckBoxSelected() {
        return maleCheckBoxController.isSelected() || femaleCheckBoxController.isSelected();
    }
    private boolean areTextFieldsEmpty () {
        return isTextFieldEmpty(ageTextFieldController) || isTextFieldEmpty(heightTextFieldController) || isTextFieldEmpty(weightTextFieldController);
    }

    private boolean areAllFieldsToCalculateCorrect() {
        return !areTextFieldsEmpty() && isCheckBoxSelected() && isChoicesBoxSelected();
    }
    private void calculateCaloriesDemand() {
        calculateCaloricDemandButtonController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent ->
                setCaloricDemandInfoLabels());
    }
    private void setCaloricDemandInfoLabels() {
        if (areAllFieldsToCalculateCorrect()) {
            if (areFieldsValuesCorrect()) calculateDemandInfoLabels();
            else  setNotSuccessfulCalculateComponents();
            }
        }

    private void calculateDemandInfoLabels() {
        CaloricDemand caloricDemand = getCaloricDemand();
        setWarningImageView();
        setNumberLabels(caloricDemand);
    }
    private void setNotSuccessfulCalculateComponents() {
        setWarningImageView();
        setNumberLabelsInVisible();
    }
    private boolean isAgeValueCorrect() {
        return Integer.parseInt(ageTextFieldController.getText()) >= MINIMUM_AGE_VALUE && Integer.parseInt(ageTextFieldController.getText()) <= MAXIMUM_AGE_VALUE;
    }
    private boolean isHeightValueCorrect() {
        return Integer.parseInt(heightTextFieldController.getText()) > MINIMUM_HEIGHT_VALUE && Integer.parseInt(heightTextFieldController.getText()) < MAXIMUM_HEIGHT_VALUE;
    }
    private boolean isWeightValueCorrect() {
        return Integer.parseInt(weightTextFieldController.getText()) > MINIMUM_WEIGHT_VALUE && Integer.parseInt(weightTextFieldController.getText()) < MAXIMUM_WEIGHT_VALUE;
    }
    private boolean areFieldsValuesCorrect() {
        return isAgeValueCorrect() && isHeightValueCorrect() && isWeightValueCorrect();
    }
    private CaloricDemandPhysicalActivity caloricDemandPhysicalActivity() {
        CaloricDemandPhysicalActivity caloricDemandPhysicalActivity = null;
       switch (activityChoiceBoxController.getSelectionModel().getSelectedIndex()) {
           case VERY_LOW_CALORIC_DEMAND_PHYSICAL_ACTIVITY_INDEX -> caloricDemandPhysicalActivity = CaloricDemandPhysicalActivity.VERY_LOW;
           case LOW_CALORIC_DEMAND_PHYSICAL_ACTIVITY_INDEX -> caloricDemandPhysicalActivity = CaloricDemandPhysicalActivity.LOW;
           case AVERAGE_CALORIC_DEMAND_PHYSICAL_ACTIVITY_INDEX -> caloricDemandPhysicalActivity = CaloricDemandPhysicalActivity.AVERAGE;
           case BIG_CALORIC_DEMAND_PHYSICAL_ACTIVITY_INDEX -> caloricDemandPhysicalActivity = CaloricDemandPhysicalActivity.BIG;
           case VER_BIG_CALORIC_DEMAND_PHYSICAL_ACTIVITY_INDEX -> caloricDemandPhysicalActivity = CaloricDemandPhysicalActivity.VERY_BIG;
        }
        return caloricDemandPhysicalActivity;
    }
    private Purpose purpose() {
        Purpose purpose = null;
        switch (trainingTargetChoiceBoxController.getSelectionModel().getSelectedIndex()) {
            case LOSS_WEIGHT_PURPOSE -> purpose = Purpose.LOSS_WEIGHT;
            case STAY_ON_WEIGHT_PURPOSE -> purpose = Purpose.STAY_AT_WEIGHT;
            case PUT_ON_WEIGHT_PURPOSE -> purpose = Purpose.PUT_ON_WEIGHT;
        }
        return purpose;
    }
    private int selectedGender() {
        if (maleCheckBoxController.isSelected()) return MALE_INDEX;
        else return FEMALE_INDEX;
    }
    private CaloricDemand getCaloricDemand() {
        return new CaloricDemand(Integer.parseInt(weightTextFieldController.getText()),
                Integer.parseInt(heightTextFieldController.getText()),
                selectedGender(),
                caloricDemandPhysicalActivity(),
                Integer.parseInt(ageTextFieldController.getText()),
                purpose());
    }
    private void setNumberLabels(CaloricDemand caloricDemand){
        setNumberLabelsText(caloricDemand);
        setNumberLabelsVisible();
    }
    private void setNumberLabelsText(CaloricDemand caloricDemand) {
        proteinsNumberLabelController.setText(String.valueOf((int) caloricDemand.getProteinsInDiet()));
        carbohydratesNumberLabelController.setText(String.valueOf((int)caloricDemand.getCarbohydratesInDiet()));
        fatNumberLabelController.setText(String.valueOf((int)caloricDemand.getFatInDiet()));
        caloriesNumberLabelController.setText(String.valueOf((int)caloricDemand.calorieNeeded()));
    }
    private void setNumberLabelsVisible() {
        proteinsNumberLabelController.setOpacity(OPACITY_VISIBLE);
        carbohydratesNumberLabelController.setOpacity(OPACITY_VISIBLE);
        fatNumberLabelController.setOpacity(OPACITY_VISIBLE);
        caloriesNumberLabelController.setOpacity(OPACITY_VISIBLE);
        proteinsLabelController.setOpacity(OPACITY_VISIBLE);
        carbohydratesLabelController.setOpacity(OPACITY_VISIBLE);
        fatLabelController.setOpacity(OPACITY_VISIBLE);
        caloriesLabelController.setOpacity(OPACITY_VISIBLE);
    }
    private void setNumberLabelsInVisible() {
        proteinsNumberLabelController.setOpacity(OPACITY_INVISIBLE);
        carbohydratesNumberLabelController.setOpacity(OPACITY_INVISIBLE);
        fatNumberLabelController.setOpacity(OPACITY_INVISIBLE);
        caloriesNumberLabelController.setOpacity(OPACITY_INVISIBLE);
        proteinsLabelController.setOpacity(OPACITY_INVISIBLE);
        carbohydratesLabelController.setOpacity(OPACITY_INVISIBLE);
        fatLabelController.setOpacity(OPACITY_INVISIBLE);
        caloriesLabelController.setOpacity(OPACITY_INVISIBLE);
    }
    private void setWarningImageView() {
        if (!isAgeValueCorrect()) ageImageViewController.setOpacity(OPACITY_VISIBLE);
        else ageImageViewController.setOpacity(OPACITY_INVISIBLE);
        if (!isHeightValueCorrect()) heightImageViewController.setOpacity(OPACITY_VISIBLE);
        else heightImageViewController.setOpacity(OPACITY_INVISIBLE);
        if (!isWeightValueCorrect()) weightImageViewController.setOpacity(OPACITY_VISIBLE);
        else weightImageViewController.setOpacity(OPACITY_INVISIBLE);
    }

    private boolean isMicronutrientsTextFieldsCalculated() {
        return  !proteinsNumberLabelController.getText().equals("0") &&
                !carbohydratesNumberLabelController.getText().equals("0") &&
                !fatNumberLabelController.getText().equals("0") &&
                !carbohydratesNumberLabelController.getText().equals("0");
    }
    private void setCalculatedCaloricDemand() {
        setCalculatedCaloricDemandController.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (isMicronutrientsTextFieldsCalculated())  safeCaloricDemand(createCalculatedCaloricDemandToSafe()); });
    }
    private void safeCaloricDemand(CaloricDemand caloricDemand) {
        CaloricDemandIO.safeCaloricDemand(caloricDemand);
    }
    private CaloricDemand createCalculatedCaloricDemandToSafe() {
        CaloricDemand caloricDemand = new CaloricDemand();
        caloricDemand.setTotalDailyEnergyExpenditure(Integer.parseInt(caloriesNumberLabelController.getText()));
        caloricDemand.setProteinsInDiet(Integer.parseInt(proteinsNumberLabelController.getText()));
        caloricDemand.setCarbohydratesInDiet(Integer.parseInt(carbohydratesNumberLabelController.getText()));
        caloricDemand.setFatInDiet(Integer.parseInt(fatNumberLabelController.getText()));
        return caloricDemand;
    }
    private boolean areSetCaloricDemandTextFieldsEmpty() {
        return  isTextFieldEmpty(proteinsCaloricDemandTextFieldController) || isTextFieldEmpty(carbohydratesCaloricDemandTextFieldController)
                || isTextFieldEmpty(fatCaloricDemandTextFieldController)  || isTextFieldEmpty(caloriesCaloricDemandTextFieldController);
    }
    private void setCaloricDemandByUser() {
        setCaloricDemandButtonController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent ->setCaloricDemand());
    }
    private void setCaloricDemand() {
        if (!areSetCaloricDemandTextFieldsEmpty()) {
            if (areSetCaloricDemandTextFieldsValuesCorrect()) safeCaloricDemandFromUser();
            else  setWarningCaloricDemandImagesVisible();
        }
    }

    /* Total daily calories = CALORIES FROM FAT + CALORIES FROM PROTEINS + CALORIES FROM CARBOHYDRATES
      the method is supposed to block set unrealistic values
     */
    private boolean areSetCaloricDemandTextFieldsValuesCorrect() {
        return Integer.parseInt(caloriesCaloricDemandTextFieldController.getText()) + CALORIC_DEMAND_RANGE_OF_CORRECTNESS > allMicronutrientsCalories()
                && Integer.parseInt(caloriesCaloricDemandTextFieldController.getText()) - CALORIC_DEMAND_RANGE_OF_CORRECTNESS < allMicronutrientsCalories();
    }
    private int allMicronutrientsCalories() {
        return (int)(CaloriesCalculator.ONE_GRAM_OF_PROTEIN_CALORIES*Integer.parseInt(proteinsCaloricDemandTextFieldController.getText()) +
                CaloriesCalculator.ONE_GRAM_OF_CARBOHYDRATES_CALORIES*Integer.parseInt(carbohydratesCaloricDemandTextFieldController.getText()) +
                CaloriesCalculator.ONE_GRAM_OF_FAT_CALORIES*Integer.parseInt(fatCaloricDemandTextFieldController.getText()));
    }
    private void setWarningCaloricDemandImagesVisible() {
        setCaloricDemandWarningImageViewController1.setOpacity(OPACITY_VISIBLE);
        setCaloricDemandWarningImageViewController2.setOpacity(OPACITY_VISIBLE);
        setCaloricDemandWarningImageViewController3.setOpacity(OPACITY_VISIBLE);
        setCaloricDemandWarningImageViewController4.setOpacity(OPACITY_VISIBLE);
    }
    private void setWarningCaloricDemandImagesInvisible() {
        setCaloricDemandWarningImageViewController1.setOpacity(OPACITY_INVISIBLE);
        setCaloricDemandWarningImageViewController2.setOpacity(OPACITY_INVISIBLE);
        setCaloricDemandWarningImageViewController3.setOpacity(OPACITY_INVISIBLE);
        setCaloricDemandWarningImageViewController4.setOpacity(OPACITY_INVISIBLE);
    }
    private void safeCaloricDemandFromUser() {
        setWarningCaloricDemandImagesInvisible();
        safeCaloricDemand(createUserCaloricDemand());
    }
    private CaloricDemand createUserCaloricDemand() {
        CaloricDemand caloricDemand = new CaloricDemand();
        caloricDemand.setProteinsInDiet(Integer.parseInt(proteinsCaloricDemandTextFieldController.getText()));
        caloricDemand.setCarbohydratesInDiet(Integer.parseInt(carbohydratesCaloricDemandTextFieldController.getText()));
        caloricDemand.setFatInDiet(Integer.parseInt(fatCaloricDemandTextFieldController.getText()));
        caloricDemand.setTotalDailyEnergyExpenditure(Integer.parseInt(caloriesCaloricDemandTextFieldController.getText()));
        return caloricDemand;
    }


    }



