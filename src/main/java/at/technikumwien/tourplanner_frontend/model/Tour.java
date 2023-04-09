package at.technikumwien.tourplanner_frontend.model;

public record Tour(
        Integer id,
        String name,
        String tour_description,
        String tour_from,
        String tour_to,
        String transport_type
) {
}
