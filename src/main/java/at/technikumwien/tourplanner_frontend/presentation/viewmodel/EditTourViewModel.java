package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.model.NewTour;
import at.technikumwien.tourplanner_frontend.model.Tour;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.swing.text.View;

public class EditTourViewModel {
    private final ObjectProperty<Tour> currentTour = new SimpleObjectProperty<>();
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty tour_description = new SimpleStringProperty();
    private final SimpleStringProperty tour_from = new SimpleStringProperty();
    private final SimpleStringProperty tour_to = new SimpleStringProperty();
    private final SimpleStringProperty transport_type = new SimpleStringProperty();
    private final TourListViewModel tourListViewModel;
    private final TourInfoViewModel tourInfoViewModel;
    private final TourPlannerManager manager;

    public EditTourViewModel(){
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
        this.tourListViewModel = ViewModelFactory.INSTANCE.getTourListViewModel();
        this.tourInfoViewModel = ViewModelFactory.INSTANCE.getTourInfoViewModel();


        currentTour.addListener((observableValue, oldValue, newValue) -> {
            if(newValue != null){
                name.set(newValue.getName());
                tour_description.set(newValue.getTour_description());
                tour_from.set(newValue.getTour_from());
                tour_to.set(newValue.getTour_to());
                transport_type.set(newValue.getTransport_type());
            }
        });

        this.currentTour.bind(tourListViewModel.currentTourProperty());

    }

    public void editTour() {
        NewTour editTour = new NewTour(name.get(), tour_from.get(), tour_to.get(), transport_type.get(), tour_description.get());
        manager.editTour(editTour, currentTour.get().getId());
        tourListViewModel.updateTourList();
        //tourInfoViewModel.updateTour();
    }


    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty tour_descriptionProperty() {
        return tour_description;
    }


    public SimpleStringProperty tour_fromProperty() {
        return tour_from;
    }


    public SimpleStringProperty tour_toProperty() {
        return tour_to;
    }


    public SimpleStringProperty transport_typeProperty() {
        return transport_type;
    }
}
