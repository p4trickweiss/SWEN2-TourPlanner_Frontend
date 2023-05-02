package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.model.Tour;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AddTourViewModel {
    private final TourPlannerManager manager;

    public AddTourViewModel() {
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
    }

    public void addTour(Tour newTour) { manager.addTour(newTour); }
}
