package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.model.NewTour;
import at.technikumwien.tourplanner_frontend.model.NewTourLog;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.AddTourLogViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.AddTourViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddTourLogController implements Initializable {
    @FXML
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

    private final AddTourLogViewModel addTourLogViewModel = ViewModelFactory.INSTANCE.getAddTourLogViewModel();

    public AddTourLogController(){
        System.out.println("AddTourLogController created");
    }

    @Override
    public void initialize(URL ulr, ResourceBundle resourceBundle){

    }

    @FXML
    public void addTourLogAction(){
        NewTourLog newTourLog = new NewTourLog(comment.getText(), difficulty.getText(), rating.getText(), time_stamp.getText(), total_time.getText());
        addTourLogViewModel.addTourLog(newTourLog);
        //TODO close window
    }

}