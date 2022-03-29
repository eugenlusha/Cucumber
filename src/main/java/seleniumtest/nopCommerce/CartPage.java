package seleniumtest.nopCommerce;

import seleniumtest.helpers.Functions;
import seleniumtest.helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CartPage {
    Helpers helpers;
    Functions functions;
    public CartPage(WebDriver driver){
        this.helpers=new Helpers(driver);
        this.functions=new Functions(driver);
        PageFactory.initElements(driver,this);
    }
    public void setDriver(WebDriver driver){
        helpers=new Helpers(driver);
        this.functions=new Functions(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//button[@class='remove-btn'][1]")
    WebElement firstProductRemoveButton;

    @FindBy(xpath = "//button[@class='remove-btn']")
    List<WebElement> productsRemoveButtonList;

    @FindBy(className = "no-data")
    WebElement emptyCartMessage;

    @FindBy(xpath = "//a[@href='/cart']//span[2]")
    WebElement cartNumberOfProductsAdded;

    @FindBy(xpath = "//a[@class='product-name']")
    WebElement firstProductName;

    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement pageMainTitle;

    @FindBy(xpath = "//button[@class='button-2 update-cart-button']")
    WebElement updateShoppingCartButton;

    @FindBy(xpath = "//button[@class='button-2 continue-shopping-button']")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//a[@class='estimate-shipping-button']")
    WebElement estimateShippingButton;

    @FindBy(xpath = "//span[@class='product-subtotal']")
    List<WebElement> productsPriceList;

    @FindBy(xpath = "//span[@class='value-summary']//strong")
    WebElement totalSum;

    public List<WebElement> getProductsRemoveButtonList() {
        return productsRemoveButtonList;
    }

    public WebElement getEmptyCartMessage() {
        return emptyCartMessage;
    }

    public WebElement getFirstProductRemoveButton() {
        return firstProductRemoveButton;
    }

    public WebElement getCartNumberOfProductsAdded() {
        return cartNumberOfProductsAdded;
    }

    public WebElement getFirstProductName() {
        return firstProductName;
    }

    public WebElement getPageMainTitle() {
        return pageMainTitle;
    }

    public WebElement getUpdateShoppingCartButton() {
        return updateShoppingCartButton;
    }

    public WebElement getContinueShoppingButton() {
        return continueShoppingButton;
    }

    public WebElement getEstimateShippingButton() {
        return estimateShippingButton;
    }

    public List<WebElement> getProductsPriceList() {
        return productsPriceList;
    }

    public WebElement getTotalSum() {
        return totalSum;
    }

    public int numberOfProducts(){
        return productsRemoveButtonList.size();
    }

    public void removeProduct(int i){
        WebElement element=productsRemoveButtonList.get(i);
        helpers.clickElement(productsRemoveButtonList.get(i));
        helpers.waitUntilStalenessOfElement(element);

    }


    public void deleteProductByIndex(int index){
        if(index<productsRemoveButtonList.size()){
            helpers.clickElement(productsRemoveButtonList.get(index));
        }
    }

    public void deleteAllProductsInCart() {
        int totalOfProducts=helpers.getNumberOfElements(productsRemoveButtonList);
        int tmp;
        for(tmp=totalOfProducts-1;tmp>=0;tmp--){
            deleteProductByIndex(tmp);
            helpers.waitForTextOfElementToBe("//a[@href='/cart']//span[2]","("+(tmp)+")");
            verifyNumberOfProductsInCart(tmp);
        }
    }
    public void waitForNumberOfProductsToGetUpdated(int nr){
        helpers.waitForTextOfElementToBe("//a[@href='/cart']//span[2]","("+(nr)+")");
    }

    public void verifyNumberOfProductsInCart(int nr){
        int total=helpers.getNumberOfElements(productsRemoveButtonList);
        Assert.assertEquals(total,nr);
    }


    public void verifyCartIsEmpty(){
        Assert.assertTrue(emptyCartMessage.isDisplayed());
    }

    public void verifyNavigationToCartPageWasSuccessful(){
        helpers.assertElementIsVisible(pageMainTitle);
    }


    public void verifyUpdateShoppingCartButtonIsShown(){
        helpers.assertElementIsVisible(updateShoppingCartButton);
    }

    public void verifyContinueShoppingButtonButtonIsShown(){
        helpers.assertElementIsVisible(continueShoppingButton);
    }

    public void verifyEstimateShippingButtonButtonIsShown(){
        helpers.assertElementIsVisible(estimateShippingButton);
    }

    public double getSumTotal(){
        return functions.parseToDoubleFromString(totalSum.getText());
    }

    public double getSumOfAllProducts(){
        double sum=0;
        for(WebElement element: productsPriceList){
            sum+=functions.parseToDoubleFromString(element.getText());
        }
        return sum;
    }
    public void waitForNumberOrProductsToBe(int nr){
        helpers.waitForNumberOfElementsToBe(By.xpath("//button[@class='remove-btn']"),nr);
    }


}
