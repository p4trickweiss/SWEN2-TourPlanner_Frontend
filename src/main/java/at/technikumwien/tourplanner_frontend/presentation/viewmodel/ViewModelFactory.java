package at.technikumwien.tourplanner_frontend.presentation.viewmodel;

public enum ViewModelFactory {
    INSTANCE;

    private final MainWindowViewModel mainWindowViewModel = new MainWindowViewModel();
    private final TourListViewModel tourListViewModel = new TourListViewModel();

    public MainWindowViewModel getMainWindowViewModel() {
        return mainWindowViewModel;
    }

    public TourListViewModel getTourListViewModel() {
            return tourListViewModel;
        }
}
