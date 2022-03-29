package seleniumtest.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import seleniumtest.nopCommerce.CartPage;
import seleniumtest.nopCommercePageObject.CartPageService;
import seleniumtest.utils.WebDriverFactory;

public class CartPageSteps {
    CartPageService cartPageService;
    CartPage cartPage;
     public CartPageSteps(){
         cartPage=new CartPage(WebDriverFactory.getInstance().getDriver());
         cartPageService=new CartPageService(WebDriverFactory.getInstance().getDriver());
     }

    @Then("^we verify sum of products is the same as total price")
    public void verifySum() {
        cartPageService.verifySumOfProductsIsCorrect();
    }

    @And("^we check if the cart action buttons are displayed$")
    public void weCheckIfTheCartActionButtonsAreDisplayed() {
         cartPageService.verifyButtonsAreShown();
    }

    @And("^we delete the first product in cart while verifying the product was deleted$")
    public void weDeleteTheFirstProductInCart() {
         cartPageService.deleteFirstProduct();
    }

    @Then("^we delete all products in cart while verifying the products are deleted$")
    public void weDeleteAllProductsInCart() {
         cartPageService.deleteAllProducts();
    }

    @Then("^we verify cart is empty$")
    public void weVerifyCartIsEmpty() {
         cartPageService.verifyCartIsEmpty();
    }
}
