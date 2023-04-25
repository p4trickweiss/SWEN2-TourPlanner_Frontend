package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.model.Tour;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TourListViewModel {
    private final ObservableList<Tour> tours;
    private Tour currentTour;
    private TourLogsViewModel tourLogsViewModel;
    private final TourPlannerManager manager;

    public TourListViewModel() {
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
        tourLogsViewModel = new TourLogsViewModel();
        this.tours = FXCollections.observableArrayList();
    }

    public void setCurrentTour(Tour currentTour) {
        this.currentTour = currentTour;
    }

    public void changeLogs() {
        this.tourLogsViewModel.changeTourLogs(currentTour);
    }

    public ObservableList<Tour> getTours() {
        tours.clear();
        tours.addAll(manager.getTours());
        return tours;
    }

    public void deleteTour(Tour currentTour) {
        manager.deleteTour(currentTour);
    }
}
