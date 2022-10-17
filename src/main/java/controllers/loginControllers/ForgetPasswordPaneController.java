package controllers.loginControllers;
import controllers.SceneSwitcherController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.language.ForgetPasswordPaneLanguage;
import model.language.Language;

public class ForgetPasswordPaneController {

    @FXML
    private TextField emailTextFieldController;
    @FXML
    private Button recoverPasswordButtonController;
    @FXML
    private Label recoverPasswordLabelController;
    @FXML
    private Button signInButtonController;
    @FXML
    private TextField usernameTextFieldController;

    public void initialize() {
        setLanguage(new Language().getForgetPasswordPaneLanguage());
        changeSceneToLoginPane();

    }
    private void setLanguage(ForgetPasswordPaneLanguage language) {
        emailTextFieldController.setPromptText(language.getEmailTextFieldController());
        recoverPasswordButtonController.setText(language.getRecoverPasswordButtonLabelController());
        recoverPasswordLabelController.setText(language.getRecoverPasswordLabelController());
        signInButtonController.setText(language.getSignInButtonController());
        usernameTextFieldController.setPromptText(language.getUsernameTextFieldController());
    }

    private void changeSceneToLoginPane() {
        signInButtonController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> new SceneSwitcherController().switchToLoginPane(thisStage()));
    }
    private Stage thisStage() {
        return (Stage) emailTextFieldController.getScene().getWindow();
    }

}
