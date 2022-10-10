package model.language;

import java.io.Serial;
import java.io.Serializable;

public class ForgetPasswordPaneLanguage implements Serializable {
    @Serial
    private static final long serialVersionUID = 6892559916781903053L;
    private String recoverPasswordLabelController;
    private String usernameTextFieldController;
    private String emailTextFieldController;
    private String recoverPasswordButtonController;
    private String signInButtonController;

    ForgetPasswordPaneLanguage(LanguageCode languageCode) {
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }
    private void createPolishTranslation() {
        recoverPasswordLabelController = "Odzyskaj hasło:";
        usernameTextFieldController = "nazwa użytkownika";
        emailTextFieldController = "email";
        recoverPasswordButtonController = "Odzyskaj";
        signInButtonController = "Zaloguj się";
    }
    private void createEnglishTranslation() {
        recoverPasswordLabelController = "Recover password:";
        usernameTextFieldController = "username";
        emailTextFieldController = "email";
        recoverPasswordButtonController = "Recover ";
        signInButtonController = "Sign in";
    }

    public String getRecoverPasswordLabelController() {
        return recoverPasswordLabelController;
    }

    public String getUsernameTextFieldController() {
        return usernameTextFieldController;
    }

    public String getEmailTextFieldController() {
        return emailTextFieldController;
    }

    public String getRecoverPasswordButtonLabelController() {
        return recoverPasswordButtonController;
    }

    public String getSignInButtonController() {
        return signInButtonController;
    }
}
