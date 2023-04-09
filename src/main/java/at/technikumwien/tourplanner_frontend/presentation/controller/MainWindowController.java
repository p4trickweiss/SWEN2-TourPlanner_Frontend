package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    private TourPlannerManager manager;

    public MainWindowController() {
        System.out.println("MainWindowController created");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("MainWindowController init");

        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
    }
}
