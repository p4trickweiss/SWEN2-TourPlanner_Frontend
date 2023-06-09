package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.Main;
import at.technikumwien.tourplanner_frontend.businesslayer.export.ExportTours;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerImpl;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.presentation.controller.AddTourController;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;

public class TourListViewModel {
    private static Logger logger = LogManager.getLogger(AddTourController.class);

    private final ObservableList<Tour> tours;
    //private Tour currentTour;
    private SimpleObjectProperty<Tour> currentTour = new SimpleObjectProperty<>();
    private final TourLogsViewModel tourLogsViewModel;


    private TourPlannerManager manager;

    public TourListViewModel() {
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
        tourLogsViewModel = ViewModelFactory.INSTANCE.getTourLogsViewModel();
        this.tours = FXCollections.observableArrayList();
    }

    public void setCurrentTour(Tour currentTour) {
        this.currentTour.set(currentTour);
    }

    public Tour getCurrentTour(){
        return this.currentTour.get();
    }

    public SimpleObjectProperty<Tour> currentTourProperty(){
        return this.currentTour;
    }

    public void changeLogs() {
        this.tourLogsViewModel.changeTourLogs(currentTour.get());
    }

    public ObservableList<Tour> getTours() {
        this.updateTourList();
        return tours;
    }

    public void updateTourList() {
        tours.clear();
        tours.addAll(manager.getTours());
        try{
            if(currentTour.get() != null){
                currentTour.set(manager.getTours().stream().filter(e -> e.getId() == currentTour.get().getId()).findFirst().get());
            }
        } catch (Exception e){
            logger.warn(e.getMessage());
        }

    }

    public void deleteTour(Tour currentTour) {
        manager.deleteTour(currentTour);
        this.updateTourList();
    }

    public void setManager(TourPlannerManager manager) {
        this.manager = manager;
    }

    public void exportTourData() {
        ExportTours.exportTours(tours);
    }

    public void addTour() {
       try{
           URL fxmlLocation = Main.class.getResource("addTour.fxml");
           FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
           Parent root1 = fxmlLoader.load();
           Stage stage = new Stage();

           stage.setTitle("Add Tour");
           stage.setScene(new Scene(root1));
           stage.show();
       } catch (Exception e) {
           logger.error(e.getMessage());
       }
   }

   public void editTour() {
       try{
           URL fxmlLocation = Main.class.getResource("EditTour.fxml");
           FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
           Parent root1 = fxmlLoader.load();
           Stage stage = new Stage();

           stage.setTitle("Edit Tour");
           stage.setScene(new Scene(root1));
           stage.show();
       } catch (Exception e) {
           logger.error(e.getMessage());
       }
   }
}
