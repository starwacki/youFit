module com.example.kalkulatorkalorii {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.sql;
    requires java.desktop;



    opens app to javafx.graphics;
    opens controllers to javafx.fxml;
    opens model.product to javafx.base;
    opens model.bodyMeasurements to javafx.base;
    opens controllers.tableViewsControllers to javafx.fxml;
    opens controllers.loginControllers to javafx.fxml;
    exports  controllers.SwitchScenesControllers to javafx.fxml;
    opens controllers.SwitchScenesControllers to javafx.fxml;
    opens controllers.MainPaneComponentsControllers to javafx.fxml;
    opens controllers.SettingsPanesControllers to javafx.fxml;


}