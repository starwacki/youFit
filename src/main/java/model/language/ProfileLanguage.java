package model.language;

public class ProfileLanguage {
    private  String changeProfilePhotoButtonController;
    private  String usernameInfoLabelController;
    private  String emailInfoLabelController;
    private  String dateOfBirthInfoLabelController;
    private  String changePasswordLabelController;
    private  String oldPasswordLabelController;
    private  String newPasswordLabelController;
    private  String changePasswordButtonController;
    private String  profileInfoTitleLabelController;

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
}
