package pageobject_model;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static final String HOMEPAGE_URL = "https://staff-clothes.by/";
    private WebDriver driver;
    @FindBy(xpath = "//button[@class='pt-dropdown-toggle' and @data-tooltip='Поиск']")
    private WebElement searchBtnElement;
    @FindBy(xpath = "//input[@class='pt-search-input']")
    private WebElement searchInputElement;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public  HomePage openPage()
    {
        driver.get(HOMEPAGE_URL);
        searchBtnElement.click();
        return this;
    }

    public SearchPage searchQuery(String str)
    {
//        new WebDriverWait(driver, Duration.ofSeconds(20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Search']")));
        searchInputElement.sendKeys(str);
        searchInputElement.sendKeys(Keys.ENTER);
        return new SearchPage(driver,str);
    }
}
