module helloworldfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    opens at.technikumwien.tourplanner_frontend to javafx.graphics, javafx.fxml;
    exports at.technikumwien.tourplanner_frontend;
}
