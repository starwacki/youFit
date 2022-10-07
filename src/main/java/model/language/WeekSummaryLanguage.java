package model.language;

import java.io.Serial;
import java.io.Serializable;

public class WeekSummaryLanguage implements Serializable {
    @Serial
    private static final long serialVersionUID = 667964906142473152L;
    private String weekProteinsLabelController;
    private String weekCarbohydratesLabelController;
    private String weekFatLabelController;
    private String weekCaloriesLabelController;
    private String daysWithoutExceededCaloriesInfoLabelController;
    private String weekSummaryTitleLabelController;
    private String mondaySeries;
    private String tuesdaySeries;
    private String wednesdaySeries;
    private String thursdaySeries;
    private String fridaySeries;
    private String saturdaySeries;
    private String sundaySeries;
    private String proteinsSeriesName;
    private String carbohydratesSeriesName;
    private String fatSeriesName;
    private String barChartTitle;



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
        mondaySeries = "Poniedziałek";
        tuesdaySeries = "Wtorek";
        wednesdaySeries = "Środa";
        thursdaySeries = "Czwartek";
        fridaySeries = "Piątek";
        saturdaySeries = "Sobota";
        sundaySeries = "Niedziela";
        barChartTitle = "Kalorie z makroskładników:";
        proteinsSeriesName = "Białka";
        fatSeriesName = "Tłuszcze";
        carbohydratesSeriesName = "Węglowodany";
    }
    private void createEnglishTranslation() {
       weekProteinsLabelController = "Week proteins";
       weekCarbohydratesLabelController = "Week carbohydrates";
       weekFatLabelController = "Week fat";
       weekCaloriesLabelController = "Week calories";
       daysWithoutExceededCaloriesInfoLabelController = "Days without Exceeded Calories:";
       weekSummaryTitleLabelController = "Week Summary";
       mondaySeries = "Monday";
       tuesdaySeries = "Tuesday";
       wednesdaySeries = "Wednesday";
       thursdaySeries = "Thursday";
       fridaySeries = "Friday";
       saturdaySeries = "Saturday";
       sundaySeries = "Sunday";
       barChartTitle = "Calories of micronutrients:";
        proteinsSeriesName = "Proteins";
        fatSeriesName = "Fat";
        carbohydratesSeriesName = "Carbohydrates";
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

    public String getMondaySeries() {
        return mondaySeries;
    }

    public String getTuesdaySeries() {
        return tuesdaySeries;
    }

    public String getWednesdaySeries() {
        return wednesdaySeries;
    }

    public String getThursdaySeries() {
        return thursdaySeries;
    }

    public String getFridaySeries() {
        return fridaySeries;
    }

    public String getSaturdaySeries() {
        return saturdaySeries;
    }

    public String getSundaySeries() {
        return sundaySeries;
    }

    public String getBarChartTitle() {
        return barChartTitle;
    }

    public String getProteinsSeriesName() {
        return proteinsSeriesName;
    }

    public String getCarbohydratesSeriesName() {
        return carbohydratesSeriesName;
    }

    public String getFatSeriesName() {
        return fatSeriesName;
    }
}
