package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.MainWindowViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.text.View;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private static Logger logger = LogManager.getLogger(MainWindowController.class);
    private TourPlannerManager manager;

    public MainWindowController() {}

    private final MainWindowViewModel mainWindowViewModel = ViewModelFactory.INSTANCE.getMainWindowViewModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.info("MainWindowController init");

        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
    }

    @FXML
    public void openExportPopup(){
        mainWindowViewModel.openExportPopup();
    }

}
