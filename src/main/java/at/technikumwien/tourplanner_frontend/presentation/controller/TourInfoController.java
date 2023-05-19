package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourInfoViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.URL;
import java.util.ResourceBundle;


public class TourInfoController implements Initializable {
    private static Logger logger = LogManager.getLogger(TourInfoController.class);

    @FXML
    public ColumnConstraints textWidth;
    @FXML
    public ImageView imageView;
    @FXML
    public Text tour_description;
    @FXML
    public Text tour_distance;
    @FXML
    public Text tour_from;
    @FXML
    public Text tour_to;
    @FXML
    public Text transport_type;
    @FXML
    public Text time_stamp;
    @FXML
    public Text comment;
    @FXML
    public Text difficulty;
    @FXML
    public Text total_time;
    @FXML
    public Text rating;
    @FXML
    private final TourInfoViewModel tourInfoViewModel = ViewModelFactory.INSTANCE.getTourInfoViewModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.info("TourInfoController init");

        //tour_description.wrappingWidthProperty().bind(textWidth.percentWidthProperty());

        //General
        tour_description.textProperty().bindBidirectional(tourInfoViewModel.tour_descriptionProperty());
        tour_distance.textProperty().bindBidirectional(tourInfoViewModel.tour_distanceProperty());
        tour_from.textProperty().bindBidirectional(tourInfoViewModel.tour_fromProperty());
        tour_to.textProperty().bindBidirectional(tourInfoViewModel.tour_toProperty());
        transport_type.textProperty().bindBidirectional(tourInfoViewModel.transport_typeProperty());

        // Image
        imageView.imageProperty().bind(Bindings.createObjectBinding(() -> {
            String imagePath = tourInfoViewModel.imagePathProperty().get();
            if (imagePath != null && !imagePath.isEmpty()) {
                return new Image(imagePath);
            } else {
                return null;
            }
        }, tourInfoViewModel.imagePathProperty()));

        // Misc
        time_stamp.textProperty().bindBidirectional(tourInfoViewModel.time_stampProperty());
        comment.textProperty().bindBidirectional(tourInfoViewModel.commentProperty());
        difficulty.textProperty().bindBidirectional(tourInfoViewModel.difficultyProperty());
        total_time.textProperty().bindBidirectional(tourInfoViewModel.total_timeProperty());
        rating.textProperty().bindBidirectional(tourInfoViewModel.ratingProperty(), java.text.NumberFormat.getIntegerInstance());
    }


}
