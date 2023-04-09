package at.technikumwien.tourplanner_frontend.businesslayer.manager;

public class JavaAppManagerFactory {
    private static JavaAppManager manager;

    public static JavaAppManager getJavaAppManager() {
        if (manager == null) {
            manager = new JavaAppManagerImpl();
        }
        return manager;
    }
}
