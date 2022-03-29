package seleniumtest.nopCommercePageObject;

import seleniumtest.nopCommerce.*;
import org.openqa.selenium.WebDriver;

public class MyAccountPageService {
    MyAccountPage myAccountPage;
    public MyAccountPageService(WebDriver driver){
        myAccountPage= new MyAccountPage(driver);
    }

    public void verifyNavigationToMyAccountPageWasSuccessful(){
        myAccountPage.verifyNavigationToMyAccountPageWasSuccessful();
    }

    public void verifyUserCredentialsAreCorrect(String gender, String emri,String mbiemri,String dita,String muaj,String viti, String email, String company,boolean news, String password){

            if(gender.equals("f")||gender.equals("F")){
                myAccountPage.verifyFemaleGenderRadioButtonIsSelected();
            }else{
                myAccountPage.verifyMaleGenderRadioButtonIsSelected();
            }
            myAccountPage.verifyFirstNameIsCorrect(emri);
            myAccountPage.verifyLastNameIsCorrect(mbiemri);
            myAccountPage.verifyDayOfBirthIsCorrect(dita);
            myAccountPage.verifyMonthOfBirthIsCorrect(muaj);
            myAccountPage.verifyYearOfBirthIsCorrect(viti);
            myAccountPage.verifyEmailIsCorrect(email);
            myAccountPage.verifyCompanyIsCorrect(company);
            if(news){
                myAccountPage.verifyNewsButtonIsSelected();
            }else {
                myAccountPage.verifyNewsButtonIsNotSelected();
            }
    }
}
