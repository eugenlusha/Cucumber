package seleniumtest.nopCommerce;

import seleniumtest.helpers.Functions;
import seleniumtest.helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    private Helpers helpers;
    Functions functions;

    @FindBy(className = "email")
    WebElement emailBox;

    @FindBy(className = "password")
    WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit'][@class='button-1 login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//button[@class='button-1 register-button']")
    WebElement registerButton;

    public LoginPage(WebDriver driver){
        this.helpers=new Helpers(driver);
        this.functions=new Functions(driver);
        PageFactory.initElements(driver,this);
    }
    public void setDriver(WebDriver driver){
        this.helpers=new Helpers(driver);
        this.functions=new Functions(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getEmailBox() {
        return emailBox;
    }

    public WebElement getPasswordBox() {
        return passwordBox;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public void goToRegisterPage(){
        helpers.clickElement(registerButton);
    }

    public void fillEmail(String email){
        helpers.sendKeys(emailBox,email);
    }
    public void fillPassword(String password){
        helpers.sendKeys(passwordBox,password);
    }
    public void proceedToLogin(){
        helpers.clickElement(loginButton);
    }

}
