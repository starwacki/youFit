package model.language;

public class BrunchTableViewLanguage extends  TableViewLanguage{
    private String mealName;

    BrunchTableViewLanguage(LanguageCode languageCode) {
        super(languageCode);
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }

    @Override
    protected void createEnglishTranslation() {
        super.createEnglishTranslation();
        mealName = "Brunch";
    }

    @Override
    protected void createPolishTranslation() {
        super.createPolishTranslation();
        mealName = "II śniadanie";
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }
}

