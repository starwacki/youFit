package model.language;

public class LunchTableViewLanguage extends TableViewLanguage{
    private String mealName;
    LunchTableViewLanguage(LanguageCode languageCode) {
        super(languageCode);
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }

    @Override
    protected void createEnglishTranslation() {
        super.createEnglishTranslation();
        mealName = "Lunch";
    }

    @Override
    protected void createPolishTranslation() {
        super.createPolishTranslation();
        mealName = "Obiad";
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }
}

