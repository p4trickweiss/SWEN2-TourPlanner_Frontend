package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.model.NewTourLog;
import at.technikumwien.tourplanner_frontend.model.Tour;

public class EditTourLogViewModel {
    private TourLogsViewModel tourLogsViewModel;
    private final TourPlannerManager manager;

    public EditTourLogViewModel(){
        tourLogsViewModel = ViewModelFactory.INSTANCE.getTourLogsViewModel();
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
    }

    public void editTour(NewTourLog tourLog) {manager.editTourLog(tourLog);}
}
