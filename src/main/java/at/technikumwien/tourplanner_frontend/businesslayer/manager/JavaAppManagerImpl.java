package at.technikumwien.tourplanner_frontend.businesslayer.manager;

import at.technikumwien.tourplanner_frontend.model.Tour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaAppManagerImpl implements JavaAppManager{
    @Override
    public List<Tour> getTours() {
        Tour[] tours = {
                new Tour("Test1"),
                new Tour("Test2"),
                new Tour("Test3"),
                new Tour("Test4")
        };

        return new ArrayList<Tour>(Arrays.asList(tours));
    }
}
