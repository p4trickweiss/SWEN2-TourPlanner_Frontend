package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.model.NewTour;
import at.technikumwien.tourplanner_frontend.model.Tour;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class EditTourViewModel {
    private SimpleObjectProperty<Tour> currentTour = new SimpleObjectProperty<Tour>();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty tour_description = new SimpleStringProperty();
    private SimpleStringProperty tour_from = new SimpleStringProperty();
    private SimpleStringProperty tour_to = new SimpleStringProperty();
    private SimpleStringProperty transport_type = new SimpleStringProperty();
    private final TourPlannerManager manager;

    public EditTourViewModel(){
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
        currentTour.addListener((observableValue, oldValue, newValue) -> {
            if(newValue != null){
                name.set(newValue.getName());
                tour_description.set(newValue.getTour_description());
                tour_from.set(newValue.getTour_from());
                tour_to.set(newValue.getTour_to());
                transport_type.set(newValue.getTransport_type());
            }
        });
    }

    public void editTour() {
        NewTour editTour = new NewTour(name.get(), tour_from.get(), tour_to.get(), transport_type.get(), tour_description.get());
        manager.editTour(editTour, currentTour.get().getId());
    }

    public Object getCurrentTour() {
        return currentTour.get();
    }

    public SimpleObjectProperty<Tour> currentTourProperty() {
        return currentTour;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getTour_description() {
        return tour_description.get();
    }

    public SimpleStringProperty tour_descriptionProperty() {
        return tour_description;
    }

    public String getTour_from() {
        return tour_from.get();
    }

    public SimpleStringProperty tour_fromProperty() {
        return tour_from;
    }

    public String getTour_to() {
        return tour_to.get();
    }

    public SimpleStringProperty tour_toProperty() {
        return tour_to;
    }

    public String getTransport_type() {
        return transport_type.get();
    }

    public SimpleStringProperty transport_typeProperty() {
        return transport_type;
    }
}
