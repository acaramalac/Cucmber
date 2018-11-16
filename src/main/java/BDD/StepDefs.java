package BDD;

import Actions.ExcelActions;
import Actions.HomePage;
import Actions.SearchActions;
import Actions.loginPageActions;
import Excel.Excel_Import;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefs {

    private WebDriver driver;
    loginPageActions loginPage;
    HomePage homePage;
    SearchActions searchAction;
    ExcelActions excelActions;
    Excel_Import excel_import;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        loginPage = new loginPageActions(driver);
        homePage = new HomePage(driver);
        searchAction = new SearchActions(driver);
        excelActions = new ExcelActions(driver);
        excel_import = new Excel_Import(driver);
    }

    @Given("^user is on main page$")
    public void userIsOnMainPage() {
//        setUp();
        loginPage.openMainPage();
    }

    @When("^user opens login page$")
    public void userClicksOpensLoginPage() {
        loginPage.openLoginPage();
    }

    @And("^user is redirected to Login page$")
    public void userIsRedirectedToLoginPage() {
        Assert.assertTrue("Assert that user is on login page", homePage.loginTitleIsDisplayed());
    }


/*    @And("^user enters the following credentials$")
    public void userEntersTheFollowingCredentials(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        System.out.println(data.get(0).get(0));
        System.out.println(data.get(0).get(1));
    }*/

    @And("^user enters ([^\"]*) and ([^\"]*)$")
    public void userEntersUserNameAndPassword(String UserName, String Password) throws NoAlertPresentException {
        loginPage.login(UserName, Password);
//        String alert = driver.switchTo().alert().getText();
//        System.out.println("Alert message is : " + alert);
    }

    @Then("^user is redirected to the Welcome to Wikipedia page$")
    public void userIsRedirectedToTheWelcomeToWikipediaPage() {
        Assert.assertTrue("Assert that username is not missing", homePage.userNameIsDisplayed());
    }


    @Given("^user is logged in using ([^\"]*) and ([^\"]*)$")
    public void userIsLoggedInUsingUserNameAndPassword(String UserName, String Password) {
        loginPage.openMainPage();
        loginPage.openLoginPage();
        loginPage.login(UserName, Password);
    }

    @When("^user opens search page$")
    public void userOpensSearchPage() {
        searchAction.openSearchPage();
    }

    @And("^user enters (.*)$")
    public void userEntersSearchKeyWords(String searchKeyWords) throws InterruptedException {
        searchAction.searchFor(searchKeyWords);
        searchAction.search();
    }

    @Then("^user gets search results$")
    public void userGetsSearchResults() {
        Assert.assertThat(driver.getTitle(), Matchers.containsString("Search results"));
    }


    @Given("^user is on search page$")
    public void userIsOnSearchPage() {
        searchAction.openSearchpageDirectly();

    }

    @Then("^filtered results are imported to excel file$")
    public void filteredResultsAreImportedToExcelFile() {
        excel_import.importExcel(excelActions.addToExcel());
    }

    @After
    public void tearDown() { driver.quit(); }
}
