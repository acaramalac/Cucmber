import Actions.*;
import Excel.Excel_Import;
import org.hamcrest.Matchers;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

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

    @Test
    public void test() {

    }

    @Test
    public void login() {
        loginPage.openMainPage();
        Assert.assertThat(driver.getTitle(), Matchers.is(loginPage.title));

        loginPage.openLoginPage();
        Assert.assertTrue("Assert that user is on login page", homePage.loginTitleIsDisplayed());

        loginPage.login("sniper342", "82006521");
        Assert.assertTrue("Assert that username is not missing", homePage.userNameIsDisplayed());
    }

    @Test
    public void searchAfterLogin() throws InterruptedException {
        login();
        searchAction.openSearchPage();
        Assert.assertThat(driver.getTitle(), Matchers.is(searchAction.searchPageTitle));

        searchAction.textInput();
        searchAction.search();
        Assert.assertThat(driver.getTitle(), Matchers.containsString("Search results"));
//        Assert.assertThat(searchAction.resultsLabel().getText(), Matchers.containsString("results"));
    }

    @Test
    public void addResultsToExcel() throws InterruptedException {
        searchAfterLogin();

        // addToExcel method executes in parentheses before importExcel method
        excel_import.importExcel(excelActions.addToExcel(100, "lol kek"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
