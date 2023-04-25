package at.technikumwien.tourplanner_frontend.model;

public class TourLog {
    private Long id;
    private String time_stamp;
    private String comment;
    private String difficulty;
    private String total_time;
    private Integer rating;
    private Tour tour;

    public TourLog() {
    }
    public TourLog(Long id, String time_stamp, String comment, String difficulty, String total_time, Integer rating, Tour tour) {
        this.id = id;
        this.time_stamp = time_stamp;
        this.comment = comment;
        this.difficulty = difficulty;
        this.total_time = total_time;
        this.rating = rating;
        this.tour = tour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
