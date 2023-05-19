package at.technikumwien.tourplanner_frontend.model;

public class NewTourLog {

    private String comment;
    private String difficulty;
    private String totalTime;
    private Integer rating;
    private Long fk_tourId;

    public NewTourLog() {
    }

    public NewTourLog(String comment, String difficulty, String total_time, Integer rating, Long fk_tourId) {
        this.comment = comment;
        this.difficulty = difficulty;
        this.totalTime = total_time;
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

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
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
