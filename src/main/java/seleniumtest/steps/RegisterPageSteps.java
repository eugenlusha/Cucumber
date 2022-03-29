package seleniumtest.steps;

import cucumber.api.java.en.Then;
import seleniumtest.nopCommerce.RegisterPage;
import seleniumtest.utils.WebDriverFactory;

public class RegisterPageSteps {

    public static RegisterPage registerPage;

    public RegisterPageSteps(){
        registerPage= new RegisterPage(WebDriverFactory.getInstance().getDriver());
    }

    @Then ("^we type (.+?) in the (.+?) field in register page$")
    public void fillTextBox(String str,String field){
        switch (field){
            case "First name:":
                registerPage.fillFirstName(str);
                break;
            case "Last name:":
                registerPage.fillLastName(str);
                break;
            case "Email:":
                registerPage.fillEmail(str);
                break;
            case "Password:":
                registerPage.fillPassword(str);
                break;
            case "Confirm password:":
                registerPage.fillConfirmPassword(str);
                break;
        }
    }

    @Then ("^we click the (.+?) from register page$")
    public void clickButton(String str){
        switch (str){
            case "Register":
                registerPage.completeRegisterButton();
                break;
        }
    }


    @Then("^we check if registration was successful$")
    public void weCheckIfRegistrationWasSuccessful() {
        registerPage.verifyRegisterSuccessfulMessageIsPresent();
    }
}
