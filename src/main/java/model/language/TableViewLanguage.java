package model.language;

import java.io.Serial;
import java.io.Serializable;

public class TableViewLanguage implements Serializable {
    @Serial
    private static final long serialVersionUID = 8938990425890761685L;
    private String proteinsInfoLabelController;
    private String carbohydratesInfoLabelController;
    private String fatInfoLabelController;
    private String caloriesInfoLabelController;

    TableViewLanguage (LanguageCode languageCode) {
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }

    protected void createPolishTranslation() {
       proteinsInfoLabelController = "b";
       fatInfoLabelController = "t";
       carbohydratesInfoLabelController = "w";
       caloriesInfoLabelController = "kcal";
    }
    protected void createEnglishTranslation() {
        proteinsInfoLabelController = "p";
        fatInfoLabelController = "f";
        carbohydratesInfoLabelController = "c";
        caloriesInfoLabelController = "kcal";
    }

    public String getProteinsInfoLabelController() {
        return proteinsInfoLabelController;
    }

    public String getCarbohydratesInfoLabelController() {
        return carbohydratesInfoLabelController;
    }

    public String getFatInfoLabelController() {
        return fatInfoLabelController;
    }

    public String getCaloriesInfoLabelController() {
        return caloriesInfoLabelController;
    }
}
