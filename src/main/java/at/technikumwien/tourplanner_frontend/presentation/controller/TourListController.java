package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourListViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.event.ActionEvent;
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
    @FXML
    public Button btnDeleteTour;
    @FXML
    public Button btnEditTour;

    private Tour currentTour;

    private final TourListViewModel tourListViewModel = ViewModelFactory.INSTANCE.getTourListViewModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listViewTours.setItems(tourListViewModel.getTours());
        formatCells();

        setCurrentItem();
    }

    private void formatCells() {
        listViewTours.setCellFactory((param -> new ListCell<>() {
            @Override
            protected void updateItem(Tour tour, boolean empty) {
                super.updateItem(tour, empty);
                if (empty || tour == null || tour.getName() == null) {
                    setText(null);
                } else {
                    setText(tour.getName());
                }
            }
        }));
    }

    private void setCurrentItem() {
        listViewTours.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if ((newValue != null) && (oldValue != newValue)) {
                currentTour = newValue;
                tourListViewModel.setCurrentTour(currentTour);
            }
        });
    }

    @FXML
    private void deleteTour(ActionEvent actionEvent) {
        tourListViewModel.deleteTour(currentTour);
        listViewTours.setItems(tourListViewModel.getTours());
    }
}
