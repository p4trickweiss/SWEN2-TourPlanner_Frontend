package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourLogsViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class TourLogsController implements Initializable {
    private static Logger logger = LogManager.getLogger(TourLogsController.class);

    @FXML
    public Button btnAddTourLog;
    @FXML
    public Button btnDeleteTourLog;
    @FXML
    public Button btnEditTourLog;
    @FXML
    public TableView<TourLog> tableViewTourLogs;
    @FXML
    public TableColumn<TourLog, String> tvDate;
    @FXML
    public TableColumn<TourLog, String> tvDuration;
    @FXML
    public TableColumn<TourLog, String> tvDistance;

    private TourLog currentTourLog;

    private final TourLogsViewModel tourLogsViewModel = ViewModelFactory.INSTANCE.getTourLogsViewModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.info("TourLogsController init");

        tableViewTourLogs.setItems(tourLogsViewModel.getTourLogs());
        formatTableCells();

        setCurrentItem();
    }

    private void formatTableCells() {
        tvDate.setCellValueFactory(new PropertyValueFactory<>("comment"));
        tvDuration.setCellValueFactory(new PropertyValueFactory<>("difficulty"));
        tvDistance.setCellValueFactory(new PropertyValueFactory<>("rating"));
    }

    private void setCurrentItem() {
        tableViewTourLogs.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if ((newValue != null) && (oldValue != newValue)) {
                currentTourLog = newValue;
                tourLogsViewModel.changeMisc(currentTourLog);
            }
        });
    }

    @FXML
    public void addTourLog(){
        tourLogsViewModel.addTourLog();
    }

    @FXML
    public void editTourLog(){
        tourLogsViewModel.editTourLog(currentTourLog);
    }

    @FXML
    public void deleteTourLog() {
        tourLogsViewModel.deleteTourLog(currentTourLog);
    }
}
