package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

import at.technikumwien.tourplanner_frontend.businesslayer.export.PdfConverter;

import javax.swing.text.View;


public class ExportTourViewModel {

    private final PdfConverter pdfConverter = new PdfConverter();
    private final TourListViewModel tourListViewModel;

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
