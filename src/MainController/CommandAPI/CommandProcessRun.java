package MainController.CommandAPI;

/*
MainController.CommandAPI.mainTestRunAction();
*/


import MainController.ObserverCore.ObserverService;
import org.openqa.selenium.WebDriver;

public class CommandProcessRun {

    //================================================================================
    // Classes
    //================================================================================

    static ObserverService theObserverService;
    static CommandProcessActionClass theCommandProcessActionClass;

    //================================================================================
    // Properties
    //================================================================================

    private final static String CLASS_NAME = "CommandProcessRun";

/*
private static int apiCommandConsumption (CommandDataObject myCommandDataObject) {
*/

    static CommandDataObject theCommandDataObject;

    private static boolean isMeantToBreak = false;

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

    public CommandProcessRun() {
        if (theObserverService == null){
            theObserverService = new ObserverService();
        }
    }

    //================================================================================
    // Run Loop Action
    //================================================================================

    public void runActionInit(WebDriver driver, CommandDataClass[] myCommandDataClassArray) {
        MainController.Utilities.Log.log(MainController.ValueCore.Constants.STARTING_TEST);
        initCommandProcessActionClass(driver);
        mainTestRunAction(driver,myCommandDataClassArray );
    }

    //        \\
    ////    \\\\
    //////\\\\\\
    //////\\\\\\
    ////    \\\\
    //        \\

    //================================================================================
    // Init Command Process Run
    //================================================================================

    public static void initCommandProcessActionClass (WebDriver driver) {
        if (theCommandProcessActionClass == null) {
            theCommandProcessActionClass = new CommandProcessActionClass(driver);
        }
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
    // Run Loop Action
    //================================================================================

    private void mainTestRunAction(WebDriver driver, CommandDataClass[] myCommandDataClassArray) {
        if (myCommandDataClassArray != null && myCommandDataClassArray.length > 0) {
            int myFullLength = myCommandDataClassArray.length;
            if (myFullLength > 0 && driver != null) {

                theCommandDataObject = setTheCommandDataObject(myCommandDataClassArray);
                int myCount = 0;

                MainController.Utilities.Log.log(MainController.ValueCore.Constants.STEP_0);

                for (CommandDataClass myCommandClass : myCommandDataClassArray) {
                    MainController.Utilities.Log.log(MainController.ValueCore.Constants.STEP_1);

                    if (isMeantToBreak || theObserverService.hasTestBeenTerminated ()) {
                        breakAction();
                        break;
                    }
                    pauseAction();
                    //driverCheckIsNull(driver);

                    writeTimeLog();
                    writeCommandReportLog();
                    writeCaseNumberLog ();
                    //Case Number Write

                    theCommandDataObject.setTheCommmandData(myCommandClass);
                    theCommandDataObject.setTheCurrentCommandNumber(runApiCommand(theCommandDataObject));
                }
            }
        }
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
    // Set Data Object
    //================================================================================

    private CommandDataObject setTheCommandDataObject (CommandDataClass[] myCommandDataClassArray) {
        return new CommandDataObject(myCommandDataClassArray);
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
    // Interrupts
    //================================================================================

    private void breakAction () {

    }

    private void pauseAction() {

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
    // Log
    //================================================================================

    private void writeCommandReportLog() {
        try {
            //HERE
        } catch (Exception e) {
            String errorMessage = ("Error - "+CLASS_NAME+" (writeCommandReportLog) - Could Not Set");
            MainController.Utilities.Log.log(errorMessage);
        }
    }

    private void writeCaseNumberLog () {
        try {
            //HERE
        } catch (Exception e) {
            String errorMessage = ("Error - "+CLASS_NAME+" (writeCaseNumberLog) - Could Not Set");
            MainController.Utilities.Log.log(errorMessage);

        }
    }

    private void writeTimeLog () {
        //HERE
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
    //Print
    //================================================================================


    private void debugPrint (int myCount, CommandDataClass myCommandClass) {
        if (MainController.ValueCore.Constants.IS_DEBUG){
            myCount ++;
            String myCommand = myCommandClass.getApi_name();
            String infoMessage = "\n    - "+myCount + " :: "+myCommand;
            MainController.Utilities.Log.log(infoMessage);
        }
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
    // Run
    //================================================================================

    private int runApiCommand (CommandDataObject myCommandDataObject) {


        return CommandProcessActionClass.apiCommandConsumption(myCommandDataObject);


    }




}
