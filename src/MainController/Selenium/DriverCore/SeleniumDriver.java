package MainController.Selenium.DriverCore;

/*
 MainController.Selenium.DriverCore
*/

import MainController.Utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumDriver {

    //================================================================================
    // Properties
    //================================================================================

    private static final String SEPARATOR = java.nio.file.FileSystems.getDefault().getSeparator();
    private static final String USR_DIRECTORY = System.getProperty("user.dir");
    private static final String OS_NAME = System.getProperty("os.name");

    private static boolean  isOSXCheck(){
        return OS_NAME.equals("Mac OS X");
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
    // Driver return by name
    //================================================================================

    //
    // Array @ ViewService
    //

    public WebDriver returnDriver (String myDriverName, String overRideURL){
        if (myDriverName.equals("FireFox")){
            return getFireFoxWebDriver(overRideURL);
        }
        else if (myDriverName.equals("GridFireFox")) {
            return gridFireFoxWebDriver(overRideURL);
        }
        else if (myDriverName.equals("Chrome")) {
            return getChromeWebDriver();
        }
        else if (myDriverName.equals("IExplore") && !OS_NAME.equals("Mac OS X")) {
            return getIExploreWebDriver();
        }
        else if (myDriverName.equals("Safari") && OS_NAME.contains("Mac")) {
            return getSafariWebDriver();
        }
        else if (myDriverName.equals("MobileSafari") && OS_NAME.contains("Mac")) {
            return null;
        }
        else if (myDriverName.equals("Android")) {
            return null;
        }
        else {
            String errorMessage = "Error - SeleniumDriver (returnDriver) - Incorrect Driver";
            Log.log(errorMessage);
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
    // FireFox
    //================================================================================

    private WebDriver getFireFoxWebDriver(String overRideURL) {
        FirefoxProfile profile = getMyFirefoxProfile ();
        if (overRideURL != null && overRideURL.length() > 4) {
            String infoMessage = "overRideURL :: "+overRideURL;
            MainController.Utilities.Log.log(infoMessage);
            String URI_AUTH = "network.automatic-ntlm-auth.trusted-uris";
            profile.setPreference(URI_AUTH, overRideURL);
        }
        WebDriver driver = new FirefoxDriver(profile);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

        return driver;
    }

    private static FirefoxProfile getMyFirefoxProfile () {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.http.phishy-userpass-length", 255);
        profile.setPreference("reader.parse-on-load.enabled", false);
        profile.setPreference("accept_untrusted_certs", true);
        return profile;
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
    // Grid Firefox
    //================================================================================

    final static String PORT = "5555";

    private WebDriver gridFireFoxWebDriver(String overRideURL) {
        return null;
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
    //Chrome
    //================================================================================

    private WebDriver getChromeWebDriver() {
        System.setProperty("webdriver.chrome.driver", myChromeDriverDirectory());
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        return driver;
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
    //IExplore
    //================================================================================

    private WebDriver getIExploreWebDriver() {
        System.setProperty("webdriver.ie.driver", myIEDriverDirectory());
        InternetExplorerDriver driver = new InternetExplorerDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        return driver;
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
    //Safari
    //================================================================================

    private WebDriver getSafariWebDriver() {
        System.setProperty("webdriver.safari.noinstall", "true"); //To stop uninstall each time

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("safariIgnoreFraudWarning", true);
        capabilities.setCapability("safariAllowPopups", true);
        capabilities.setCapability("cleanSession", true);

        WebDriver driver = null;

        try {
            driver = new SafariDriver(capabilities);
        }
        catch (Exception e) {
            String errorMessage = "Safari Driver Error\n" + e;
            Log.log(errorMessage);
        }
        if (driver != null) {
            MainController.Utilities.Sleep.sleepForTime(2000);
        }
        else {
            String errorMessage = "Safari Driver Error";
            Log.log(errorMessage);
        }
        MainController.Utilities.Sleep.sleepForTime(1000);
        return driver;
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
    // Directories
    //================================================================================

    private static String myIEDriverDirectory () {
        String myPathAdd = SEPARATOR + "resources" + SEPARATOR + "Driver" + SEPARATOR + "IEDriverServer.exe";
        return USR_DIRECTORY + myPathAdd;
    }

    private static String myChromeDriverDirectory () {
        if(isOSXCheck()) {
            String myPathAdd = SEPARATOR + "resources" + SEPARATOR + "WebDrivers" + SEPARATOR + "chromedriver";
            return USR_DIRECTORY + myPathAdd;
        }
        else {
            String myPathAdd = SEPARATOR + "resources" + SEPARATOR + "WebDrivers" + SEPARATOR + "chromedriverwin.exe";
            return USR_DIRECTORY + myPathAdd;
        }
    }

}
