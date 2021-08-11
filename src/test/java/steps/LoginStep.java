package steps;

import BaseEntities.BaseStep;
import core.BrowsersService;
import models.User;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginStep extends BaseStep {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    public LoginStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public ProductStep successLogin(User user){
         productsPage = new LoginPage(browsersService,true)
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .successLoginButtonClick();
        return new ProductStep(browsersService);
    }

    public LoginStep incorrectLogin(User user){
        productsPage = new LoginPage(browsersService,true)
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .successLoginButtonClick();
        return this;
    }

}
