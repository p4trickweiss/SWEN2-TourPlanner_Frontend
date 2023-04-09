package at.technikumwien.tourplanner_frontend;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.ButtonMatchers;
import org.testfx.matcher.control.LabeledMatchers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.testfx.service.query.impl.NodeQueryImpl;
import org.testfx.util.NodeQueryUtils;

import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
class HelloWorldTest {

    private Parent root = null;
    /**
     * Will be called with {@code @Before} semantics, i. e. before each test method.
     *
     * @param stage - Will be injected by the test runner.
     */
    @Start
    private void start(Stage primaryStage) {
        try {
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
    }

    /**
     * @param robot - Will be injected by the test runner.
     */
    @Test
    void should_contain_outputlabel_with_text(FxRobot robot) {
        FxAssert.verifyThat("#OutputLabel", LabeledMatchers.hasText("Hello VM!"));
    }

    @Test
    void should_contain_outputlabel_with_changed_text(FxRobot robot) {
        NodeQueryUtils.bySelector("#InputTextField").apply(root).forEach(
                node -> robot.write("Vietnam")
        );
        new NodeQueryImpl().from(root).lookup(ButtonMatchers.isDefaultButton()).queryAll().forEach(
                defaultButton -> robot.clickOn(defaultButton)
        );
        robot.sleep(500);
        FxAssert.verifyThat("#OutputLabel", LabeledMatchers.hasText("Hello Vietnam!"));
    }

    @Test
    void should_contain_outputlabel_with_changed_text2(FxRobot robot) {
        NodeQueryUtils.bySelector("#InputTextField").apply(root).forEach(
                node -> robot.write("Vietnam")
        );
        robot.clickOn(new NodeQueryImpl().from(root).lookup(ButtonMatchers.isDefaultButton()).queryButton());
        robot.sleep(500);
        FxAssert.verifyThat("#OutputLabel", LabeledMatchers.hasText("Hello Vietnam!"));

    }
}