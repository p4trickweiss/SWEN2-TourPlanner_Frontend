package at.technikumwien.tourplanner_frontend.businesslayer.manager;

import at.technikumwien.tourplanner_frontend.businesslayer.http.HttpRequestBackend;
import at.technikumwien.tourplanner_frontend.model.NewTour;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TourPlannerManagerImpl implements TourPlannerManager {
    private final HttpRequestBackend httpRequestBackend;
    private final ObjectMapper objectMapper;
    private List<Tour> tourList;
    private List<TourLog> tourLogs;

    public TourPlannerManagerImpl() {
        this.httpRequestBackend = new HttpRequestBackend();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public List<Tour> getTours() {
        try {
            HttpResponse<String> response = httpRequestBackend.sendGetRequest("tour");
            this.tourList = objectMapper.readValue(response.body(), objectMapper.getTypeFactory().constructCollectionType(List.class, Tour.class));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            //this.tourList = getDummyTours();
        }
        return this.tourList;
    }

    private List<Tour> getDummyTours() {
        Tour[] tours = {
                new Tour(1L,
                        "Test 1",
                        "Desc",
                        "Start",
                        "End",
                        "Transport Type",
                        "Distance",
                        "Time",
                        "Route",
                        null),
                new Tour(2L,
                        "SWEN 2",
                        "Desc",
                        "Start",
                        "End",
                        "Transport Type",
                        "Distance",
                        "Time",
                        "Route",
                        null),
                new Tour(3L,
                        "Tour XY",
                        "Desc",
                        "Start",
                        "End",
                        "Transport Type",
                        "Distance",
                        "Time",
                        "Route",
                        null),
                new Tour(4L,
                        "TOUR",
                        "Desc",
                        "Start",
                        "End",
                        "Transport Type",
                        "Distance",
                        "Time",
                        "Route",
                        null),
        };
        return new ArrayList<>(Arrays.asList(tours));
    }

    @Override
    public void deleteTour(Tour currentTour) {
        try {
            HttpResponse<String> response = httpRequestBackend.sendDeleteRequest("tour" ,currentTour.getId());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addTour(NewTour tour) {
        try {
            String body = objectMapper.writeValueAsString(tour);
            System.out.println(body);
            HttpResponse<String> response = httpRequestBackend.sendPostRequest("tour", body);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editTour(NewTour tour, Long id) {
        System.out.println("in edit tour");
        try {
            String body = objectMapper.writeValueAsString(tour);
            HttpResponse<String> response = httpRequestBackend.sendPutRequest("tour/" + id.toString(), body);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
