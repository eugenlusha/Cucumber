package seleniumtest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import seleniumtest.nopCommerce.NotebooksPage;
import seleniumtest.nopCommercePageObject.NotebooksPageService;
import seleniumtest.utils.WebDriverFactory;

import java.util.List;

public class NotebooksPageSteps {
    NotebooksPageService notebooksPageService;
    NotebooksPage notebooksPage;

    public NotebooksPageSteps(){
        notebooksPageService=new NotebooksPageService(WebDriverFactory.getInstance().getDriver());
        notebooksPage=new NotebooksPage(WebDriverFactory.getInstance().getDriver());
    }

    @And ("^we choose to show '(.+?)' products per page$")
    public void chooseNrOrProductsPerPage(String nr){
        notebooksPageService.selectNumberOfProductsToBeShown(nr);
    }

    //    per int (\\d+)
    @Then("^we verify '(\\d+)' products are shown$")
    public void weVerifyProductsAreShown(int nr) {
        notebooksPageService.verifyNumberOfDisplayedProductsIsCorrect(nr);
    }

    @Then("^we filter by memory (\\d+) GB$")
    public void weFilterByMemoryGB(int nr) {
        switch (nr){
            case 16:
                notebooksPageService.filterProductsBy16Gb();
                break;
        }
    }

    @Then("^we remove filter by memory (\\d+) GB$")
    public void weUnfilterByMemoryGB(int nr) {
        switch (nr){
            case 16:
                notebooksPageService.unfilterProductsBy16Gb();
                break;
        }
    }

    @And("^we add products to wishlist$")
    public void weAddProductsToWishlist(DataTable dataTable) {
        List<Integer> listOfProducts=dataTable.asList(Integer.class);
        for(Integer el : listOfProducts){
            notebooksPageService.addProductToWishlistByIndex(el);
        }
    }

    @And("^we add products to cart$")
    public void weAddProductsToCart(DataTable dataTable) {
        List<Integer> listOfProducts=dataTable.asList(Integer.class);
        for(Integer el : listOfProducts){
            notebooksPageService.addProductToCartByIndex(el);
        }
    }


    @Then("^we verify number of products added to cart is '(\\d+)'$")
    public void weVerifyNumberOfProductsAddedToCartIs(int nr) {
        notebooksPageService.verifyNumberOfProductsInCart(nr);
        try{
            Thread.sleep(3000);
        }catch (Exception e){

        }
    }

    @Then("^we verify number of products added to wishlist is '(\\d+)'$")
    public void weVerifyNumberOfProductsAddedToWishlistIs(int nr) {
        notebooksPageService.verifyNumberOfProductsInWishList(nr);
    }
}
