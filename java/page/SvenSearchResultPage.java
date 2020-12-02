package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SvenSearchResultPage {

    private WebDriver driver;
    private String term;

    @FindBy(xpath = ".//div[contains(@class,'views_search')]/*[(contains(@class,'row'))]")
    private List<WebElement> searchResults;

    public SvenSearchResultPage(WebDriver driver, String term)
    {
        this.term = term;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int countSearchResults(){ return searchResults.size();}

}
