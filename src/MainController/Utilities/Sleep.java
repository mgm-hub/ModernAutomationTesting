package MainController.Utilities;

/*
MainController.Utilities.Sleep.sleepForTime();
*/

public class Sleep {
    public static void sleepForTime (Integer myInt) {
        try {
            Thread.sleep(myInt);
        }
        catch (Exception e){
            //empty
        }
    }
}
