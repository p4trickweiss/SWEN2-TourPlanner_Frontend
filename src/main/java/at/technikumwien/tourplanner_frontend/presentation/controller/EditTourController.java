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
    public TextField name;
    @FXML
    public TextField tour_description;
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
        name.textProperty().bindBidirectional(editTourViewModel.nameProperty());
        tour_description.textProperty().bindBidirectional(editTourViewModel.tour_descriptionProperty());
        tour_from.textProperty().bindBidirectional(editTourViewModel.tour_fromProperty());
        tour_to.textProperty().bindBidirectional(editTourViewModel.tour_toProperty());
        transport_type.textProperty().bindBidirectional(editTourViewModel.transport_typeProperty());
    }

    @FXML
    public void editTourAction(){
        editTourViewModel.editTour();
    }
}
