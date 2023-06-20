package at.technikumwien.tourplanner_frontend.presentation.controller;

import java.util.regex.Pattern;
import java.util.function.UnaryOperator;
import javafx.scene.control.TextFormatter;


public enum IntFilter {
    INSTANCE;

    public UnaryOperator<TextFormatter.Change> getNumericFilter(){
        return change -> {
            String newText = change.getControlNewText();
            if(isNumeric(newText)) {
                return change;
            }
            return null;
        };
    }

    public UnaryOperator<TextFormatter.Change> getRatingFilter(){
        return change -> {
            String newText = change.getControlNewText();
            if(isNumericRating(newText)) {
                return change;
            }
            return null;
        };
    }

    private boolean isNumeric(String str) {
        return Pattern.matches("^[0-9]*$", str);
    }

    private boolean isNumericRating(String str) { return Pattern.matches("^[0-5s]?", str);}
}
