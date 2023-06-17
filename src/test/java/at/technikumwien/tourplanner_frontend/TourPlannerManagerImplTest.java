package at.technikumwien.tourplanner_frontend;

import at.technikumwien.tourplanner_frontend.businesslayer.http.HttpRequestBackend;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerImpl;
import at.technikumwien.tourplanner_frontend.model.NewTour;
import at.technikumwien.tourplanner_frontend.model.NewTourLog;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TourPlannerManagerImplTest {

    private TourPlannerManagerImpl tourPlannerManager;
    private HttpRequestBackend httpRequestBackend;
    private HttpResponse<String> response;

    @BeforeEach
    void setUp() {
        httpRequestBackend = mock(HttpRequestBackend.class);
        response = mock(HttpResponse.class);

        tourPlannerManager = new TourPlannerManagerImpl(httpRequestBackend);
    }

    @Test
    void getTours_SuccessfulResponse_ReturnsTourList() throws Exception {
        // Arrange
        List<Tour> expectedTours = new ArrayList<>();
        expectedTours.add(new Tour());
        when(httpRequestBackend.sendGetRequest("tour")).thenReturn(response);
        when(response.body()).thenReturn("[{\"id\":1,\"name\":\"Tour 1\"}]");

        // Act
        List<Tour> tours = tourPlannerManager.getTours();

        // Assert
        verify(httpRequestBackend, times(1)).sendGetRequest("tour");
        assertEquals(expectedTours.size(), tours.size());
    }

    @Test
    void getTours_ExceptionThrown_ReturnsEmptyTourList() throws Exception {
        // Arrange
        when(httpRequestBackend.sendGetRequest("tour")).thenThrow(new RuntimeException());

        // Act
        List<Tour> tours = tourPlannerManager.getTours();

        // Assert
        verify(httpRequestBackend, times(1)).sendGetRequest("tour");
        assertNotNull(tours);
        assertTrue(tours.isEmpty());
    }

    @Test
    void deleteTour_ValidTour_CallsDeleteRequest() throws Exception {
        // Arrange
        Tour tour = new Tour();
        tour.setId(1L);

        // Act
        tourPlannerManager.deleteTour(tour);

        // Assert
        verify(httpRequestBackend, times(1)).sendDeleteRequest("tour/1");
    }

    // Weitere Tests für die anderen Methoden des Managers

}
