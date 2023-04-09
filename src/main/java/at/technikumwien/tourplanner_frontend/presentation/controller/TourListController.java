package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourListViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class TourListController implements Initializable {
    @FXML
    public ListView<Tour> listViewTours;
    @FXML
    public Button btnAddTour;
    @FXML Button btnDeleteTour;
    @FXML Button btnEditTour;

    private final TourListViewModel tourListViewModel = ViewModelFactory.INSTANCE.getTourListViewModel();

    public TourListController() {
        System.out.println("TourListController created");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("TourListController init");

        listViewTours.setItems(tourListViewModel.getTours());

        formatCells();
    }

    private void formatCells() {
        listViewTours.setCellFactory((param -> new ListCell<>() {
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
