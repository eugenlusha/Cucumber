package seleniumtest.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions {
    WebDriver driver;
    WebDriverWait waiter;

    public Functions(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, 5);
    }

    public double parseToDoubleFromString(String str) {
        char c = 0;
        String value = "";
        boolean continueToAdd = true;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c == '.') {
                continueToAdd = false;
            }
            if (Character.isDigit(c) && continueToAdd) {
                value = value + c;
            }
        }
        return Double.parseDouble(value);
    }

}