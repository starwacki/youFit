package model.language;

import java.io.Serial;
import java.io.Serializable;

public class DaysPaneLanguage implements Serializable {
    @Serial
    private static final long serialVersionUID = 5596007841419286214L;
    private String mondayButtonController;
    private String tuesdayButtonController;
    private String wednesdayButtonController;
    private String thursdayButtonController;
    private String fridayButtonController;
    private String saturdayButtonController;
    private String sundayButtonController;

    DaysPaneLanguage (LanguageCode languageCode) {
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }
    protected void createPolishTranslation() {
        mondayButtonController = "PON";
        tuesdayButtonController = "WTO";
        wednesdayButtonController = "ŚRO";
        thursdayButtonController = "CZW";
        fridayButtonController = "PIĄ";
        saturdayButtonController = "SOB";
        sundayButtonController = "NDZ";
    }
    protected void createEnglishTranslation() {
        mondayButtonController = "MON";
        tuesdayButtonController = "TUE";
        wednesdayButtonController = "WED";
        thursdayButtonController = "THU";
        fridayButtonController = "FRI";
        saturdayButtonController = "SAT";
        sundayButtonController = "SUN";
    }

    public String getMondayButtonController() {
        return mondayButtonController;
    }

    public String getTuesdayButtonController() {
        return tuesdayButtonController;
    }

    public String getWednesdayButtonController() {
        return wednesdayButtonController;
    }

    public String getThursdayButtonController() {
        return thursdayButtonController;
    }

    public String getFridayButtonController() {
        return fridayButtonController;
    }

    public String getSaturdayButtonController() {
        return saturdayButtonController;
    }

    public String getSundayButtonController() {
        return sundayButtonController;
    }
}
