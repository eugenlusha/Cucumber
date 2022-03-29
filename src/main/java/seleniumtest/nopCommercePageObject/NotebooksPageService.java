package seleniumtest.nopCommercePageObject;

import seleniumtest.nopCommerce.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NotebooksPageService {
    NotebooksPage notebooksPage;
    public  NotebooksPageService(WebDriver driver){
        notebooksPage= new NotebooksPage(driver);
    }

    public void verifyUrlOfNotebooksPage(){
        notebooksPage.verifyUrlOfNotebooksPage();
    }

    public void selectNumberOfProductsToBeShown(String nr){
        WebElement el=notebooksPage.getFirstShownProduct();
        notebooksPage.selectNumberOfProductsPerPage(nr);
        notebooksPage.waitForListOfElementsToBeRefreshed(el);
    }

    public void verifyNumberOfDisplayedProductsIsCorrect(int nr){
        Assert.assertEquals(notebooksPage.getNumberOfProductsActuallyDisplayed(),nr);
    }

    public void filterProductsBy16Gb() {
        WebElement el=notebooksPage.getFirstShownProduct();
        notebooksPage.filterProductsBy16Gb();
        notebooksPage.waitForListOfElementsToBeRefreshed(el);
    }

    public void unfilterProductsBy16Gb(){
        WebElement el=notebooksPage.getFirstShownProduct();
        notebooksPage.unfilterProductsBy16Gb();
        notebooksPage.waitForListOfElementsToBeRefreshed(el);
    }

    public void addProductToWishlistByIndex(int i){
        if(i<=notebooksPage.getNumberOrProductsAddableToWishlist()){
            notebooksPage.addProductToWishlistByIndex(i);
        }
    }

    public void addProductToCartByIndex(int i){
        if(i<=notebooksPage.getNumberOrProductsAddableToCart()){
            notebooksPage.addProductToCartByIndex(i);
        }
    }

    public void verifyNumberOfProductsInWishList(int number){
        String value="("+number+")";;
        Assert.assertEquals(notebooksPage.getNumberOfProductsAddedToWishlist(),value);
    }
    public void verifyNumberOfProductsInCart(int number){
        String value="("+number+")";;
        Assert.assertEquals(notebooksPage.getNumberOfProductsAddedToCart(),value);
    }



}
