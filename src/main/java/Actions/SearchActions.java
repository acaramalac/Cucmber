package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchActions extends BaseAction {

    private String directSearchUrl = "https://en.wikipedia.org/w/index.php?search=&title=Special%3ASearch&go=Go";
    private By searchButtonLocator = By.cssSelector("#searchButton");
    private By inputField = By.cssSelector("#ooui-php-1");
    private By buttonToSearch = By.cssSelector("#mw-search-top-table > div > div > div > span > span > button");
    public final String searchText = "exception handling";
    public final String searchPageTitle = "Search - Wikipedia";

    public SearchActions(WebDriver driver) { super(driver); }

//    @FindBy(id = "firstHeading")
//    private WebElement results;
//
//    public WebElement resultsLabel(){
//        return results;
//    }

    public void openSearchPage(){ clickOnButton(searchButtonLocator); }

    public void openSearchpageDirectly(){ driver.get(directSearchUrl);}

    public void textInput() { typeText(inputField, searchText); }

    public void searchFor(String searchKeyWord) { typeText(inputField, searchKeyWord);}

    public void search() throws InterruptedException {
        clickOnButton(buttonToSearch);
        Thread.sleep(1000);
    }

}
