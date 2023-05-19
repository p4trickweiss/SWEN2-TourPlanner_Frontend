package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ExportTourViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class ExportTourController implements Initializable {
    private static Logger logger = LogManager.getLogger(ExportTourController.class);
    @FXML
    public ComboBox cb;
    @FXML
    public TextField path;
    private final ExportTourViewModel exportTourViewModel = ViewModelFactory.INSTANCE.getExportTourViewModel();

    public ExportTourController(){}

    @Override
    public void initialize(URL ulr, ResourceBundle resourceBundle){
        logger.info("ExportTourController created");
    }

    @FXML
    public void export(){
        if(cb.getValue().toString().equals("Tour")){
            exportTourViewModel.exportSelectedTour(path.getText());
        }
        else if(cb.getValue().toString().equals("Summary")){
            exportTourViewModel.exportSummary(path.getText());
        }
        else{
            logger.warn("Export Type is not set");
        }
    }

}
