package model.language;

public class CaloricDemandLanguage {
    private String caloricDemandCalculatorLabelController;
    private String ageLabelController;
    private String ageInfoLabelController;
    private String genderLabelController;
    private String maleCheckBoxController;
    private String femaleCheckBoxController;
    private String heightInfoLabelController;
    private String weightInfoLabelController;
    private String activityLabelController;
    private String trainingTargetLabelController;
    private String calculateCaloricDemandButtonController;
    private String recommendedCaloriesLabelController;
    private String caloriesLabelController;
    private String proteinsLabelController;
    private String carbohydratesLabelController;
    private String fatLabelController;
    private String setCalculatedCaloricDemandController;
    private String setCaloricDemandLabelController;
    private String setCaloricDemandProteinsLabelController;
    private String setCaloricDemandCarbohydratesLabelController;
    private String setCaloricDemandFatLabelController;
    private String setCaloricDemandCaloriesLabelController;
    private String setCaloricDemandButtonController;
    private String harrisBenedictInfoLabelController;
    private String maleHarrisBenedictFormulaLabelController;
    private String femaleHarrisBenedictFormulaLabelController;
    private String caloricDemandPaneTitleLabelController;

    CaloricDemandLanguage (LanguageCode languageCode) {
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }
    private void createPolishTranslation() {
        caloricDemandCalculatorLabelController = "Kalkulator zapotrzebowania kalorycznego";
        ageLabelController = "Wiek";
        ageInfoLabelController = "Rekomendowany wiek: (18-80)";
        genderLabelController = "Płeć";
        maleCheckBoxController = "M";
        femaleCheckBoxController = "K";
        heightInfoLabelController = "Wzrost";
        weightInfoLabelController = "Waga";
        activityLabelController = "Aktywność";
        trainingTargetLabelController = "Cel treningowy";
        calculateCaloricDemandButtonController = "Oblicz";
        recommendedCaloriesLabelController = "Rekomendowane makroskładniki:";
        caloriesLabelController = "kalorie";
        proteinsLabelController = "g białka";
        carbohydratesLabelController = "g węglowodanów";
        fatLabelController = "g tłuszczu";
        setCalculatedCaloricDemandController = "Ustaw zapotrzebowanie kaloryczne";
        setCaloricDemandLabelController = "Ustaw zapotrzebowanie kaloryczne";
        setCaloricDemandProteinsLabelController = "Białka";
        setCaloricDemandCarbohydratesLabelController = "Węglowodany";
        setCaloricDemandFatLabelController = "Tłuszcze";
        setCaloricDemandCaloriesLabelController = "Kalorie";
        setCaloricDemandButtonController = "Ustaw zapotrzebowanie";
        harrisBenedictInfoLabelController = "Zapotrzebowanie kaloryczne jest wyliczane na podstawie wzoru Harrisa Benedicta";
        maleHarrisBenedictFormulaLabelController = "Mężczyźni: BMR = 66 + (13,7 × waga w kg) + (5 × wzrost w cm) - (6,8 × wiek w latach)";
        femaleHarrisBenedictFormulaLabelController = " Kobiety: BMR = 655 + (9,6 × waga w kg) + (1,8 × wzrost w cm) - (4,7 × wiek w latach)";
        caloricDemandPaneTitleLabelController = "Zapotrzebowanie kaloryczne";

    }
    private void createEnglishTranslation() {
        caloricDemandCalculatorLabelController = "Caloric demand calculator";
        ageLabelController = "Age";
        ageInfoLabelController = "recommended age for calculated: (18-80)";
        genderLabelController = "Gender";
        maleCheckBoxController = "M";
        femaleCheckBoxController = "F";
        heightInfoLabelController = "Height";
        weightInfoLabelController = "Weight";
        activityLabelController = "Activity";
        trainingTargetLabelController = "Training Target";
        calculateCaloricDemandButtonController = "Calculate";
        recommendedCaloriesLabelController = "Recommended calories for you:";
        caloriesLabelController = "calories";
        proteinsLabelController = "g proteins";
        carbohydratesLabelController = "g carbohydrates";
        fatLabelController = "g fat";
        setCalculatedCaloricDemandController = "Set calculated caloric demand";
        setCaloricDemandLabelController = "Set caloric demand";
        setCaloricDemandProteinsLabelController = "Proteins";
        setCaloricDemandCarbohydratesLabelController = "Carbohydrates";
        setCaloricDemandFatLabelController = "Fat";
        setCaloricDemandCaloriesLabelController = "Calories";
        setCaloricDemandButtonController = "Set caloric demand";
        harrisBenedictInfoLabelController = "The caloric demand is calculated on the basis of by Harris-Benedict formula. ";
        maleHarrisBenedictFormulaLabelController = "Male: BMR = 66 + (13,7 × weight in kg) + (5 × height in cm) - (6,8 × age in years)";
        femaleHarrisBenedictFormulaLabelController = " Female: BMR = 655 + (9,6 × weight in kg) + (1,8 × height in cm) - (4,7 × age in years)";
        caloricDemandPaneTitleLabelController = "Calories Demand";
    }

