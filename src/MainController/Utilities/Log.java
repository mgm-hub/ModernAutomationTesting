package MainController.Utilities;

/*
MainController.Utilities.Log.log();
        if (MainController.ValueCore.Constants.IS_DEBUG){
            String infoMessage = "";
            MainController.Utilities.Log.log(infoMessage);
        }

*/

public class Log {
    public static void log (String myString) {
        if (myString != null && MainController.ValueCore.Constants.IS_SHOWING_CONSOLE){
            System.out.print("\n"+myString);
        }
    }
}
