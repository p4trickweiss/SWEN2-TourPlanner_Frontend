package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.model.NewTourLog;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import javafx.beans.property.SimpleStringProperty;

public class TourInfoViewModel {

    private final SimpleStringProperty tour_from = new SimpleStringProperty();
    private final SimpleStringProperty tour_to = new SimpleStringProperty();
    private final SimpleStringProperty transport_type = new SimpleStringProperty();
    private final SimpleStringProperty tour_description = new SimpleStringProperty();

    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty estimated_time = new SimpleStringProperty();
    private final SimpleStringProperty tour_distance = new SimpleStringProperty();
    private final SimpleStringProperty imagePath = new SimpleStringProperty();



    private final SimpleStringProperty time_stamp = new SimpleStringProperty();
    private final SimpleStringProperty comment = new SimpleStringProperty();
    private final SimpleStringProperty difficulty = new SimpleStringProperty();
    private final SimpleStringProperty total_time = new SimpleStringProperty();
    private final SimpleStringProperty rating = new SimpleStringProperty();


    public TourInfoViewModel() {

    }

    public void changeTourDetails(Tour currentTour) {
        tour_from.set(currentTour.getTour_from());
        tour_to.set(currentTour.getTour_to());
        transport_type.set(currentTour.getTransport_type());
        name.set(currentTour.getName());
        estimated_time.set(currentTour.getEstimated_time());
        tour_distance.set(currentTour.getTour_distance());
        tour_description.set(currentTour.getTour_description());
        imagePath.set(currentTour.getRoute_information());
    }

    public void changeMisc(TourLog tourLog) {
        time_stamp.set(tourLog.getTime_stamp());
        comment.set(tourLog.getComment());
        difficulty.set(tourLog.getDifficulty());
        total_time.set(tourLog.getTotal_time());
        rating.set(tourLog.getRating().toString());
    }


    public String getTour_from() {
        return tour_from.get();
    }

    public SimpleStringProperty tour_fromProperty() {
        return tour_from;
    }

    public String getTour_to() {
        return tour_to.get();
    }

    public SimpleStringProperty tour_toProperty() {
        return tour_to;
    }

    public String getTransport_type() {
        return transport_type.get();
    }

    public SimpleStringProperty transport_typeProperty() {
        return transport_type;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getEstimated_time() {
        return estimated_time.get();
    }

    public SimpleStringProperty estimated_timeProperty() {
        return estimated_time;
    }

    public String getTour_distance() {
        return tour_distance.get();
    }

    public SimpleStringProperty tour_distanceProperty() {
        return tour_distance;
    }

    public String getTour_description() {
        return tour_description.get();
    }

    public SimpleStringProperty tour_descriptionProperty() {
        return tour_description;
    }

    public String getImagePath() {
        return imagePath.get();
    }

    public SimpleStringProperty imagePathProperty() {
        return imagePath;
    }


    public String getTime_stamp() {
        return time_stamp.get();
    }

    public SimpleStringProperty time_stampProperty() {
        return time_stamp;
    }

    public String getComment() {
        return comment.get();
    }

    public SimpleStringProperty commentProperty() {
        return comment;
    }

    public String getDifficulty() {
        return difficulty.get();
    }

    public SimpleStringProperty difficultyProperty() {
        return difficulty;
    }

    public String getTotal_time() {
        return total_time.get();
    }

    public SimpleStringProperty total_timeProperty() {
        return total_time;
    }

    public String getRating() {
        return rating.get();
    }

    public SimpleStringProperty ratingProperty() {
        return rating;
    }
}
