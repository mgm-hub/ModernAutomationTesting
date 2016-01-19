package MainController.RunCore;


import MainController.CommandAPI.CommandDataClass;
import MainController.CommandAPI.CommandProcessRun;
import MainController.Selenium.DriverCore.SeleniumDriver;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainLineCode {

    public static void main(String[] args) throws Exception {
        //empty

        //0.0
        //TEST_web_driver_build ();

        //0.1
        TEST_engine_run () ;

    }

    private static void TEST_engine_run () {


        CommandDataClass myCommandDataClass_I = new CommandDataClass ();
        myCommandDataClass_I.setApi_name("elementIsVisible");
        myCommandDataClass_I.setApi_value("/html/body/div/div[5]/span/center/div[1]/div");
        CommandDataClass myCommandDataClass_II = new CommandDataClass ();
        myCommandDataClass_II.setApi_name("elementIsVisible");
        myCommandDataClass_II.setApi_value("html body#gsr.hp.vasq div#viewport.ctr-p div#searchform.jhp.big form#tsf.tsf div.tsf-p div.jsb center input");
        CommandDataClass[] myCommandDataClassArray = {myCommandDataClass_I,myCommandDataClass_II };


        SeleniumDriver mySeleniumDriver = new SeleniumDriver ();
        WebDriver myWebDriver = mySeleniumDriver.returnDriver("FireFox", "");

        myWebDriver.get("http://www.google.com");

        CommandProcessRun myCommandProcessRun = new CommandProcessRun();
        myCommandProcessRun.runActionInit(myWebDriver,myCommandDataClassArray );


    }

    private static void TEST_web_driver_build () {
        SeleniumDriver mySeleniumDriver = new SeleniumDriver ();
        WebDriver myWebDriver = mySeleniumDriver.returnDriver("FireFox", "");
        TEST_web_driver(myWebDriver);
    }

    private static void TEST_web_driver (WebDriver myWebDriver) {
        if (myWebDriver != null) {
            System.out.print("\nStarting Test");
            myWebDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            myWebDriver.manage().timeouts().pageLoadTimeout(120000, TimeUnit.MILLISECONDS);
            myWebDriver.get("http://www.google.com");
            MainController.Utilities.Sleep.sleepForTime(5000);
            myWebDriver.quit();
        } else {
            System.out.print("\nDriver was null");
        }
    }


}
