package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

public enum ViewModelFactory {
    INSTANCE;

    private MainWindowViewModel mainWindowViewModel;
    private TourListViewModel tourListViewModel;
    private TourLogsViewModel tourLogsViewModel;
    private AddTourViewModel addTourViewModel;
    private EditTourViewModel editTourViewModel;
    private ExportTourViewModel exportTourViewModel;
    private AddTourLogViewModel addTourLogViewModel;
    private EditTourLogViewModel editTourLogViewModel;

    private TourInfoViewModel tourInfoViewModel;


    public MainWindowViewModel getMainWindowViewModel() {
        if (mainWindowViewModel == null) {
            mainWindowViewModel = new MainWindowViewModel();
        }
        return mainWindowViewModel;
    }

    public TourListViewModel getTourListViewModel() {
        if(tourListViewModel == null) {
            tourListViewModel = new TourListViewModel();
        }
            return tourListViewModel;
    }

    public TourLogsViewModel getTourLogsViewModel() {
        if (tourLogsViewModel == null) {
            tourLogsViewModel = new TourLogsViewModel();
        }
        return tourLogsViewModel;
    }

    public AddTourViewModel getAddTourViewModel() {
        if(addTourViewModel == null) {
            addTourViewModel = new AddTourViewModel();
        }
        return addTourViewModel;
    }

    public EditTourViewModel getEditTourViewModel() {
        if(editTourViewModel == null) {
            editTourViewModel = new EditTourViewModel();
        }
        return editTourViewModel;
    }

    public ExportTourViewModel getExportTourViewModel(){
        if(exportTourViewModel == null){
            exportTourViewModel = new ExportTourViewModel();
        }
        return exportTourViewModel;
    }

    public AddTourLogViewModel getAddTourLogViewModel(){
        if(addTourLogViewModel == null){
            addTourLogViewModel = new AddTourLogViewModel();
        }
        return addTourLogViewModel;
    }

    public EditTourLogViewModel getEditTourLogViewModel(){
        if(editTourLogViewModel == null){
            editTourViewModel = new EditTourViewModel();
        }
        return editTourLogViewModel;
    }

    public TourInfoViewModel getTourInfoViewModel(){
        if(tourInfoViewModel == null){
            tourInfoViewModel = new TourInfoViewModel();
        }
        return tourInfoViewModel;
    }
}
