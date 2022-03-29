package seleniumtest.nopCommerce;

import seleniumtest.helpers.Functions;
import seleniumtest.helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPage {
    private Helpers helpers;
    Functions functions;
    public RegisterPage(WebDriver driver){
        this.helpers=new Helpers(driver);
        this.functions=new Functions(driver);
        PageFactory.initElements(driver,this);
    }
    public void setDriver(WebDriver driver){
        this.helpers=new Helpers(driver);
        this.functions=new Functions(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "span.male > label")
    WebElement maleRadioButton;

    @FindBy(css = "span.female > label")
    WebElement femaleRadioButton;

    @FindBy(id = "FirstName")
    WebElement firstnameTextBox;

    @FindBy(id = "LastName")
    WebElement lastnameTextBox;

    @FindBy(name = "DateOfBirthDay")
    WebElement daySelectlist;

    @FindBy(name = "DateOfBirthMonth")
    WebElement monthSelectList;

    @FindBy(name = "DateOfBirthYear")
    WebElement yearSelectList;

    @FindBy(id = "Email")
    WebElement emailTextBox;

    @FindBy(id = "Company")
    WebElement companyTextBox;

    @FindBy(id = "Newsletter")
    WebElement newsletterCheckBox;

    @FindBy(id = "Password")
    WebElement passwordTextBox;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTextBox;

    @FindBy(id = "register-button")
    WebElement completeRegisterButton;

    @FindBy(className = "result")
    WebElement registerResultTextElement;

    public WebElement getMaleRadioButton() {
        return maleRadioButton;
    }

    public void selectMaleGender(){
        helpers.clickElement(maleRadioButton);
    }

    public WebElement getFemaleRadioButton() {
        return femaleRadioButton;
    }

    public void selectFemaleGender(){
        helpers.clickElement(femaleRadioButton);
    }

    public WebElement getFirstnameTextBox() {
        return firstnameTextBox;
    }

    public void fillFirstName(String firstName){
        helpers.sendKeys(firstnameTextBox,firstName);
    }

    public WebElement getLastnameTextBox() {
        return lastnameTextBox;
    }

    public void fillLastName(String lastName){
        helpers.sendKeys(lastnameTextBox,lastName);
    }

    public WebElement getDaySelectList() {
        return daySelectlist;
    }

    public void fillDayOfBirth(String day){
        helpers.selectByVisibleText(daySelectlist,day);
    }

    public WebElement getMonthSelectList() {
        return monthSelectList;
    }

    public void fillMonthOfBirth(String month){
        helpers.selectByVisibleText(monthSelectList,month);
    }

    public WebElement getYearSelectList() {
        return yearSelectList;
    }

    public void fillYearOfBirth(String year){
        helpers.selectByVisibleText(yearSelectList,year);
    }

    public WebElement getEmailTextBox() {
        return emailTextBox;
    }

    public void fillEmail(String email){
        helpers.sendKeys(emailTextBox,email);
    }

    public WebElement getCompanyTextBox() {
        return companyTextBox;
    }

    public void fillCompany(String company){
        helpers.sendKeys(companyTextBox,company);
    }

    public WebElement getNewsletterCheckBox() {
        return newsletterCheckBox;
    }

    public void agreeToGetNews(){
        if(!newsletterCheckBox.isSelected()){
            helpers.clickElement(newsletterCheckBox);
        }
    }
    public void disagreeToGetNews(){
        if(newsletterCheckBox.isSelected()){
            helpers.clickElement(newsletterCheckBox);
        }
    }

    public WebElement getPasswordTextBox() {
        return passwordTextBox;
    }

    public void fillPassword(String password){
        helpers.sendKeys(passwordTextBox,password);
    }

    public WebElement getConfirmPasswordTextBox() {
        return confirmPasswordTextBox;
    }

    public void fillConfirmPassword(String password){
        helpers.sendKeys(confirmPasswordTextBox,password);
    }

    public WebElement getCompleteRegisterButton() {
        return completeRegisterButton;
    }

    public void completeRegisterButton(){
        helpers.clickElement(completeRegisterButton);
    }

    public WebElement getRegisterResultTextElement() {
        return registerResultTextElement;
    }


    public void verifyRegisterSuccessfulMessageIsPresent(){
        helpers.assertElementHasText(registerResultTextElement,"Your registration completed");
    }

}
