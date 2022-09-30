package model.language;

public class Language {
    public static Enum language = LanguageCode.EN;
    SettingsLanguage settingsLanguage;
    ProfileLanguage profileLanguage;
    WeekSummaryLanguage weekSummaryLanguage;
    BodyMeasurementsLanguage bodyMeasurementsLanguage;
    SettingsSettingsLanguage settingsSettingsLanguage;
    CaloricDemandLanguage caloricDemandLanguage;
    CaloriesPaneLanguage caloriesPaneLanguage;
    BreakfastTableViewLanguage breakfastTableViewLanguage;
    BrunchTableViewLanguage brunchTableViewLanguage;
    LunchTableViewLanguage lunchTableViewLanguage;
    SupperTableViewLanguage supperTableViewLanguage;
    DaysPaneLanguage daysPaneLanguage;
    EditPaneLanguage editPaneLanguage;




   public Language () {
       if (language==LanguageCode.EN) createEnglishTranslate();
       if (language==LanguageCode.PL) createPolishTranslate();
   }
   private void createPolishTranslate () {
       settingsSettingsLanguage = new SettingsSettingsLanguage(LanguageCode.PL);
       caloricDemandLanguage = new CaloricDemandLanguage(LanguageCode.PL);
       bodyMeasurementsLanguage = new BodyMeasurementsLanguage(LanguageCode.PL);
       weekSummaryLanguage = new WeekSummaryLanguage(LanguageCode.PL);
       profileLanguage = new ProfileLanguage(LanguageCode.PL);
       settingsLanguage = new SettingsLanguage(LanguageCode.PL);
       caloriesPaneLanguage = new CaloriesPaneLanguage(LanguageCode.PL);
       breakfastTableViewLanguage = new BreakfastTableViewLanguage(LanguageCode.PL);
       brunchTableViewLanguage = new BrunchTableViewLanguage(LanguageCode.PL);
       lunchTableViewLanguage = new LunchTableViewLanguage(LanguageCode.PL);
       supperTableViewLanguage = new SupperTableViewLanguage(LanguageCode.PL);
       daysPaneLanguage = new DaysPaneLanguage(LanguageCode.PL);
       editPaneLanguage = new EditPaneLanguage(LanguageCode.PL);
   }
   private void createEnglishTranslate() {
       settingsSettingsLanguage = new SettingsSettingsLanguage(LanguageCode.EN);
       caloricDemandLanguage = new CaloricDemandLanguage(LanguageCode.EN);
       bodyMeasurementsLanguage = new BodyMeasurementsLanguage(LanguageCode.EN);
       weekSummaryLanguage = new WeekSummaryLanguage(LanguageCode.EN);
       profileLanguage = new ProfileLanguage(LanguageCode.EN);
       settingsLanguage = new SettingsLanguage(LanguageCode.EN);
       caloriesPaneLanguage = new CaloriesPaneLanguage(LanguageCode.EN);
       breakfastTableViewLanguage = new BreakfastTableViewLanguage(LanguageCode.EN);
       brunchTableViewLanguage = new BrunchTableViewLanguage(LanguageCode.EN);
       lunchTableViewLanguage = new LunchTableViewLanguage(LanguageCode.EN);
       supperTableViewLanguage = new SupperTableViewLanguage(LanguageCode.EN);
       daysPaneLanguage = new DaysPaneLanguage(LanguageCode.EN);
       editPaneLanguage = new EditPaneLanguage(LanguageCode.EN);
   }

    public SettingsSettingsLanguage getSettingsSettingsLanguage() {
        return settingsSettingsLanguage;
    }

    public CaloricDemandLanguage getCaloricDemandLanguage() {
        return caloricDemandLanguage;
    }

    public BodyMeasurementsLanguage getBodyMeasurementsLanguage() {
        return bodyMeasurementsLanguage;
    }

    public WeekSummaryLanguage getWeekSummaryLanguage() {
        return weekSummaryLanguage;
    }

    public ProfileLanguage getProfileLanguage() {
        return profileLanguage;
    }

    public SettingsLanguage getSettingsLanguage() {
        return settingsLanguage;
    }

    public CaloriesPaneLanguage getCaloriesPaneLanguage() {
        return caloriesPaneLanguage;
    }

    public BreakfastTableViewLanguage getBreakfastTableViewLanguage() {
        return breakfastTableViewLanguage;
    }

    public BrunchTableViewLanguage getBrunchTableViewLanguage() {
        return brunchTableViewLanguage;
    }

    public LunchTableViewLanguage getLunchTableViewLanguage() {
        return lunchTableViewLanguage;
    }

    public SupperTableViewLanguage getSupperTableViewLanguage() {
        return supperTableViewLanguage;
    }

    public DaysPaneLanguage getDaysPaneLanguage() {
        return daysPaneLanguage;
    }

    public EditPaneLanguage getEditPaneLanguage() {
        return editPaneLanguage;
    }
}