    public String getCaloricDemandCalculatorLabelController() {
        return caloricDemandCalculatorLabelController;
    }

    public String getAgeLabelController() {
        return ageLabelController;
    }

    public String getAgeInfoLabelController() {
        return ageInfoLabelController;
    }

    public String getGenderLabelController() {
        return genderLabelController;
    }

    public String getMaleCheckBoxController() {
        return maleCheckBoxController;
    }

    public String getFemaleCheckBoxController() {
        return femaleCheckBoxController;
    }

    public String getHeightInfoLabelController() {
        return heightInfoLabelController;
    }

    public String getWeightInfoLabelController() {
        return weightInfoLabelController;
    }

    public String getActivityLabelController() {
        return activityLabelController;
    }

    public String getTrainingTargetLabelController() {
        return trainingTargetLabelController;
    }

    public String getCalculateCaloricDemandButtonController() {
        return calculateCaloricDemandButtonController;
    }

    public String getRecommendedCaloriesLabelController() {
        return recommendedCaloriesLabelController;
    }

    public String getCaloriesLabelController() {
        return caloriesLabelController;
    }

    public String getProteinsLabelController() {
        return proteinsLabelController;
    }

    public String getCarbohydratesLabelController() {
        return carbohydratesLabelController;
    }

    public String getFatLabelController() {
        return fatLabelController;
    }

    public String getSetCalculatedCaloricDemandController() {
        return setCalculatedCaloricDemandController;
    }

    public String getSetCaloricDemandLabelController() {
        return setCaloricDemandLabelController;
    }

    public String getSetCaloricDemandProteinsLabelController() {
        return setCaloricDemandProteinsLabelController;
    }

    public String getSetCaloricDemandCarbohydratesLabelController() {
        return setCaloricDemandCarbohydratesLabelController;
    }

    public String getSetCaloricDemandFatLabelController() {
        return setCaloricDemandFatLabelController;
    }

    public String getSetCaloricDemandCaloriesLabelController() {
        return setCaloricDemandCaloriesLabelController;
    }

    public String getSetCaloricDemandButtonController() {
        return setCaloricDemandButtonController;
    }

    public String getHarrisBenedictInfoLabelController() {
        return harrisBenedictInfoLabelController;
    }

    public String getMaleHarrisBenedictFormulaLabelController() {
        return maleHarrisBenedictFormulaLabelController;
    }

    public String getFemaleHarrisBenedictFormulaLabelController() {
        return femaleHarrisBenedictFormulaLabelController;
    }

    public String getCaloricDemandPaneTitleLabelController() {
        return caloricDemandPaneTitleLabelController;
    }
}
