package steps;

import BaseEntities.BaseStep;
import core.BrowsersService;
import pages.ProductsPage;

public class ProductStep extends BaseStep {

    public ProductStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public ProductStep addItemToCard(String productName){
        new ProductsPage(browsersService,false).getItemAddToCartButton(productName).click();
        return  this;
    }

    public CheckOutStep moveToCart(){
       new ProductsPage(browsersService,false).cartBadgeClick();
return new CheckOutStep(browsersService);
    }
}
