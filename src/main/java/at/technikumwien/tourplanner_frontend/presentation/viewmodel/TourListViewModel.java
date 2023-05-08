package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.Main;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.model.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class TourListViewModel {
    private final ObservableList<Tour> tours;
    private Tour currentTour;
    private TourLogsViewModel tourLogsViewModel;
    private EditTourViewModel editTourViewModel;
    private final TourPlannerManager manager;

    public TourListViewModel() {
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
        tourLogsViewModel = ViewModelFactory.INSTANCE.getTourLogsViewModel();
        editTourViewModel = ViewModelFactory.INSTANCE.getEditTourViewModel();
        this.tours = FXCollections.observableArrayList();
    }

    public void setCurrentTour(Tour currentTour) {
        this.currentTour = currentTour;
    }

    public void changeLogs() {
        this.tourLogsViewModel.changeTourLogs(currentTour);
    }

    public ObservableList<Tour> getTours() {
        tours.clear();
        tours.addAll(manager.getTours());
        return tours;
    }

    public void updateTourList() {
        tours.clear();
        tours.addAll(manager.getTours());
    }

    public void deleteTour(Tour currentTour) {
        manager.deleteTour(currentTour);
    }

   public void addTour() {
       try{
           URL fxmlLocation = Main.class.getResource("addTour.fxml");
           FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();

           stage.setTitle("Add Tour");
           stage.setScene(new Scene(root1));
           stage.show();
       } catch (Exception e) {
           System.out.printf(e.getMessage());
           System.out.println("Cant load new window");
       }
   }

   public void editTour() {
        editTourViewModel.currentTourProperty().setValue(currentTour);
       try{
           URL fxmlLocation = Main.class.getResource("EditTour.fxml");
           FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();

           stage.setTitle("Edit Tour");
           stage.setScene(new Scene(root1));
           stage.show();
       } catch (Exception e) {
           System.out.printf(e.getMessage());
           System.out.println("Cant load new window");
       }
   }
}
