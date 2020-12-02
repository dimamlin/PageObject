package page;import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SvenHomePage {

    private WebDriver driver;
    private String HOMEPAGE_URL = "http://www.sven.fi/ru/";

    @FindBy(xpath = ".//input[@name='q']")
    private WebElement searchInput;

    @FindBy(xpath = ".//input[@name='s']")
    private WebElement searchButton;

    @FindBy(id = "lang_dropdown_select")
    private WebElement languageButton;

    @FindBy(xpath = ".//option[@value = \"en\"]")
    private WebElement languageWord;

    public SvenHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SvenHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SvenSearchResultPage searchForTerms(String term){
        searchInput.sendKeys(term);
        searchButton.click();
        return new SvenSearchResultPage(driver, term);
    }

    public SvenHomePage changeLanguage()
    {
        languageButton.click();
        languageWord.click();
        return this;
    }

    public String checkLanguageWord() { return languageWord.getText(); }

}
