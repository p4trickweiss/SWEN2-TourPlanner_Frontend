package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.EditTourViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourInfoViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourListViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class TourListController implements Initializable {
    private static Logger logger = LogManager.getLogger(TourListController.class);
    @FXML
    public ListView<Tour> listViewTours;
    @FXML
    public Button btnAddTour;
    @FXML
    public Button btnDeleteTour;
    @FXML
    public Button btnEditTour;
    @FXML
    public Button btnExportTour;

    private Tour currentTour;

    private final TourListViewModel tourListViewModel = ViewModelFactory.INSTANCE.getTourListViewModel();

    // Für Unit-Test

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.info("TourListController init");

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
                tourListViewModel.changeLogs();
            }
        });
    }

    @FXML
    private void deleteTour() {
        tourListViewModel.deleteTour(currentTour);
        listViewTours.getSelectionModel().selectFirst();
    }

    @FXML
    private void addTour(){
        tourListViewModel.addTour();
    }

    @FXML
    private void editTour() {
        tourListViewModel.editTour();
    }

    @FXML
    private void exportTours(){
        tourListViewModel.exportTourData();
    }
}
