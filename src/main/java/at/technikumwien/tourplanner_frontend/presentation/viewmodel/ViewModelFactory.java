package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

public enum ViewModelFactory {
    INSTANCE;

    private MainWindowViewModel mainWindowViewModel;
    private TourListViewModel tourListViewModel;
    private TourLogsViewModel tourLogsViewModel;

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
}
