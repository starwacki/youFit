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
import model.language.CaloriesPaneLanguage;
import model.language.Language;
import model.language.LanguageCode;
import model.language.LoginPaneLanguage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LoginPaneController {
    private Map<String,String> map = new HashMap<>();


    @FXML
    private ImageView englishLanguageImageViewController;

    @FXML
    private Label forgetPasswordLabelController;

    @FXML
    private PasswordField passwordTextFieldController;

    @FXML
    private ImageView polishLanguageImageViewControllr;

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
        putTestUsers();
        signIn();
        switchToRegisterPane();
        switchToForgetPasswordPane();
        setApplicationLanguage();
    }

    private void setLanguage(LoginPaneLanguage language) {
       forgetPasswordLabelController.setText(language.getForgetPasswordLabelController());
       passwordTextFieldController.setPromptText(language.getPasswordTextFieldController());
       usernameTextFieldController.setPromptText(language.getUsernameTextFieldController());
       registerButtonController.setText(language.getRegisterButtonController());
       signInLabelController.setText(language.getSignInLabelController());
       signInButtonLabelController.setText(language.getSignInLabelController());
       incorrectLoginOrPasswordLabelController.setText(language.getIncorrectLoginOrPasswordLabelController());
       setActuallyLanguageOpacity();
    }
    private void putTestUsers() {
        map.put("user1","password1");
        map.put("user2","password2");
        map.put("user3","password3");
        map.put("user4","password4");
    }
    private void signIn() {
     signInByClickedButton();
     signInByKeyPressed();

    }
    private void signInByClickedButton() {
        signInButtonLabelController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            if (correctUserLoginPassword()) new SceneSwitcherController().switchToMainPane(thisStage());
        }
        );
    }
    private void signInByKeyPressed() {
        passwordTextFieldController.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent ->
        {
            if (keyEvent.getCode() == KeyCode.ENTER) {
               if (correctUserLoginPassword()) new SceneSwitcherController().switchToMainPane(thisStage());
            }
        });
    }
    private  boolean correctUserLoginPassword(){
        if (usernameTextFieldController.getText()!=null && passwordTextFieldController.getText()!=null) {
            if (QueryExecutor.getUserPassword(usernameTextFieldController.getText()) !=null)
               if(Arrays.hashCode(QueryExecutor.getUserPassword(usernameTextFieldController.getText())) == Arrays.hashCode(passwordTextFieldController.getText().toCharArray())) {
                   return true;
               } else  {
                   incorrectLoginOrPassword();
                   return false;
               };
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
        if (Language.language== LanguageCode.PL) polishLanguageImageViewControllr.setOpacity(0.5);
        else englishLanguageImageViewController.setOpacity(0.5);
    }
    private void setApplicationLanguage() {
        polishLanguageImageViewControllr.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> setPL());
        englishLanguageImageViewController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> setEN());
    }
    private void setPL() {
        Language.language = LanguageCode.PL;
        englishLanguageImageViewController.setOpacity(1);
        setLanguage(new Language().getLoginPaneLanguage());
    }
    private void setEN() {
        Language.language = LanguageCode.EN;
        polishLanguageImageViewControllr.setOpacity(1);
        setLanguage(new Language().getLoginPaneLanguage());
    }


}
