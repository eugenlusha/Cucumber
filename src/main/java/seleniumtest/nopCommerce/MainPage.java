package seleniumtest.nopCommerce;


import org.testng.Assert;
import seleniumtest.helpers.Functions;
import seleniumtest.helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
    private Helpers helpers;
    Functions functions;
    public void setDriver(WebDriver driver){
        this.helpers=new Helpers(driver);
        this.functions=new Functions(driver);
        PageFactory.initElements(driver,this);
    }
    public MainPage(WebDriver driver){
        this.helpers=new Helpers(driver);
        this.functions=new Functions(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "ico-login")
    WebElement loginPageRedirectingButton;

    @FindBy(className = "ico-logout")
    WebElement logoutButton;

    @FindBy(className ="ico-register")
    WebElement registerPageRedirectingButton;

    @FindBy(xpath = "//a[@href='/wishlist']")
    WebElement wishList;

    @FindBy(className = "search-box-text")
    WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit'][@class='button-1 search-box-button']")
    WebElement searchBoxQueryExecutorButton;

    @FindBy(className = "topic-block-title")
    WebElement mainPageWelcomingMessage;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[@href='/computers']")
    WebElement computersPageRedirectingLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[@href='/notebooks']")
    WebElement notebooksPageRedirectingLink;

    @FindBy(className = "ico-account")
    WebElement myAccountPageRedirectingLink;

    @FindBy(className = "cart-label")
    WebElement cartPageRedirectinLink;

    @FindBy(xpath = "//button[@class='button-1 cart-button']")
    WebElement goToCartButton;

    public WebElement getCartPageRedirectinLink() {
        return cartPageRedirectinLink;
    }

    public WebElement getMyAccountPageRedirectingLink() {
        return myAccountPageRedirectingLink;
    }

    public  WebElement getLoginPageRedirectingButton() {
        return loginPageRedirectingButton;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getRegisterPageRedirectingButton() {
        return registerPageRedirectingButton;
    }

    public WebElement getWishList() {
        return wishList;
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchBoxQueryExecutorButton() {
        return searchBoxQueryExecutorButton;
    }

    public WebElement getMainPageWelcomingMessage() {
        return mainPageWelcomingMessage;
    }

    public WebElement getComputersPageRedirectingLink() {
        return computersPageRedirectingLink;
    }

    public WebElement getNotebooksPageRedirectingLink() {
        return notebooksPageRedirectingLink;
    }
    public void goToLoginPage(){
        helpers.clickElement(loginPageRedirectingButton);
    }
    public void logOutOfAccount(){
        helpers.clickElement(logoutButton);
    }
    public void goToRegisterPage(){
        helpers.clickElement(registerPageRedirectingButton);
    }
    public void hoverComputerMenu(){
        helpers.hoverElement(computersPageRedirectingLink);
    }
    public void hoverCartMenu(){
        helpers.hoverElement(cartPageRedirectinLink);
    }
    public void goToNotebooksPage(){
        hoverComputerMenu();
        helpers.clickElement(notebooksPageRedirectingLink);
    }
    public void goToMyAccountPage(){
        helpers.clickElement(myAccountPageRedirectingLink);
    }

    public void goToCart(){
        helpers.clickElement(cartPageRedirectinLink);
    }

    public void verifyLoginWasSuccessful(){
        helpers.assertElementIsVisible(logoutButton);
        helpers.assertElementHasText(mainPageWelcomingMessage,"Welcome to our store");
    }
    public void urlIsAsExpected(String url){
        helpers.assertWebpageLinkIsAsExpected(url);
    }

    public void goToCartThroughButtonAfterHoveringCartMenu(){
        hoverCartMenu();
        helpers.assertElementIsVisible(goToCartButton);
        goToCartButton.click();
    }

    public String getCurrentUrl(){
        return helpers.getCurrentURL();
    }

}
