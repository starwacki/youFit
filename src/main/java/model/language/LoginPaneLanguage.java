package model.language;

import java.io.Serial;
import java.io.Serializable;

public class LoginPaneLanguage implements Serializable {
    @Serial
    private static final long serialVersionUID = 1142599896128226723L;
    private String signInLabelController;
    private String usernameTextFieldController;
    private String passwordTextFieldController;
    private String forgetPasswordLabelController;
    private String incorrectLoginOrPasswordLabelController;
    private String registerButtonController;

    LoginPaneLanguage(LanguageCode languageCode) {
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }
    private void createPolishTranslation() {
        signInLabelController = "Zaloguj się";
        usernameTextFieldController = "nazwa użytkownika";
        passwordTextFieldController = "hasło";
        forgetPasswordLabelController = "Zapomniałeś hasła?";
        incorrectLoginOrPasswordLabelController = "Nieprawidłowy login lub hasło!";
        registerButtonController = "Nie masz konta? Zarejestruj się!";
    }
    private void createEnglishTranslation() {
        signInLabelController = "Sign in";
        usernameTextFieldController = "username";
        passwordTextFieldController = "password";
        forgetPasswordLabelController = "Forget password?";
        incorrectLoginOrPasswordLabelController = "Incorrect login or password";
        registerButtonController = "Don't have account? Register";
    }

    public String getSignInLabelController() {
        return signInLabelController;
    }

    public String getUsernameTextFieldController() {
        return usernameTextFieldController;
    }

    public String getPasswordTextFieldController() {
        return passwordTextFieldController;
    }

    public String getForgetPasswordLabelController() {
        return forgetPasswordLabelController;
    }

    public String getIncorrectLoginOrPasswordLabelController() {
        return incorrectLoginOrPasswordLabelController;
    }

    public String getRegisterButtonController() {
        return registerButtonController;
    }
}
