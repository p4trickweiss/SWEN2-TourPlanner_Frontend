package at.technikumwien.tourplanner_frontend.businesslayer.manager;

import at.technikumwien.tourplanner_frontend.businesslayer.http.HttpRequestBackend;
import at.technikumwien.tourplanner_frontend.model.NewTour;
import at.technikumwien.tourplanner_frontend.model.NewTourLog;
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
            this.tourList = new ArrayList<>();
        }
        return this.tourList;
    }

    @Override
    public void deleteTour(Tour currentTour) {
        try {
            HttpResponse<String> response = httpRequestBackend.sendDeleteRequest("tour/" + currentTour.getId().toString());
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
        try {
            String body = objectMapper.writeValueAsString(tour);
            HttpResponse<String> response = httpRequestBackend.sendPutRequest("tour/" + id.toString(), body);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addTourLog(NewTourLog tourlog){
        System.out.printf("Test");
    }

    @Override
    public void editTourLog(NewTourLog tourlog){
        System.out.printf("Test");
    }

}
