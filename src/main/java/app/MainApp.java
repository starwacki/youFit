package app;
import io.LanguageIO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainApp extends Application {

    public static void main(String[] args) {
        LanguageIO.setLanguageApp();
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainPane.fxml"));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UNIFIED);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.setTitle("YouFit!");
        stage.getIcons().add(new Image(getClass().getResource("/img/icon.jpg").toExternalForm()));
        stage.show();


    }
    public void stop() {
        LanguageIO.safeLanguageApp();
    }
}
