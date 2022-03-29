package seleniumtest.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Helpers{
    WebDriver driver;
    WebDriverWait waiter;
    Actions actions;
    public Helpers(WebDriver driver){
        this.driver=driver;
        this.waiter=new WebDriverWait(driver,8);
        this.actions=new Actions(driver);
    }

    public void verifyNumberOfProductsDisplayed(List<WebElement> elements, int number){
        waiter.until(ExpectedConditions.visibilityOfAllElements(elements));
        Assert.assertEquals(elements.size(),number);
    }
    public void assertWebpageLinkIsAsExpected(String link){
        Assert.assertEquals(driver.getCurrentUrl(),link);
    }
    public void hoverElement(WebElement element){
        waiter.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
    }
    public void waitUntilElementIsNotVisible(WebElement element){
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void sendKeys(WebElement element, String text){
        waiter.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }
    public void clickElement(WebElement element){
        waiter.until(ExpectedConditions.visibilityOf(element));
        waiter.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void selectByIndex(WebElement list,int index){
        waiter.until(ExpectedConditions.visibilityOf((WebElement) list));
        Select selectList = new Select(list);
        selectList.selectByIndex(index);
    }
    public void selectByVisibleText(WebElement list,String text){
        waiter.until(ExpectedConditions.visibilityOf(list));
        Select selectList= new Select(list);
        selectList.selectByVisibleText(text);
    }
    public void assertElementHasText(WebElement element,String expectedText){
        waiter.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(element.getText(),expectedText);
    }
    public void assertElementHasTextFromInput(WebElement element,String expectedText){
        waiter.until(ExpectedConditions.visibilityOf(element));
        String text=element.getAttribute("value");
        Assert.assertEquals(text,expectedText);
    }
    public int getNumberOfElements(List<WebElement> elements){
        if(elements.size()>0) {
            waiter.until(ExpectedConditions.visibilityOfAllElements(elements));
        }else return 0;
        return elements.size();
    }

    public void assertElementIsVisible(WebElement element){
        waiter.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed());
    }
    public void waitUntilAllElementsAreVisible(List<WebElement> list){
        waiter.until(ExpectedConditions.visibilityOfAllElements(list));
    }
    public void waitUntilStalenessOfElement(WebElement element){
        waiter.until(ExpectedConditions.stalenessOf(element));
    }
    public boolean isElementSelected(WebElement element){
        waiter.until(ExpectedConditions.visibilityOf(element));
        if(element.isSelected()){ return true;}
        return false;
    }
    public boolean isElementNotSelected(WebElement element){
        waiter.until(ExpectedConditions.visibilityOf(element));
        if(element.isSelected()) {return false;}
        return true;
    }
    public void waitUntilElementIsVisible(WebElement element){
        waiter.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilElementIsInvisible(WebElement element){
        waiter.until(ExpectedConditions.invisibilityOf(element));
    }

    public void assertSelectedElementFromSelectList(WebElement element,String value){
        waiter.until(ExpectedConditions.visibilityOf(element));
        Select tmp= new Select(element);
        assertElementHasText(tmp.getFirstSelectedOption(),value);
    }
    public void waitForTextOfElementToBe(String xpath,String str){
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
        waiter.until(ExpectedConditions.textToBe(By.xpath(xpath),str));
    }

    public void waitForNumberOfElementsToBe(By elements, int nr){
        waiter.until(ExpectedConditions.numberOfElementsToBe(elements,nr));
    }

    public void waitForTextOfElementNotToBe(WebElement element,String str){
        waiter.until(ExpectedConditions.visibilityOf(element));
        waiter.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element,str)));
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }


}
