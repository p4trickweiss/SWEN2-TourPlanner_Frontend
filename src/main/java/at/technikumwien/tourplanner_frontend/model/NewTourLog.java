package at.technikumwien.tourplanner_frontend.model;

public class NewTourLog {

    private String comment;
    private String difficulty;
    private String total_time;
    private Integer rating;
    private Long fk_tourId;

    public NewTourLog() {
    }

    public NewTourLog(String comment, String difficulty, String total_time, Integer rating, Long fk_tourId) {
        this.comment = comment;
        this.difficulty = difficulty;
        this.total_time = total_time;
        this.rating = rating;
        this.fk_tourId = fk_tourId;
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

    public Long getFk_tourId() {
        return fk_tourId;
    }

    public void setFk_tourId(Long fk_tourId) {
        this.fk_tourId = fk_tourId;
    }
}
