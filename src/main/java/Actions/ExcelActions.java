package Actions;

import com.google.common.base.Splitter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;
import java.util.TreeMap;


public class ExcelActions extends BaseAction {

    public ExcelActions(WebDriver driver) { super(driver); }

    public void clickOnNextPage() { clickOnButton(linkToNextPage); }

    private By linkToNextPage = By.className("mw-nextlink");

    public Map<String, Object[]> addToExcel(int exitCriteria, String search) {

//      Split the String into parts
        Iterable<String> parts = Splitter.on(" ").split(search);

        String beforeXpath_pageName = "//*[@id=\"mw-content-text\"]/div[3]/ul/li[";
        String afterXpath_pageName = "]/div[1]/a";

        int count = 0;
        int rowCount = 20;
        Map<String, Object[]> data = new TreeMap<String, Object[]>();

        while (count < exitCriteria) {
            for (int i = 1; i <= rowCount; i++) {

                String actualXpath_pageName = beforeXpath_pageName + i + afterXpath_pageName;
                String pageName = driver.findElement(By.xpath(actualXpath_pageName)).getText();
                System.out.println(pageName);

                for (String s : parts) {
                    if ( (pageName.toLowerCase()).contains(s) ) {

                        WebElement link = driver.findElement(By.linkText(pageName));
                        String pageLink = link.getAttribute("href");
                        System.out.println(pageLink);

                        data.put("" + i, new Object[]{i, pageName, pageLink});
                    }
                }
                count++;
            }
            clickOnNextPage();
        }
        return data;
    }
}
