package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.model.NewTourLog;
import at.technikumwien.tourplanner_frontend.model.Tour;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AddTourLogViewModel {
    private final SimpleStringProperty comment = new SimpleStringProperty();
    private final SimpleStringProperty difficulty = new SimpleStringProperty();
    private final SimpleIntegerProperty rating = new SimpleIntegerProperty();
    private final SimpleStringProperty total_time = new SimpleStringProperty();
    private final TourListViewModel tourListViewModel;
    private final TourLogsViewModel tourLogsViewModel;
    private final TourPlannerManager manager;

    public AddTourLogViewModel() {
        this.tourListViewModel = ViewModelFactory.INSTANCE.getTourListViewModel();
        this.tourLogsViewModel = ViewModelFactory.INSTANCE.getTourLogsViewModel();
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
    }

    public void addTourLog() {
        Tour currentTour = this.tourLogsViewModel.getCurrentTour();
        NewTourLog newTourLog = new NewTourLog(
                comment.get(),
                difficulty.get(),
                total_time.get(),
                rating.get(),
                currentTour.getId()
        );
        manager.addTourLog(newTourLog);
        this.tourListViewModel.updateTourList();
        tourLogsViewModel.updateTourLogs();
    }

    public String getComment() {
        return comment.get();
    }

    public SimpleStringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
    }

    public String getDifficulty() {
        return difficulty.get();
    }

    public SimpleStringProperty difficultyProperty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty.set(difficulty);
    }

    public int getRating() {
        return rating.get();
    }

    public SimpleIntegerProperty ratingProperty() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating.set(rating);
    }

    public String getTotal_time() {
        return total_time.get();
    }

    public SimpleStringProperty total_timeProperty() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time.set(total_time);
    }
}
