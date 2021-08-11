package BaseEntities;

import core.BrowsersService;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ShoppingCartPage;

public abstract class BaseStep {
    public BrowsersService browsersService;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ShoppingCartPage shoppingCartPage;

    public BaseStep(BrowsersService browsersService) {
        this.browsersService = browsersService;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(browsersService, false);
    }

    public ProductsPage getProductPage() {
        return new ProductsPage(browsersService, false);
    }

    public ShoppingCartPage getShoppingCartPage() {
        return new ShoppingCartPage(browsersService, false);
    }

}


