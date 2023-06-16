package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.calculator.StatsCalculator;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.model.Stats;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.swing.text.View;
import java.util.Optional;

public class TourInfoViewModel {



    public TourPlannerManager getManager() {
        return manager;
    }

    private final SimpleObjectProperty<Tour> currentTour = new SimpleObjectProperty<>();
    private final SimpleObjectProperty<TourLog> currentTourLog = new SimpleObjectProperty<>();

    private final SimpleStringProperty tour_from = new SimpleStringProperty();
    private final SimpleStringProperty tour_to = new SimpleStringProperty();
    private final SimpleStringProperty transport_type = new SimpleStringProperty();
    private final SimpleStringProperty tour_description = new SimpleStringProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty estimated_time = new SimpleStringProperty();
    private final SimpleStringProperty tour_distance = new SimpleStringProperty();



    private final SimpleStringProperty avg_difficulty = new SimpleStringProperty();
    private final SimpleFloatProperty avg_time = new SimpleFloatProperty();
    private final SimpleFloatProperty avg_rating = new SimpleFloatProperty();



    private final SimpleIntegerProperty popularity = new SimpleIntegerProperty();
    private final SimpleStringProperty child_friendliness = new SimpleStringProperty();
    private final SimpleStringProperty imagePath = new SimpleStringProperty();


    private final SimpleStringProperty time_stamp = new SimpleStringProperty();
    private final SimpleStringProperty comment = new SimpleStringProperty();
    private final SimpleStringProperty difficulty = new SimpleStringProperty();
    private final SimpleStringProperty total_time = new SimpleStringProperty();
    private final SimpleIntegerProperty rating = new SimpleIntegerProperty();

    private final StatsCalculator statsCalculator = new StatsCalculator();
    private Stats stats;

    private final TourLogsViewModel tourLogsViewModel;
    private final TourListViewModel tourListViewModel;

    private final TourPlannerManager manager;

    public TourInfoViewModel() {

        this.tourLogsViewModel = ViewModelFactory.INSTANCE.getTourLogsViewModel();
        this.tourListViewModel = ViewModelFactory.INSTANCE.getTourListViewModel();

        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
        currentTour.addListener((observableValue, oldValue, newValue) -> {
            if(newValue != null){
                tour_from.set(newValue.getTour_from());
                tour_to.set(newValue.getTour_to());
                transport_type.set(newValue.getTransport_type());
                name.set(newValue.getName());
                estimated_time.set(newValue.getEstimated_time());
                tour_distance.set(newValue.getTour_distance());
                tour_description.set(newValue.getTour_description());
                imagePath.set(newValue.getRoute_information());

                stats = statsCalculator.calculateTourAvg(newValue);
                avg_time.set(stats.getAvg_time());
                avg_difficulty.set(stats.getAvg_difficulty());
                avg_rating.set(stats.getAvg_rating());

                stats = statsCalculator.calculateTourAvg(currentTour.get());
                avg_time.set(stats.getAvg_time());
                avg_difficulty.set(stats.getAvg_difficulty());
                avg_rating.set(stats.getAvg_rating());
                popularity.set(stats.getPopularity());
                child_friendliness.set(stats.getChild_friendliness());
            }
        });

        currentTourLog.addListener((observableValue, oldValue, newValue) -> {
            if(newValue != null){
                time_stamp.set(newValue.getTime_stamp());
                comment.set(newValue.getComment());
                difficulty.set(newValue.getDifficulty());
                total_time.set(newValue.getTotal_time());
                rating.set(newValue.getRating());
            }
        });

        currentTourLog.bind(tourLogsViewModel.currentTourLogProperty());
        currentTour.bind(tourListViewModel.currentTourProperty());
    }

    public void clearMisc(){
        time_stamp.set("");
        comment.set("");
        difficulty.set("");
        total_time.set("");
        rating.set(0);
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

    public int getRating() {
        return rating.get();
    }

    public SimpleIntegerProperty ratingProperty() {
        return rating;
    }
    public Tour getCurrentTour() {
        return currentTour.get();
    }

    public SimpleObjectProperty<Tour> currentTourProperty() {
        return currentTour;
    }

    public TourLog getCurrentTourLog() {
        return currentTourLog.get();
    }

    public SimpleObjectProperty<TourLog> currentTourLogProperty() {
        return currentTourLog;
    }

    public String getAvg_difficulty() {
        return avg_difficulty.get();
    }

    public SimpleStringProperty avg_difficultyProperty() {
        return avg_difficulty;
    }

    public float getAvg_time() {
        return avg_time.get();
    }

    public SimpleFloatProperty avg_timeProperty() {
        return avg_time;
    }

    public float getAvg_rating() {
        return avg_rating.get();
    }

    public SimpleFloatProperty avg_ratingProperty() {
        return avg_rating;
    }

    public int getPopularity() {
        return popularity.get();
    }

    public SimpleIntegerProperty popularityProperty() {
        return popularity;
    }

    public String getChild_friendliness() {
        return child_friendliness.get();
    }

    public SimpleStringProperty child_friendlinessProperty() {
        return child_friendliness;
    }
}
