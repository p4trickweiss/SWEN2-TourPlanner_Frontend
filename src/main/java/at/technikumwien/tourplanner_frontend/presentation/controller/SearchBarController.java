package at.technikumwien.tourplanner_frontend.presentation.controller;

import javafx.fxml.Initializable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchBarController implements Initializable {
    private static Logger logger = LogManager.getLogger(SearchBarController.class);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.info("SearchBarController init");
    }
}
