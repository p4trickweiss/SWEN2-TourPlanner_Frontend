package at.technikumwien.tourplanner_frontend.businesslayer.calculator;

import at.technikumwien.tourplanner_frontend.model.Stats;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;

import java.util.List;

public class StatsCalculator {

    public Stats calculateTourAvg(Tour currentTour){

        if(currentTour.getTourLogs().size() == 0){
            return new Stats(0, 0, 0);
        }

        int sum_rating = 0;
        //int sum_time = 0;
        //int sum_difficulty = 0;

        List<TourLog> tourLogList = currentTour.getTourLogs();

        try{
            for(int i = 0; i < tourLogList.size(); i++){
                sum_rating += tourLogList.get(i).getRating();
                //sum_time += Integer.parseInt(tourLogList.get(i).getTotal_time());
                //sum_difficulty += Integer.parseInt(tourLogList.get(i).getDifficulty());
            }
        } catch (Exception e){
            System.out.printf("Cant Convert String to int");
            return new Stats(0, 0, 0);
        }

        //float avg_time = sum_time / tourLogList.size();
        //float avg_difficulty = sum_difficulty / tourLogList.size();
        float avg_rating = sum_rating / tourLogList.size();

        // replace 0 with variables
        return new Stats(0, 0, avg_rating);
    }

}
