package MainController.Selenium.ActionCore;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@SuppressWarnings({"static-member","static-access","unused","StatementWithEmptyBody"})
public class SeleniumActions {

    private final static String CLASS_NAME = "SeleniumActions";

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
    // Element is Visible
    //================================================================================

    public static Boolean elementIsVisible (String myPath, WebDriver driver, Boolean reportsError) {
        WebElement myElement = null;
        myElement = getWebElement(myPath, driver, reportsError);
        if (myElement != null && myElement.isDisplayed()){
            return true;
        }
        else {
            return false;
        }
    }

    public static Boolean elementIsNotVisible (String myPath, WebDriver driver, Boolean reportsError) {
        WebElement myElement = null;
        myElement = getWebElement(myPath, driver, reportsError);
        if (myElement == null || myElement.isDisplayed()){
            return true;
        }
        else {
            return false;
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
    // Find Element
    //================================================================================

    public static WebElement getWebElement(String myPath, WebDriver driver, Boolean reportsError) {
        if (myPath != null && myPath.length() > 0){
            WebElement myElement = null;

            myElement = findByXpath(myPath, driver);

            if (myElement == null){
                findByCSSPath(myPath, driver);
            }
            if (myElement == null){
                findByID(myPath, driver);
            }
            if (myElement == null){
                findByClassName(myPath, driver);
            }

            if (myElement != null) {
                return myElement;
            }
            else {
                String errorMessage = ("Error - "+CLASS_NAME+" (findElement) - No Element : " + myPath);
                // reporter class
                return null;
            }
        }
        else {
            String errorMessage = ("Error - "+CLASS_NAME+" (findElement) - No Path : " + myPath);
            // reporter class
            return null;
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
    // Click Element
    //================================================================================

    public static void clickElement(WebElement myElement, String myPath, WebDriver driver,  Boolean reportsError) {
        if (myElement != null && myElement.isDisplayed()) {
            boolean clickHasFailed = wasClickUnsuccessful(myElement);
            if (clickHasFailed){
                moveToElement(driver, myElement, reportsError);
                boolean clickHasFailedAgain = wasClickUnsuccessful(myElement);
                if (clickHasFailedAgain){
                    boolean hasFailedThrice = sendEnterToElement(myElement, reportsError);
                    if (hasFailedThrice){
                        String errorMessage = ("Error - "+CLASS_NAME+" (clickElementAction) - Element Is Not clickable");
                        // reporter class
                    }
                }
            }
        }
        else {
            String errorMessage = ("Error - "+CLASS_NAME+" (clickElementAction) - Element Is Not Visible : " + myPath);
            // reporter class
        }
    }

    private static Boolean wasClickUnsuccessful (WebElement myElement){
        try {
            myElement.click();
            return false;
        }
        catch (Exception e){
            return true;
        }
    }

    //--------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------
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
    //--------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------

    //================================================================================
    // Move to Element
    //================================================================================

    private static void moveToElement (WebDriver driver, WebElement myElement, Boolean reportsError) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(myElement).perform();
        }
        catch (Exception e){
            String errorMessage = ("Error - "+CLASS_NAME+" (moveToElement) - Could not move to element");
            // reporter class
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
    // Move to Element
    //================================================================================

    public static Boolean sendEnterToElement (WebElement myElement, Boolean reportsError) {
        if (myElement != null && myElement.isDisplayed()) {
            try {
                myElement.sendKeys(Keys.ENTER);
                return  false;
            }
            catch (Exception e){
                return true;
            }
        }
        else {
            String errorMessage = ("Error - "+CLASS_NAME+" (sendEnterToElement) - Element not visible ");
            // reporter class
            return true;
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
    // Selenium Find Methods
    //================================================================================

    public static WebElement findByXpath(String myPath, WebDriver driver) {
        try {
            return driver.findElement(By.xpath(myPath));
        } catch (Exception e) {
            return null;
        }
    }

    public static WebElement findByCSSPath(String myPath, WebDriver driver) {
        try {
            return driver.findElement(By.cssSelector(myPath));
        } catch (Exception e) {
            return null;
        }
    }

    public static WebElement findByID(String myPath, WebDriver driver) {
        try {
            return driver.findElement(By.id(myPath));
        } catch (Exception e) {
            return null;
        }
    }

    public static WebElement findByClassName(String myPath, WebDriver driver) {
        try {
            return driver.findElement(By.className(myPath));
        } catch (Exception e) {
            return null;
        }
    }

    }
