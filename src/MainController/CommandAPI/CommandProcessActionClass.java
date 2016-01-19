package MainController.CommandAPI;


import MainController.CommandAPI.WebActions.WebDriverActions;
import MainController.Utilities.Log;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;


public class CommandProcessActionClass {

    //================================================================================
    // Class
    //================================================================================

    static WebDriver theDriver;

    //================================================================================
    // Properties
    //================================================================================

    private final static String CLASS_NAME = "CommandProcessActionClass";
    private static final String METHOD_PREFIX = "api_";

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

    public CommandProcessActionClass(WebDriver myWebDriver) {
        if (theDriver == null) {
            theDriver = myWebDriver;
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
    // API command Consumption
    //================================================================================

    public static int apiCommandConsumption (CommandDataObject myCommandDataObject) {
        String myApiName = myCommandDataObject.getCommandDataApiName();
        if (ApiList.apiListHasMethod(myApiName)) {
            runApiMethodFromString(myCommandDataObject);
        }
        else {
            String errorMessage = ("Error - "+CLASS_NAME+" (apiCommandConsumption) - Command Case Not covered : " + myApiName);
            // reporter class
        }
        myCommandDataObject.setTheCurrentCommandNumber(myCommandDataObject.getTheCurrentCommandNumber() + 1);
        return  myCommandDataObject.getTheCurrentCommandNumber();
    }

    private static void runApiMethodFromString(CommandDataObject myCommandDataObject) {
        String myApiCommandName = METHOD_PREFIX+myCommandDataObject.getCommandDataApiName ();
        try {
            Class[] argTypes = new Class[] { CommandDataObject.class };
            Method m = Class.forName(CommandProcessActionClass.class.getName()).getDeclaredMethod(myApiCommandName, argTypes);
            CommandDataObject mainArgs = myCommandDataObject;
            m.invoke(null, (Object)mainArgs);
        } catch (Exception e) {
            String errorMessage = ("Error - "+CLASS_NAME+" (runApiMethodFromString) - Method named : " + myApiCommandName + " :: could not be ran");
            Log.log(errorMessage);
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
    // Command Process List
    //================================================================================

    public static void api_clickElement (CommandDataObject myCommandDataList) {
        WebDriverActions.clickElementAction(myCommandDataList, theDriver);
    }

    public static void api_elementIsVisible (CommandDataObject myCommandDataList) {
        WebDriverActions.elementIsVisibleAction(myCommandDataList, theDriver);
    }

}

