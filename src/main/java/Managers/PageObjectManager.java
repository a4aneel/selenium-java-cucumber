package Managers;

import PageObjects.*;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class PageObjectManager {

    private final WebDriver webDriver;
    private LNHomePage lnHomePage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void switchWindows() {
        Set<String> windowHandles = webDriver.getWindowHandles();

        // Iterate through each window handle
        for (String windowHandle : windowHandles) {
            // Switch to the new window
            webDriver.switchTo().window(windowHandle);
        }
    }

    public LNHomePage getLnHomePage() {
        return (lnHomePage == null) ? lnHomePage = new LNHomePage(webDriver) : lnHomePage;
    }
}
