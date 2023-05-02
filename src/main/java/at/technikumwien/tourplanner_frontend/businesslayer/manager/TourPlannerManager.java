package at.technikumwien.tourplanner_frontend.businesslayer.manager;

import at.technikumwien.tourplanner_frontend.model.NewTour;
import at.technikumwien.tourplanner_frontend.model.Tour;

import java.util.List;

public interface TourPlannerManager {
    List<Tour> getTours();
    void deleteTour(Tour currentTour);
    void addTour(NewTour newTour);
    void editTour(Tour newTour);
}
