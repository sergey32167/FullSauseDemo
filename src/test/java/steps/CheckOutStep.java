package steps;

import BaseEntities.BaseStep;
import core.BrowsersService;
import pages.CheckoutCompletionPage;
import pages.ShoppingCartPage;

public class CheckOutStep extends BaseStep {
    public CheckOutStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public CheckoutCompletionPage compliteOrder(){
        return new ShoppingCartPage(browsersService,false)
                .checkoutButtonClick()
                .setFirstName("name")
                .setLastName("Surname")
                .setZipcode("220000")
                .continueButtonClick()
                .finishButtonClick();

    }

}
