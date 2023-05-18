package at.technikumwien.tourplanner_frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main extends Application {

    private static Logger logger = LogManager.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) throws Exception{
        logger.info("Application started");
        // fxml created with SceneBuilder
        Parent root = FXMLLoader.load(Main.class.getResource("mainWindow.fxml"));
        logger.info("fxml loaded");

        // bootstrap "window" named stage
        primaryStage.setTitle("Tour Planner");
        logger.info("set title");

        // set scene into stage in defined size
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(400);
        logger.info("set scene");

        // let's go
        primaryStage.show();
        logger.info("show stage");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
