package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.presentation.viewmodel.AddTourLogViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class AddTourLogController implements Initializable {
    private static Logger logger = LogManager.getLogger(AddTourController.class);

    @FXML
    public TextField comment;
    @FXML
    public TextField difficulty;
    @FXML
    public TextField rating;
    @FXML
    public TextField total_time;
    @FXML
    public Button submit_button;

    private final AddTourLogViewModel addTourLogViewModel = ViewModelFactory.INSTANCE.getAddTourLogViewModel();

    public AddTourLogController(){}

    @Override
    public void initialize(URL ulr, ResourceBundle resourceBundle){
        logger.info("AddTourLogController init");

        comment.textProperty().bindBidirectional(addTourLogViewModel.commentProperty());
        difficulty.textProperty().bindBidirectional(addTourLogViewModel.difficultyProperty());
        rating.textProperty().bindBidirectional(addTourLogViewModel.ratingProperty(), new NumberStringConverter());
        total_time.textProperty().bindBidirectional(addTourLogViewModel.total_timeProperty());
    }

    @FXML
    public void addTourLogAction(){
        addTourLogViewModel.addTourLog();
        //TODO close window
    }



}
