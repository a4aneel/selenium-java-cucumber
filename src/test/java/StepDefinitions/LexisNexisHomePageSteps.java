package StepDefinitions;

import Enums.Context;
import PageObjects.LNHomePage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LexisNexisHomePageSteps {

    LNHomePage lnhomePage;
    TestContext testContext;

    public LexisNexisHomePageSteps(TestContext context) {
        testContext = context;
        lnhomePage = testContext.getPageObjectManager().getLnHomePage();
    }

    @Given("I am on Homepage and clicks on About us link")
    public void homePageWithoutAuthorizations() {
        lnhomePage.clickAboutUs();
    }

    @Given("I click on Careers link")
    public void clickCareerslink() {
        lnhomePage.clickCareerslink();
    }

    @When("I click search all jobs link and search for {string} keyword")
    public void searchJobsWithKeyword(String jobName) {
        testContext.getPageObjectManager().switchWindows();
        lnhomePage.searchJobData(jobName);
        testContext.scenarioContext.setContext(Context.EXPECTED_DATA, jobName);
    }

    }
