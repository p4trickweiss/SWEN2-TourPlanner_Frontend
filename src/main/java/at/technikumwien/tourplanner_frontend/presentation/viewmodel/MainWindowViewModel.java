package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.Main;
import at.technikumwien.tourplanner_frontend.businesslayer.export.PdfConverter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class MainWindowViewModel {

    public MainWindowViewModel(){
    }

    public void openExportPopup(){
        try{
            URL fxmlLocation = Main.class.getResource("exportTour.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setTitle("Export Tour");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.printf(e.getMessage());
            System.out.printf("Cant load new window");
        }
    }

}
