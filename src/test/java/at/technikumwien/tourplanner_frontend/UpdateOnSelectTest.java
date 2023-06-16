package at.technikumwien.tourplanner_frontend;

import at.technikumwien.tourplanner_frontend.model.TourLog;
import at.technikumwien.tourplanner_frontend.presentation.controller.MainWindowController;
import at.technikumwien.tourplanner_frontend.presentation.controller.TourListController;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourInfoViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourListViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.ViewModelFactory;
import at.technikumwien.tourplanner_frontend.model.Tour;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javax.swing.text.View;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.testfx.util.NodeQueryUtils.hasText;

@ExtendWith(ApplicationExtension.class)
class UpdateOnSelectTest {

    private Parent root = null;
    private TourListViewModel tourListViewModelMock;
    private MainWindowController mainWindowController_mock;
    private ObservableList<Tour> dummyTours;

    @Start
    private void start(Stage primaryStage) {

        dummyTours = FXCollections.observableArrayList();
        Tour tour1 = new Tour(0L, "Tour1", "Beschreibung", "Wien", "Krems" , "fastest", "200", "100", "Bild", null);
        dummyTours.add(tour1);


        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainWindow.fxml"));
            this.root = loader.load();

            FXMLLoader List_loader = new FXMLLoader(getClass().getResource("UpdateOnSelectTest"));
            Parent includedList_loader = List_loader.load();

            VBox includedList = (VBox) loader.getNamespace().get("#tourList");

            TourListController tourListController_mock = mock(TourListController.class);

            List_loader.setController(tourListController_mock);

        } catch(IOException e){
            throw new RuntimeException(e);
        }

        primaryStage.setTitle("Hello World");

        // set scene into stage in defined size
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(400);

        // let's go
        primaryStage.show();


        /*try {
            root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // bootstrap "window" named stage
        primaryStage.setTitle("Hello World");

        // set scene into stage in defined size
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(400);

        // let's go
        primaryStage.show();

        TourListViewModel tourListViewModelMock = Mockito.mock(TourListViewModel.class);
        ObservableList<Tour> newtours = FXCollections.observableArrayList();
        Tour tour1 = new Tour(0L, "Tour1", "Beschreibung", "Wien", "Krems" , "fastest", "200", "100", "Bild", null);
        newtours.add(tour1);
        System.out.printf(newtours.get(0).getName());

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                invocationOnMock.getMock().getClass().getDeclaredField("tours").set(invocationOnMock.getMock(), newtours);
                return null;
            }
        }).when(tourListViewModelMock).updateTourList();

        tourListViewModelMock.updateTourList();*/

        this.tourListViewModelMock = Mockito.mock(TourListViewModel.class);

        // Create Dummy-Data

        try{
            Field tourListTours = TourListViewModel.class.getDeclaredField("tours");
            tourListTours.setAccessible(true);
            tourListTours.set(tourListViewModelMock, dummyTours);

        } catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }

    @Test
    void UpdateDetailsOnChange(FxRobot robot){
        TourInfoViewModel tourInfoViewModelMock = Mockito.mock(TourInfoViewModel.class);
        try{
            Field tourInfo_TourListViewModel = TourInfoViewModel.class.getDeclaredField("tourListViewModel");
            tourInfo_TourListViewModel.setAccessible(true);

            tourInfo_TourListViewModel.set(tourInfoViewModelMock, this.tourListViewModelMock);
            when(tourListViewModelMock.getTours()).thenReturn(dummyTours);
            tourListViewModelMock.setCurrentTour(tourListViewModelMock.getTours().get(0));
            System.out.printf(tourListViewModelMock.getCurrentTour().getName());
        } catch (Exception e){
            System.out.printf(e.getMessage());
        }

        assert tourListViewModelMock.getCurrentTour() == tourInfoViewModelMock.getCurrentTour();
    }

    @Test
    void test(FxRobot robot){

    }
}
