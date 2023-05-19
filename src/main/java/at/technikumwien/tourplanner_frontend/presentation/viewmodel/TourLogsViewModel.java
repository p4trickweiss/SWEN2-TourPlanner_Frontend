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

import javax.swing.text.View;
import java.net.URL;

public class TourLogsViewModel {
    private Tour currentTour;
    private TourLog currentTourLog;
    private final ObservableList<TourLog> tourLogs;
    private final TourPlannerManager manager;
    private final TourInfoViewModel tourInfoViewModel = ViewModelFactory.INSTANCE.getTourInfoViewModel();
    private EditTourLogViewModel editTourLogViewModel;

    public TourLogsViewModel() {
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
        this.tourLogs = FXCollections.observableArrayList();
        this.editTourLogViewModel = ViewModelFactory.INSTANCE.getEditTourLogViewModel();
    }

    public ObservableList<TourLog> getTourLogs() {
        return this.tourLogs;
    }

    public void changeTourLogs(Tour currentTour) {
        this.currentTour = currentTour;
        this.tourLogs.clear();
        this.tourLogs.addAll(currentTour.getTourLogs());
    }

    public void changeMisc(TourLog currentTourLog){
        this.tourInfoViewModel.changeMisc(currentTourLog);
    }

    public void addTourLog(TourLog currentTourLog){

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
            System.out.println("Cant load new window");
        }
    }

    public void setCurrentTourLog(TourLog tourLog){
        this.currentTourLog = tourLog;
    }

    public void editTourLog(){
        editTourLogViewModel.currentTourLogProperty().set(this.currentTourLog);
        try{
            URL fxmlLocation = Main.class.getResource("editTourLog.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setTitle("Edit TourLog");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.printf(e.getMessage());
            System.out.println("Cant load new window");
        }
    }

    public void deleteTourLog(TourLog currentTourLog) {
        manager.deleteTourLog(currentTourLog);
    }

    public Tour getCurrentTour() {
        return currentTour;
    }
}
