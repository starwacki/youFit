package model.language;

import java.io.Serial;
import java.io.Serializable;

public class SettingsLanguage implements Serializable {
    @Serial
    private static final long serialVersionUID = 2021742115425847912L;
    private String profileLabelController;
    private String mealsLabelController;
    private String weekSummaryLabelController;
    private String bodyMeasurementsLabelController;
    private String changeCaloriesDemandLabelController;
    private String settingsLabelController;

    SettingsLanguage (LanguageCode languageCode) {
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }
    private void createPolishTranslation() {
        profileLabelController = "Profil";
        mealsLabelController = "Posiłki";
        weekSummaryLabelController = "Podsumowanie Tygodnia";
        bodyMeasurementsLabelController = "Pomiary Ciała";
        changeCaloriesDemandLabelController = "Zapotrzebowanie Kaloryczne";
        settingsLabelController = "Ustawienia";

    }
    private void createEnglishTranslation() {
        profileLabelController = "Profile";
        mealsLabelController = "Meals";
        weekSummaryLabelController = "Week summary";
        bodyMeasurementsLabelController = "Body measurements";
        changeCaloriesDemandLabelController = "Calories Demand";
        settingsLabelController = "Settings";
    }

    public String getProfileLabelController() {
        return profileLabelController;
    }

    public String getMealsLabelController() {
        return mealsLabelController;
    }

    public String getWeekSummaryLabelController() {
        return weekSummaryLabelController;
    }

    public String getBodyMeasurementsLabelController() {
        return bodyMeasurementsLabelController;
    }

    public String getChangeCaloriesDemandLabelController() {
        return changeCaloriesDemandLabelController;
    }

    public String getSettingsLabelController() {
        return settingsLabelController;
    }
}
