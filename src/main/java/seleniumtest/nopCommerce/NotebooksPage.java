package seleniumtest.nopCommerce;

import org.openqa.selenium.By;
import seleniumtest.helpers.Functions;
import seleniumtest.helpers.Helpers;
import seleniumtest.helpers.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NotebooksPage {

     Helpers helpers;
     Functions functions;

     public NotebooksPage(WebDriver driver){
          this.helpers=new Helpers(driver);
          this.functions=new Functions(driver);
          PageFactory.initElements(driver,this);
     }
     public void setDriver(WebDriver driver){
          this.helpers=new Helpers(driver);
          this.functions=new Functions(driver);
          PageFactory.initElements(driver,this);
     }
     @FindBy(xpath = "//select[@id='products-pagesize']")
     WebElement numberOfProductsPerPageSelectList;

     @FindBy(id = "attribute-option-10")
     WebElement filterBy16Gb;

     @FindBy(xpath = "//div[@class='item-grid']/div")
     List<WebElement> listOfDisplayedElements;

     @FindBy(xpath = "//button[@class='button-2 add-to-wishlist-button']")
     List<WebElement> addProductToWishlistButtonList;

     @FindBy(xpath = "//div[@class='bar-notification success']")
     WebElement addingToWishlistOrCartSuccessNotification;


     @FindBy(xpath = "//div[@id='bar-notification']//span")
     WebElement successBannerClosingButton;

     @FindBy(xpath = "//button[@class='button-2 product-box-add-to-cart-button']")
     List<WebElement> addProductToShoppingCartButtonList;


     @FindBy(xpath = "//a[@href='/wishlist']//span[2]")
     WebElement wishlistNumberOfProductsAdded;

     @FindBy(xpath = "//a[@href='/cart']//span[2]")
     WebElement cartNumberOfProductsAdded;


     public WebElement getNumberOfProductsPerPageSelectList() {
          return numberOfProductsPerPageSelectList;
     }

     public void chooseNumberOrProductsShown(String nr){
          helpers.selectByVisibleText(numberOfProductsPerPageSelectList,nr);
     }

     public WebElement getFilterBy16Gb() {
          return filterBy16Gb;
     }


     public List<WebElement> getListOfDisplayedElements() {
          return listOfDisplayedElements;
     }

     public int getNumberOfProductsActuallyDisplayed(){
          return listOfDisplayedElements.size();
     }

     public WebElement getAddingToWishlistOrCartSuccessNotification() {
          return addingToWishlistOrCartSuccessNotification;
     }

     public WebElement getSuccessBannerClosingButton() {
          return successBannerClosingButton;
     }

     public WebElement getWishlistNumberOfProductsAdded() {
          return wishlistNumberOfProductsAdded;
     }

     public WebElement getCartNumberOfProductsAdded() {
          return cartNumberOfProductsAdded;
     }

     public List<WebElement> getAddProductToWishlistButtonList() {
          return addProductToWishlistButtonList;
     }

     public int getNumberOrProductsAddableToWishlist(){
          return  addProductToWishlistButtonList.size();
     }

     public int getNumberOrProductsAddableToCart(){
          return  addProductToShoppingCartButtonList.size();
     }

     public void selectNumberOfProductsPerPage(String str){
          helpers.selectByVisibleText(numberOfProductsPerPageSelectList,str);
          helpers.waitUntilStalenessOfElement(listOfDisplayedElements.get(0));
     }

     public WebElement getFirstShownProduct(){
          return listOfDisplayedElements.get(0);
     }

     public void waitForListOfElementsToBeRefreshed(WebElement element){
          helpers.waitUntilStalenessOfElement(element);
     }
     public void filterProductsBy16Gb(){
          if(!helpers.isElementSelected(filterBy16Gb)){
              helpers.clickElement(filterBy16Gb);
          }
          helpers.waitUntilStalenessOfElement(listOfDisplayedElements.get(0));
     }

     public void unfilterProductsBy16Gb(){
          if(helpers.isElementSelected(filterBy16Gb)){
               helpers.clickElement(filterBy16Gb);
          }
          helpers.waitUntilStalenessOfElement(listOfDisplayedElements.get(0));
     }

     public void verifyUrlOfNotebooksPage(){
          helpers.assertWebpageLinkIsAsExpected(Constants.notebooksPageURL);
     }


     public void addProductToWishlistByIndex(int position) {
          try {
               helpers.clickElement(addProductToWishlistButtonList.get(position - 1));
               helpers.waitUntilElementIsVisible(addingToWishlistOrCartSuccessNotification);
               Thread.sleep(3000);
          }catch (Exception e){

          }
          //helpers.assertElementHasText(addingToWishlistOrCartSuccessNotification,Constants.addedToWishlistSuccessMessage);
          //helpers.waitUntilElementIsInvisible(addingToWishlistOrCartSuccessNotification);
     }

     public void addProductToCartByIndex(int position){
          try {
               helpers.clickElement(addProductToShoppingCartButtonList.get(position - 1));
               helpers.waitUntilElementIsVisible(addingToWishlistOrCartSuccessNotification);
               Thread.sleep(3000);
          }catch (Exception e){

          }
          //helpers.assertElementHasText(addingToWishlistOrCartSuccessNotification,Constants.addedToCartSuccessMessage);
          //helpers.waitUntilElementIsInvisible(addingToWishlistOrCartSuccessNotification);
     }

     public String getNumberOfProductsAddedToWishlist(){
          return wishlistNumberOfProductsAdded.getText();
     }
     public String getNumberOfProductsAddedToCart(){
          return cartNumberOfProductsAdded.getText();
     }



}
