package model.language;

import java.io.Serial;
import java.io.Serializable;

public class RegisterPaneLanguage implements Serializable {
    @Serial
    private static final long serialVersionUID = -8204306893768444913L;
    private String registerInLabelController;
    private String usernameTextFieldController;
    private String passwordTextFieldController;
    private String registerButtonLabelController;
    private String haveAccountController;
    private String emailTextFieldController;

    RegisterPaneLanguage(LanguageCode languageCode) {
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }
    private void createPolishTranslation() {
        registerInLabelController= "Stwórz nowe konto:";
        usernameTextFieldController = "nazwa użytkownika";
        passwordTextFieldController = "hasło";
        registerButtonLabelController = "Zarejestruj się";
        haveAccountController = "Masz konto? Zaloguj się!";
    }
    private void createEnglishTranslation() {
        registerInLabelController= "Create new account:";
        usernameTextFieldController = "username";
        passwordTextFieldController = "password";
        registerButtonLabelController = "Register";
        haveAccountController = "Have a account? Login!";
    }

    public String getRegisterInLabelController() {
        return registerInLabelController;
    }

    public String getUsernameTextFieldController() {
        return usernameTextFieldController;
    }

    public String getPasswordTextFieldController() {
        return passwordTextFieldController;
    }

    public String getRegisterButtonLabelController() {
        return registerButtonLabelController;
    }

    public String getHaveAccountController() {
        return haveAccountController;
    }
}
