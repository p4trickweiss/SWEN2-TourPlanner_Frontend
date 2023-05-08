package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TourLogsViewModel {
    private final ObservableList<TourLog> tourLogs;
    private final TourPlannerManager manager;

    public TourLogsViewModel() {
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
        this.tourLogs = FXCollections.observableArrayList();
    }

    public ObservableList<TourLog> getTourLogs() {
        return this.tourLogs;
    }

    public void changeTourLogs(Tour currentTour) {
        this.tourLogs.clear();
        this.tourLogs.addAll(currentTour.getTourLogs());
    }
}
