package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.model.NewTour;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.AddTourViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ExportTourViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.text.View;
import java.net.URL;
import java.util.ResourceBundle;

public class exportTourController implements Initializable {
    @FXML
    public ComboBox cb;
    @FXML
    public TextField path;
    private final ExportTourViewModel exportTourViewModel = ViewModelFactory.INSTANCE.getExportTourViewModel();

    public exportTourController(){
        System.out.println("ExportTourController created");
    }

    @Override
    public void initialize(URL ulr, ResourceBundle resourceBundle){
        System.out.println("AddTourController created");
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
            System.out.printf("You have to set the export type!");
        }
    }

}
