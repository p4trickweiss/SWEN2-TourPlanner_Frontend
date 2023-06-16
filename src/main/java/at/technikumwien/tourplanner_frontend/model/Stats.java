package at.technikumwien.tourplanner_frontend.model;

public class Stats {

    public float avg_time;
    public String avg_difficulty;
    public float avg_rating;
    public int popularity;

    public String child_friendliness;


    public Stats(float avg_time, String avg_difficulty, float avg_rating, int popularity, String child_friendliness) {
        this.avg_time = avg_time;
        this.avg_difficulty = avg_difficulty;
        this.avg_rating = avg_rating;
        this.popularity = popularity;
        this.child_friendliness = child_friendliness;
    }

    public String getAvg_difficulty() {
        return avg_difficulty;
    }

    public float getAvg_rating() {
        return avg_rating;
    }

    public float getAvg_time() {
        return avg_time;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getChild_friendliness() {
        return child_friendliness;
    }
}
