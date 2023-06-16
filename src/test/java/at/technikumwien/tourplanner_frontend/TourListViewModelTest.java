package at.technikumwien.tourplanner_frontend;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerImpl;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourInfoViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TourListViewModelTest {

    @Mock
    private TourPlannerManager tourPlannerManager;
    private TourInfoViewModel tourInfoViewModel;
    private TourListViewModel tourListViewModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tourListViewModel = new TourListViewModel();
        tourInfoViewModel = new TourInfoViewModel();
        tourPlannerManager = mock(TourPlannerManager.class);
        tourListViewModel.setManager(tourPlannerManager);
    }

    @Test
    void testGetTours() {
        // Arrange
        List<Tour> expectedTours = Arrays.asList(
                new Tour(),
                new Tour(),
                new Tour()
        );
        ObservableList<Tour> expectedObservableList = FXCollections.observableArrayList(expectedTours);
        when(tourPlannerManager.getTours()).thenReturn(expectedTours);

        // Act
        ObservableList<Tour> actualTours = tourListViewModel.getTours();

        // Assert
        assertNotNull(actualTours);
        assertEquals(expectedObservableList, actualTours);
    }

    @Test
    void testDeleteTour() {
        // Arrange
        List<Tour> tours = Arrays.asList(
                new Tour(),
                new Tour(),
                new Tour()
        );
        when(tourPlannerManager.getTours()).thenReturn(tours);
        Tour tourToDelete = tourListViewModel.getTours().get(0);

        // Act
        tourListViewModel.deleteTour(tourToDelete);

        // Assert
        verify(tourPlannerManager).deleteTour(tourToDelete);
    }

    @Test
    void testEditTour() {
        // Arrange
        List<Tour> tours = Arrays.asList(
                new Tour(),
                new Tour(),
                new Tour()
        );
        when(tourPlannerManager.getTours()).thenReturn(tours);
        Tour tourToDelete = tourListViewModel.getTours().get(0);

        // Act
        tourListViewModel.deleteTour(tourToDelete);

        // Assert
        verify(tourPlannerManager).deleteTour(tourToDelete);
    }


}