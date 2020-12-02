package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SvenHomePage;
import java.util.concurrent.TimeUnit;


public class WebDriverSvenTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "searchResultIsNotEmpty")
    public void searchResultIsNotEmpty() {

        int searchResultsNumber = new SvenHomePage(driver)
                .openPage()
                .searchForTerms("sven ps-650")
                .countSearchResults();

        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Assert.assertTrue(searchResultsNumber > 0, "Search result are empty!");
    }

    @Test (description = "changePageLanguage")
    public void changePageLanguage() {

        String languageWord = new SvenHomePage(driver)
                .openPage()
                .changeLanguage()
                .checkLanguageWord();

        Assert.assertTrue(languageWord  != "РУС", "Language did not change!");

    }

    @AfterMethod (alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }

}
