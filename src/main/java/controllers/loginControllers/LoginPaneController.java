package controllers.loginControllers;

import controllers.SceneSwitcherController;
import dao.QueryExecutor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.language.Language;
import model.language.LanguageCode;
import model.language.LoginPaneLanguage;
import model.user.User;

public class LoginPaneController {
    private static final double ACTUAL_CLICKED_COUNTRY_OPACITY = 0.5;
    private static final int NOT_CLICKED_COUNTRY_OPACITY = 1;
    @FXML
    private ImageView englishLanguageImageViewController;
    @FXML
    private Label forgetPasswordLabelController;
    @FXML
    private PasswordField passwordTextFieldController;
    @FXML
    private ImageView polishLanguageImageViewController;
    @FXML
    private Button registerButtonController;
    @FXML
    private Button signInButtonLabelController;
    @FXML
    private Label signInLabelController;
    @FXML
    private TextField usernameTextFieldController;
    @FXML
    private Label incorrectLoginOrPasswordLabelController;


    public void initialize() {
        setLanguage(new Language().getLoginPaneLanguage());
        signIn();
        switchToRegisterPane();
        switchToForgetPasswordPane();
        setApplicationLanguageByClickedCountry();
    }

    private void setLanguage(LoginPaneLanguage language) {
       setLanguageLabels(language);
       setActuallyLanguageOpacity();
    }

    private void setLanguageLabels(LoginPaneLanguage language) {
        forgetPasswordLabelController.setText(language.getForgetPasswordLabelController());
        passwordTextFieldController.setPromptText(language.getPasswordTextFieldController());
        usernameTextFieldController.setPromptText(language.getUsernameTextFieldController());
        registerButtonController.setText(language.getRegisterButtonController());
        signInLabelController.setText(language.getSignInLabelController());
        signInButtonLabelController.setText(language.getSignInLabelController());
        incorrectLoginOrPasswordLabelController.setText(language.getIncorrectLoginOrPasswordLabelController());
    }


    private void signIn() {
     signInByClickedButton();
     signInByKeyPressed();

    }
    private void signInByClickedButton() {
        signInButtonLabelController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            if (correctUserLoginPassword()) {
                changeScene();
            }
        }
        );
    }

    private void signInByKeyPressed() {
        passwordTextFieldController.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent ->
        {
            if (keyEvent.getCode() == KeyCode.ENTER) {
               if (correctUserLoginPassword()) {
                   changeScene();
               }
            }
        });
    }

    private void changeScene() {
        initializeUser();
        new SceneSwitcherController().switchToMainPane(thisStage());
    }

    private  boolean correctUserLoginPassword(){
        if (usernameTextFieldController.getText()!=null && passwordTextFieldController.getText()!=null) {
            if (QueryExecutor.isUsernameInBase(usernameTextFieldController.getText())) {
                if (QueryExecutor.getUserPassword(usernameTextFieldController.getText()) != null)
                    if (isCorrectPassword()) {
                        return true;
                    } else {
                        incorrectLoginOrPassword();
                        return false;
                    }
            }
        }

         incorrectLoginOrPassword();
         return false;
    }

    private Stage thisStage() {
     return  (Stage)  signInLabelController.getScene().getWindow();
    }

    private void incorrectLoginOrPassword() {
    incorrectLoginOrPasswordLabelController.setOpacity(1);
    }

    private void switchToRegisterPane() {
        registerButtonController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent ->
                new SceneSwitcherController().switchToRegisterPane(thisStage()));
    }

    private void switchToForgetPasswordPane() {
        forgetPasswordLabelController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent ->
                new SceneSwitcherController().switchToForgetPasswordPane(thisStage()));
    }

    private void setActuallyLanguageOpacity() {
        if (Language.language== LanguageCode.PL) polishLanguageImageViewController.setOpacity(ACTUAL_CLICKED_COUNTRY_OPACITY);
        else englishLanguageImageViewController.setOpacity(ACTUAL_CLICKED_COUNTRY_OPACITY);
    }

    private void setApplicationLanguageByClickedCountry() {
        polishLanguageImageViewController.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> setPL());
        englishLanguageImageViewController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> setEN());
    }

    private void setPL() {
        Language.language = LanguageCode.PL;
        englishLanguageImageViewController.setOpacity(NOT_CLICKED_COUNTRY_OPACITY);
        setLanguage(new Language().getLoginPaneLanguage());
    }

    private void setEN() {
        Language.language = LanguageCode.EN;
        polishLanguageImageViewController.setOpacity(NOT_CLICKED_COUNTRY_OPACITY);
        setLanguage(new Language().getLoginPaneLanguage());
    }

    private void initializeUser() {
        User.setNickname(usernameTextFieldController.getText());
        User.setUserID(QueryExecutor.getUserID(usernameTextFieldController.getText()));
        User.setDateOfBirth(QueryExecutor.getUserDateOfBirth(usernameTextFieldController.getText()));
        User.setEmail(QueryExecutor.getUserEmail(usernameTextFieldController.getText()));
    }

    private boolean isCorrectPassword() {
        char[] password = QueryExecutor.getUserPassword(usernameTextFieldController.getText());
        char[] typedPassword = passwordTextFieldController.getText().toCharArray();
        if (password.length!=typedPassword.length) return false;
        for (int i = 0; i < password.length ; i++) {
            if (password[i]!=typedPassword[i]) return false;
        }
        return true;
    }

}
