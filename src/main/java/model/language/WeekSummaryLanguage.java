package model.language;

public class WeekSummaryLanguage {
    private String weekProteinsLabelController;
    private String weekCarbohydratesLabelController;
    private String weekFatLabelController;
    private String weekCaloriesLabelController;
    private String daysWithoutExceededCaloriesInfoLabelController;
    private String weekSummaryTitleLabelController;



    WeekSummaryLanguage (LanguageCode languageCode) {
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }
    private void createPolishTranslation() {
        weekProteinsLabelController = "Tygodniowa suma białka:";
        weekCarbohydratesLabelController = "Tygodniowa suma węglowodanów:";
        weekFatLabelController = "Tygodniowa suma tłuszczów:";
        weekCaloriesLabelController = "Tygodniowa suma kalorii:";
        daysWithoutExceededCaloriesInfoLabelController = "Dni bez przekroczonych kalorii:";
        weekSummaryTitleLabelController = "Podsumowanie Tygodnia";
    }
    private void createEnglishTranslation() {
       weekProteinsLabelController = "Week proteins";
       weekCarbohydratesLabelController = "Week carbohydrates";
       weekFatLabelController = "Week fat";
       weekCaloriesLabelController = "Week calories";
       daysWithoutExceededCaloriesInfoLabelController = "Days without Exceeded Calories:";
       weekSummaryTitleLabelController = "Week Summary";
    }

    public String getWeekProteinsLabelController() {
        return weekProteinsLabelController;
    }

    public String getWeekCarbohydratesLabelController() {
        return weekCarbohydratesLabelController;
    }

    public String getWeekFatLabelController() {
        return weekFatLabelController;
    }

    public String getWeekCaloriesLabelController() {
        return weekCaloriesLabelController;
    }

    public String getDaysWithoutExceededCaloriesInfoLabelController() {
        return daysWithoutExceededCaloriesInfoLabelController;
    }

    public String getWeekSummaryTitleLabelController() {
        return weekSummaryTitleLabelController;
    }
}
