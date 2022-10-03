package model.language;

import java.io.Serial;
import java.io.Serializable;

public class BrunchTableViewLanguage extends  TableViewLanguage implements Serializable {
    @Serial
    private static final long serialVersionUID = -3978183735148889035L;
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

