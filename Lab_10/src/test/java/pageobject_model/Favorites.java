package pageobject_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Favorites {
    private String Favorites_URL = "https://staff-clothes.by/wishlist/";
    private WebDriver driver;
    @FindBy(xpath = "//a[@class='pt-dropdown-toggle']/span[@class='pt-badge']")
    private WebElement count_element;
    public  Favorites(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Favorites openFavoritesPage()
    {
        driver.get(Favorites_URL);
        return this;
    }

    public int CheckElementInFavorites()
    {
        int count = Integer.parseInt(count_element.getText());
        return count;
    }
}
