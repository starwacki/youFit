package controllers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class SceneSwitcherController {
    private Scene scene;
    private static final String MAIN_PANE_FILE_PATH = "/fxml/mainPane.fxml";
    private static final String BREAKFAST_EDIT_PANE_FILE_PATH = "/fxml/mainEditPanes/breakfastMainEditPane.fxml";
    private static final String BRUNCH_EDIT_PANE_FILE_PATH = "/fxml/mainEditPanes/brunchMainEditPane.fxml";
    private static final String LUNCH_EDIT_PANE_FILE_PATH = "/fxml/mainEditPanes/lunchMainEditPane.fxml";

    private static final String SUPPER_EDIT_PANE_FILE_PATH = "/fxml/mainEditPanes/supperMainEditPane.fxml";
    public void switchToMainPane(Stage stage)  {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(MAIN_PANE_FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToBreakfastEditPane(Stage stage) {
        switchScene(stage,BREAKFAST_EDIT_PANE_FILE_PATH);
    }
    public void switchToBrunchEditPane(Stage stage) {
        switchScene(stage,BRUNCH_EDIT_PANE_FILE_PATH);
    }
    public void switchToLunchEditPane(Stage stage) {
        switchScene(stage,LUNCH_EDIT_PANE_FILE_PATH);
    }
    public void switchToSupperEditPane(Stage stage) {
      switchScene(stage,SUPPER_EDIT_PANE_FILE_PATH);
    }
    private void switchScene(Stage stage,String filePath) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

