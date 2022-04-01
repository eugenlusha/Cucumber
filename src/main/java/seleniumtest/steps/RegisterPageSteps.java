package seleniumtest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import seleniumtest.nopCommerce.RegisterPage;
import seleniumtest.nopCommercePageObject.RegisterPageService;
import seleniumtest.utils.WebDriverFactory;

public class RegisterPageSteps {

    public static RegisterPage registerPage;
    public static RegisterPageService registerPageService;

    public RegisterPageSteps(){
        registerPage= new RegisterPage(WebDriverFactory.getInstance().getDriver());
        registerPageService = new RegisterPageService(WebDriverFactory.getInstance().getDriver());
    }

    @Then ("^we type '(.+?)' in the '(.+?)' field in register page$")
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

    @Then ("^we click the '(.+?)' from register page$")
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

    @And("^we register a new user with credentials as below$")
    public void weRegisterANewUserWithCredentials(DataTable dataTable) {
        String gender;
        boolean getNews=false;
        if(dataTable.raw().get(0).get(0).equals("Female")){
            gender="f";
        }else{
            gender="m";
        }
        if(dataTable.raw().get(0).get(8).equals("AgreeToNews")){
            getNews=true;
        }
        registerPageService.registerNewUser(gender,dataTable.raw().get(0).get(1),dataTable.raw().get(0).get(2),dataTable.raw().get(0).get(3),dataTable.raw().get(0).get(4),dataTable.raw().get(0).get(5),dataTable.raw().get(0).get(6),dataTable.raw().get(0).get(7),getNews,dataTable.raw().get(0).get(9));

    }
}
