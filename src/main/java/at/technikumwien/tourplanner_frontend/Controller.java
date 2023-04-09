package at.technikumwien.tourplanner_frontend;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Controller()
    {
        System.out.println("Controller created");
    }

    public void calculateOutput(ActionEvent actionEvent) {
        System.out.println("Controller calculate");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Controller init");
    }
}
