package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.presentation.viewmodel.EditTourLogViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourListViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourLogsViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import at.technikumwien.tourplanner_frontend.presentation.controller.IntFilter;

import javax.swing.text.View;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;


public class EditTourLogController implements Initializable {
    private static Logger logger = LogManager.getLogger(EditTourController.class);

    public TextField comment;
    @FXML
    public ComboBox difficulty;
    @FXML
    public TextField rating;
    @FXML
    public TextField total_time;

    private final EditTourLogViewModel editTourLogViewModel = ViewModelFactory.INSTANCE.getEditTourLogViewModel();
    private final IntFilter intFilter = IntFilter.INSTANCE;

    public EditTourLogController(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        logger.info("EditTourLogController created");

        comment.textProperty().bindBidirectional(editTourLogViewModel.commentProperty());
        difficulty.valueProperty().bindBidirectional(editTourLogViewModel.difficultyProperty());
        rating.textProperty().bindBidirectional(editTourLogViewModel.ratingProperty());
        total_time.textProperty().bindBidirectional(editTourLogViewModel.total_timeProperty());

        rating.setTextFormatter(new TextFormatter<>(intFilter.getRatingFilter()));
        total_time.setTextFormatter(new TextFormatter<>(intFilter.getNumericFilter()));
    }

    @FXML
    public void editTourLogAction(){
        editTourLogViewModel.editTour();
    }

}
