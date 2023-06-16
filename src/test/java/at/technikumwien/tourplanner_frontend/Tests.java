package at.fhtw.highscores;

import at.technikumwien.tourplanner_frontend.businesslayer.calculator.StatsCalculator;
import at.technikumwien.tourplanner_frontend.businesslayer.export.PdfConverter;
import at.technikumwien.tourplanner_frontend.model.Stats;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourInfoViewModel;
import at.technikumwien.tourplanner_frontend.presentation.viewmodel.TourListViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.skin.TableColumnHeader;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.ButtonMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.service.query.impl.NodeQueryImpl;
import org.testfx.util.NodeQueryUtils;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(ApplicationExtension.class)

class Tests {

    private ObservableList<Tour> dummyTours;
    private PdfConverter pdfConverter;

    private StatsCalculator statsCalculator = new StatsCalculator();

    @Start
    private void start(Stage primaryStage) {
        dummyTours = FXCollections.observableArrayList();
        List<TourLog> tourLogList = new ArrayList<>();

        TourLog tourLog1 = new TourLog(0L, "time", "comment", "easy", "12", 3, null);
        TourLog tourLog2 = new TourLog(1L, "time", "comment", "medium", "10", 5, null);

        tourLogList.add(tourLog1);
        tourLogList.add(tourLog2);

        Tour tour1 = new Tour(0L, "Tour1", "Beschreibung", "Wien", "Krems" , "fastest", "8", "100", "Bild", tourLogList);
        Tour tour2 = new Tour(1L, "Tour2", "Beschreibung", "Wien", "Krems" , "fastest", "8", "100", "Bild", null);
        dummyTours.add(tour1);
        dummyTours.add(tour2);

        pdfConverter = new PdfConverter();
    }

    @Test
    void check_calculation(){
        Stats calc = statsCalculator.calculateTourAvg(dummyTours.get(0));
        Stats calculated_stats = new Stats(11, "easy", 4, 2, "child friendly");

        assertEquals(calc.getAvg_difficulty(), calculated_stats.getAvg_difficulty());
        assertEquals(calc.getAvg_time(), calculated_stats.getAvg_time());
        assertEquals(calc.getPopularity(), calculated_stats.getPopularity());
        assertEquals(calc.getChild_friendliness(), calculated_stats.getChild_friendliness());
        assertEquals(calc.getAvg_rating(), calculated_stats.getAvg_rating());
    }

    @Test
    void check_calculation_wihtout_logs(){
        Stats calc = statsCalculator.calculateTourAvg(dummyTours.get(1));
        Stats nullstats = new Stats(0, null, 0, 0, null);

        assertEquals(calc.getAvg_difficulty(), nullstats.getAvg_difficulty());
        assertEquals(calc.getAvg_time(), nullstats.getAvg_time());
        assertEquals(calc.getPopularity(), nullstats.getPopularity());
        assertEquals(calc.getChild_friendliness(), nullstats.getChild_friendliness());
        assertEquals(calc.getAvg_rating(), nullstats.getAvg_rating());
    }

    @Test
    public void exportSelectedTour_ValidTour_ExportSuccessful() {

        String filePath = "C:\\Users\\stevi\\Documents\\FH\\Semester4\\SWEN\\test.pdf";

        // Act
        Assertions.assertDoesNotThrow(() -> pdfConverter.exportSelectedTour(dummyTours.get(0), filePath));

        // Assert
        Assertions.assertTrue(Files.exists(Paths.get(filePath)));
    }

    @Test
    public void exportSummary_ValidTours_ExportSuccessful() {

        ObservableList<Tour> tours = FXCollections.observableArrayList(Arrays.asList(dummyTours.get(0), dummyTours.get(0)));

        String filePath = "C:\\Users\\stevi\\Documents\\FH\\Semester4\\SWEN\\test.pdf";

        // Act
        Assertions.assertDoesNotThrow(() -> pdfConverter.exportSummary(tours, filePath));

        // Assert
        Assertions.assertTrue(Files.exists(Paths.get(filePath)));
    }



}
