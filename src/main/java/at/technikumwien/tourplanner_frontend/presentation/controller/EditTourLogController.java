package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.presentation.viewmodel.EditTourLogViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.event.KeyEvent;
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

        comment.textProperty().bindBidirectional(editTourLogViewModel.commentProperty());
        difficulty.textProperty().bindBidirectional(editTourLogViewModel.difficultyProperty());
        rating.textProperty().bindBidirectional(editTourLogViewModel.ratingProperty(), java.text.NumberFormat.getIntegerInstance());
        total_time.textProperty().bindBidirectional(editTourLogViewModel.total_timeProperty());
    }

    @FXML
    public void editTourLogAction(){
        editTourLogViewModel.editTour();

    }

    @FXML
    public void handleInput(){
        String inputText = rating.getText();
        try {
            Integer.parseInt(inputText);
        } catch (NumberFormatException e) {
            rating.setText(inputText.replaceAll("[^\\d]", ""));
        }
    }
}
