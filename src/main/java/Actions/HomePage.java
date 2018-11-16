package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseAction {

    private By userNameLocator = By.id("pt-userpage");
    private By loginTitleLocator = By.xpath("//*[@id=\"mw-createaccount-cta\"]");

    public HomePage (WebDriver driver){ super(driver);   }

    public boolean userNameIsDisplayed() {
        return driver.findElement(userNameLocator).isDisplayed();
    }

    public boolean loginTitleIsDisplayed(){
        return driver.findElement(loginTitleLocator).isDisplayed();
    }
}
