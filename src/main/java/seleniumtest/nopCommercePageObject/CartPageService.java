package seleniumtest.nopCommercePageObject;

import seleniumtest.nopCommerce.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPageService {
    CartPage cartPage;
    public CartPageService(WebDriver driver){
        cartPage=new CartPage(driver);
    }

    public void verifyNavigationToCartPageWasSuccessful(){
        cartPage.verifyNavigationToCartPageWasSuccessful();
    }

    public void verifyButtonsAreShown(){
        cartPage.verifyContinueShoppingButtonButtonIsShown();
        cartPage.verifyUpdateShoppingCartButtonIsShown();
        cartPage.verifyEstimateShippingButtonButtonIsShown();
    }

    public void verifySumOfProductsIsCorrect(){
        double totalSum=cartPage.getSumTotal();
        double sumOfAllProducts=cartPage.getSumOfAllProducts();
        Assert.assertEquals(totalSum,sumOfAllProducts);
    }
    public void deleteFirstProduct(){
        if(cartPage.numberOfProducts()>0){
            cartPage.removeProduct(0);

        }
    }
     public void deleteProductByIndex(int i){
        if(i-1<cartPage.numberOfProducts()){
            cartPage.removeProduct(i-1);
        }
     }

     public void deleteAllProducts(){
         int totalOfProducts=cartPage.numberOfProducts();
         for(int i=0;i<totalOfProducts;i++){
             deleteFirstProduct();
             cartPage.waitForNumberOfProductsToGetUpdated(totalOfProducts-i-1);
             Assert.assertEquals(cartPage.numberOfProducts(),totalOfProducts-i-1);
         }
     }

     public void verifyCartIsEmpty(){
        cartPage.verifyCartIsEmpty();
     }

}
