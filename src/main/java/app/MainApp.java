package app;
import dao.DataBaseConnector;
import dao.QueryExecutor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MainApp extends Application {
    public static void main(String[] args) throws SQLException {
        DataBaseConnector.connect();
       ResultSet resultSet = QueryExecutor.executeSelect("SELECT * FROM days");
        resultSet.next();
        System.out.println(resultSet.getString("id"));
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
}
