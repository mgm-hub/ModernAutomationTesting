package MainController.ReportCore;


import java.util.ArrayList;

public class KeyValueGroup {

    //================================================================================
    // Properties
    //================================================================================

    public String theKey;
    public ArrayList<String> theValueList = new ArrayList<>();
    public ArrayList<Double> theDoubleList = new ArrayList<>();

    public String theDoubleSumString;
    public double theDoubleSumDouble;

    //================================================================================
    // Double Sum Builder and Getter
    //================================================================================

    public void buildDoubleListFromStringListConversion() {
        theDoubleList.clear();
        for (String myString : theValueList) {
            double myDouble;
            String myCleanedString = myString.replaceAll(",","");
            try {
                myDouble = Double.parseDouble(myCleanedString);
                theDoubleList.add(myDouble);
            }
            catch (Exception e) {
                //empty
            }
        }
    }

    public void computeDoubleSum () {
        double myDoubleSum = 0.0;
        for (double myDouble : theDoubleList) {
            myDoubleSum = myDoubleSum + myDouble;
        }

        String myDoubleNumberString = null;
        try  {
            myDoubleNumberString = String.format("%.2f", myDoubleSum);
        }
        catch (Exception e) {
            //empty
        }
        if (myDoubleNumberString != null && myDoubleNumberString.length() > 0) {
            theDoubleSumString = myDoubleNumberString;
            theDoubleSumDouble = myDoubleSum;
        }
    }

    public String buildAndReturnComputedString () {
        buildDoubleListFromStringListConversion();
        computeDoubleSum();
        return theDoubleSumString;
    }

    public void removeLastEntry() {
        if (theValueList != null && theValueList.size() > 0) {
            theValueList.remove(theValueList.size() - 1);
        }
    }

}
