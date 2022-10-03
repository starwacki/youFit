package controllers.SettingsPanesControllers;

import io.LanguageIO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.language.CaloricDemandLanguage;
import model.language.Language;

public class CaloricDemandPaneController {

    @FXML
    private ChoiceBox<?> PropertiesChoiceBoxController;

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
    private ChoiceBox<?> trainingTargetChoiceBoxController;

    @FXML
    private Label trainingTargetLabelController;

    @FXML
    private Label weightInfoLabelController;

    @FXML
    private TextField weightTextFieldController;

    @FXML
    private Label caloricDemandPaneTitleLabelController;

    public void initialize() {
        setLanguage(new Language().getCaloricDemandLanguage());
    }
    private void setLanguage(CaloricDemandLanguage language) {
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

}

