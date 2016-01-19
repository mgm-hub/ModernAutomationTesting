package MainController.ReportCore;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReportDataDelegate {

    //================================================================================
    // Properties
    //================================================================================

    private final static String CLASS_NAME = "ReportDataDelegate";

    public String theUUID;
    public String theTestName;
    public String theTestDate;
    public String theBrowser;
    public String theTestFileName;
    public String theURL;


    static int testsPassedCount = 0; //might have to reset between tests
    static int testsFailedCount = 0; //might have to reset between tests

    private String theCurrentCaseNumber = "";
    private boolean hasTestErrorOccurred = false;

    //================================================================================
    // Log
    //================================================================================

    public ArrayList<String> theEventLogList = new ArrayList<>();
    public Map<String, String> theEventTimeList = new LinkedHashMap<>();

    //================================================================================
    // Data Holders
    //================================================================================

    public  Map <String, String> theErrorList =  new LinkedHashMap<>();
    public  Map <String, String> theTestIDStatusList =  new LinkedHashMap<>();

    public ArrayList<String> theTestPassList =  new ArrayList<>();
    public ArrayList<String> theTestFailList =  new ArrayList<>();

    public ArrayList<String> theCaseList = new ArrayList<>();

    //        \\
    ////    \\\\
    //////\\\\\\
    ////    \\\\
    //        \\
    //        \\
    //        \\
    ////    \\\\
    //////\\\\\\
    ////    \\\\
    //        \\

    //================================================================================
    // Constructor
    //================================================================================

    public ReportDataDelegate() {


    }

    //        \\
    ////    \\\\
    //////\\\\\\
    ////    \\\\
    //        \\
    //        \\
    //        \\
    ////    \\\\
    //////\\\\\\
    ////    \\\\
    //        \\

    //================================================================================
    // Existential
    //================================================================================

    public boolean canErrorBeWritten(String myError) {
        return theCurrentCaseNumber.length() > 0 && myError.length() > 0 && theErrorList != null;
    }

    //        \\
    ////    \\\\
    //////\\\\\\
    ////    \\\\
    //        \\
    //        \\
    //        \\
    ////    \\\\
    //////\\\\\\
    ////    \\\\
    //        \\

    //================================================================================
    // Getters and Setters
    //================================================================================


    public boolean getHasTestErrorOccurred() {
        return hasTestErrorOccurred;
    }

    public void setHasTestErrorOccurred(boolean hasTestErrorOccurred) {
        this.hasTestErrorOccurred = hasTestErrorOccurred;
    }

    public String getTheCurrentCaseNumber() {
        return theCurrentCaseNumber;
    }

    public void setTheCurrentCaseNumber(String theCurrentCaseNumber) {
        this.theCurrentCaseNumber = theCurrentCaseNumber;
    }
}
