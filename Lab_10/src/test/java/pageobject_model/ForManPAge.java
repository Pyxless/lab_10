package pageobject_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForManPAge {
    private static final String HOMEPAGE_URL = "https://staff-clothes.by/";

    private WebDriver driver;

    @FindBy(xpath = "//a/span[text()='Для парней']")
    private WebElement ForManBtnElement;


    public ForManPAge(WebDriver driver)
    {
        this.driver = driver;
        driver.get(HOMEPAGE_URL);
        PageFactory.initElements(driver,this);
    }

    public  ForManPAge openPage()
    {
        ForManBtnElement.click();
        return this;
    }
    public Favorites AddInFavorites()
    {
        WebElement addInFavoritesBtn = driver.findElement(By.xpath("//*[@id=\"pt-pageContent\"]/div/div/div/div[2]/div/div[2]/div[1]/div/div[1]/div/a"));
        addInFavoritesBtn.click();
        return new Favorites(driver);
    }
}
