package at.technikumwien.tourplanner_frontend.businesslayer.manager;

import at.technikumwien.tourplanner_frontend.model.NewTour;
import at.technikumwien.tourplanner_frontend.model.NewTourLog;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;

import java.util.List;

public interface TourPlannerManager {
    List<Tour> getTours();
    void deleteTour(Tour currentTour);
    void addTour(NewTour newTour);
    void editTour(NewTour tour, Long id);
    void addTourLog(NewTourLog newTour);
    void editTourLog(NewTourLog tour, Long id);
    void deleteTourLog(TourLog currentLog);
    void deleteAllTours();
}
