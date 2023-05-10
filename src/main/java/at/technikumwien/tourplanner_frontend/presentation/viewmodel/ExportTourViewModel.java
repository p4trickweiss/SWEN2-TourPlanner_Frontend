package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.manager.TourPlannerManagerFactory;
import at.technikumwien.tourplanner_frontend.model.NewTour;
import at.technikumwien.tourplanner_frontend.businesslayer.export.PdfConverter;

import javax.swing.text.View;


public class ExportTourViewModel {

    private PdfConverter pdfConverter = new PdfConverter();
    private TourListViewModel tourListViewModel;

    public ExportTourViewModel() {
        this.tourListViewModel = ViewModelFactory.INSTANCE.getTourListViewModel();
    }

    public void exportSelectedTour(String path){
        pdfConverter.exportSelectedTour(this.tourListViewModel.getCurrentTour(), path);
    }

    public void exportSummary(String path){
        pdfConverter.exportSummary(this.tourListViewModel.getTours(), path);
    }


}
