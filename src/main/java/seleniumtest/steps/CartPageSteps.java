package seleniumtest.steps;

import cucumber.api.DataTable;
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

    @And("^then we check if the buttons below are shown$")
    public void thenWeCheckIfTheButtonsBelowAreShown(DataTable dataTable) {
         for(int i=0;i<dataTable.raw().get(0).size();i++){
             switch ((dataTable.raw().get(0).get(i))){
                 case "Update Cart":
                     cartPage.verifyUpdateShoppingCartButtonIsShown();
                     break;
                 case "Continue Shopping":
                     cartPage.verifyContinueShoppingButtonButtonIsShown();
                     break;
                 case "Estimate shipping":
                     cartPage.verifyEstimateShippingButtonButtonIsShown();
                     break;
             }
         }
    }
}
