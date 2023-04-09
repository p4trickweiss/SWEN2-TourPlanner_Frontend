package at.technikumwien.tourplanner_frontend;

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

public class Controller implements Initializable {
    @FXML
    public ListView<Tour> listViewTours;
    private ObservableList<Tour> tours;
    private JavaAppManager manager;

    public Controller() {
        System.out.println("Controller created");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Controller init");

        manager = JavaAppManagerFactory.getJavaAppManager();

        tours = FXCollections.observableArrayList();
        tours.addAll(manager.getTours());
        listViewTours.setItems(tours);

        // format cells
        listViewTours.setCellFactory((param -> new ListCell<Tour>() {
            @Override
            protected void updateItem(Tour tour, boolean empty) {
                super.updateItem(tour, empty);
                if (empty || tour == null || tour.name() == null) {
                    setText(null);
                } else {
                    setText(tour.name());
                }
            }
        }));
    }
}
