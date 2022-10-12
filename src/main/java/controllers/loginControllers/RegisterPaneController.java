package controllers.loginControllers;

import controllers.SceneSwitcherController;
import dao.QueryExecutor;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.language.Language;
import model.language.RegisterPaneLanguage;

public class RegisterPaneController {
    private static final String EMPTY_FIELD = "";
    private static final int MINIMUM_USERNAME_LENGTH = 5;
    private static final int MAXIMUM_USERNAME_LENGTH = 20;
    private static final int MINIMUM_PASSWORD_LENGTH = 5;
    private static final int MAXIMUM_PASSWORD_LENGTH = 20;
    private static final int MINIMUM_EMAIL_LENGTH = 5;
    private static final int MAXIMUM_EMAIL_LENGTH = 60;
    private static  String USERNAME_OR_EMAIL_ERROR = "USERNAME OR EMAIL ERROR";
    private static  String PASSWORD_ERROR = "PASSWORD ERROR";
    private static  String EMAIL_LOGIN_EXIST_ERROR = "EMAIL LOGIN EXIST ERROR";
    private static  String EMPTY_TEXT_FIELD_ERROR = "EMPTY TEXT FIELD ERROR";

    @FXML
    private PasswordField passwordTextFieldController;

    @FXML
    private Button haveAccountController;

    @FXML
    private Button registerButtonLabelController;

    @FXML
    private Label registerInLabelController;

    @FXML
    private TextField usernameTextFieldController;

    @FXML
    private TextField emailTextFieldController;

    @FXML
    private DatePicker dateOfBirthDatePickerController;

    @FXML
    private Label errorTextFieldController;

    public void initialize() {
        setLanguage(new Language().getRegisterPaneLanguage());
        changeToLoginScene();
        registerByClickedButton();
        blockAllIncorrectTextFieldValues();

    }
    private void setLanguage(RegisterPaneLanguage language) {
        passwordTextFieldController.setPromptText(language.getPasswordTextFieldController());
        haveAccountController.setText(language.getHaveAccountController());
        registerButtonLabelController.setText(language.getRegisterButtonLabelController());
        registerInLabelController.setText(language.getRegisterInLabelController());
        usernameTextFieldController.setPromptText(language.getUsernameTextFieldController());
        USERNAME_OR_EMAIL_ERROR = language.getUsernameOrEmailError();
        EMAIL_LOGIN_EXIST_ERROR = language.getEmailLoginExistError();
        PASSWORD_ERROR = language.getPasswordError();
        EMPTY_TEXT_FIELD_ERROR = language.getEmptyTextFieldError();

    }

    private void changeToLoginScene() {
        haveAccountController.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent ->
                new SceneSwitcherController().switchToLoginPane(thisStage()));
    }
    private Stage thisStage() {
        return (Stage) haveAccountController.getScene().getWindow();
    }
    private void blockIncorrectDatePickerValues(){
        dateOfBirthDatePickerController.setEditable(false);
    }
    private boolean isTextFieldEmpty(TextField textField) {
        if(textField == null) return true;
        else return textField.getText().equals(EMPTY_FIELD);
    }
    private void blockAllIncorrectTextFieldValues() {
        blockIncorrectTextFieldValues(usernameTextFieldController);
        blockIncorrectTextFieldValues(passwordTextFieldController);
        blockIncorrectDatePickerValues();
    }
    private void blockIncorrectTextFieldValues(TextField textField) {
        textField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue.matches("\\w*")) {
                textField.setText(oldValue);
            }
        });
    }
    private boolean areTextFieldsEmpty(){
        return  isTextFieldEmpty(usernameTextFieldController) || isTextFieldEmpty(passwordTextFieldController) ||
                isTextFieldEmpty(emailTextFieldController) || isTextFieldEmpty(dateOfBirthDatePickerController.getEditor());

    }
    private void registerByClickedButton() {
        registerButtonLabelController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> register()
                );
    }
    private void register() {
        if (!areTextFieldsEmpty()) {
            if (isUsernameCorrect() && isEmailCorrect()) {
               if (isPasswordCorrect()) {
                  if (!isUsernameOrEmailExist()) {
                      registerNewUser();
                      clearFields();
                   } else setErrorTextFieldController(EMAIL_LOGIN_EXIST_ERROR);
               } else setErrorTextFieldController(PASSWORD_ERROR);
            } else setErrorTextFieldController(USERNAME_OR_EMAIL_ERROR);
        } else setErrorTextFieldController(EMPTY_TEXT_FIELD_ERROR);
    }
    private boolean isUsernameCorrect() {
        return  usernameTextFieldController.getText().length() >= MINIMUM_USERNAME_LENGTH &&
                usernameTextFieldController.getText().length() <= MAXIMUM_USERNAME_LENGTH;
    }
    private boolean isUsernameOrEmailExist() {
        return   QueryExecutor.isUsernameInBase(usernameTextFieldController.getText()) ||
                 QueryExecutor.isEmailInBase(emailTextFieldController.getText());
    }
    private boolean isPasswordCorrect() {
       return  passwordTextFieldController.getText().length() >= MINIMUM_PASSWORD_LENGTH &&
               passwordTextFieldController.getText().length() <= MAXIMUM_PASSWORD_LENGTH;
    }
    private boolean isEmailCorrect() {
        return  emailTextFieldController.getText().length() >= MINIMUM_EMAIL_LENGTH &&
                emailTextFieldController.getText().length() <= MAXIMUM_EMAIL_LENGTH;

    }
    private void setErrorTextFieldController(String text) {
        errorTextFieldController.setOpacity(1);
        errorTextFieldController.setText(text);
    }
    private void registerNewUser() {
        QueryExecutor.registerNewUser(usernameTextFieldController.getText(), passwordTextFieldController.getText(),
                emailTextFieldController.getText(), dateOfBirthDatePickerController.getValue());
    }
    private void clearFields() {
        errorTextFieldController.setOpacity(0);
        usernameTextFieldController.clear();
        emailTextFieldController.clear();
        passwordTextFieldController.clear();
        dateOfBirthDatePickerController.getEditor().clear();

    }

}
