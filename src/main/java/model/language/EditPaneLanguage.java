package model.language;

import java.io.Serial;
import java.io.Serializable;

public class EditPaneLanguage implements Serializable {
    @Serial
    private static final long serialVersionUID = -4280711665109333881L;
    private String percentageOfMacronutrientsLabelController;
    private String proteinsPieCharLabelController;
    private String carbohydratesPieCharLabelController;
    private String fatPieCharLabelController;
    private String selectProductToAddInfoLabelController;
    private String searchLabelController;
    private String weightInfoLabelController;
    private String addNewProductToYourBaseInfoLabelController;
    private String productNameInfoLabelController;
    private String producerInfoLabelController;
    private String proteinsPer100gInfoLabelController;
    private String carbsPer100gInfoLabelController;
    private String caloriesPer100gInfoLabelController;
    private String fatPer100gInfoLabelController;
    private String addNewProductToYourBase;
    private String changeListViewButtonController;
    private String emptyTextFieldError;
    private String incorrectSumOfMicronutrientsCaloriesError;
    private String incorrectSumOfMicronutrientsPer100gError;
    private String incorrectMicronutrientsValuesError;
    private String productSuccessivelyAddedInfo;

    EditPaneLanguage(LanguageCode languageCode) {
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }
    private void createPolishTranslation() {
        percentageOfMacronutrientsLabelController ="Rozkład makroskładników: ";
        proteinsPieCharLabelController = "Białka:";
        carbohydratesPieCharLabelController = "Węglowodany:";
        fatPieCharLabelController = "Tłuszcze:";
        selectProductToAddInfoLabelController = "wybierz produkt do dodania";
        searchLabelController = "Szukaj";
        changeListViewButtonController = "Twoje produkty";
        weightInfoLabelController = "Waga";
        addNewProductToYourBaseInfoLabelController = "Dodaj nowy produkt do Twojej bazy (Wszystkie pola muszą byc pełne)";
        productNameInfoLabelController = "Nazwa:";
        producerInfoLabelController = "Producent:";
        caloriesPer100gInfoLabelController = "Kalorie /100g";
        proteinsPer100gInfoLabelController = "Białka /100g";
        carbsPer100gInfoLabelController = "Węglo. /100g";
        fatPer100gInfoLabelController = "Tłuszcze /100g";
        addNewProductToYourBase = "Dodaj";
        emptyTextFieldError = "Uzupełnij wszystkie pola!";
        incorrectSumOfMicronutrientsPer100gError = "Łączna gramatura wszystkich makroskładników nie może być większa od 100g!";
        incorrectSumOfMicronutrientsCaloriesError = "Produkt z niepoprawnymi wartościami makroskładników! ";
        incorrectMicronutrientsValuesError = "Makroskładnik na 100g produktu nie może być większy od 100g!";
        productSuccessivelyAddedInfo = "Produkt został dodany!";
    }
    private void createEnglishTranslation() {
        percentageOfMacronutrientsLabelController = "percentage of macronutrients:";
        proteinsPieCharLabelController = "Proteins:";
        carbohydratesPieCharLabelController = "Carbohydrates:";
        fatPieCharLabelController = "Fat:";
        selectProductToAddInfoLabelController = "select products to add:";
        searchLabelController = "Search";
        changeListViewButtonController = "Personal products";
        weightInfoLabelController = "Weight";
        addNewProductToYourBaseInfoLabelController = "Add new product to your base (All textfield must be completed)";
        productNameInfoLabelController = "Product name";
        producerInfoLabelController = "Producer";
        caloriesPer100gInfoLabelController = "Calories /100g";
        proteinsPer100gInfoLabelController = "Proteins /100g";
        carbsPer100gInfoLabelController = "Carbs. /100g";
        fatPer100gInfoLabelController = "Fat /100g";
        addNewProductToYourBase = "Add";
        emptyTextFieldError = "Text fields are empty!";
        incorrectSumOfMicronutrientsPer100gError = "Total sum of micronutrients grammages cannot be greater than 100g!";
        incorrectSumOfMicronutrientsCaloriesError = "Product with incorrect micronutrients values! ";
        incorrectMicronutrientsValuesError = "Micronutrient per 100g of product cannot be greater than 100g!";
        productSuccessivelyAddedInfo = "Product added!";

    }

    public String getPercentageOfMacronutrientsLabelController() {
        return percentageOfMacronutrientsLabelController;
    }

    public String getProteinsPieCharLabelController() {
        return proteinsPieCharLabelController;
    }

    public String getCarbohydratesPieCharLabelController() {
        return carbohydratesPieCharLabelController;
    }

    public String getFatPieCharLabelController() {
        return fatPieCharLabelController;
    }

    public String getSelectProductToAddInfoLabelController() {
        return selectProductToAddInfoLabelController;
    }

    public String getSearchLabelController() {
        return searchLabelController;
    }

    public String getWeightInfoLabelController() {
        return weightInfoLabelController;
    }

    public String getAddNewProductToYourBaseInfoLabelController() {
        return addNewProductToYourBaseInfoLabelController;
    }

    public String getProductNameInfoLabelController() {
        return productNameInfoLabelController;
    }

    public String getProducerInfoLabelController() {
        return producerInfoLabelController;
    }

    public String getProteinsPer100gInfoLabelController() {
        return proteinsPer100gInfoLabelController;
    }

    public String getCarbsPer100gInfoLabelController() {
        return carbsPer100gInfoLabelController;
    }

    public String getCaloriesPer100gInfoLabelController() {
        return caloriesPer100gInfoLabelController;
    }

    public String getFatPer100gInfoLabelController() {
        return fatPer100gInfoLabelController;
    }

    public String getAddNewProductToYourBase() {
        return addNewProductToYourBase;
    }

    public String getChangeListViewButtonController() {
        return changeListViewButtonController;
    }

    public String getEmptyTextFieldError() {
        return emptyTextFieldError;
    }

    public String getIncorrectSumOfMicronutrientsCaloriesError() {
        return incorrectSumOfMicronutrientsCaloriesError;
    }

    public String getIncorrectSumOfMicronutrientsPer100gError() {
        return incorrectSumOfMicronutrientsPer100gError;
    }

    public String getIncorrectMicronutrientsValuesError() {
        return incorrectMicronutrientsValuesError;
    }

    public String getProductSuccessivelyAddedInfo() {
        return productSuccessivelyAddedInfo;
    }
}
