package at.technikumwien.tourplanner_frontend.controller;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.JavaAppManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.JavaAppManagerFactory;
import at.technikumwien.tourplanner_frontend.model.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    private JavaAppManager manager;

    public MainWindowController() {
        System.out.println("Controller created");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Controller init");

        manager = JavaAppManagerFactory.getJavaAppManager();
    }
}
