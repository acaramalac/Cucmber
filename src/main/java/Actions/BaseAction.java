package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseAction {

    WebDriver driver;

    public BaseAction(WebDriver driver) {
        this.driver = driver;
    }

    public void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void clickOnButton (By by) {
        driver.findElement(by).click();
    }
}
