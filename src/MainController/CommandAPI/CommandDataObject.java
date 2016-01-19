package MainController.CommandAPI;

public class CommandDataObject {

    //================================================================================
    // Properties
    //================================================================================

    private  CommandDataClass theCommandData;
    private  int theCurrentCommandNumber;
    private  CommandDataClass[] theCommandDataClassArray;

    //================================================================================
    // Constructor
    //================================================================================

    public CommandDataObject(CommandDataClass[] myCommandDataClassArray) {
        theCommandData = null;
        theCurrentCommandNumber = 0;
        theCommandDataClassArray = myCommandDataClassArray;
    }

    //================================================================================
    // Value Return
    //================================================================================

    public String getCommandDataApiName () {
        if (theCommandData != null) {
            return theCommandData.getApi_name();
        }
        else {
            return null;
        }
    }

    public String getCommandDataApiValue () {
        if (theCommandData != null) {
            return theCommandData.getApi_value();
        }
        else {
            return null;
        }
    }

    //================================================================================
    // Existential
    //================================================================================

    public Boolean isCommandDataListNotEmpty (){
        return theCommandDataClassArray != null && theCommandDataClassArray.length > 0;
    }

    public Boolean doesMyCommandDataExist (){
        return theCommandDataClassArray != null && theCommandDataClassArray.length >= theCurrentCommandNumber;
    }

    //================================================================================
    // Size
    //================================================================================

    public int sizeOfCommandDataClassArray () {
        return  theCommandDataClassArray.length;
    }

    //================================================================================
    // Getters and Setters
    //================================================================================

    public void setTheCommmandData(CommandDataClass theCommandData) {
        this.theCommandData = theCommandData;
    }

    public void setTheCurrentCommandNumber(int theCurrentCommandNumber) {
        this.theCurrentCommandNumber = theCurrentCommandNumber;
    }

    public void setTheCommandDataClassArray(CommandDataClass[] theCommandDataClassArray) {
        this.theCommandDataClassArray = theCommandDataClassArray;
    }

    public CommandDataClass getTheCommmandData() {
        return theCommandData;
    }

    public int getTheCurrentCommandNumber() {
        return theCurrentCommandNumber;
    }

    public CommandDataClass[] getTheCommandDataClassArray() {
        return theCommandDataClassArray;
    }
}
