package controllers.loginControllers;

import controllers.SceneSwitcherController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.language.Language;
import model.language.LoginPaneLanguage;
import model.language.RegisterPaneLanguage;

public class RegisterPaneController {

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

    public void initialize() {
        setLanguage(new Language().getRegisterPaneLanguage());
        changeToLoginScene();
        blockIncorrectDatePickerValues();
    }
    private void setLanguage(RegisterPaneLanguage language) {
        passwordTextFieldController.setPromptText(language.getPasswordTextFieldController());
        haveAccountController.setText(language.getHaveAccountController());
        registerButtonLabelController.setText(language.getRegisterButtonLabelController());
        registerInLabelController.setText(language.getRegisterInLabelController());
        usernameTextFieldController.setPromptText(language.getUsernameTextFieldController());
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

}
