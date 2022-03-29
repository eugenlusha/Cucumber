package seleniumtest.steps;

import cucumber.api.java.en.Then;
import seleniumtest.nopCommerce.MyAccountPage;
import seleniumtest.utils.WebDriverFactory;

public class MyAccountSteps {
    MyAccountPage myAccountPage;
    public MyAccountSteps(){
        myAccountPage=new MyAccountPage(WebDriverFactory.getInstance().getDriver());
    }
    @Then ("^we verify if credentials are correct first name '(.+?)' last name '(.+?)' email '(.+?)'$")
    public void verifyCredentials(String name,String surname,String email){
        myAccountPage.verifyFirstNameIsCorrect(name);
        myAccountPage.verifyLastNameIsCorrect(surname);
        myAccountPage.verifyEmailIsCorrect(email);
    }
}
