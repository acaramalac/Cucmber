package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;
import java.util.TreeMap;


public class ExcelActions extends BaseAction {

    public ExcelActions(WebDriver driver) { super(driver); }

    private By linkToNextPage = By.className("mw-nextlink");
    private String exitCriteria = "61 – 80";

    SearchActions searchActions = new SearchActions(driver);

    String toSplit = searchActions.searchText;
    String[] parts = toSplit.split(" ");
    String part1 = parts[0].toLowerCase();
    String part2 = parts[1].toLowerCase();

    public Map<String, Object[]> addToExcel(){

        String beforeXpath_pageName = "//*[@id=\"mw-content-text\"]/div[3]/ul/li[";
        String afterXpath_pageName = "]/div[1]/a";
        String xPath_pageResult = "//*[@id=\"mw-search-top-table\"]/div[2]/strong[1]";

        int rowCount = 20;
        Map<String, Object[]> data = new TreeMap<String, Object[]>();

        while(!driver.findElement(By.xpath(xPath_pageResult)).getText().equals(exitCriteria)){
            for (int i = 1; i <= rowCount; i++) {

                String actualXpath_pageName = beforeXpath_pageName + i + afterXpath_pageName;
                String pageName = driver.findElement(By.xpath(actualXpath_pageName)).getText();
                System.out.println(pageName);

                if ( (pageName.toLowerCase()).contains(part1) || (pageName.toLowerCase()).contains(part2) ) {

                    WebElement link = driver.findElement(By.linkText(pageName));
                    String pageLink = link.getAttribute("href");
                    System.out.println(pageLink);

                    data.put("" + i, new Object[]{i, pageName, pageLink});
                }
            }
            clickOnNextPage();
        }
        return data;
    }

    public void clickOnNextPage(){ clickOnButton(linkToNextPage); }

}
