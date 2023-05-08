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
    private ObservableList<TourLog> tourLogs;
    private final TourPlannerManager manager;

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
        System.out.println(this.tourLogs.size());
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

    public void editTourLog(){
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
            System.out.printf("Cant load new window");
        }
    }
}
