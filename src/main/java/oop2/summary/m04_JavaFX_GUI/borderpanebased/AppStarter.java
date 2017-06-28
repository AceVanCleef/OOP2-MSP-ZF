package oop2.summary.m04_JavaFX_GUI.borderpanebased;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oop2.summary.m04_JavaFX_GUI.borderpanebased.presentationmodel.RootPM;
import oop2.summary.m04_JavaFX_GUI.borderpanebased.view.RootPane;

/**
 * Created by Degonas on 28.06.2017.
 */
public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        RootPM pm = new RootPM();

        Parent rootPanel = new RootPane(pm);

        Scene scene = new Scene(rootPanel);

        primaryStage.setTitle("");
        primaryStage.setScene(scene);

        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
