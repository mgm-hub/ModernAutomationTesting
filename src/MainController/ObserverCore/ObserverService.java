package MainController.ObserverCore;


@SuppressWarnings({"static-member","static-access","StatementWithEmptyBody","unused"})
public class ObserverService {

    public static final String TEST_NOTIFICATION = "CanRunTestNow";
    public static final String LOG_NOTIFICATION = "CanPostResultsNow";
    public static final String PAUSE_NOTIFICATION = "CanPauseNow";
    public static final String CUE_NOTIFICATION = "ShouldCheckCue";
    public static final String CUE_CLEANUP = "ShouldCleanCue";
    public static final String TERMINATE_NOTIFICATION = "CanTerminateNow";

    public static Boolean hasPaused = false;
    public static Boolean isRunning = false;
    private static Boolean hasPressedTerminate = false;

    public ObserverService() {


    }
}
