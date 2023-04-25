package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class TourLogsViewModel {
    private ObservableList<TourLog> tourLogs;

    private final TourPlannerManager manager;

    public TourLogsViewModel() {
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
        this.tourLogs = FXCollections.observableArrayList();
    }

    public ObservableList<TourLog> getTourLogs() {
        tourLogs.clear();
        List<Tour> tours = manager.getTours();
        tourLogs.addAll(tours.get(0).getTourLogs());
        return tourLogs;
    }
}
