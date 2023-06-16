package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.presentation.viewmodel.EditTourViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourInfoViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourListViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditTourController implements Initializable {
    private static Logger logger = LogManager.getLogger(EditTourController.class);

    @FXML
    public TextField name;
    @FXML
    public TextField tour_description;
    @FXML
    public TextField tour_from;
    @FXML
    public TextField tour_to;
    @FXML
    public ComboBox transport_type;

    private final EditTourViewModel editTourViewModel = ViewModelFactory.INSTANCE.getEditTourViewModel();

    public EditTourController(){}

    @Override
    public void initialize(URL ulr, ResourceBundle resourceBundle){
        logger.info("EditTourController created");
        
        name.textProperty().bindBidirectional(editTourViewModel.nameProperty());
        tour_description.textProperty().bindBidirectional(editTourViewModel.tour_descriptionProperty());
        tour_from.textProperty().bindBidirectional(editTourViewModel.tour_fromProperty());
        tour_to.textProperty().bindBidirectional(editTourViewModel.tour_toProperty());
        transport_type.valueProperty().bindBidirectional(editTourViewModel.transport_typeProperty());

    }

    @FXML
    public void editTourAction(){
        editTourViewModel.editTour();
    }
}
