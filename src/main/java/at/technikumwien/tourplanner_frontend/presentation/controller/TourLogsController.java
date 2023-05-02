package at.technikumwien.tourplanner_frontend.presentation.controller;

import at.technikumwien.tourplanner_frontend.model.TourLog;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourLogsViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TourLogsController implements Initializable {
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

    private TourLogsViewModel tourLogsViewModel = ViewModelFactory.INSTANCE.getTourLogsViewModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewTourLogs.setItems(tourLogsViewModel.getTourLogs());
        formatTableCells();
    }

    private void formatTableCells() {
        tvDate.setCellValueFactory(new PropertyValueFactory<TourLog, String>("comment"));
        tvDuration.setCellValueFactory(new PropertyValueFactory<TourLog, String>("difficulty"));
        tvDistance.setCellValueFactory(new PropertyValueFactory<TourLog, String>("rating"));
        /*
        tvDate.setCellValueFactory(tourLog -> new SimpleStringProperty(tourLog.getValue().getComment()));
        tvDuration.setCellValueFactory(tourLog -> new SimpleStringProperty(tourLog.getValue().getDifficulty()));
        tvDistance.setCellValueFactory(tourLog -> new SimpleStringProperty(tourLog.getValue().getTime_stamp()));
        */
    }
}