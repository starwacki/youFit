package model.language;

public class BodyMeasurementsLanguage {
    private String weightControlInfoLabelController;
    private String weightMeasurementsInfoLabelController;
    private String dateLinearChartTableViewTableColumnController;
    private String weightTableColumnController;
    private String weightInfoLabelController;
    private String addWeightLinearChartButtonController;
    private String bodyMeasurementsInfoLabelController;
    private String dateBodyMeasurementsTableViewTableColumnController;
    private String hipTableColumnController;
    private String chestTableColumnController;
    private String thighTableColumnController;
    private String bicepsTableColumnController;
    private String tricepsTableColumnController;
    private String waistTableColumnController;
    private String hipLabelController;
    private String thighLabelController;
    private String tricepsLabelController;
    private String chestLabelController;
    private String bicepsLabelController;
    private String waistLabelController;
    private String addBodyMeasurementsButtonController;
    private String bodyMeasurementsTitleLabelController;


    BodyMeasurementsLanguage (LanguageCode languageCode) {
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }
    private void createPolishTranslation() {
        weightControlInfoLabelController = "Wykres wagi";
        weightMeasurementsInfoLabelController = "Pomiary wagi";
        dateLinearChartTableViewTableColumnController = "Data";
        weightTableColumnController = "Waga";
        weightInfoLabelController = "Waga";
        addWeightLinearChartButtonController = "Dodaj";
        bodyMeasurementsInfoLabelController = "Pomiary ciała";
        dateBodyMeasurementsTableViewTableColumnController = "Data";
        hipTableColumnController = "Biodra";
        chestTableColumnController = "Klatka";
        thighTableColumnController = "Udo";
        bicepsTableColumnController = "Biceps";
        tricepsTableColumnController = "Triceps";
        waistTableColumnController = "Pas";
        hipLabelController = "Biodra";
        chestLabelController = "Klatka";
        thighLabelController = "Udo";
        bicepsLabelController = "Biceps";
        tricepsLabelController = "Triceps";
        waistLabelController = "Pas";
        addBodyMeasurementsButtonController = "Dodaj";
        bodyMeasurementsTitleLabelController = "Pomiary ciała";
    }
    private void createEnglishTranslation() {
        weightControlInfoLabelController = "Weight control";
        weightMeasurementsInfoLabelController = "Weight measurements";
        dateLinearChartTableViewTableColumnController = "Date";
        weightTableColumnController = "Weight";
        weightInfoLabelController = "Weight";
        addWeightLinearChartButtonController = "Add";
        bodyMeasurementsInfoLabelController = "Body measurements";
        dateBodyMeasurementsTableViewTableColumnController = "Date";
        hipTableColumnController = "Hip";
        chestTableColumnController = "Chest";
        thighTableColumnController = "Thigh";
        bicepsTableColumnController = "Biceps";
        tricepsTableColumnController = "Triceps";
        waistTableColumnController = "Waist";
        hipLabelController = "Hip";
        chestLabelController = "Chest";
        thighLabelController = "Thigh";
        bicepsLabelController = "Biceps";
        tricepsLabelController = "Triceps";
        waistLabelController = "Waist";
        addBodyMeasurementsButtonController = "Add";
        bodyMeasurementsTitleLabelController = "Body measurements";
    }

    public String getWeightControlInfoLabelController() {
        return weightControlInfoLabelController;
    }

    public String getWeightMeasurementsInfoLabelController() {
        return weightMeasurementsInfoLabelController;
    }

    public String getDateLinearChartTableViewTableColumnController() {
        return dateLinearChartTableViewTableColumnController;
    }

    public String getWeightTableColumnController() {
        return weightTableColumnController;
    }

    public String getWeightInfoLabelController() {
        return weightInfoLabelController;
    }

    public String getAddWeightLinearChartButtonController() {
        return addWeightLinearChartButtonController;
    }

    public String getBodyMeasurementsInfoLabelController() {
        return bodyMeasurementsInfoLabelController;
    }

    public String getDateBodyMeasurementsTableViewTableColumnController() {
        return dateBodyMeasurementsTableViewTableColumnController;
    }

    public String getHipTableColumnController() {
        return hipTableColumnController;
    }

    public String getChestTableColumnController() {
        return chestTableColumnController;
    }

    public String getThighTableColumnController() {
        return thighTableColumnController;
    }

    public String getBicepsTableColumnController() {
        return bicepsTableColumnController;
    }

    public String getTricepsTableColumnController() {
        return tricepsTableColumnController;
    }

    public String getWaistTableColumnController() {
        return waistTableColumnController;
    }

    public String getHipLabelController() {
        return hipLabelController;
    }

    public String getThighLabelController() {
        return thighLabelController;
    }

    public String getTricepsLabelController() {
        return tricepsLabelController;
    }

    public String getChestLabelController() {
        return chestLabelController;
    }

    public String getBicepsLabelController() {
        return bicepsLabelController;
    }

    public String getWaistLabelController() {
        return waistLabelController;
    }

    public String getAddBodyMeasurementsButtonController() {
        return addBodyMeasurementsButtonController;
    }

    public String getBodyMeasurementsTitleLabelController() {
        return bodyMeasurementsTitleLabelController;
    }
}
