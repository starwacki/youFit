package model.language;

import java.io.Serial;
import java.io.Serializable;

public class SettingsSettingsLanguage implements Serializable {
    @Serial
    private static final long serialVersionUID = -5290663866033232277L;
    private String meal1NameLabelController;
    private String meal2NameLabelController;
    private String meal3NameLabelController;
    private String meal4NameLabelController;
    private String meal1TimeLabelController;
    private String meal2TimeLabelController;
    private String meal3TimeLabelController;
    private String meal4TimeLabelController;
    private String selectLanguageLabelController;
    private String changeMealNameButtonController;
    private String changeMealTimeButtonController;
    private String settingsTitleLabelController;

     SettingsSettingsLanguage (LanguageCode languageCode) {
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }
    private void createPolishTranslation() {
        meal1NameLabelController = "Nazwa posiłku I:";
        meal2NameLabelController = "Nazwa posiłku II:";
        meal3NameLabelController = "Nazwa posiłku III:";
        meal4NameLabelController = "Nazwa posiłku IV:";
        meal1TimeLabelController = "Godzina posiłku I:";
        meal2TimeLabelController = "Godzina posiłku II:";
        meal3TimeLabelController = "Godzina posiłku III:";
        meal4TimeLabelController = "Godzina posiłku IV:";
        selectLanguageLabelController = "Wybierz język";
        changeMealNameButtonController = "Zmień nazwe";
        changeMealTimeButtonController = "Zmień godzine";
        settingsTitleLabelController = "Ustawienia";

    }
    private void createEnglishTranslation() {
        meal1NameLabelController = "Meal I Name:";
        meal2NameLabelController = "Meal II Name:";
        meal3NameLabelController = "Meal III Name:";
        meal4NameLabelController = "Meal IV Name:";
        meal1TimeLabelController = "Meal I Time:";
        meal2TimeLabelController = "Meal II Time:";
        meal3TimeLabelController = "Meal III Time:";
        meal4TimeLabelController = "Meal IV Time:";
        selectLanguageLabelController = "Select language" ;
        changeMealNameButtonController = "Change name";
        changeMealTimeButtonController = "Change time";
        settingsTitleLabelController = "Settings";
    }

    public String getMeal1NameLabelController() {
        return meal1NameLabelController;
    }

    public String getMeal2NameLabelController() {
        return meal2NameLabelController;
    }

    public String getMeal3NameLabelController() {
        return meal3NameLabelController;
    }

    public String getMeal4NameLabelController() {
        return meal4NameLabelController;
    }

    public String getMeal1TimeLabelController() {
        return meal1TimeLabelController;
    }

    public String getMeal2TimeLabelController() {
        return meal2TimeLabelController;
    }

    public String getMeal3TimeLabelController() {
        return meal3TimeLabelController;
    }

    public String getMeal4TimeLabelController() {
        return meal4TimeLabelController;
    }

    public String getSelectLanguageLabelController() {
        return selectLanguageLabelController;
    }

    public String getChangeMealNameButtonController() {
        return changeMealNameButtonController;
    }

    public String getChangeMealTimeButtonController() {
        return changeMealTimeButtonController;
    }

    public String getSettingsTitleLabelController() {
        return settingsTitleLabelController;
    }
}
