package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.EditTourViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;


import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditTourController implements Initializable {
    @FXML
    public TextField estimated_time;
    @FXML
    public TextField name;
    @FXML
    public TextField route_information;
    @FXML
    public TextField tour_description;
    @FXML
    public TextField tour_distance;
    @FXML
    public TextField tour_from;
    @FXML
    public TextField tour_to;
    @FXML
    public TextField transport_type;

    private final EditTourViewModel editTourViewModel = ViewModelFactory.INSTANCE.getEditTourViewModel();

    public EditTourController(){
        System.out.println("EditTourController created");
    }

    @Override
    public void initialize(URL ulr, ResourceBundle resourceBundle){
        Tour currentTour = ViewModelFactory.INSTANCE.getTourListViewModel().getCurrentTour();
        estimated_time.setText(currentTour.getEstimated_time());
        name.setText(currentTour.getName());
        route_information.setText(currentTour.getRoute_information());
        tour_description.setText(currentTour.getTour_description());
        tour_distance.setText(currentTour.getTour_distance());
        tour_from.setText(currentTour.getTour_from());
        tour_to.setText(currentTour.getTour_to());
        transport_type.setText(currentTour.getTransport_type());
    }

    @FXML
    public void editTourAction(){
        Tour newTour = new Tour(2L , name.getText(), tour_description.getText(), tour_from.getText(), tour_to.getText(), transport_type.getText(), tour_distance.getText(), estimated_time.getText(), route_information.getText(), new ArrayList<TourLog>());
        editTourViewModel.editTour(newTour);
    }
}
