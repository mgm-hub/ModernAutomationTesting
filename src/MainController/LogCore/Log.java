package MainController.LogCore;

/*
MainController.LogCore.Log.log.
*/

public class Log {
    public static void log (String myString) {
        if (myString != null && MainController.ValueCore.Constants.IS_SHOWING_CONSOLE){
            System.out.print("\n"+myString);
        }
    }
}