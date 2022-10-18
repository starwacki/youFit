package controllers.SettingsPanesControllers;

import dao.QueryExecutor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.language.Language;
import model.language.ProfileLanguage;
import model.user.User;

public class ProfilePaneController {
    private static final int MINIMUM_PASSWORD_LENGTH = 5;
    private static final int MAXIMUM_PASSWORD_LENGTH = 20;
    private static final int VISIBLE_OPACITY =1;
    private static final int INVISIBLE_OPACITY =0;
    private static final String EMPTY_FIELD = "";
    private static  String EMPTY_TEXT_FIELD_ERROR = "EMPTY TEXT FIELD ERROR";
    private static  String INCORRECT_PASSWORD_LENGTH_ERROR = "INCORRECT PASSWORD LENGTH ERROR";
    private static  String NOT_THE_SAME_PASSWORD_ERROR = "INCORRECT PASSWORD LENGTH ERROR";
    @FXML
    private Button changePasswordButtonController;
    @FXML
    private Label changePasswordLabelController;
    @FXML
    private Button changeProfilePhotoButtonController;
    @FXML
    private Label dateOfBirthInfoLabelController;
    @FXML
    private Label dateOfBirthLabelController;
    @FXML
    private Label emailInfoLabelController;
    @FXML
    private Label emailLabelController;
    @FXML
    private Label newPasswordLabelController;
    @FXML
    private PasswordField newPasswordPasswordFieldController;
    @FXML
    private Label oldPasswordLabelController;
    @FXML
    private PasswordField oldPasswordPasswordFieldController;
    @FXML
    private AnchorPane profilPaneAnchorPaneController;
    @FXML
    private ImageView userPhotoImageViewController;
    @FXML
    private Label usernameInfoLabelController;
    @FXML
    private Label usernameLabelController;
    @FXML
    private Label profileInfoTitleLabelController;
    @FXML
    private Label errorLabelController;

    public void initialize() {
        setLanguage(new Language().getProfileLanguage());
        initializeUserLabels();
        blockAllIncorrectTextFieldsValues();
        changePasswordByClickedButton();


    }

    private void setLanguage(ProfileLanguage language) {
        changeProfilePhotoButtonController.setText(language.getChangeProfilePhotoButtonController());
        usernameInfoLabelController.setText(language.getUsernameInfoLabelController());
        emailInfoLabelController.setText(language.getEmailInfoLabelController());
        dateOfBirthInfoLabelController.setText(language.getDateOfBirthInfoLabelController());
        changePasswordLabelController.setText(language.getChangePasswordLabelController());
        oldPasswordLabelController.setText(language.getOldPasswordLabelController());
        newPasswordLabelController.setText(language.getNewPasswordLabelController());
        changePasswordButtonController.setText(language.getChangePasswordButtonController());
        profileInfoTitleLabelController.setText(language.getProfileInfoTitleLabelController());
        EMPTY_TEXT_FIELD_ERROR = language.getEmptyFieldErrorLabelController();
        INCORRECT_PASSWORD_LENGTH_ERROR  = language.getIncorrectLengthErrorLabelController();
        NOT_THE_SAME_PASSWORD_ERROR = language.getNotTheSamePasswordErrorLabelController();
    }

    private void initializeUserLabels() {
        usernameLabelController.setText(User.getNickname());
        emailLabelController.setText(User.getEmail());
        dateOfBirthLabelController.setText(User.getDateOfBirth().toString());
    }

    private void changePasswordByClickedButton() {
        changePasswordButtonController.addEventFilter(MouseEvent.MOUSE_CLICKED,
                mouseEvent -> changeUserPassword());
    }

    private void changeUserPassword() {
        if (oldPasswordPasswordFieldController.getText()!=null && newPasswordPasswordFieldController.getText() !=null) {
            if (!areTextFieldsEmpty()) {
                if (isCorrectPasswordLength()) {
                    if (isCorrectPassword()) {
                        changePassword();
                    } else setErrorLabel(NOT_THE_SAME_PASSWORD_ERROR);
                } else setErrorLabel(INCORRECT_PASSWORD_LENGTH_ERROR);
            } else setErrorLabel(EMPTY_TEXT_FIELD_ERROR);
        }
    }
    private void setErrorLabel(String textLabel) {
        errorLabelController.setOpacity(VISIBLE_OPACITY);
        errorLabelController.setText(textLabel);
    }

    private void changePassword() {
        errorLabelController.setOpacity(INVISIBLE_OPACITY);
        QueryExecutor.changeUserPassword(newPasswordPasswordFieldController.getText());
    }


    private void blockAllIncorrectTextFieldsValues() {
        blockIncorrectTextFieldValues(oldPasswordPasswordFieldController);
        blockIncorrectTextFieldValues(newPasswordPasswordFieldController);
    }

    private void blockIncorrectTextFieldValues(TextField textField) {
        textField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue.matches("\\w*")) {
                textField.setText(oldValue);
            }
        });
    }
    private boolean isCorrectPassword() {
        char[] password = QueryExecutor.getUserPassword(User.getNickname());
        char[] typedPassword = oldPasswordPasswordFieldController.getText().toCharArray();
        if (password.length!=typedPassword.length) return false;
        for (int i = 0; i < password.length ; i++) {
            if (password[i]!=typedPassword[i]) return false;
        }
        return true;
    }
    private boolean isTextFieldEmpty(TextField textField) {
        if(textField == null) return true;
        else return textField.getText().equals(EMPTY_FIELD);
    }
    private boolean areTextFieldsEmpty() {
        return isTextFieldEmpty(oldPasswordPasswordFieldController) || isTextFieldEmpty(newPasswordPasswordFieldController);
    }

    private boolean isCorrectPasswordLength() {
        return newPasswordPasswordFieldController.getText().length() >= MINIMUM_PASSWORD_LENGTH &&
               newPasswordPasswordFieldController.getText().length() < MAXIMUM_PASSWORD_LENGTH;
    }

}
