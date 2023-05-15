package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourInfoViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourListViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


public class TourInfoController implements Initializable {
    @FXML
    public ImageView imageView;

    @FXML
    public TableColumn<Tour, String> tour_description;
    @FXML
    public TableColumn<Tour, String> tour_distance;
    @FXML
    public TableColumn<Tour, String> tour_from;
    @FXML
    public TableColumn<Tour, String> tour_to;
    @FXML
    public TableColumn<Tour, String> transport_type;
    @FXML
    public TableView<Tour> tableViewTourDetails;

    private final TourInfoViewModel tourInfoViewModel = ViewModelFactory.INSTANCE.getTourInfoViewModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tour_description.textProperty().bindBidirectional(tourInfoViewModel.tour_descriptionProperty());
        tour_distance.textProperty().bindBidirectional(tourInfoViewModel.tour_distanceProperty());
        tour_from.textProperty().bindBidirectional(tourInfoViewModel.tour_fromProperty());
        tour_to.textProperty().bindBidirectional(tourInfoViewModel.tour_toProperty());
        transport_type.textProperty().bindBidirectional(tourInfoViewModel.transport_typeProperty());
        //Tabelle befülle

        // Image anzeigen lassen
        imageView.imageProperty().bind(Bindings.createObjectBinding(() -> {
            String imagePath = tourInfoViewModel.imagePathProperty().get();
            if (imagePath != null && !imagePath.isEmpty()) {
                return new Image(imagePath);
            } else {
                return null;
            }
        }, tourInfoViewModel.imagePathProperty()));

    }


}
