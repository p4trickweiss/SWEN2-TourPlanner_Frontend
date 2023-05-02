package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.model.NewTour;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.AddTourViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddTourController implements Initializable {
    @FXML
    public TextField name;
    @FXML
    public TextField tour_from;
    @FXML
    public TextField tour_to;
    //TODO change to dropdown
    @FXML
    public TextField transport_type;
    @FXML
    public TextField tour_description;
    @FXML
    public Button submit_button;

    private final AddTourViewModel addTourViewModel = ViewModelFactory.INSTANCE.getAddTourViewModel();

    public AddTourController(){
        System.out.println("AddTourController created");
    }

    @Override
    public void initialize(URL ulr, ResourceBundle resourceBundle){
        System.out.println("AddTourController created");
    }

    @FXML
    public void addTourAction(){
        NewTour newTour = new NewTour(name.getText(), tour_from.getText(), tour_to.getText(), transport_type.getText(), tour_description.getText());
        addTourViewModel.addTour(newTour);
        //TODO close window
    }

}
