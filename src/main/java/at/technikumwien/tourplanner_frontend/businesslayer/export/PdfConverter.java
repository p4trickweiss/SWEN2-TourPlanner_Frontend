package at.technikumwien.tourplanner_frontend.businesslayer.export;

import at.technikumwien.tourplanner_frontend.businesslayer.calculator.StatsCalculator;
import at.technikumwien.tourplanner_frontend.model.Stats;
import at.technikumwien.tourplanner_frontend.model.Tour;
import at.technikumwien.tourplanner_frontend.model.TourLog;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.wmf.WmfImageData;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import javafx.collections.ObservableList;
import com.itextpdf.layout.element.Image;
import com.itextpdf.io.image.ImageDataFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class PdfConverter {

    private StatsCalculator statsCalculator = new StatsCalculator();

    private Table addCellsFromTour(Table table, Tour tour){
        table.addCell(tour.getName());
        table.addCell(tour.getTour_description());
        table.addCell(tour.getTour_from());
        table.addCell(tour.getTour_to());
        table.addCell(tour.getTour_distance());
        table.addCell(tour.getTransport_type());
        table.addCell(tour.getEstimated_time());
        return table;
    }
    public void exportSelectedTour(Tour currentTour, String path){
        try{
            PdfWriter writer = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            Paragraph tableHeader = new Paragraph("Tour Information").setFontSize(14).setBold();
            document.add(tableHeader);

            //image
            String imageUrl = currentTour.getRoute_information();
            byte[] imageData = downloadImage(imageUrl);


            // Bild zur PDF-Seite hinzufügen
            Image image = new Image(ImageDataFactory.create(imageData));
            image.scaleToFit(200,200);
            image.setHorizontalAlignment(HorizontalAlignment.CENTER);
            image.setMarginBottom(10);
            document.add(image);


            Table tour_table = new Table(8);

            tour_table.addHeaderCell("name");
            tour_table.addHeaderCell("tour description");
            tour_table.addHeaderCell("tour from");
            tour_table.addHeaderCell("tour to");
            tour_table.addHeaderCell("tour distance");
            tour_table.addHeaderCell("transport type");
            tour_table.addHeaderCell("estimated time");
            tour_table.addHeaderCell("Average rating");
            tour_table.addHeaderCell("Average time");
            tour_table.addHeaderCell("Average difficulty");

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


            Table tour_table = new Table(7);
            tour_table.setFontSize(10);

            tour_table.addHeaderCell("name");
            tour_table.addHeaderCell("tour description");
            tour_table.addHeaderCell("tour from");
            tour_table.addHeaderCell("tour to");
            tour_table.addHeaderCell("tour distance");
            tour_table.addHeaderCell("transport type");
            tour_table.addHeaderCell("estimated time");

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

            Stats stats;

            for(int i = 0; i < tours.size(); i++){
                Tour iterator = tours.get(i);

                tour_table = addCellsFromTour(tour_table, iterator);

                stats = statsCalculator.calculateTourAvg(iterator);

                tourLogs_table.addCell(iterator.getName());
                tourLogs_table.addCell(String.valueOf(stats.getAvg_time()));
                tourLogs_table.addCell(String.valueOf(stats.getAvg_distance()));
                tourLogs_table.addCell(String.valueOf(stats.getAvg_rating()));

            }

            document.add(tour_table);
            document.add(tourLogs_table);
            document.close();
        } catch (Exception e){
            System.out.printf(e.getMessage());
        }


    }

    private static byte[] downloadImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        try (InputStream inputStream = url.openStream()) {
            Path tempFile = Files.createTempFile("temp-image", ".jpg");
            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
            return Files.readAllBytes(tempFile);
        }
    }

}
