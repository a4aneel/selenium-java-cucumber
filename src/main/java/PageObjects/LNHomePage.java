package PageObjects;

import Utilities.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;


import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;


public class LNHomePage {

    LNHomePage lnhomePage;
    TestContext testContext;

    public LNHomePage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

    
    @FindBy(xpath = "//*[@id=\"mm-32882528-f67d-4cb9-8509-f6d48ac579c5\"]/div/div/ul/li[4]/a[1]")
    private WebElement headerAboutUs;

    @FindBy(xpath = "//*[@id='mm-32882528-f67d-4cb9-8509-f6d48ac579c5']/div/div/ul/li[4]/ul/li/div/div/div/div[2]/div[4]/div[2]/div[2]/a[2]")
    private WebElement clickCareerslink;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/a")
    private WebElement clickSearchAllJobs;

    @FindBy(xpath = "//*[@id=\"search-box-d3ba3a32752d48908f4061d0129326bf\"]")
    private WebElement typeKeyword;

    public void clickAboutUs() {
        headerAboutUs.isDisplayed();
        headerAboutUs.isEnabled();
        headerAboutUs.click();
    }

    public void clickCareerslink() {
        clickCareerslink.isDisplayed();
        clickCareerslink.isEnabled();
        clickCareerslink.click();
    }

    public void searchJobData(String jobName) {
        clickSearchAllJobs.isDisplayed();
        clickSearchAllJobs.isEnabled();
        clickSearchAllJobs.click();
        typeKeyword.isEnabled();
        typeKeyword.click();
        typeKeyword.sendKeys(jobName);
    }

    public void validateResults(){
        try {
            Thread.sleep(3000); // Wait for 3 seconds (adjust this as needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Check if there are any search results
        boolean areSearchResultsPresent = webDriver.findElements(By.cssSelector(".search-result")).size() > 0;

        // Assert that at least one search result is present
        Assert.assertTrue(areSearchResultsPresent, "No search results found!");
    }


    private WebDriver webDriver;
}
