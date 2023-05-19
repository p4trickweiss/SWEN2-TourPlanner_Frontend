package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.presentation.viewmodel.EditTourLogViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class EditTourLogController implements Initializable {
    private static Logger logger = LogManager.getLogger(EditTourController.class);

    public TextField comment;
    @FXML
    public TextField difficulty;
    @FXML
    public TextField rating;
    @FXML
    public TextField total_time;

    private final EditTourLogViewModel editTourLogViewModel = ViewModelFactory.INSTANCE.getEditTourLogViewModel();

    public EditTourLogController(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        logger.info("EditTourLogController created");

        /*
        comment.textProperty().bindBidirectional(editTourLogViewModel.commentProperty());
        difficulty.textProperty().bindBidirectional(editTourLogViewModel.difficultyProperty());
        rating.textProperty().bindBidirectional(editTourLogViewModel.ratingProperty());
        total_time.textProperty().bindBidirectional(editTourLogViewModel.total_timeProperty());
         */
        // Current Item missing
    }

    @FXML
    public void editTourLogAction(){
        editTourLogViewModel.editTour();
    }
}
