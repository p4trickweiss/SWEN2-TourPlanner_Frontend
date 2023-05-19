package at.technikumwien.tourplanner_frontend.businesslayer.export;

import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import javafx.collections.ObservableList;

public class PdfConverter {

    private Table addCellsFromTour(Table table, Tour tour){
        table.addCell(tour.getName());
        table.addCell(tour.getTour_description());
        table.addCell(tour.getTour_from());
        table.addCell(tour.getTour_to());
        // Update empty fields
        table.addCell("empty");
        // Update empty fields
        table.addCell("empty");
        table.addCell(tour.getTransport_type());
        // Update empty fields
        table.addCell("empty");

        return table;
    }
    public void exportSelectedTour(Tour currentTour, String path){
        try{
            PdfWriter writer = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            Paragraph tableHeader = new Paragraph("Tour Information").setFontSize(14).setBold();
            document.add(tableHeader);

            Table tour_table = new Table(8);

            tour_table = addCellsFromTour(tour_table, currentTour);

            tour_table.setFontSize(10);
            document.add(tour_table);

            Paragraph logsHeader = new Paragraph("Logs").setFontSize(14).setBold();
            document.add(logsHeader);

            if(currentTour.getTourLogs().size() > 0){
                Table logs_table = new Table(5);

                logs_table.addHeaderCell("comment");
                logs_table.addHeaderCell("difficulty");
                logs_table.addHeaderCell("rating");
                logs_table.addHeaderCell("time_stamp");
                logs_table.addHeaderCell("total_time");

                for(int i = 0; i < currentTour.getTourLogs().size(); i++){
                    logs_table.addCell(currentTour.getTourLogs().get(i).getComment());
                    logs_table.addCell(currentTour.getTourLogs().get(i).getDifficulty());
                    logs_table.addCell(currentTour.getTourLogs().get(i).getRating().toString());
                    logs_table.addCell(currentTour.getTourLogs().get(i).getTime_stamp());
                    logs_table.addCell(currentTour.getTourLogs().get(i).getTotal_time());
                }

                document.add(logs_table);
            }
            else{
                Paragraph noLogsParagraph = new Paragraph("The Tour has no Logs yet!");
                document.add(noLogsParagraph);
            }

            document.close();

        } catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }

    public void exportSummary(ObservableList<Tour> tours, String path){
        try {
            PdfWriter writer = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            Paragraph header = new Paragraph("Summary").setFontSize(18).setBold();
            document.add(header);

            if(tours.size() < 1){
                Paragraph error = new Paragraph("No Tours found!").setFontSize(14).setBold();
                document.add(error);
                return;
            }

            Paragraph tours_header = new Paragraph("Tours: ").setFontSize(14).setBold();
            document.add(tours_header);


            Table tour_table = new Table(8);
            tour_table.setFontSize(10);

            tour_table.addHeaderCell("name");
            tour_table.addHeaderCell("tour_description");
            tour_table.addHeaderCell("tour_from");
            tour_table.addHeaderCell("tour_to");
            tour_table.addHeaderCell("tour_distance");
            tour_table.addHeaderCell("route_information");
            tour_table.addHeaderCell("transport_type");
            tour_table.addHeaderCell("estimated_time");

            Table tourLogs_table = new Table(4);
            tourLogs_table.setFontSize(10);

            tourLogs_table.addHeaderCell("Tour");
            tourLogs_table.addHeaderCell("avg. time");
            tourLogs_table.addHeaderCell("avg. distance");
            tourLogs_table.addHeaderCell("avg. rating");

            // Time and Difficulty are not type of integer --> no Average value. Input?

            //int sum_time;
            //int avg_time;

            //int sum_diff;
            //int avg_diff;

            int sum_rating;
            int avg_rating;

            for(int i = 0; i < tours.size(); i++){
                Tour iterator = tours.get(i);

                tour_table = addCellsFromTour(tour_table, iterator);

                if(iterator.getTourLogs().size() > 0){
                    //sum_time = 0;
                    //sum_diff = 0;
                    sum_rating = 0;

                    for(int logs_i = 0; logs_i < iterator.getTourLogs().size(); i++){
                        TourLog logIterator = iterator.getTourLogs().get(logs_i);
                        //sum_time += logIterator.getTotal_time();
                        //sum_diff += logIterator.getDifficulty();
                        sum_rating += logIterator.getRating();
                    }

                    //avg_time = sum_time / iterator.getTourLogs().size();
                    //avg_diff = sum_diff / iterator.getTourLogs().size();
                    avg_rating = sum_rating / iterator.getTourLogs().size();

                    tourLogs_table.addCell(iterator.getName());
                    tourLogs_table.addCell("Time");
                    tourLogs_table.addCell("Difficulty");
                    tourLogs_table.addCell(String.valueOf(avg_rating));
                }
            }

            document.add(tour_table);
            document.add(tourLogs_table);
            document.close();
        } catch (Exception e){
            System.out.printf(e.getMessage());
        }

    }

}
