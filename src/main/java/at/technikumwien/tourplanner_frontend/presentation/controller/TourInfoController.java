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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


public class TourInfoController implements Initializable {
    private static Logger logger = LogManager.getLogger(TourInfoController.class);

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

    public TableColumn<Tour, String> time_stamp;
    @FXML
    public TableColumn<Tour, String> comment;
    @FXML
    public TableColumn<Tour, String> difficulty;
    @FXML
    public TableColumn<Tour, String> total_time;
    @FXML
    public TableColumn<Tour, String> rating;
    @FXML
    public TableView<Tour> tableViewMisc;
    private final TourInfoViewModel tourInfoViewModel = ViewModelFactory.INSTANCE.getTourInfoViewModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.info("TourInfoController init");

        tour_description.textProperty().bindBidirectional(tourInfoViewModel.tour_descriptionProperty());
        tour_distance.textProperty().bindBidirectional(tourInfoViewModel.tour_distanceProperty());
        tour_from.textProperty().bindBidirectional(tourInfoViewModel.tour_fromProperty());
        tour_to.textProperty().bindBidirectional(tourInfoViewModel.tour_toProperty());
        transport_type.textProperty().bindBidirectional(tourInfoViewModel.transport_typeProperty());
        //Tabelle befüllen

        // Image anzeigen lassen
        imageView.imageProperty().bind(Bindings.createObjectBinding(() -> {
            String imagePath = tourInfoViewModel.imagePathProperty().get();
            if (imagePath != null && !imagePath.isEmpty()) {
                return new Image(imagePath);
            } else {
                return null;
            }
        }, tourInfoViewModel.imagePathProperty()));

        // Misc-Daten binden
        time_stamp.textProperty().bindBidirectional(tourInfoViewModel.time_stampProperty());
        comment.textProperty().bindBidirectional(tourInfoViewModel.commentProperty());
        difficulty.textProperty().bindBidirectional(tourInfoViewModel.difficultyProperty());
        total_time.textProperty().bindBidirectional(tourInfoViewModel.total_timeProperty());
        rating.textProperty().bindBidirectional(tourInfoViewModel.ratingProperty());
    }


}
