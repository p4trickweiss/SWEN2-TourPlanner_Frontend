package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManager;
import at.technikumwien.tourplanner_frontend.model.NewTour;
import javafx.beans.property.SimpleStringProperty;

public class AddTourViewModel {
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty tour_description = new SimpleStringProperty();
    private final SimpleStringProperty tour_from = new SimpleStringProperty();
    private final SimpleStringProperty tour_to = new SimpleStringProperty();
    private final SimpleStringProperty transport_type = new SimpleStringProperty();
    private final TourListViewModel tourListViewModel;
    private final TourPlannerManager manager;

    public AddTourViewModel() {
        this.tourListViewModel = ViewModelFactory.INSTANCE.getTourListViewModel();
        this.manager = TourPlannerManagerFactory.INSTANCE.getTourPlannerManager();
    }

    public void addTour() {
        NewTour newTour = new NewTour(name.get(), tour_from.get(), tour_to.get(), transport_type.get(), tour_description.get());
        manager.addTour(newTour);
        tourListViewModel.updateTourList();
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
