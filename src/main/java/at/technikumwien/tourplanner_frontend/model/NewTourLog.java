package at.technikumwien.tourplanner_frontend.model;

public class NewTourLog {

    private String comment;
    private String difficulty;
    private String rating;
    private String time_stamp;
    private String total_time;

    public NewTourLog() {
    }

    public NewTourLog(String comment, String difficulty, String rating, String time_stamp, String total_time) {
        this.comment = comment;
        this.difficulty = difficulty;
        this.rating = rating;
        this.time_stamp = time_stamp;
        this.total_time = total_time;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

}
