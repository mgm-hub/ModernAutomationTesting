package MainController.ReportCore;

public class Reporter {

    private final static String CLASS_NAME = "Reporter";


    public Reporter() {
        if (MainController.ValueCore.Constants.IS_DEBUG){
            String infoMessage = "DEBUG ENABLED - ReportDataDelegate";
            MainController.Utilities.Log.log(infoMessage);
        }

    }
}
