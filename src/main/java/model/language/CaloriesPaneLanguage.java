package model.language;

public class CaloriesPaneLanguage {
    private String proteinsStringLabelController;
    private String carbohydratesStringLabelController;
    private String fatStringLabelController;
    private String caloriesStringLabelController;

    CaloriesPaneLanguage (LanguageCode languageCode) {
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }
    private void createPolishTranslation() {
      proteinsStringLabelController = "Białka:";
      carbohydratesStringLabelController = "Węglowodany:";
      fatStringLabelController = "Tłuszcze:";
      caloriesStringLabelController = "Kalorie:";
    }
    private void createEnglishTranslation() {
        proteinsStringLabelController = "Proteins";
        carbohydratesStringLabelController = "Carbohydrates:";
        fatStringLabelController = "Fat:";
        caloriesStringLabelController = "Calories:";
    }

    public String getProteinsStringLabelController() {
        return proteinsStringLabelController;
    }

    public String getCarbohydratesStringLabelController() {
        return carbohydratesStringLabelController;
    }

    public String getFatStringLabelController() {
        return fatStringLabelController;
    }

    public String getCaloriesStringLabelController() {
        return caloriesStringLabelController;
    }
}
