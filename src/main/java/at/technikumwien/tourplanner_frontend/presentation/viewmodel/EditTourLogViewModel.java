package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerImpl;
import at.technikumwien.tourplanner_frontend.model.NewTourLog;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.swing.text.View;

public class EditTourLogViewModel {

    private final SimpleObjectProperty<TourLog> currentTourLog = new SimpleObjectProperty<>();
    private final SimpleStringProperty comment = new SimpleStringProperty();
    private final SimpleStringProperty difficulty = new SimpleStringProperty();
    private final SimpleIntegerProperty rating = new SimpleIntegerProperty();
    private final SimpleStringProperty total_time = new SimpleStringProperty();
    private final TourPlannerManager manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
    private final TourLogsViewModel tourLogsViewModel = ViewModelFactory.INSTANCE.getTourLogsViewModel();
    private final TourListViewModel tourListViewModel;


    public EditTourLogViewModel(){
        this.tourListViewModel = ViewModelFactory.INSTANCE.getTourListViewModel();

        currentTourLog.addListener((observableValue, oldValue, newValue) -> {
            if(newValue != null){
                comment.set(newValue.getComment());
                difficulty.set(newValue.getDifficulty());
                rating.set(newValue.getRating());
                total_time.set(newValue.getTotal_time());
            }
        });
        currentTourLog.bind(tourLogsViewModel.currentTourLogProperty());
    }

    public void editTour() {
        NewTourLog newTourLog = new NewTourLog(
                comment.get(),
                difficulty.get(),
                total_time.get(),
                rating.get(),
                0L
        );
        this.manager.editTourLog(newTourLog, currentTourLog.get().getId());
        System.out.printf(currentTourLog.get().getId().toString());
        //tourInfoViewModel.updateMisc();
        //tourInfoViewModel.updateTour();
        this.tourListViewModel.updateTourList();
        this.tourLogsViewModel.updateTourLogs();

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
