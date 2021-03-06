package cloud.autotests.helpers;

import cloud.autotests.config.App;
import cloud.autotests.config.Project;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverSettings {

    public static void configure() {
        Configuration.browser = Project.config.browser();
        Configuration.browserVersion = Project.config.browserVersion();
        Configuration.browserSize = Project.config.browserSize();
        Configuration.baseUrl = App.config.webUrl();




        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        Configuration.browserCapabilities = capabilities;
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--force-device-scale-factor=1");
        chromeOptions.addArguments("--lang=en-en");
        chromeOptions.addArguments("--disable-gpu");
        WebDriverManager.chromedriver().forceDownload().setup();





        if (Project.isWebMobile()) { // for chrome only
            Map<String, Object> mobileDevice = new HashMap<>();
            mobileDevice.put("deviceName", Project.config.browserMobileView());
            chromeOptions.setExperimentalOption("mobileEmulation", mobileDevice);
        }

        if (Project.isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            //Configuration.remote = Project.config.remoteDriverUrl();


        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}
