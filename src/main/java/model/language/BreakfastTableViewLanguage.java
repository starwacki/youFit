package model.language;

import java.io.Serial;
import java.io.Serializable;

public class BreakfastTableViewLanguage extends TableViewLanguage implements Serializable {
    @Serial
    private static final long serialVersionUID = 280708105296855915L;
    private String mealName;
    BreakfastTableViewLanguage(LanguageCode languageCode) {
        super(languageCode);
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();

    }

    @Override
    protected void createEnglishTranslation() {
        super.createEnglishTranslation();
        mealName = "Breakfast";
    }

    @Override
    protected void createPolishTranslation() {
        super.createPolishTranslation();
        mealName = "Śniadanie";
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }
}
