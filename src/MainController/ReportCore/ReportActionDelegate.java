package MainController.ReportCore;


import java.text.DecimalFormat;

public class ReportActionDelegate {

    //================================================================================
    // Class
    //================================================================================

    public ReportDataDelegate theReportDataDelegate;

    //================================================================================
    // Property
    //================================================================================

    private final static String CLASS_NAME = "ReportActionDelegate";

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
    // Error Log
    //================================================================================

    public void addErrorToList (String myError) {
        if (theReportDataDelegate.canErrorBeWritten(myError)) {

            double myDoubleCaseNumber = getDouble(theReportDataDelegate.getTheCurrentCaseNumber());
            String myDoubleNumberString = getDoubleString(myDoubleCaseNumber);

            recursiveErrorAction(myDoubleCaseNumber,myDoubleNumberString,myError);

            //Flag
            theReportDataDelegate.setHasTestErrorOccurred(true);

            //Write to Log
            MainController.Utilities.Log.log(myError);

        }
        else {
            theReportDataDelegate.setHasTestErrorOccurred(true);
            String errorString = "\n** Error - "+CLASS_NAME+" (addErrorToList) - "+ theReportDataDelegate.getTheCurrentCaseNumber()+ " : " + myError +" **";
            MainController.Utilities.Log.log(errorString);
        }
    }

    //        \\
    ////    \\\\
    //////\\\\\\
    //////\\\\\\
    ////    \\\\
    //        \\

    double DOUBLE_INCREMENT = 0.01;

    private void recursiveErrorAction (Double myDoubleCaseNumber, String myDoubleNumberString,String myError) {
        if (theReportDataDelegate.theErrorList.get(myDoubleNumberString) != null) {
            myDoubleCaseNumber = myDoubleCaseNumber + DOUBLE_INCREMENT;
            myDoubleNumberString = getDoubleString(myDoubleCaseNumber);

            //Recursion
            recursiveErrorAction(myDoubleCaseNumber, myDoubleNumberString, myError);
        }
        else {
            theReportDataDelegate.theErrorList.put(myDoubleNumberString, myError);
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

    double DEFAULT_DOUBLE = 0.00;
    String DEFAULT_DOUBLE_STRING = "000.00";

    private Double getDouble (String myCurrentCaseNumber) {
        try {
            return Double.parseDouble(myCurrentCaseNumber) + DEFAULT_DOUBLE;
        }
        catch (Exception e)
        {
            return DEFAULT_DOUBLE;
        }
    }

    private String getDoubleString (Double myDoubleCaseNumber) {
        DecimalFormat formatter = new java.text.DecimalFormat(DEFAULT_DOUBLE_STRING);
        try {
            return formatter.format(myDoubleCaseNumber);
        }
        catch (Exception e) {
            return "";
        }
    }

}
