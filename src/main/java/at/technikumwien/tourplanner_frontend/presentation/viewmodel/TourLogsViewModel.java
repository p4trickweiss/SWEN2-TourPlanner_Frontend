package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.Main;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class TourLogsViewModel {
    private final ObservableList<TourLog> tourLogs;
    private TourLog currentTourLog;
    private final TourPlannerManager manager;

    private final TourInfoViewModel tourInfoViewModel = ViewModelFactory.INSTANCE.getTourInfoViewModel();

    public TourLogsViewModel() {
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
        this.tourLogs = FXCollections.observableArrayList();
    }

    public ObservableList<TourLog> getTourLogs() {
        return this.tourLogs;
    }

    public void changeTourLogs(Tour currentTour) {
        this.tourLogs.clear();
        this.tourLogs.addAll(currentTour.getTourLogs());
    }

    public void changeMisc(TourLog currentTourLog){
        this.tourInfoViewModel.changeMisc(currentTourLog);
    }

    public void addTourLog(){
        try{
            URL fxmlLocation = Main.class.getResource("addTourLog.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setTitle("Add TourLog");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.printf(e.getMessage());
            System.out.printf("Cant load new window");
        }
    }

    public void editTourLog(TourLog tourLog){
        try{
            this.currentTourLog = tourLog;
            URL fxmlLocation = Main.class.getResource("editTourLog.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setTitle("Edit TourLog");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.printf(e.getMessage());
            System.out.printf("Cant load new window");
        }
    }

    public void deleteTourLog(TourLog currentTourLog) {
        manager.deleteTourLog(currentTourLog);
    }
}
