package tests;

import BaseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutCompletionPage;
import pages.LoginPage;
import pages.ShoppingCartPage;
import steps.LoginStep;
import steps.ProductStep;

public class SmokeTest extends BaseTest {

    @Test
    public void criticalPathTest(){
        CheckoutCompletionPage completionPage = new LoginPage(browsersService,true)
                .setUsername(correctUser.getUsername())
                .setPassword(correctUser.getPassword())
                .successLoginButtonClick()
                .addItemToCard("Sauce Labs Backpack")
                .cartBadgeClick()
                .checkoutButtonClick()
                .setFirstName("name")
                .setLastName("Surname")
                .setZipcode("220000")
                .continueButtonClick()
                .finishButtonClick();

        Assert.assertEquals(completionPage.getCompletionMessage().trim(), "THANK YOU FOR YOUR ORDER");

    }

    @Test
    public void loginFailedTest(){
        LoginPage loginPage = new LoginPage(browsersService,true)
                .setUsername(lockedUser.getUsername())
                .setPassword(lockedUser.getPassword())
                .loginButtonClick();

        Assert.assertEquals(loginPage.getErrorMessage().getText().trim(),"Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void removeItemCartTest(){
        ShoppingCartPage shoppingCartPage = new LoginPage(browsersService,true)
                .setUsername(correctUser.getUsername())
                .setPassword(correctUser.getPassword())
                .successLoginButtonClick()
                .addItemToCard("Sauce Labs Backpack")
                .addItemToCard("Sauce Labs Bolt T-Shirt")
                .cartBadgeClick()
                .removeButtonClick("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(shoppingCartPage.getItemsCount(), 1);

    }

    @Test
    public void criticalPathStepTest(){
       CheckoutCompletionPage completionPage = new LoginStep(browsersService)
                .successLogin(correctUser)
                .addItemToCard("Sauce Labs Backpack")
               .moveToCart()
               .compliteOrder();

        Assert.assertEquals(completionPage.getCompletionMessage().trim(), "THANK YOU FOR YOUR ORDER");
    }
}
