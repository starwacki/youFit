package controllers.SettingsPanesControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.language.Language;
import model.language.ProfileLanguage;
import model.user.User;

public class ProfilePaneController {
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

    public void initialize() {
        setLanguage(new Language().getProfileLanguage());
        initializeUserLabels();

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
    }

    private void initializeUserLabels() {
        usernameLabelController.setText(User.getNickname());
        emailLabelController.setText(User.getEmail());
        dateOfBirthLabelController.setText(User.getDateOfBirth().toString());
    }

}
