package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.model.Tour;

public class EditTourViewModel {
    private TourListViewModel tourListViewModel;
    private final TourPlannerManager manager;

    public EditTourViewModel(){
        tourListViewModel = ViewModelFactory.INSTANCE.getTourListViewModel();
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
    }


    public void editTour(Tour newTour) {manager.editTour(newTour);}
}
