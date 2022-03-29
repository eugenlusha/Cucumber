package seleniumtest.nopCommercePageObject;

import seleniumtest.nopCommerce.*;
import org.openqa.selenium.WebDriver;

public class MainPageService {
    MainPage mainPage;
     public MainPageService(WebDriver driver){
         mainPage=new MainPage(driver);
     }
     public void navigateToLoginPage(){
         mainPage.goToLoginPage();
     }
     public void navigateToMyAccountPage(){
         mainPage.goToMyAccountPage();
     }
     public void navigateToNotebooksPage(){
         mainPage.goToNotebooksPage();
     }
     public void navigateToCartPage(){
         mainPage.goToCart();
     }
     public void navigateToCartPageThroughCartMenu(){
         mainPage.goToCartThroughButtonAfterHoveringCartMenu();
     }

     public void logoutOfAccount(){
         mainPage.logOutOfAccount();
     }

      public void verifyLoginWasSuccessful(){
         mainPage.verifyLoginWasSuccessful();
      }

      public void printActualURL(){
        mainPage.getCurrentUrl();
    }

    public void verifyUrlIsAsExpected(String str){
         mainPage.urlIsAsExpected(str);
    }


}
