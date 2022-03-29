package seleniumtest.nopCommercePageObject;

import seleniumtest.nopCommerce.*;
import org.openqa.selenium.WebDriver;

public class RegisterPageService {
    RegisterPage registerPage;
    public RegisterPageService(WebDriver driver){
        registerPage=new RegisterPage(driver);
    }

    public void registerNewUser(String gender, String emri,String mbiemri,String dita,String muaj,String viti, String email, String company,boolean getNews, String password){
        if (gender.equals("f")||gender.equals("F")) {
            registerPage.selectFemaleGender();
        }else{
            registerPage.selectMaleGender();
        }
        registerPage.fillFirstName(emri);
        registerPage.fillLastName(mbiemri);
        registerPage.fillDayOfBirth(dita);
        registerPage.fillMonthOfBirth(muaj);
        registerPage.fillYearOfBirth(viti);
        registerPage.fillEmail(email);
        registerPage.fillCompany(company);
        if(getNews){
            registerPage.agreeToGetNews();
        }else{
            registerPage.disagreeToGetNews();
        }
        registerPage.fillPassword(password);
        registerPage.fillConfirmPassword(password);
        registerPage.completeRegisterButton();
    }

    public void verifyRegisterWasSuccessful(){
        registerPage.verifyRegisterSuccessfulMessageIsPresent();
    }
}
