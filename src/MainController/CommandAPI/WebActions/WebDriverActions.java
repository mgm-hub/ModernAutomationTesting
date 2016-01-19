package MainController.CommandAPI.WebActions;

import MainController.CommandAPI.CommandDataObject;
import MainController.Selenium.ActionCore.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverActions {

    public static void clickElementAction (CommandDataObject myCommandDataObject, WebDriver driver) {
        String myPath = myCommandDataObject.getCommandDataApiValue();
        WebElement myElement = null;
        if (myPath != null) {
            myElement = SeleniumActions.getWebElement(myPath, driver, false);
        }
        if (myElement != null) {
            SeleniumActions.clickElement(myElement, myPath, driver, false);
        }
    }

    public static void elementIsVisibleAction (CommandDataObject myCommandDataObject, WebDriver driver) {
        String myPath = myCommandDataObject.getCommandDataApiValue();
        WebElement myElement = null;
        if (myPath != null) {
            myElement = SeleniumActions.getWebElement(myPath, driver, false);
        }
        if (myElement != null) {
            SeleniumActions.elementIsVisible(myPath, driver, false);
        }


    }



}
