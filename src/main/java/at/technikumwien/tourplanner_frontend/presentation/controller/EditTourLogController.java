package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.model.NewTourLog;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.EditTourLogViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.EditTourViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditTourLogController implements Initializable {
    public TextField comment;
    @FXML
    public TextField difficulty;
    @FXML
    public TextField rating;
    @FXML
    public TextField time_stamp;
    @FXML
    public TextField total_time;
    @FXML
    public Button submit_button;

    private final EditTourLogViewModel editTourLogViewModel = ViewModelFactory.INSTANCE.getEditTourLogViewModel();

    public EditTourLogController(){
        System.out.println("EditTourLogController created");
    }

    @Override
    public void initialize(URL ulr, ResourceBundle resourceBundle){
        // Current Item missing
    }

    @FXML
    public void editTourLogAction(){
        NewTourLog tourLog = new NewTourLog(comment.getText(), difficulty.getText(), rating.getText(), time_stamp.getText(), total_time.getText());
        // id is maybe needed
        editTourLogViewModel.editTour(tourLog);
    }
}
