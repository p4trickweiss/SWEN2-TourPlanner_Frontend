package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.presentation.viewmodel.AddTourViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.net.URL;
import java.util.ResourceBundle;

public class AddTourController implements Initializable {
    private static Logger logger = LogManager.getLogger(AddTourController.class);

    @FXML
    public TextField name;
    @FXML
    public TextField tour_from;
    @FXML
    public TextField tour_to;
    //TODO change to dropdown
    @FXML
    public ComboBox transport_type;
    @FXML
    public TextField tour_description;
    @FXML
    public Button submit_button;

    private final AddTourViewModel addTourViewModel = ViewModelFactory.INSTANCE.getAddTourViewModel();

    public AddTourController(){}

    @Override
    public void initialize(URL ulr, ResourceBundle resourceBundle){
        logger.info("AddTourController init");

        name.textProperty().bindBidirectional(addTourViewModel.nameProperty());
        tour_description.textProperty().bindBidirectional(addTourViewModel.tour_descriptionProperty());
        tour_from.textProperty().bindBidirectional(addTourViewModel.tour_fromProperty());
        tour_to.textProperty().bindBidirectional(addTourViewModel.tour_toProperty());
        transport_type.valueProperty().bindBidirectional(addTourViewModel.transport_typeProperty());
    }

    @FXML
    public void addTourAction(){
        addTourViewModel.addTour();
        //TODO close window
    }

}
