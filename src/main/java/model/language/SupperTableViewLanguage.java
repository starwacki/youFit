package model.language;

import java.io.Serial;
import java.io.Serializable;

public class SupperTableViewLanguage extends TableViewLanguage implements Serializable {
    @Serial
    private static final long serialVersionUID = -7795880625961660091L;
    private String mealName;
    SupperTableViewLanguage(LanguageCode languageCode) {
        super(languageCode);
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }

    @Override
    protected void createEnglishTranslation() {
        super.createEnglishTranslation();
        mealName = "Supper";
    }

    @Override
    protected void createPolishTranslation() {
        super.createPolishTranslation();
        mealName = "Kolacja";
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }
}

