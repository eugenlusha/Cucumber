package seleniumtest.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import seleniumtest.helpers.Constants;
import seleniumtest.nopCommerce.MainPage;
import seleniumtest.nopCommercePageObject.MainPageService;
import seleniumtest.utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class MainPageSteps {

    public static MainPage mainPage;

    public MainPageSteps(){
        mainPage=new MainPage(WebDriverFactory.getInstance().getDriver());
    }

    @Then("^print URL$")
    public void printUrl() {
        System.out.println(WebDriverFactory.getInstance().getDriver().getCurrentUrl());
    }

    @Given("^the webpage '(.+?)' is opened$")
    public void loadPage(String str){
        WebDriver webDriver=WebDriverFactory.getInstance().getDriver();
        webDriver.navigate().to(str);
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

    }

    @Then("^we navigate to '(.+?)' page$")
    public void weNavigateToPage(String str) {

        switch (str){
            case "Login":
                mainPage.goToLoginPage();
                break;
            case "Notebooks":
                mainPage.goToNotebooksPage();
                break;
            case "MyAccount":
                mainPage.goToMyAccountPage();
                break;
            case "Cart":
                mainPage.goToCartThroughButtonAfterHoveringCartMenu();
                break;
            case "Register":
                mainPage.goToRegisterPage();
                break;
        }
    }

    @Then ("^we check if the navigation to '(.+?)' page was successful$")
    public void checkIfNavigationToPageWasSuccessful(String page){
        switch (page){
            case "Register":
                mainPage.urlIsAsExpected(Constants.registerPageURL);
                break;
            case "Notebooks":
                mainPage.urlIsAsExpected(Constants.notebooksPageURL);
                break;
            case "Cart":
                mainPage.urlIsAsExpected(Constants.cartPageURL);
        }


    }

    @Then("^we logout of account$")
    public void weLogoutOfAccount() {
        mainPage.logOutOfAccount();
    }

    @Then("^we verify we have logged in successfully$")
    public void weVerifyWeHaveLoggedInSuccessfully() {
        mainPage.verifyLoginWasSuccessful();
    }

    @And("^we close browser$")
    public void weCloseBrowser() {
        WebDriverFactory.getInstance().getDriver().close();
    }
}
