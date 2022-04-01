package seleniumtest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import seleniumtest.nopCommerce.MyAccountPage;
import seleniumtest.nopCommercePageObject.MyAccountPageService;
import seleniumtest.utils.WebDriverFactory;

public class MyAccountSteps {
    MyAccountPage myAccountPage;
    MyAccountPageService myAccountPageService;
    public MyAccountSteps(){
        myAccountPage=new MyAccountPage(WebDriverFactory.getInstance().getDriver());
        myAccountPageService=new MyAccountPageService(WebDriverFactory.getInstance().getDriver());
    }


    @Then("^we verify if credentials of the user match$")
    public void weVerifyIfCredentialsOfTheUserMatch(DataTable dataTable) {
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
        myAccountPageService.verifyUserCredentialsAreCorrect(gender,dataTable.raw().get(0).get(1),dataTable.raw().get(0).get(2),dataTable.raw().get(0).get(3),dataTable.raw().get(0).get(4),dataTable.raw().get(0).get(5),dataTable.raw().get(0).get(6),dataTable.raw().get(0).get(7),getNews,dataTable.raw().get(0).get(9));

    }
}
