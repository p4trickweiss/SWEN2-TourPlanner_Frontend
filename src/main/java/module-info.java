module tourplanner_frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    opens at.technikumwien.tourplanner_frontend to javafx.graphics, javafx.fxml;
    exports at.technikumwien.tourplanner_frontend;
    exports at.technikumwien.tourplanner_frontend.presentation.controller;
    opens at.technikumwien.tourplanner_frontend.presentation.controller to javafx.fxml, javafx.graphics;
    exports at.technikumwien.tourplanner_frontend.presentation.viewmodel;
    opens at.technikumwien.tourplanner_frontend.presentation.viewmodel to javafx.fxml, javafx.graphics;
}
