package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Waits;

public class BrowsersService {
    private WebDriver driver = null;
    private Waits waits;

    public BrowsersService() {
        switch (ReadProperties.getInstance().getBrowserName().toLowerCase()) {
            case "chrome":
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(ReadProperties.getInstance().isHeadless());
                chromeOptions.addArguments("--disable-gpu");
                //chromeOptions.addArguments("--window-size=1920,1200");
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--silent");
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Browser " + ReadProperties.getInstance().getBrowserName() + " is not supported.");
        }
        waits = new Waits(driver, ReadProperties.getInstance().getTimeOut());
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Waits getWaits() {
        return waits;
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
