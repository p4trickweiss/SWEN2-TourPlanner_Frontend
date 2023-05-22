package at.technikumwien.tourplanner_frontend.model;

public class Stats {

    public float avg_time;
    public float avg_distance;
    public float avg_rating;

    public Stats(float avg_time, float avg_distance, float avg_rating) {
        this.avg_time = avg_time;
        this.avg_distance = avg_distance;
        this.avg_rating = avg_rating;
    }

    public float getAvg_distance() {
        return avg_distance;
    }

    public float getAvg_rating() {
        return avg_rating;
    }

    public float getAvg_time() {
        return avg_time;
    }

}
