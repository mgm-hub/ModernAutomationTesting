package MainController.ReportCore;


public class KeyValuePair {

    //================================================================================
    // Property
    //================================================================================

    private static String MARKER = " $$ ";
    private final static String CLASS_NAME = "KeyValuePair";

    //================================================================================
    // Data Holder
    //================================================================================

    private static String theKey;
    private static String theValue;

    //================================================================================
    // Getter
    //================================================================================

    public static String getMarker() {
        return MARKER;
    }

    //================================================================================
    // Builder
    //================================================================================

    public static String combineKeyAndValue (String myKey, String myValue){
        return myKey+MARKER+myValue;
    }

    //        \\
    ////    \\\\
    //////\\\\\\
    //////\\\\\\
    ////    \\\\
    //        \\

    public static KeyValuePair buildKeyValuePairFromSentence (String mySentence){
        if (mySentence.length() > 0 ) {
            int myIndexToMarker = mySentence.indexOf(MARKER);
            String myPreSubString = mySentence.substring(0, myIndexToMarker);
            String myPostSubString = mySentence.substring(myIndexToMarker + MARKER.length(), mySentence.length());

            if (myPreSubString.length() > 0 && myPostSubString.length() > 0) {
                KeyValuePair myKeyValuePair = new KeyValuePair();
                theKey = myPreSubString;
                theValue = myPostSubString;
                return myKeyValuePair;
            } else {
                String errorMessage = ("Error -  "+CLASS_NAME+" (buildKeyValuePair) - incorrect phrasing or null value - "+mySentence);
                System.out.print(errorMessage);
                MainController.Utilities.Log.log(errorMessage);
                return null;
            }
        }
        else {
            String errorMessage = ("Error -  "+CLASS_NAME+" (buildKeyValuePair) - empty string");
            System.out.print(errorMessage);
            MainController.Utilities.Log.log(errorMessage);
            return null;
        }
    }






}
