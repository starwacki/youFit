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
    private String usernameOrEmailError;
    private String passwordError;
    private String emailLoginExistError;
    private String emptyTextFieldError;
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
        usernameOrEmailError = "Login i email muszą mieć  od 6 do 20 znaków! ( bez znaków specjalnych)";
        passwordError = "Hasło jest za krótkie! - powinno mieć między 6 a 20 znaków";
        emptyTextFieldError = "Uzupelnij wszystkie pola!";
        emailLoginExistError = "Podany login lub email już istnieje";
    }
    private void createEnglishTranslation() {
        registerInLabelController= "Create new account:";
        usernameTextFieldController = "username";
        passwordTextFieldController = "password";
        registerButtonLabelController = "Register";
        haveAccountController = "Have a account? Login!";
        usernameOrEmailError = "Login and email should have between 6 and 20 characters (Without special characters)";
        passwordError = "Password is too short! Password should have between 6 and 20 characters!";
        emptyTextFieldError = "All fields must be completed!";
        emailLoginExistError = "Login or email exists!";
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

    public String getUsernameOrEmailError() {
        return usernameOrEmailError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public String getEmailLoginExistError() {
        return emailLoginExistError;
    }

    public String getEmptyTextFieldError() {
        return emptyTextFieldError;
    }
}
