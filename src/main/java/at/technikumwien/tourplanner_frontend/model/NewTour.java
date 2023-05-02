package at.technikumwien.tourplanner_frontend.model;

public class NewTour {
    private String name;

    private String tour_description;
    private String tour_from;
    private String tour_to;
    private String transport_type;

    public NewTour() {
    }

    public NewTour(String name, String tour_from, String tour_to, String transport_type, String tour_description) {
        this.name = name;
        this.tour_from = tour_from;
        this.tour_to = tour_to;
        this.transport_type = transport_type;
        this.tour_description = tour_description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTour_from() {
        return tour_from;
    }

    public void setTour_from(String tour_from) {
        this.tour_from = tour_from;
    }

    public String getTour_to() {
        return tour_to;
    }

    public void setTour_to(String tour_to) {
        this.tour_to = tour_to;
    }

    public String getTransport_type() {
        return transport_type;
    }

    public void setTransport_type(String transport_type) {
        this.transport_type = transport_type;
    }

    public String getTour_description() {
        return tour_description;
    }

    public void setTour_description(String tour_description) {
        this.tour_description = tour_description;
    }
}
