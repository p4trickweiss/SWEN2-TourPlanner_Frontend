module tourplanner_frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires java.net.http;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens at.technikumwien.tourplanner_frontend to javafx.graphics, javafx.fxml;
    exports at.technikumwien.tourplanner_frontend;
    exports at.technikumwien.tourplanner_frontend.presentation.controller;
    opens at.technikumwien.tourplanner_frontend.presentation.controller to javafx.fxml, javafx.graphics;
    exports at.technikumwien.tourplanner_frontend.presentation.viewmodel;
    opens at.technikumwien.tourplanner_frontend.presentation.viewmodel to javafx.fxml, javafx.graphics;

    exports at.technikumwien.tourplanner_frontend.model;
    opens at.technikumwien.tourplanner_frontend.model to com.fasterxml.jackson.databind, com.fasterxml.jackson.datatype;
}
