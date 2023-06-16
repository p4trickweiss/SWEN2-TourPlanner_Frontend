package at.technikumwien.tourplanner_frontend.businesslayer.calculator;

import at.technikumwien.tourplanner_frontend.model.Stats;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;

import java.util.List;

public class StatsCalculator {

    public Stats calculateTourAvg(Tour currentTour){

        if(currentTour.getTourLogs() == null || currentTour.getTourLogs().size() == 0){
            return new Stats(0, null, 0, 0, null);
        }

        int sum_rating = 0;
        int sum_time = 0;
        int sum_difficulty = 0;

        List<TourLog> tourLogList = currentTour.getTourLogs();

        try{
            for(int i = 0; i < tourLogList.size(); i++){
                sum_rating += tourLogList.get(i).getRating();
                sum_time += Integer.parseInt(tourLogList.get(i).getTotal_time());
                if(tourLogList.get(i).getDifficulty().equals("easy")){
                    sum_difficulty += 1;
                } else if(tourLogList.get(i).getDifficulty().equals("medium")){
                    sum_difficulty += 2;
                } else{
                    sum_difficulty += 3;
                }
            }
        } catch (Exception e){
            System.out.printf("Cant Convert String to int");
            return new Stats(0, null, 0, 0, null);
        }

        float avg_time = sum_time / tourLogList.size();
        int avg_difficulty = Math.round(sum_difficulty / tourLogList.size());
        float avg_rating = sum_rating / tourLogList.size();

        String child_friendliness;

        try{
            if(Integer.valueOf(currentTour.getTour_distance()) < 10 && avg_difficulty <= 1.5 && avg_time < 120){
                child_friendliness = "child friendly";
            } else if (Integer.valueOf(currentTour.getTour_distance()) < 15 && avg_difficulty <= 2 && avg_time < 180) {
                child_friendliness = "medium child friendly";
            } else{
                child_friendliness = "not child friendly";
            }

        }
        catch (Exception e){
            System.out.printf("Cant convert String to int");
            return new Stats(0, null, 0, 0, null);
        }

        String avg_difficulty_string;

        if(avg_difficulty == 1){
            avg_difficulty_string = "easy";
        } else if (avg_difficulty == 2) {
            avg_difficulty_string = "medium";
        } else{
            avg_difficulty_string = "hard";
        }

        // replace 0 with variables
        return new Stats(avg_time, avg_difficulty_string, avg_rating, tourLogList.size(), child_friendliness);
    }

}
