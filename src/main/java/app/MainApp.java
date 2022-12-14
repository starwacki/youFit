package app;
import io.BodyMeasurementsIO;
import io.LanguageIO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.product.ProductBase;

public class MainApp extends Application {

    public static void main(String[] args) {
        ProductBase.initializeProductBase();
        LanguageIO.initializeLanguage();
        BodyMeasurementsIO.initializeBodyMeasurementsBase();
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/loginFXMLS/loginPane.fxml"));
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
        BodyMeasurementsIO.safeBodyMeasurementsBase();
    }
}
