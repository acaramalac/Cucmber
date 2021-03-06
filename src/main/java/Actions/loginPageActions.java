package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPageActions extends BaseAction {

    private By findLoginLocator = By.cssSelector("#pt-login > a");
    private By usernameLocator = By.cssSelector("#wpName1");
    private By passwordLocator = By.cssSelector("#wpPassword1");
    private By loginButtonLocator = By.cssSelector("#wpLoginAttempt");
    private String url = "https://en.wikipedia.org/wiki/Main_Page";
    public final String title = "Wikipedia, the free encyclopedia";

    public loginPageActions(WebDriver driver) {
        super(driver);
    }

    public void openMainPage () {
        driver.get(url);
    }

    public void openLoginPage(){
        clickOnButton(findLoginLocator);
    }

    public void login(String username, String password) {
        typeText(usernameLocator, username);
        typeText(passwordLocator, password);
        clickOnButton(loginButtonLocator);
    }


}