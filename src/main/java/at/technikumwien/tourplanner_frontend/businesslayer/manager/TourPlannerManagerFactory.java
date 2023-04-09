package at.technikumwien.tourplanner_frontend.businesslayer.manager;

public enum TourPlannerManagerFactory {
    INSTANCE;

    private final TourPlannerManager manager = new TourPlannerManagerImpl();

    public TourPlannerManager getTourPlannerManager() {
        return manager;
    }
}
