package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.model.NewTour;
import at.technikumwien.tourplanner_frontend.model.NewTourLog;

public class AddTourLogViewModel {
    private final TourPlannerManager manager;

    public AddTourLogViewModel() {
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
    }

    public void addTourLog(NewTourLog newTourLog) { manager.addTourLog(newTourLog); }
}
