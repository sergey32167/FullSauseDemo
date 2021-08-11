package BaseEntities;

import core.BrowsersService;
import core.ReadProperties;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.Listener;

@Listeners(Listener.class)
public abstract class BaseTest {
    public BrowsersService browsersService;
    protected User correctUser;
    protected User lockedUser;

    @BeforeSuite
    public void prepareData(){
        correctUser = User.builder()
                .username("standard_user")
                .password("secret_sauce")
                .build();

        lockedUser = User.builder()
                .username("locked_out_user")
                .password("secret_sauce")
                .build();
    }

    @BeforeMethod
    public void startBrowser() {
        browsersService = new BrowsersService();
    }

    @AfterMethod
    public void closeBrowser() {
        browsersService.getDriver().quit();
        browsersService = null;
    }
}
