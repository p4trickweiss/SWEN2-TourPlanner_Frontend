package at.technikumwien.tourplanner_frontend.businesslayer.manager;

import at.technikumwien.tourplanner_frontend.model.Tour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TourPlannerManagerImpl implements TourPlannerManager {
    @Override
    public List<Tour> getTours() {
        // dummy data
        Tour[] tours = {
                new Tour(1,
                        "Test 1",
                        "Desc",
                        "Start",
                        "End",
                        "Transport Type"),
                new Tour(1,
                        "SWEN 2",
                        "Desc",
                        "Start",
                        "End",
                        "Transport Type"),
                new Tour(1,
                        "Tour XY",
                        "Desc",
                        "Start",
                        "End",
                        "Transport Type"),
                new Tour(1,
                        "TOUR",
                        "Desc",
                        "Start",
                        "End",
                        "Transport Type")
        };

        return new ArrayList<>(Arrays.asList(tours));
    }
}
