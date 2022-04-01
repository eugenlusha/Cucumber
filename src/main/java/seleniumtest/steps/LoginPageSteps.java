package seleniumtest.steps;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import seleniumtest.nopCommerce.LoginPage;
import seleniumtest.nopCommercePageObject.LoginPageService;
import seleniumtest.utils.WebDriverFactory;

public class LoginPageSteps {
    public static LoginPage loginPage;
    public static LoginPageService loginPageService;

    public LoginPageSteps(){
        loginPage=new LoginPage(WebDriverFactory.getInstance().getDriver());
        loginPageService=new LoginPageService(WebDriverFactory.getInstance().getDriver());
    }

    @Then ("^we click '(.+?)' button from Login page$")
    public void clickButton(String btnName){
        switch (btnName){
            case "Register":
                loginPage.goToRegisterPage();
                break;
            case "Log in":
                loginPage.proceedToLogin();
        }
    }

    @And("^we type (.+?) in the (.+?) field in login page$")
    public void fillTextBox(String str,String field){
        switch (field){
            case "Email:":
                loginPage.fillEmail(str);
                break;
            case "Password:":
                loginPage.fillPassword(str);
                break;
        }
    }


    @Then("^we login with credentials$")
    public void weLoginWithCredentials(DataTable dataTable) {
        loginPageService.loginWithCredentials(dataTable.raw().get(0).get(0),dataTable.raw().get(0).get(1));
    }
}
