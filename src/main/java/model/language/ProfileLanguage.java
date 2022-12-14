package model.language;

import java.io.Serial;
import java.io.Serializable;

public class ProfileLanguage implements Serializable {
    @Serial
    private static final long serialVersionUID = 6186444897947369444L;
    private  String changeProfilePhotoButtonController;
    private  String usernameInfoLabelController;
    private  String emailInfoLabelController;
    private  String dateOfBirthInfoLabelController;
    private  String changePasswordLabelController;
    private  String oldPasswordLabelController;
    private  String newPasswordLabelController;
    private  String changePasswordButtonController;
    private String  profileInfoTitleLabelController;
    private String emptyFieldErrorLabelController;
    private String incorrectLengthErrorLabelController;
    private String notTheSamePasswordErrorLabelController;



    ProfileLanguage (LanguageCode languageCode) {
        if (languageCode==LanguageCode.PL) createPolishTranslation();
        if (languageCode==LanguageCode.EN) createEnglishTranslation();
    }
    private void createPolishTranslation() {
        changeProfilePhotoButtonController = "Zmień zdjęcie profilowe";
        usernameInfoLabelController = "Nazwa użytkownika:";
        emailInfoLabelController = "Email:";
        dateOfBirthInfoLabelController = "Data urodzenia:";
        changePasswordLabelController = "Zmiana hasła";
        oldPasswordLabelController = "Stare hasło:";
        newPasswordLabelController = "Nowe hasło:";
        changePasswordButtonController = "Zmień";
        profileInfoTitleLabelController = "Profil";
        emptyFieldErrorLabelController = "Pola są puste!";
        incorrectLengthErrorLabelController = "Hasło musi mieć od 6 do 20 znaków!";
        notTheSamePasswordErrorLabelController = "Wpisane hasło jest nieprawidłowe!";
    }
    private void createEnglishTranslation() {
        changeProfilePhotoButtonController = "Change photo";
        usernameInfoLabelController = "Username:";
        emailInfoLabelController = "Email:";
        dateOfBirthInfoLabelController = "Date of birth:";
        changePasswordLabelController = "Change password";
        oldPasswordLabelController = "Old password:";
        newPasswordLabelController = "New password:";
        changePasswordButtonController = "Change";
        profileInfoTitleLabelController = "Profile";
        emptyFieldErrorLabelController = "Text Fields are empty!";
        incorrectLengthErrorLabelController = "Password must have between 5 and 20 characters";
        notTheSamePasswordErrorLabelController = "The entered password is incorrect!";
    }

    public String getChangeProfilePhotoButtonController() {
        return changeProfilePhotoButtonController;
    }

    public String getUsernameInfoLabelController() {
        return usernameInfoLabelController;
    }

    public String getEmailInfoLabelController() {
        return emailInfoLabelController;
    }

    public String getDateOfBirthInfoLabelController() {
        return dateOfBirthInfoLabelController;
    }

    public String getChangePasswordLabelController() {
        return changePasswordLabelController;
    }

    public String getOldPasswordLabelController() {
        return oldPasswordLabelController;
    }

    public String getNewPasswordLabelController() {
        return newPasswordLabelController;
    }

    public String getChangePasswordButtonController() {
        return changePasswordButtonController;
    }

    public String getProfileInfoTitleLabelController() {
        return profileInfoTitleLabelController;
    }

    public String getEmptyFieldErrorLabelController() {
        return emptyFieldErrorLabelController;
    }

    public String getIncorrectLengthErrorLabelController() {
        return incorrectLengthErrorLabelController;
    }

    public String getNotTheSamePasswordErrorLabelController() {
        return notTheSamePasswordErrorLabelController;
    }
}
