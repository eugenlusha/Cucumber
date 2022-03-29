package seleniumtest.steps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import seleniumtest.nopCommerce.LoginPage;
import seleniumtest.utils.WebDriverFactory;

public class LoginPageSteps {
    public static LoginPage loginPage;

    public LoginPageSteps(){
        loginPage=new LoginPage(WebDriverFactory.getInstance().getDriver());
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


}
